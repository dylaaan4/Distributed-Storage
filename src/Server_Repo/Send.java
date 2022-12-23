package Server_Repo;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;

public class Send extends Thread {
    String src ;
    Socket theCommnunication;
    public Send(Socket theCommnunication, String src) {
        setTheCommnunication(theCommnunication);
        setSrc(src);
        start();
    }

    @Override
    public void run() {
        try {
            // maka anle anaranle file alefa
            DataInputStream din = new DataInputStream(getTheCommnunication().getInputStream());  
            // inons le fichier alaina
            String file_name = din.readUTF();
            String [] lists = new File(getSrc()).list() ;

            String rep= null ;
            // mitady an'ilay fichier ho alaina
            for (int i = 0; i < lists.length; i++) {
                System.out.println(lists[i].substring(1));
                if(lists[i].substring(1).equalsIgnoreCase(file_name.substring(0, file_name.indexOf(":")))){
                    rep =lists[i] ;
                    System.out.println("hitany ilay alefa");
                    break ;
                }
            }

            DataOutputStream output = new DataOutputStream(getTheCommnunication().getOutputStream());
            // tenenina hoe inona ilay anaran'ilay fichier
            output.writeUTF(rep);
            //create new fileinputstream amn le file
            FileInputStream fileReader = new FileInputStream(getSrc().concat("/".concat(rep)));
            // init
            int n=0 ;
            byte[]buf = new byte[4096];
            //write file to dos
            while((n =fileReader.read(buf)) != -1){
                System.out.println("writing...");
                output.write(buf,0,n);
                output.flush();
                buf= new byte[4096];
            }
            fileReader.close();
            output.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("finished");

    }



    
    public String getSrc() {
        return src;
    }
    public void setSrc(String src) {
        this.src = src;
    }

    public Socket getTheCommnunication() {
        return theCommnunication;
    }

    public void setTheCommnunication(Socket theCommnunication) {
        this.theCommnunication = theCommnunication;
    }

}
