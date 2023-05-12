/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author nnbil
 */
public class ViewVehicleDetails extends javax.swing.JFrame {

    private Connection conn;
    
    /**
     * Creates new form viewVehicleDetails
     */
    public ViewVehicleDetails() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        vehicleID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        AdvancedQuery = new javax.swing.JTextField();
        RunButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ResultTextArea = new javax.swing.JTextArea();
        BackButton = new javax.swing.JButton();
        FilterButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("View Vehicle Details");

        jLabel2.setText("vehicleID");

        jLabel3.setText("Advanced Filter (using query)");

        RunButton.setText("Run");
        RunButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RunButtonActionPerformed(evt);
            }
        });

        ResultTextArea.setColumns(20);
        ResultTextArea.setRows(5);
        jScrollPane1.setViewportView(ResultTextArea);

        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        FilterButton.setText("Filter");
        FilterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilterButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(BackButton)
                                .addGap(70, 70, 70)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(vehicleID, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(RunButton))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addComponent(AdvancedQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(FilterButton)))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BackButton)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(vehicleID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RunButton))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AdvancedQuery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(FilterButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        // Come back to ViewPanel.java ("Back" button):
        ViewPanel obj = new ViewPanel();
        //Set position&bounds of next window, same as the existing one
        obj.setBounds(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_BackButtonActionPerformed

    private void RunButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RunButtonActionPerformed
        // "RUN" button:
        
        //Clear any previous query results and ready to display the new results obtained from executing the SQL query.
        ResultTextArea.selectAll(); //selects all the text in the TextArea, prepares for replacement of the new query results
        ResultTextArea.replaceSelection(""); //replaces the selected text with an empty string
        
        try {
            ConnectionDB connDB = new ConnectionDB();
            conn = connDB.getCon(); //get Connection: all the stuff - com.mysql.cj.jdbc.Driver, jdbc:mysql://localhost:3306/...

            String query = "SELECT * FROM vehicle WHERE vehicleID = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, vehicleID.getText());
            ResultSet rs = pst.executeQuery();

            // Iterate through the data in the result set and display it.
            // Process query results
            StringBuilder results = new StringBuilder();

            //Fetch the column information for the table
            ResultSetMetaData metaData = rs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            for (int i = 1; i <= numberOfColumns; i++) {
                results.append(metaData.getColumnName(i)).append("\t");
            }
            results.append("\n");
            //  Metadata
            while (rs.next()) {
                //Obtain the results of the query
                for (int i = 1; i <= numberOfColumns; i++) {
                    results.append(rs.getObject(i)).append("\t");
                }
                results.append("\n");
            }

            //Display the results onto Text Area (txtResult)
            ResultTextArea.setText(results.toString());
           
        } catch (SQLException e) {
            ResultTextArea.setText(e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewOwnerDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_RunButtonActionPerformed

    private void FilterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FilterButtonActionPerformed
        // "FILTER" button:
        
        // Check if the user hasn’t input a query, display an error message and return control to the main form
        if (AdvancedQuery.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Please input query string!", "Message", JOptionPane.WARNING_MESSAGE);
            return;
        }

        ResultTextArea.selectAll();
        ResultTextArea.replaceSelection("");
        
        try {
            ConnectionDB connDB = new ConnectionDB();
            conn = connDB.getCon(); //get Connection: all the stuff - com.mysql.cj.jdbc.Driver, jdbc:mysql://localhost:3306/...

            Statement stmt = conn.createStatement();
            String SQL = AdvancedQuery.getText();
            ResultSet rs = stmt.executeQuery(SQL);

// Following code is for DISPLAYing result in TextArea:            
            // Iterate through the data in the result set and display it.
            // Process query results
            StringBuilder results = new StringBuilder();

            //Fetch the column information for the table
            ResultSetMetaData metaData = rs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            for (int i = 1; i <= numberOfColumns; i++) {
                results.append(metaData.getColumnName(i)).append("\t");
            }
            results.append("\n");
            //  Metadata
            while (rs.next()) {
                //Obtain the results of the query
                for (int i = 1; i <= numberOfColumns; i++) {
                    results.append(rs.getObject(i)).append("\t");
                }
                results.append("\n");
            }

            //Display the results onto Text Area (txtResult)
            ResultTextArea.setText(results.toString());
        } // Handle any errors that may have occurred.
        catch (SQLException e) {
            ResultTextArea.setText(e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewOwnerDetails.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_FilterButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ViewVehicleDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewVehicleDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewVehicleDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewVehicleDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewVehicleDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AdvancedQuery;
    private javax.swing.JButton BackButton;
    private javax.swing.JButton FilterButton;
    private javax.swing.JTextArea ResultTextArea;
    private javax.swing.JButton RunButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField vehicleID;
    // End of variables declaration//GEN-END:variables
}
