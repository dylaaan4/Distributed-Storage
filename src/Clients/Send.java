package Clients;

import java.io.DataOutputStream;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Send extends Thread{
    int portCible ;
    File files ;
    long byteSize ;
    int serverNumber  ;

    public Send (int portCible , File files , long byteSize , int idNb  ){
        setPortCible(portCible);
        setFiles(files);
        setByteSize(byteSize);
        setServerNumber(idNb);
    }
    
    @Override
    public void run() {
        try {
            // open the socket
            Socket socket = new Socket("localhost",getPortCible() ) ;
            System.out.println("connected with:"+getPortCible() );
            // get the outputstream of the socket
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            // notify the server that it' is send 
            output.writeUTF("send");
            // tell the server the name of file+nb
            output.writeUTF(files.getName());
            // randomAccesFile -> manana anle file pointer
            RandomAccessFile Myreader = new RandomAccessFile( getFiles(), "r");
            // specifié le file pointer 
            Myreader.seek((getServerNumber()-1) *getByteSize()); // servernumber minim : 1 -> tokony atao -1 zany
            // initialisation
            int bytes =0;
            long stop = getByteSize()/4096;  
            int rest =(int) getByteSize()%4096;
            long toFinish = 0 ;
            // par 4096 bytes foana no alefa 
            byte [] buffer = new byte [4096];
            // transfer part one
            while (toFinish < stop ) {
                if( !((bytes = Myreader.read(buffer)) != -1)) break ;
                System.out.println("sending"+bytes);
                output.write(buffer, 0, 4096);
                output.flush();
                toFinish+=1;
            }
            // transfer last part
            byte[] lastByte = new byte[rest];
            if( ((bytes = Myreader.read(lastByte)) != -1)) {
                output.write(lastByte, 0, rest);
                System.out.println("sending last part"+bytes);
                output.flush();
            }
            socket.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        JOptionPane.showMessageDialog(new JFrame(), "Transfert reussi");

    }
    public int getPortCible() {
        return portCible;
    }

    public void setPortCible(int portCible) {
        this.portCible = portCible;
    }

    public File getFiles() {
        return files;
    }

    public void setFiles(File files) {
        this.files = files;
    }

    public long getByteSize() {
        return byteSize;
    }

    public void setByteSize(long byteSize) {
        this.byteSize = byteSize;
    }

    public int getServerNumber() {
        return serverNumber;
    }

    public void setServerNumber(int serverNumber) {
        this.serverNumber = serverNumber;
    }


}
