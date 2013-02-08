
package Enoikiazomena;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

public class SearchDB extends javax.swing.JFrame {

    public SearchDB() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        results = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        details = new javax.swing.JButton();
        book = new javax.swing.JButton();
        newsearch = new javax.swing.JButton();
        quit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(results);
        results.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        jLabel1.setText("Available Rooms:");

        details.setText("Details...");
        details.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailsActionPerformed(evt);
            }
        });

        book.setText("Book");
        book.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookActionPerformed(evt);
            }
        });

        newsearch.setText("New Search");
        newsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newsearchActionPerformed(evt);
            }
        });

        quit.setText("Exit");
        quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(book, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(details, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(newsearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(quit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(details)
                        .addGap(18, 18, 18)
                        .addComponent(book)
                        .addGap(18, 18, 18)
                        .addComponent(newsearch)
                        .addGap(18, 18, 18)
                        .addComponent(quit))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void quitActionPerformed(java.awt.event.ActionEvent evt) {                                     
        System.exit(0);
    }                                    

    private void newsearchActionPerformed(java.awt.event.ActionEvent evt) {                                          
        this.dispose();
    }                                         

    private void detailsActionPerformed(java.awt.event.ActionEvent evt) {
        if (results.isSelectionEmpty()){
            JOptionPane.showMessageDialog(null, "Please select a room");
        }else{
            i = results.getSelectedIndex();
            D.setVisible(true);
            D.setLabels(i);
        } 
    }                                       

    private void bookActionPerformed(java.awt.event.ActionEvent evt) {
         if (results.isSelectionEmpty()){
            JOptionPane.showMessageDialog(null, "Please select a room");
        }else{
            i = results.getSelectedIndex();
            this.dispose();
            ClientInfo info = new ClientInfo();
            info.getIndex(i);
            info.setVisible(true);
        } 
    }
   
    // Variables declaration - do not modify                     
    private javax.swing.JButton book;
    private javax.swing.JButton details;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton newsearch;
    private javax.swing.JButton quit;
    public javax.swing.JList results;
    // End of variables declaration
    static int i=0;
  
    DefaultListModel model = new DefaultListModel();
    Details D = new Details();
    
    public void getElements(String roomNum) {
        System.out.println(roomNum);
        model.addElement(roomNum);
        results.setModel(model);   
    }
    
    public void getDetails(String booked, String type, String beds){
        D.getDetails(booked, type, beds);
    }
    public static void returnInfo(String Name, String Datein, String Dateout, int j)throws SQLException, ParseException{
        EnoikiazomenaDwmatia.update(Name, Datein, Dateout, j);
    }
    
}