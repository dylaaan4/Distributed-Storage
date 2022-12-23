package main_server;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class List_Client_Event implements  ActionListener {

    List_Client frame;
    
    public List_Client_Event(List_Client  frame ) {
        setFrame(frame);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if((JButton)e.getSource()== frame.getExit()){
            frame.dispose();
            frame.getMain().setVisible(true);
        }
    }



    public List_Client  getFrame() {
        return frame;
    }

    public void setFrame(List_Client  frame) {
        this.frame = frame;
    }

    
}
