package main_server;;

/**
 *
 * @author ACER
 */
public class List_Client extends javax.swing.JFrame {

    Server_Interface_Index main;

    public List_Client(Server_Interface_Index main) {
        setMain(main);
        initComponents();
    }
    private void initComponents() {

        div = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        Title = new javax.swing.JLabel();
        exit = new javax.swing.JButton();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        div.setBackground(new java.awt.Color(51, 51, 51));

        Table.setBackground(new java.awt.Color(153, 153, 153));
        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_Client", "Client", "Port", "Options"
            }
        ));
        jScrollPane1.setViewportView(Table);

        Title.setFont(new java.awt.Font("Bookman Old Style", 0, 24)); // NOI18N
        Title.setForeground(new java.awt.Color(0, 153, 153));
        Title.setText("DYM_SERVER");

        exit.setBackground(new java.awt.Color(0, 102, 102));
        exit.setText("EXIT");
        exit.addActionListener(new List_Client_Event(this));

        javax.swing.GroupLayout divLayout = new javax.swing.GroupLayout(div);
        div.setLayout(divLayout);
        divLayout.setHorizontalGroup(
            divLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(divLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(divLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, divLayout.createSequentialGroup()
                        .addComponent(exit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(divLayout.createSequentialGroup()
                        .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        divLayout.setVerticalGroup(
            divLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, divLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(divLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exit))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(div, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(div, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(List_Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(List_Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(List_Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(List_Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new List_Client(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JTable Table;
    private javax.swing.JLabel Title;
    private javax.swing.JButton exit;
    private javax.swing.JPanel div;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration                   

    public Server_Interface_Index getMain() {
        return main;
    }
    public void setMain(Server_Interface_Index main) {
        this.main = main;
    }
    public javax.swing.JTable getTable() {
        return Table;
    }
    public void setTable(javax.swing.JTable table) {
        Table = table;
    }

    public void setTitle(javax.swing.JLabel title) {
        Title = title;
    }
    public javax.swing.JButton getExit() {
        return exit;
    }
    public void setExit(javax.swing.JButton exit) {
        this.exit = exit;
    }
    public javax.swing.JPanel getDiv() {
        return div;
    }
    public void setDiv(javax.swing.JPanel div) {
        this.div = div;
    }
    public javax.swing.JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }
    public void setjScrollPane1(javax.swing.JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }
}
