package Server_Repo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_Distributed extends Thread{
    // tsy maintsy A surdefinir
    int port ; 
    String repository ;
    boolean connection = true  ;
    Socket socket ;
    String mode ;
    String idServer ;
    DataInputStream lunette;
    DataOutputStream stylo ;
    String server_name = "ServerPart2";

    public Server_Distributed(){
    }
    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(getPort());
            while(isConnection()) {
                System.out.println("welcome");
                setSocket(server.accept()); 
                setLunette(new DataInputStream(getSocket().getInputStream()));
                setStylo(new DataOutputStream(getSocket().getOutputStream()));
                System.out.println("miandry notification");
                Thread.sleep(1000);
                notification(getLunette().readUTF());
            } 
            System.out.println("hehe closed");
            server.close();
        } catch (Exception e) {
        }
    }

    public void notification (String message) throws InterruptedException{
        if(message.equalsIgnoreCase("send")) receiveFile() ;
        if(message.equalsIgnoreCase("receive")) sendFile() ;
        System.out.println("vi");
    }
    public void receiveFile() throws InterruptedException{
        Receive receive = new Receive(getSocket(),getRepository() ,getIdServer()) ;
        System.out.println("en mode receive");
        receive.start();
        receive.join();
    }
    public void set_functionality(String title, String mode){
        setRepository(getRepository().concat("/"+title.concat(idServer)));
        setMode(mode);

    }

    public void sendFile(){
        Send send = new Send(getSocket(),getRepository()) ;
        System.out.println("en mode send");
        try {
            send.start();
            send.join();
            
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public int getPort() {
        return port;
    }
    public void setPort(int port) {
        this.port = port;
    }
    public String getRepository() {
        return repository;
    }
    public void setRepository(String repository) {
        this.repository = repository;
    }
    public boolean isConnection() {
        return connection;
    }
    public void setConnection(boolean connection) {
        this.connection = connection;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
    public String getIdServer() {
        return idServer;
    }
    public void setIdServer(String idServer) {
        this.idServer = idServer;
    }
    public DataInputStream getLunette() {
        return lunette;
    }
    public void setLunette(DataInputStream lunette) {
        this.lunette = lunette;
    }
    public DataOutputStream getStylo() {
        return stylo;
    }
    public void setStylo(DataOutputStream stylo) {
        this.stylo = stylo;
    }
    public String getServer_name() {
        return server_name;
    }
    public void setServer_name(String server_name) {
        this.server_name = server_name;
    }
    
    
}
