package Server_Repo;
import java.io.File;
import java.net.Socket;

public class ServerPart1 extends Server_Distributed{
    int port= 2781 ;
    String repository=  new File("").getAbsolutePath().concat("/Server_Repository/Server_Part1");
    boolean connection = true  ;
    Socket socket ;
    String mode ;
    String idServer = "1";

    public ServerPart1(){
        super.setRepository(getRepository());

    }
    public ServerPart1(String title, String mode) {
        super();
        setRepository(getRepository().concat("/"+title.concat(idServer)));
        setMode(mode);
        super.setRepository(getRepository());
    
    }
    public void set_functionality(String title, String mode){
        setRepository(getRepository().concat("/"+title.concat(idServer)));
        setMode(mode);

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

    

}
