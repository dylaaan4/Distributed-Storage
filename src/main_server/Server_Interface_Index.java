package main_server;

import javax.swing.JFrame;

public class Server_Interface_Index extends JFrame {
        // Variables declaration -                      
        private javax.swing.JLabel BackGround;
        private javax.swing.JPanel Content;
        private javax.swing.JLabel Text_area;
        private javax.swing.JLabel Title;
        private javax.swing.JButton jButton1;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel connexion;
        private javax.swing.JButton shower_table;
        private javax.swing.JButton shower_servers_stock;
        private Main_Server_Tunnel main_server ;
        // End of variables declaration                   

    public Server_Interface_Index(Main_Server_Tunnel main_server) {
        setMain_server(main_server);
        initComponents();
    }

    private void initComponents() {

        Content = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        Text_area = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        connexion = new javax.swing.JLabel();
        shower_table = new javax.swing.JButton();
        shower_servers_stock = new javax.swing.JButton();
        BackGround = new javax.swing.JLabel();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Content.setLayout(null);

        Title.setFont(new java.awt.Font("Bookman Old Style", 0, 36)); // NOI18N
        Title.setForeground(new java.awt.Color(0, 153, 153));
        Title.setText("DYM_SERVER");
        Content.add(Title);
        Title.setBounds(6, 39, 320, 43);

        Text_area.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Text_area.setForeground(new java.awt.Color(255, 255, 255));
        Text_area.setText("This is the main controller for the distributed stockage");
        Content.add(Text_area);
        Text_area.setBounds(6, 106, 370, 40);

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Connect");
        jButton1.addActionListener(new Index_Event(this));
        Content.add(jButton1);
        jButton1.setBounds(230, 190, 100, 27);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("The server's port is : 2219");
        Content.add(jLabel1);
        jLabel1.setBounds(6, 152, 164, 26);

        connexion.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        connexion.setForeground(new java.awt.Color(0, 153, 51));
        connexion.setText("Connected");
        Content.add(connexion);
        connexion.setBounds(20, 270, 90, 30);
        connexion.setVisible(false);

        shower_table.setBackground(new java.awt.Color(0, 153, 153));
        shower_table.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        shower_table.setForeground(new java.awt.Color(0, 0, 0));
        shower_table.setText("Show clients");
        shower_table.addActionListener(new Index_Event(this));

        shower_servers_stock.setBackground(new java.awt.Color(0, 153, 153));
        shower_servers_stock.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        shower_servers_stock.setForeground(new java.awt.Color(0, 0, 0));
        shower_servers_stock.setText("Show servers");
        shower_servers_stock.addActionListener(new Index_Event(this));


        Content.add(shower_table);
        shower_table.setBounds(10, 320, 110, 27);
        shower_table.setVisible(false);

        Content.add(shower_servers_stock);
        shower_servers_stock.setBounds(10, 355, 110, 27);
        shower_servers_stock.setVisible(false);


        BackGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main_server/6dc6bfda42e82b400d58717f2c1b0d8a.jpg"))); // NOI18N
        BackGround.setText("jLabel");
        Content.add(BackGround);
        BackGround.setBounds(-110, 0, 520, 720);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Content, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Content, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(Server_Interface_Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Server_Interface_Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Server_Interface_Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Server_Interface_Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Server_Interface_Index(new Main_Server_Tunnel()).setVisible(true);
            }
        });
    }

    public javax.swing.JLabel getBackGround() {
        return BackGround;
    }

    public void setBackGround(javax.swing.JLabel backGround) {
        BackGround = backGround;
    }

    public javax.swing.JPanel getContent() {
        return Content;
    }

    public void setContent(javax.swing.JPanel content) {
        Content = content;
    }

    public javax.swing.JLabel getText_area() {
        return Text_area;
    }

    public void setText_area(javax.swing.JLabel text_area) {
        Text_area = text_area;
    }

    public void setTitle(javax.swing.JLabel title) {
        Title = title;
    }

    public javax.swing.JButton getjButton1() {
        return jButton1;
    }

    public void setjButton1(javax.swing.JButton jButton1) {
        this.jButton1 = jButton1;
    }

    public javax.swing.JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(javax.swing.JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }



    public javax.swing.JLabel getConnexion() {
        return connexion;
    }

    public void setConnexion(javax.swing.JLabel connexion) {
        this.connexion = connexion;
    }


    public javax.swing.JButton getShower_table() {
        return shower_table;
    }

    public void setShower_table(javax.swing.JButton shower_table) {
        this.shower_table = shower_table;
    }


    public javax.swing.JButton getShower_servers_stock() {
        return shower_servers_stock;
    }

    public void setShower_servers_stock(javax.swing.JButton shower_servers_stock) {
        this.shower_servers_stock = shower_servers_stock;
    }

    public void setMain_server(Main_Server_Tunnel main_server) {
        this.main_server = main_server;
    }

    public javax.swing.JLabel getMyTitle() {
        return Title;
    }

    public Main_Server_Tunnel getMain_server() {
        return main_server;
    }


}
