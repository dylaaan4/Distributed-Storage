package Clients;
public class Clients_Choice_Interface extends javax.swing.JFrame {

    Clients_Interface clients ;
    public Clients_Choice_Interface(Clients_Interface clients) {
        setClients(clients);
        initComponents();
    }
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        send = new javax.swing.JButton();
        receive = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Clients/6dc6bfda42e82b400d58717f2c1b0d8a.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Bookman Old Style", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("DYM_Application");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 10, 210, 50);

        send.setBackground(new java.awt.Color(0, 102, 102));
        send.setForeground(new java.awt.Color(255, 255, 255));
        send.setText("Send");
        jPanel1.add(send);
        send.setBounds(60, 150, 80, 30);
        send.addActionListener(new Choice_event(this));
        receive.setBackground(new java.awt.Color(0, 102, 102));
        receive.setForeground(new java.awt.Color(255, 255, 255));
        receive.setText("Receive");
        receive.addActionListener(new Choice_event(this));
        
        jPanel1.add(receive);
        receive.setBounds(240, 150, 72, 30);

        exit.setBackground(new java.awt.Color(0, 102, 102));
        exit.setText("Exit");
        jPanel1.add(exit);
        exit.addActionListener(new Choice_event(this));
        exit.setBounds(310, 250, 75, 23);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Clients/6dc6bfda42e82b400d58717f2c1b0d8a.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(-110, -20, 510, 630);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
        );


        pack();
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
            java.util.logging.Logger.getLogger(Clients_Choice_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Clients_Choice_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Clients_Choice_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Clients_Choice_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Clients_Choice_Interface(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton receive;
    private javax.swing.JButton send;
    // End of variables declaration                   
    public javax.swing.JButton getExit() {
        return exit;
    }
    public void setExit(javax.swing.JButton exit) {
        this.exit = exit;
    }
    public javax.swing.JLabel getjLabel1() {
        return jLabel1;
    }
    public void setjLabel1(javax.swing.JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }
    public javax.swing.JLabel getjLabel2() {
        return jLabel2;
    }
    public void setjLabel2(javax.swing.JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }
    public javax.swing.JLabel getjLabel3() {
        return jLabel3;
    }
    public void setjLabel3(javax.swing.JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }
    public javax.swing.JPanel getjPanel1() {
        return jPanel1;
    }
    public void setjPanel1(javax.swing.JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }
    public javax.swing.JButton getReceive() {
        return receive;
    }
    public void setReceive(javax.swing.JButton receive) {
        this.receive = receive;
    }
    public javax.swing.JButton getSend() {
        return send;
    }
    public void setSend(javax.swing.JButton send) {
        this.send = send;
    }
    public Clients_Interface getClients() {
        return clients;
    }
    public void setClients(Clients_Interface clients) {
        this.clients = clients;
    }
}
