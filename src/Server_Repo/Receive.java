package Server_Repo;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.Socket;

public class Receive extends Thread{
    Socket socket ;
    String path ;
    String id_file ;
    public Receive(Socket socket , String path , String idFile){
        setSocket(socket);
        setPath(path);
        setId_file(idFile);
    }

    @Override
    public void run() {
        try {
        DataInputStream lunette = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        // name of the file to receive
        String file_name= lunette.readUTF();
        // preparation an'ilay emplacement an'ilay fichier
        System.out.println(getPath().concat("/"+ id_file+file_name));
        File f = new File(getPath().concat("/"+id_file+file_name));
        f.createNewFile() ;
        FileOutputStream fostr = new FileOutputStream(getPath().concat("/"+id_file+file_name));
        // initialisation
        int n =0;
        byte[]buf = new byte[4092];
        // write
        while((n = lunette.read(buf)) != -1){
            fostr.write(buf,0,n);
            fostr.flush();
        }
        lunette.close();
        fostr.close();
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getId_file() {
        return id_file;
    }

    public void setId_file(String id_file) {
        this.id_file = id_file;
    }


}
