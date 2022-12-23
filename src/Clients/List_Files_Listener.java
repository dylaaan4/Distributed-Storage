package Clients;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class List_Files_Listener implements ListSelectionListener {
    List_Files lp;
    public List_Files_Listener (List_Files lp){
        setLp(lp);        

    }
    @Override
    public void valueChanged(ListSelectionEvent e) {
            
        try {
            if(e.getValueIsAdjusting()){
                // do nothing
            }else{
                int i =(int) e.getSource().getClass().getMethod("getMinSelectionIndex").invoke(e.getSource());
                getLp().getClient().setMessageTemp(String.valueOf(i));
                getLp().getClient().setMessage_mode("receive");
                getLp().getClient().setTask("receive");
                getLp().setVisible(false);
                getLp().getClient().sleep(5000);
            }
            return ;
        } catch (Exception g) {
            System.out.println(g);
        }
    }
    public List_Files getLp() {
        return lp;
    }

    public void setLp(List_Files lp) {
        this.lp = lp;
    }
}