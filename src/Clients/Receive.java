package Clients;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.Socket;
import FileUtils.Writer;

public class Receive extends Thread{
    int port ;
    String message ;
    String path ; // as destination
    public Receive(int port , String path , String message){
        setPort(port);
        setPath(path);
        setMessage(message);
    }

    @Override
    public void run() {
        try {
            Socket socket = new Socket("localhost",getPort() ) ;
            System.out.println("connected with:"+getPort() );
            // mandefa anle anaranle fichier alaina

            DataInputStream lunette = new DataInputStream(socket.getInputStream());
            DataOutputStream stylo = new DataOutputStream(socket.getOutputStream());
            // notify the server that it' is receive 
            stylo.writeUTF("receive");
            // ilay fichier alefa
            stylo.writeUTF(message);
            // maka anle anarana avy amn server
            String last_part= lunette.readUTF();
            // initialisation
            FileOutputStream fostr = new FileOutputStream(path.concat("/"+last_part));
            int n ;
            byte[]buf = new byte[4096];
            // write
            while((  n = lunette.read(buf)) != -1){
                System.out.println("writing"+n+" bytes...");
                fostr.write(buf,0,n);
                fostr.flush();
                buf = new byte[4096] ;
            }
            lunette.close();
            fostr.close();
            socket.close();
            
            Writer transfer_history= new Writer();
            transfer_history.createTheFile(path.concat("/history.txt"));
            transfer_history.saveInFile(last_part, path.concat("/history.txt"));

            } catch (Exception e) {
                System.out.println(e);
            } 
            System.out.println("downloaded");
        }
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
