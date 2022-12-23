package main_server;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
public class Main_Server_Tunnel extends Thread{
    String main_server_repository =new File("").getAbsolutePath().concat("/Server_Repository/Main_server_info_repository");
    ServerSocket server_socket ;
    int sizeOfSub = 20 ;
    int port = 2219 ;
    boolean connection = true;
    int indice =0 ;  // indice mi pointe null amnle subs
    ArrayList<Integer> ports ;
    Server_Wall [] subs = new Server_Wall[sizeOfSub] ; // isan' ny client afaka miditra 
    public void run(){
        setPorts(new ArrayList<Integer>());
        try {
            ServerSocket sc = new ServerSocket(getPort());
            setServer_socket(sc);
            while(connection){
                System.out.println("Waiting for client");
                servirConnection(sc.accept());
            }
                sc.close();        
        } catch (Exception e) {
            System.out.println("main server stopped");
        }
    }
        
    void servirConnection(Socket socket) throws IOException{
        System.out.println("processing...");
        getSubs()[getIndice()] = new Server_Wall(socket , getPorts() , getMain_server_repository() );
        setIndice(getIndice()+1);
        System.out.println("done");
    }

    public int getSizeOfSub() {
        return sizeOfSub;
    }

    public void setSizeOfSub(int sizeOfSub) {
        this.sizeOfSub = sizeOfSub;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean isConnection() {
        return connection;
    }

    public void setConnection(boolean connection) {
        this.connection = connection;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public Server_Wall[] getSubs() {
        return subs;
    }

    public void setSubs(Server_Wall[] subs) {
        this.subs = subs;
    }

    public ServerSocket getServer_socket() {
        return server_socket;
    }

    public void setServer_socket(ServerSocket server_socket) {
        this.server_socket = server_socket;
    }

    public ArrayList<Integer> getPorts() {
        return ports;
    }

    public void setPorts(ArrayList<Integer> ports) {
        this.ports = ports;
    }

    public String getMain_server_repository() {
        return main_server_repository;
    }

    public void setMain_server_repository(String main_server_repository) {
        this.main_server_repository = main_server_repository;
    }
    
}
