package Server_Repo;

public class Server_Two_Interface extends Server_Distributed_Interface {
    private Server_Activity_Status status ;
    private ServerPart2 server2 ;

    public Server_Two_Interface() {
        setServer(new ServerPart2()) ;
        getServer().start();
        setText("This is the second server for the distributed stockage");
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
            java.util.logging.Logger.getLogger(Server_Two_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Server_Two_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Server_Two_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Server_Two_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Server_Two_Interface().setVisible(true);
            }
        });
    }

    public Server_Activity_Status getStatus() {
        return status;
    }

    public void setStatus(Server_Activity_Status status) {
        this.status = status;
    }

    public ServerPart2 getServer2() {
        return server2;
    }

    public void setServer2(ServerPart2 server2) {
        this.server2 = server2;
    }


}
