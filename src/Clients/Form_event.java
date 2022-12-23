package Clients;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Form_event implements  ActionListener{
    Form_Connection frame;
    boolean connection_visibility = true ;

    public Form_event(Form_Connection frame ) {
        setFrame(frame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
// for functionality
        String host = frame.getHost_text().getText();
        int port = Integer.valueOf(frame.getPort_text().getText());
        try {
            frame.getSi().setClient_appli(new Client(null, host, port));
        } catch (Exception exc) {
            System.out.println(exc);
        }
// for interface
        new Clients_Choice_Interface(frame.getSi()).setVisible(true);;
    frame.dispose();        

    }

    public Form_Connection getFrame() {
        return frame;
    }

    public void setFrame(Form_Connection frame) {
        this.frame = frame;
    }

    public boolean isConnection_visibility() {
        return connection_visibility;
    }

    public void setConnection_visibility(boolean connection_visibility) {
        this.connection_visibility = connection_visibility;
    }
    
}
