package Server_Repo;
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
        // communication avec server principal
        frame.getSi().setStatus_server(new Server_Activity_Status(port, host, frame.getSi().getServer()));
        // for interface
        frame.getSi().setVisible(true);
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
