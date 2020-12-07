/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Core.Person;
import DAO.PersonDAO;
import javax.swing.JPanel;

/**
 *
 * @author Bostrap
 */
public class EditForm extends javax.swing.JFrame {
    private PersonDAO personDAO;
    private Person prevPerson;
    private JPanel thisPanel;
    

    /**
     * Creates new form TR_PR
     */
    public EditForm(){
        initComponents();
    }
    public EditForm(JPanel thePanel, Person thePrevPerson, PersonDAO personDAO) {
        this();
        thisPanel = thePanel;
        prevPerson = thePrevPerson;
        this.personDAO = personDAO;
        populateGUI(prevPerson);
    }
    
    private void populateGUI(Person thePrevPerson){
        jTextField5.setText(thePrevPerson.getIdentityID());
        jTextField3.setText(thePrevPerson.getFirstName());
        jTextField7.setText(thePrevPerson.getLastName());
        jTextField6.setText(thePrevPerson.getRelationship());
        jTextField4.setText(thePrevPerson.getPhoneNum());
        jTextField8.setText(thePrevPerson.getAddress());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jTextField6 = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jScrollPane2.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(7, 19, 51));
        jPanel8.setForeground(new java.awt.Color(255, 255, 255));
        jPanel8.setPreferredSize(new java.awt.Dimension(420, 631));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("PingFang HK", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(238, 238, 238));
        jLabel8.setText("Phone Number");
        jPanel8.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, -1, -1));

        jLabel9.setFont(new java.awt.Font("PingFang HK", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(238, 238, 238));
        jLabel9.setText("First Name");
        jPanel8.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 157, -1, -1));

        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator4.setAlignmentX(0.0F);
        jSeparator4.setAlignmentY(0.0F);
        jSeparator4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSeparator4.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jPanel8.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 320, 20));

        jLabel11.setFont(new java.awt.Font("PingFang HK", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(238, 238, 238));
        jLabel11.setText("Last Name");
        jPanel8.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        jSeparator6.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator6.setAlignmentX(0.0F);
        jSeparator6.setAlignmentY(0.0F);
        jSeparator6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSeparator6.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jPanel8.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 320, 20));

        jLabel12.setFont(new java.awt.Font("PingFang HK", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(238, 238, 238));
        jLabel12.setText("Indentity ID");
        jPanel8.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 92, -1, -1));

        jLabel17.setFont(new java.awt.Font("PingFang HK", 0, 20)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(238, 238, 238));
        jLabel17.setText("Edit Person Information");
        jPanel8.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 320, -1));

        jTextField3.setBackground(new java.awt.Color(7, 19, 51));
        jTextField3.setFont(new java.awt.Font("PingFang HK", 0, 12)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(238, 238, 238));
        jTextField3.setBorder(null);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel8.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 320, 19));

        jTextField4.setBackground(new java.awt.Color(7, 19, 51));
        jTextField4.setFont(new java.awt.Font("PingFang HK", 0, 12)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(238, 238, 238));
        jTextField4.setBorder(null);
        jPanel8.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 320, 24));

        jTextField5.setBackground(new java.awt.Color(7, 19, 51));
        jTextField5.setFont(new java.awt.Font("PingFang HK", 0, 12)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(238, 238, 238));
        jTextField5.setBorder(null);
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jPanel8.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 320, 19));

        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator5.setAlignmentX(0.0F);
        jSeparator5.setAlignmentY(0.0F);
        jSeparator5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSeparator5.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jPanel8.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 320, 20));

        jLabel14.setFont(new java.awt.Font("PingFang HK", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(238, 238, 238));
        jLabel14.setText("Relationship");
        jPanel8.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        jSeparator7.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator7.setAlignmentX(0.0F);
        jSeparator7.setAlignmentY(0.0F);
        jSeparator7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSeparator7.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jPanel8.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 320, 20));

        jTextField6.setBackground(new java.awt.Color(7, 19, 51));
        jTextField6.setFont(new java.awt.Font("PingFang HK", 0, 12)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(238, 238, 238));
        jTextField6.setBorder(null);
        jPanel8.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 320, 24));

        jSeparator8.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator8.setAlignmentX(0.0F);
        jSeparator8.setAlignmentY(0.0F);
        jSeparator8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSeparator8.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jPanel8.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 320, 20));

        jTextField7.setBackground(new java.awt.Color(7, 19, 51));
        jTextField7.setFont(new java.awt.Font("PingFang HK", 0, 12)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(238, 238, 238));
        jTextField7.setBorder(null);
        jPanel8.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 320, 24));

        jTextField8.setBackground(new java.awt.Color(7, 19, 51));
        jTextField8.setFont(new java.awt.Font("PingFang HK", 0, 12)); // NOI18N
        jTextField8.setForeground(new java.awt.Color(238, 238, 238));
        jTextField8.setBorder(null);
        jPanel8.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, 320, 24));

        jSeparator9.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator9.setAlignmentX(0.0F);
        jSeparator9.setAlignmentY(0.0F);
        jSeparator9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSeparator9.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jPanel8.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 510, 320, 20));

        jLabel15.setFont(new java.awt.Font("PingFang HK", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(238, 238, 238));
        jLabel15.setText("Address");
        jPanel8.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, -1, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("SAVE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 571, -1, 30));

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(EditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
public void savePerson(){
    String id = prevPerson
}
}