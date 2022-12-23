package Clients;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import FileUtils.Reader;
import FileUtils.Writer;
public class Client extends Thread{
    String default_repository=new File("").getAbsolutePath().concat("/Client_Repository/my_file");
    String idClient ;
    String host;
    int portServer ;
    Socket socket ;
    boolean connection = true;
    DataOutputStream stylo ;
    DataInputStream lunette ;
    String task=null;
    String messageTemp =null ;
    String message_mode =null;
    String[] repo = null;
    @Override
    public void run() {
        try {
            System.out.println("launched");
            // send first message
            DataOutputStream dout = getStylo();
            dout.writeUTF("Clients");
            while(connection){
                if(getTask() == "exit") break;
                sleep(1000);
                if(getTask()!=null){
                    System.out.println("en excecution");
                    sendMessage(getMessageTemp(), getMessage_mode(),getRepo());
                    setTask(null);
                    setMessageTemp(null);
                    setMessage_mode(null);
                    setRepo(null);
                }
            }
            // manidy anle interface
            socket.close();                
        } catch (Exception e) {
        }
    }
    
    public Client(String idClient, String host, int portServer) throws UnknownHostException, IOException {
        setIdClient(idClient);
        setHost(host);
        setPortServer(portServer);
        setSocket(new Socket(host, portServer)); 
        setStylo(new DataOutputStream(socket.getOutputStream()));
        setLunette(new DataInputStream(socket.getInputStream()));
        start();
    }
    void sendMessage(String message , String mode , String...repository ) throws Exception{
        getStylo().writeUTF(mode);
        if(mode.equalsIgnoreCase("send")) sendFile(message);
        if(mode.equalsIgnoreCase("receive")) receiveFile(message); ;
    }
    void sendFile (String message ) throws Exception{
        try {
            System.out.println(message);
            // mba miteny hoe inona ilay Anaranle fichier
            getStylo().writeUTF(message.substring(message.lastIndexOf("\\")));
            //
            System.out.println("lasa ny repertoire");
            File file = new File(message);
            // eto maka anle taille
            long size = Files.size(file.toPath()) ;
            // alefa any amn serveur le taille 
            getStylo().writeLong(size);
            System.out.println("lasa ny taille");
            // miandry reponse avy aamn serveur hoe tokony tapahana firy le fichier
            int division = (getLunette().read()) ;
            System.out.println("azo ny division");
            // miandry reponse avy amn serveur hoe aiza avy ny andefasana anle fichier -> port 
            int [] ports = new int [division];
            for (int i = 0; i < ports.length; i++) {
                ports [i] = Integer.valueOf(getLunette().readUTF()) ;
            } 
            System.out.println("azo daholo ny ports");
            // manamboatra send anaki tsy aiko hoe firy
            // de atsofoka any daholo ny port ,  fichier , parametre hoe manomboka aiza no alefa le fichier  , tapatapana fichier  
            Send [] senderThread = new Send [division];
            // mi prepare anle zavatra ho alefa anaty send
            long sizeParSend = (size / division) ;  // isanle byte alefa (par send)
            for (int i = 0; i < division; i++) {
                senderThread[i] = new Send( ports [i], file , sizeParSend , i+1) ;
                if( i+1 >= division && size%division >0 ) senderThread[i].setByteSize(sizeParSend + size %division); 
                senderThread[i].start();
            }
     
        } catch (Exception e) {
            System.out.println(e);
        }
   }

    void receiveFile(String message) throws NumberFormatException, IOException{

        // mandefa ny index(anaranle) fichier ho alaina
        getStylo().writeUTF(message);
        // maka anle tena anarana
        String real_name= getLunette().readUTF();

        if(getLunette().readUTF().equalsIgnoreCase("tsy afaka alefa")){
            JOptionPane.showMessageDialog(new JFrame(), "Veuillez reesayer plus tard");
            return ;
        } 
        // maka anle isanle receive tokony velomina
        int size_receive = getLunette().read() ;
        // liste ana ports 
        int [] port_list = new int [size_receive];
        for (int index = 0; index < port_list.length; index++) {
            port_list[index]= Integer.valueOf( getLunette().readUTF()) ;
        }
        Receive[] receive = new Receive[size_receive];
        for (int i = 0; i < receive.length; i++) {
            receive[i] = new Receive(port_list[i],getDefault_repository(),real_name);
            receive[i].start();
        }

        for (int i = 0; i < receive.length; i++) {
            try {
                receive[i].join();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        try {
            Reader reader = new Reader(getDefault_repository().concat("/history.txt"));
            String [] last = reader.readContentFile() ;
            Arrays.sort(last);
            FileOutputStream writer =new FileOutputStream(getDefault_repository().concat("/".concat(real_name.substring(0,real_name.indexOf(":")))));
            
            for (int index = 0; index <last.length; index++) {
                FileInputStream lecteur = new FileInputStream(getDefault_repository().concat("/"+last[index]));
                writer.write(lecteur.readAllBytes());
                writer.flush();
                lecteur.close();
                // Files.deleteIfExists(new File(getDefault_repository().concat("/"+last[index])).toPath()) ;
            }
            writer.close();
    // delete history
            new Writer().deleteAllInFile(getDefault_repository().concat("/history.txt"));
            System.out.println("file transfered");
        } catch (Exception e) {
            System.out.println(e);
        }
        JOptionPane.showMessageDialog(new JFrame(), "Telechargement reussi");
    
    }
    public String getIdClient() {
        return idClient;
    }
    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }
    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }
    public int getPortServer() {
        return portServer;
    }
    public void setPortServer(int portServer) {
        this.portServer = portServer;
    }
    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public boolean isConnection() {
        return connection;
    }

    public void setConnection(boolean connection) {
        this.connection = connection;
    }

    public DataOutputStream getStylo() {
        return stylo;
    }

    public void setStylo(DataOutputStream stylo) {
        this.stylo = stylo;
    }

    public DataInputStream getLunette() {
        return lunette;
    }

    public void setLunette(DataInputStream lunette) {
        this.lunette = lunette;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getMessageTemp() {
        return messageTemp;
    }

    public void setMessageTemp(String messageTemp) {
        this.messageTemp = messageTemp;
    }

    public String getMessage_mode() {
        return message_mode;
    }

    public void setMessage_mode(String message_mode) {
        this.message_mode = message_mode;
    }

    public String[] getRepo() {
        return repo;
    }

    public void setRepo(String[] repo) {
        this.repo = repo;
    }

    public String getDefault_repository() {
        return default_repository;
    }

    public void setDefault_repository(String default_repository) {
        this.default_repository = default_repository;
    }

}
