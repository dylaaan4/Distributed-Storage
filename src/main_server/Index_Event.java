package main_server;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
public class Index_Event implements  ActionListener {

    Server_Interface_Index frame;
    String status="Disconnect";
    boolean connection_visibility = true ;
    
    public Index_Event(Server_Interface_Index frame ) {
        setFrame(frame);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if((JButton) e.getSource() == frame.getjButton1()){
            // for the interface
            event_for_connection_interface();
            // functional event
            event_for_connection();

            // connection
            setConnection_visibility(!connection_visibility);

        }
        if((JButton) e.getSource() == frame.getShower_table()){
            // for the interface
            frame.setVisible(false);
            new List_Client(frame).setVisible(true);;
        }
    }

    public void event_for_connection_interface(){
        String temp=frame.getjButton1().getText();
        frame.getjButton1().setText(getStatus());
        setStatus(temp);
        frame.getConnexion().setVisible(connection_visibility);
        frame.getShower_table().setVisible(connection_visibility);
        frame.getShower_servers_stock().setVisible(connection_visibility);
    }
    public void event_for_connection(){
        if(connection_visibility==true){
            frame.setMain_server(new Main_Server_Tunnel());
            frame.getMain_server().start();
        }
        else{
            try {
                frame.getMain_server().getServer_socket().close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Server_Interface_Index getFrame() {
        return frame;
    }

    public void setFrame(Server_Interface_Index frame) {
        this.frame = frame;
    }

    public boolean isConnection_visibility() {
        return connection_visibility;
    }

    public void setConnection_visibility(boolean connection_visibility) {
        this.connection_visibility = connection_visibility;
    }
    
}
