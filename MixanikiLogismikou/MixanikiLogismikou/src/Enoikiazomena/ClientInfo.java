
package Enoikiazomena;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ClientInfo extends javax.swing.JFrame {

    public ClientInfo() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        fullName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        checkin = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        checkout = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        clientOK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Full Name:");

        jLabel2.setText("Check-in Date:");

        jLabel3.setText("Check-out Date:");

        jLabel4.setText("Example: John Black");

        jLabel5.setText("Example: 2012-07-24");

        jLabel6.setText("Example: 2012-07-24");

        clientOK.setText("OK");
        clientOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    clientOKActionPerformed(evt);
                } catch (        SQLException | ParseException ex) {
                    Logger.getLogger(ClientInfo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clientOK)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(checkout, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addComponent(checkin)
                                .addComponent(jLabel4)
                                .addComponent(fullName)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(checkin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jLabel5)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(checkout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(clientOK)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>
    
     private void clientOKActionPerformed(java.awt.event.ActionEvent evt)throws SQLException, ParseException {
         this.checking();
         Name = getClientName();
         DateIn = getCheckin();
         DateOut = getCheckout();
         this.getIndex(j);
         SearchDB.returnInfo(Name, DateIn, DateOut, j);
         this.dispose();
     }
    
    //Checks if inputs are correct
    private void checking(){
        if(fullName.getText()==null || checkin.getText()==null || checkout.getText()==null){
            JOptionPane.showMessageDialog(null, "Please check your informations");
            checkin.setText("0000-00-00");
            checkout.setText("0000-00-00");
            j=0;
        }else if (checkin.getText().trim().length() != dateFormat.toPattern().length() || checkout.getText().trim().length() != dateFormat.toPattern().length()){
            JOptionPane.showMessageDialog(null, "Please check your informations");
            checkin.setText("0000-00-00");
            checkout.setText("0000-00-00");
            j=0;
        }
    }
    
    private String getClientName(){
        return Name = fullName.getText();
    }
    
    private String getCheckin(){
        return DateIn = checkin.getText();
    }
    
    private String getCheckout(){
        return DateOut = checkout.getText();
    }
    
    public void getIndex(int i){
        j=i;
    }
    
    // Variables declaration
    private javax.swing.JButton clientOK;
    private javax.swing.JTextField fullName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField checkin;
    private javax.swing.JTextField checkout;
    // End of variables declaration
    // My variables
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    static int j;
    String Name;
    String DateIn;
    String DateOut;
}
