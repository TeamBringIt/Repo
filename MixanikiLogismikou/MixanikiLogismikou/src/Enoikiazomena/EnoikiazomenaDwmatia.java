package Enoikiazomena;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnoikiazomenaDwmatia extends javax.swing.JFrame  {
    
    //Database Connection
    public static java.sql.Connection connection(){ 
        String username = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/roomstolet?useUnicode=true&characterEncoding=utf8";
        String query = "SELECT * FROM ROOMS"; 
        try {  
            Class.forName("com.mysql.jdbc.Driver");  
            java.sql.Connection connection = DriverManager.getConnection(url,username,password);  
            Statement statement = connection.createStatement();  
            ResultSet resultSet = statement.executeQuery(query); 
            System.out.println("Connection Established");
            System.out.println("You are now connected to the database Rooms To Let");
            return connection;     
        } catch (ClassNotFoundException | SQLException e) {  
            return null;
        }  
    }  
    
    public static void update(String Name, String CheckIn, String CheckOut, int i) throws SQLException, ParseException{
        if (i!=0){
            System.out.println("System is updating");
            query = "UPDATE ROOMS SET BOOKED = 1 WHERE ROOMNUM = "+i;
            Statement statement = connection().createStatement();
            int resultSet = statement.executeUpdate(query);
            query = "UPDATE ROOMS SET CHECKIN = '"+CheckIn+"' WHERE ROOMNUM = "+i;
            statement = connection().createStatement();
            resultSet = statement.executeUpdate(query);
            query = "UPDATE ROOMS SET CHECKOUT = '"+CheckOut+"' WHERE ROOMNUM = "+i;
            statement = connection().createStatement();
            resultSet = statement.executeUpdate(query);
        }
    }
    
    //main and UI
    private EnoikiazomenaDwmatia() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        adults = new javax.swing.JLabel();
        children = new javax.swing.JLabel();
        adultscount = new javax.swing.JComboBox();
        childrencount = new javax.swing.JComboBox();
        suite = new javax.swing.JCheckBox();
        search = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Booking");

        adults.setText("Adults:");
        adults.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        children.setText("Children:");
        children.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        adultscount.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4" }));
        adultscount.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        childrencount.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4" }));
        childrencount.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        suite.setText("Suite");
        suite.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        search.setText("Search");
        search.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    searchActionPerformed(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(EnoikiazomenaDwmatia.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(EnoikiazomenaDwmatia.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        exit.setText("Exit");
        exit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        jLabel4.setText("Room:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(children)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addComponent(childrencount, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(adults)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(adultscount, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(33, 33, 33)
                        .addComponent(suite)
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(search))
                        .addGap(32, 32, 32))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(adults)
                                    .addComponent(adultscount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(suite))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(children)
                            .addComponent(childrencount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 30, Short.MAX_VALUE)
                        .addComponent(search)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(exit)
                        .addGap(37, 37, 37))))
        );

        pack();
    }// </editor-fold>
        
    //Search Button Action
    private void searchActionPerformed(java.awt.event.ActionEvent evt) throws SQLException, ParseException {                                       
        SearchDB DB = new SearchDB();
 
        String a=(String)adultscount.getSelectedItem();
        adult = Integer.parseInt(a);
        String b=(String)childrencount.getSelectedItem();
        child = Integer.parseInt(b);
        all = adult+child;
        roomt = "TYPICAL";
        if (check = suite.isSelected()){
            roomt = "SUITE";
        }else{
            roomt = "TYPICAL";
        }
        if (all==0){
            query = "SELECT * FROM ROOMS WHERE ROOMTYPE = "+"'"+ roomt + "'"+"&&"+"BOOKED = 0 order by ROOMNUM";
            Statement statement = connection().createStatement();  
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next())
            {
                String roomNum = resultSet.getString("ROOMNUM");
                String booked = resultSet.getString("BOOKED");
                String roomType = resultSet.getString("ROOMTYPE");
                String bedsNum = resultSet.getString("BEDSNUM");
                DB.getElements(roomNum);
                DB.getDetails(booked, roomType, bedsNum);
            }
        }else{
            query = "SELECT * FROM ROOMS WHERE ROOMTYPE = "+"'"+ roomt + "'" +"&&"+ "BEDSNUM >= " +all+"&& BOOKED = 0 order by ROOMNUM";
            Statement statement = connection().createStatement();  
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next())
            {
                String roomNum = resultSet.getString("ROOMNUM");
                String booked = resultSet.getString("BOOKED");
                String roomType = resultSet.getString("ROOMTYPE");
                String bedsNum = resultSet.getString("BEDSNUM");
                DB.getElements(roomNum);
                DB.getDetails(booked, roomType, bedsNum);
            }
        }
        DB.setVisible(true);
        
        
    }    
    
    //Exit Button Action
    private void exitActionPerformed(java.awt.event.ActionEvent evt) {                                     
        System.exit(0);
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
            java.util.logging.Logger.getLogger(EnoikiazomenaDwmatia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EnoikiazomenaDwmatia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EnoikiazomenaDwmatia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EnoikiazomenaDwmatia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
     
        //Connection.connection();
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                new EnoikiazomenaDwmatia().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify                     
    private javax.swing.JLabel adults;
    public javax.swing.JComboBox adultscount;
    private javax.swing.JLabel children;
    public javax.swing.JComboBox childrencount;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    public javax.swing.JButton search;
    public javax.swing.JCheckBox suite;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration                   
    // My variables
    int adult;
    int child;
    int all;
    boolean check;
    String roomt;
    static String query;
    int rIndex;
    String rCheckin;
    String rCheckout;
}


