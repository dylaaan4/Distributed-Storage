
package Clients;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

public class Choice_event implements ActionListener {
    Clients_Choice_Interface client ;
    public Choice_event(Clients_Choice_Interface client) {
        setClient(client);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if((JButton)e.getSource()== client.getSend()){
            System.out.println("send");
            JFileChooser js = new JFileChooser();
            js.setCurrentDirectory(new File("."));
            int reponse = js.showOpenDialog(null);
            if(reponse == JFileChooser.APPROVE_OPTION){
                String file = js.getSelectedFile().getAbsolutePath();
                try {
                    getClient().getClients().getClient_appli().setMessageTemp(file);
                    getClient().getClients().getClient_appli().setMessage_mode("send");
                    getClient().getClients().getClient_appli().setTask("send");
                    getClient().getClients().getClient_appli().sleep(5000);
                } catch (Exception exc) {
                    System.out.println(exc);    
                }
            }
        }
        else if((JButton)e.getSource()== client.getReceive()){
            try {
                List_Files lst= new List_Files(client.getClients().getClient_appli());                
                getClient().getClients().getClient_appli().getStylo().writeUTF("get_all_file");
                int size = getClient().getClients().getClient_appli().getLunette().read();
                for (int i = 0; i < size; i++) {
                    ((DefaultTableModel)lst.getjTable1().getModel())
                    .addRow(new Object []{i,getClient().getClients().getClient_appli()
                    .getLunette().readUTF() });
                }
                lst.setVisible(true);
           

            } catch (Exception exc) {
                System.out.println(exc);
            }
        }
        else if((JButton)e.getSource()== client.getExit()){
            client.dispose();
        }
    }

    public Clients_Choice_Interface getClient() {
        return client;
    }

    public void setClient(Clients_Choice_Interface client) {
        this.client = client;
    }
    
}
