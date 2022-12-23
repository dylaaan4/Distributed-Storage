package Server_Repo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class Server_Connection_Event implements  ActionListener {

    Server_Distributed_Interface frame;
    String status="Disconnect";
    boolean connection_visibility = true ;
    
    public Server_Connection_Event(Server_Distributed_Interface frame ) {
        setFrame(frame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if((JButton) e.getSource() == frame.getjButton1()){
            event_for_connection_interface();
            if(connection_visibility==false){
                frame.getStatus_server().setConnection(false);
            }
            setConnection_visibility(!connection_visibility);

        }
    }
    public void event_for_connection_interface(){
        String temp=frame.getjButton1().getText();
        frame.getjButton1().setText(getStatus());
        if(connection_visibility) new Form_Connection(frame).setVisible(true); 
        frame.setVisible(!connection_visibility);
        setStatus(temp);

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Server_Distributed_Interface getFrame() {
        return frame;
    }

    public void setFrame(Server_Distributed_Interface frame) {
        this.frame = frame;
    }

    public boolean isConnection_visibility() {
        return connection_visibility;
    }

    public void setConnection_visibility(boolean connection_visibility) {
        this.connection_visibility = connection_visibility;
    }
    
    
}
