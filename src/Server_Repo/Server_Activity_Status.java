package Server_Repo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Server_Activity_Status extends Thread{

    Server_Distributed server ;
    int port ;
    String host ;
    boolean connection ;
    int server_real_port;
    public Server_Activity_Status(int port  ,String host , Server_Distributed server){
        setPort(port);
        setHost(host);
        setServer_real_port(server.getPort());
        setServer(server);
        start();
    }
    @Override
    public void run() {
        try {
            System.out.println("launched");
            Socket sc = new Socket(host , port);
            // send first message
            DataOutputStream dout = new DataOutputStream(sc.getOutputStream());
            DataInputStream din = new DataInputStream(sc.getInputStream());
            dout.writeUTF("server:"+ server_real_port);
            // ---
            connection= true;

            dout.writeUTF(String.valueOf(getServer_real_port()));
            System.out.println("nahazo id ilay server");
            getServer().setIdServer( din.readUTF() );
            while(connection){
                Thread.sleep(1000);
            } 
            dout.writeUTF(server_real_port+": deconnected");
            System.out.println("server repo closed");
            sc.close();
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
    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }
    public boolean isConnection() {
        return connection;
    }
    public void setConnection(boolean connection) {
        this.connection = connection;
    }
    public int getServer_real_port() {
        return server_real_port;
    }
    public void setServer_real_port(int server_real_port) {
        this.server_real_port = server_real_port;
    }
    public Server_Distributed getServer() {
        return server;
    }
    public void setServer(Server_Distributed server) {
        this.server = server;
    }


    
}
