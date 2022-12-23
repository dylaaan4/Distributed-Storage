package Server_Repo;

public class Server_Three_Interface extends Server_Distributed_Interface {
    private Server_Activity_Status status ;
    private ServerPart3 server3 ;
    public Server_Three_Interface() {
        setServer(new ServerPart3()) ;
        getServer().start();

        setText("This is the third server for the distributed stockage");
        initComponents();
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Server_Three_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Server_Three_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Server_Three_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Server_Three_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Server_Three_Interface().setVisible(true);
            }
        });
    }

    public Server_Activity_Status getStatus() {
        return status;
    }

    public void setStatus(Server_Activity_Status status) {
        this.status = status;
    }

    public ServerPart3 getServer3() {
        return server3;
    }

    public void setServer3(ServerPart3 server3) {
        this.server3 = server3;
    }


}
