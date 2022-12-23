package Clients;

public class Form_Connection extends javax.swing.JFrame {
    private  Clients_Interface si ;
    public Form_Connection( Clients_Interface si) {
        setSi(si);
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        myTitle = new javax.swing.JLabel();
        host_label = new javax.swing.JLabel();
        port_label = new javax.swing.JLabel();
        host_text = new javax.swing.JTextField();
        port_text = new javax.swing.JTextField();
        valid_button = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        myTitle.setFont(new java.awt.Font("Bookman Old Style", 0, 24)); // NOI18N
        myTitle.setForeground(new java.awt.Color(0, 102, 102));
        myTitle.setText("DYM_SERVER");
        jPanel1.add(myTitle);
        myTitle.setBounds(20, 40, 180, 29);

        host_label.setForeground(new java.awt.Color(255, 255, 255));
        host_label.setText("Host :");
        jPanel1.add(host_label);
        host_label.setBounds(100, 100, 70, 16);

        port_label.setForeground(new java.awt.Color(255, 255, 255));
        port_label.setText("Port number :");
        jPanel1.add(port_label);
        port_label.setBounds(100, 160, 90, 16);

        host_text.setText(" ");
        jPanel1.add(host_text);
        host_text.setBounds(190, 100, 64, 22);

        port_text.setText(" ");
        jPanel1.add(port_text);
        port_text.setBounds(190, 160, 64, 22);

        valid_button.setBackground(new java.awt.Color(0, 102, 102));
        valid_button.setText("Valid");
        jPanel1.add(valid_button);
        valid_button.setBounds(260, 220, 72, 23);
        valid_button.addActionListener(new Form_event(this));
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Clients/6dc6bfda42e82b400d58717f2c1b0d8a.jpg"))); // NOI18N
        background.setText(" ");
        jPanel1.add(background);
        background.setBounds(-110, -10, 530, 710);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
        );


        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify                     
    private javax.swing.JLabel background;
    private javax.swing.JLabel host_label;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField host_text;
    private javax.swing.JTextField port_text;
    private javax.swing.JLabel myTitle;
    private javax.swing.JLabel port_label;
    private javax.swing.JButton valid_button;
    // End of variables declaration                   
    public javax.swing.JLabel geMytBackground() {
        return background;
    }

    public void setBackground(javax.swing.JLabel background) {
        this.background = background;
    }

    public javax.swing.JLabel getHost_label() {
        return host_label;
    }

    public void setHost_label(javax.swing.JLabel host_label) {
        this.host_label = host_label;
    }

    public javax.swing.JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(javax.swing.JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public javax.swing.JTextField getHost_text() {
        return host_text;
    }

    public void setHost_text(javax.swing.JTextField host_text) {
        this.host_text = host_text;
    }

    public javax.swing.JTextField getPort_text() {
        return port_text;
    }

    public void setPort_text(javax.swing.JTextField port_text) {
        this.port_text = port_text;
    }

    public javax.swing.JLabel getMyTitle() {
        return myTitle;
    }

    public void setMyTitle(javax.swing.JLabel myTitle) {
        this.myTitle = myTitle;
    }

    public javax.swing.JLabel getPort_label() {
        return port_label;
    }

    public void setPort_label(javax.swing.JLabel port_label) {
        this.port_label = port_label;
    }

    public javax.swing.JButton getValid_button() {
        return valid_button;
    }

    public void setValid_button(javax.swing.JButton valid_button) {
        this.valid_button = valid_button;
    }

    public Clients_Interface getSi() {
        return si;
    }

    public void setSi(Clients_Interface si) {
        this.si = si;
    }

    public javax.swing.JLabel getMyBackground() {
        return background;
    }
}
