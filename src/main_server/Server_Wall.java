package main_server;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import FileUtils.Reader;
import FileUtils.Writer;

public class Server_Wall extends Thread{

    String main_repository;
    Socket socket ;
    DataOutputStream stylo ;
    DataInputStream lunette ;
    boolean connection = true;
    ArrayList<Integer> ports ;

    public Server_Wall(Socket socket, ArrayList<Integer> ports , String main_repository) throws IOException{
        setPorts(ports);
        setSocket(socket);
        setStylo(new DataOutputStream(socket.getOutputStream()));
        setLunette(new DataInputStream(socket.getInputStream()));
        setMain_repository(main_repository);
        start();
    }
    public void run(){
        try {
            String readed = lunette.readUTF() ;
            if( readed.substring(0, 6).equalsIgnoreCase("server") ){
                System.out.println("one server repo dispo");
                ports.add(Integer.valueOf(lunette.readUTF()));
                System.out.println(ports.get(ports.size()-1));
                    stylo.writeUTF(String.valueOf(ports.indexOf(ports.get(ports.size()-1))) );
                while(isConnection()){
                    String next_readed=  lunette.readUTF() ;
                        System.out.println( "ho fafana :"+next_readed);
                        int a = Integer.valueOf(next_readed.substring(0, next_readed.indexOf(":")));
                        ports.remove(ports.indexOf(a));
                        System.out.println("removed |"+a); 
                        setConnection(false);
                }
                setConnection(false);
            }else{
                while(connection){
                    System.out.println("client");
                    String next_readed=  lunette.readUTF() ;
                    if(next_readed.equalsIgnoreCase("send")){
                        receive();
                    }
                    else if(next_readed.equalsIgnoreCase("receive")){
                        send();
                    }else if(next_readed.equalsIgnoreCase("get_all_file")){
                        liste_file_disponible_to_client();
                    }
                }
            }

            getSocket().close();
                
        } catch (Exception e) {
        }

    }


    public void receive () throws Exception{
        try {
            DataInputStream dataInputStream = getLunette() ;
            // maka le anaranle fichier
            String title = dataInputStream.readUTF() ;
            System.out.println(title);
            // maka anle taille 
            long size = dataInputStream.readLong();
            System.out.println(size);
            //mandefa hoe tokony ho zaraina firy ilay fichier
            DataOutputStream stylo = getStylo();
            int division = ports.size();
            System.out.println(division);
            // 
            stylo.write(division);
            // alefa daholo ny port_na server disponible
            for (int i = 0; i < ports.size(); i++) {
                stylo.writeUTF(String.valueOf(getPorts().get(i)) );
            }
    
            // base de donnee kely -> ilay fichier
            Writer writer = new Writer();
            writer.createTheFile(getMain_repository().concat("/".concat("informations.txt")) );
            // all_ports
            String all_ports="", virj =",";
            for (int i = 0; i < ports.size(); i++) {
                all_ports = all_ports+ getPorts().get(i) +  virj ; 
            }
            writer.saveInFile(title.substring(1).concat(":".concat(ports.size()+"|".concat(all_ports))),getMain_repository().concat("/".concat("informations.txt")));
    
            System.out.println("alefaso amn server jiaby");
    
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public void send() throws Exception{
        try {

            DataInputStream din = getLunette();
            // maka liste ana file disponible
            Reader reader = new Reader(getMain_repository().concat("/".concat("informations.txt")));
            String [] disponibles = reader.readContentFile();
            // maka ny anaranle fichier ho alefa  
            String index= din.readUTF() ;
            String toSend =disponibles[Integer.valueOf(index)];
            // mamaly anle hoe tena alefa
            getStylo().writeUTF(toSend);
            if( is_dispo(disponibles,toSend)){
                // miteny @ client hoe ho azony ilay fichier
                getStylo().writeUTF("afaka alefa");
                System.out.println("afaka alefa");
                // de mandefa any amn client hoe fraction anaky firy ilay fichier 
                getStylo().write(getPorts().size());
                // mandefa an'ireo liste ana port
                int [] port_to_send = return_port(ports, toSend);
                for (int i = 0; i < getPorts().size(); i++) {
                    getStylo().writeUTF(String.valueOf( port_to_send[i]));
                }
            }else{
                getStylo().writeUTF("tsy afaka alefa");

               System.out.println( "tsy mbola afaka alaina ");
            }
    
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public boolean is_dispo(String[] dispo ,String toSend){
        String toTreat ="";
        for (int i = 0; i < dispo.length; i++) {
            if(dispo[i].substring(0 , dispo[i].indexOf(":")).equalsIgnoreCase(toSend.substring(0 , toSend.indexOf(":")))){
                toTreat = dispo[i];
                break;
            }
        }
        if(get_port(getPorts(),toTreat))return true ;
        
        return false ;
    }
    public boolean get_port( ArrayList<Integer> list_port,String d){
        String temp = d ;
        int size = Integer.valueOf( d.substring(d.indexOf(":")+1, d.indexOf(":")+2));
        String regex=  "|";
        for (int i = 0; i < size; i++) {
            temp = temp.substring(temp.indexOf(regex)+1);
            if(list_port.indexOf(Integer.valueOf(temp.substring(0, temp.indexOf(","))))==-1) return false;
            regex=",";
        }
        return true ;
    }
    int [] return_port(ArrayList<Integer> list_port,String d){
        String temp = d ;
        int size = Integer.valueOf( d.substring(d.indexOf(":")+1, d.indexOf(":")+2));
        int [] reponse = new int [size];
        String regex=  "|";
        for (int i = 0; i < size; i++) {
            temp = temp.substring(temp.indexOf(regex)+1);
            reponse[i]= (Integer.valueOf(temp.substring(0, temp.indexOf(",")))) ;
            regex=",";
        }
        return reponse;
    }

    public void liste_file_disponible_to_client(){
        try {
            DataOutputStream dout = getStylo();
            Reader reader = new Reader(getMain_repository().concat("/".concat("informations.txt")));
            System.out.println(getMain_repository().concat("/".concat("informations.txt")));
            String [] disponibles = reader.readContentFile();
            // alefa alony hoe file firy no disponible
            dout.write(disponibles.length);
            // mandefa hoe iza avy no disponible
            
            for (int i = 0; i < disponibles.length; i++) {
                dout.writeUTF(disponibles[i].substring(0 , disponibles[i].indexOf(":")));
                System.out.println(disponibles[i].substring(0 , disponibles[i].indexOf(":")));
            }        
        } catch (Exception e) {
            System.out.println(e);
        }

    }


    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
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
    public boolean isConnection() {
        return connection;
    }
    public void setConnection(boolean connection) {
        this.connection = connection;
    }
    public ArrayList<Integer> getPorts() {
        return ports;
    }
    public void setPorts(ArrayList<Integer> ports) {
        this.ports = ports;
    }
    public String getMain_repository() {
        return main_repository;
    }
    public void setMain_repository(String main_repository) {
        this.main_repository = main_repository;
    }
}
