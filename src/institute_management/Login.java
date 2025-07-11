/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package institute_management;

import com.institute.common.DateAndTime;
import com.institute.common.MD5;
import com.institute.common.SendEmail;
import com.institute.common.SystemConfigData;
import com.institute.common.SystemVariable;
import com.institute.db.DB;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import javax.mail.MessagingException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author pasindu hathurushigh
 */
public class Login extends javax.swing.JFrame {

    private Design design;
    private Home home;

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        design = new Design();
        setIconImage(design.getIconImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        load_bar = new javax.swing.JProgressBar();
        jButton1 = new javax.swing.JButton();
        txt_password = new javax.swing.JPasswordField();
        txt_username = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        load_bar.setBackground(new java.awt.Color(0, 153, 153));
        load_bar.setBorderPainted(false);
        getContentPane().add(load_bar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 534, 600, 10));

        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 380, 330, 60));

        txt_password.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txt_password.setForeground(new java.awt.Color(0, 51, 102));
        txt_password.setBorder(null);
        txt_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_passwordKeyReleased(evt);
            }
        });
        getContentPane().add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 273, 280, 40));

        txt_username.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        txt_username.setForeground(new java.awt.Color(0, 51, 102));
        txt_username.setBorder(null);
        txt_username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_usernameKeyReleased(evt);
            }
        });
        getContentPane().add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 180, 280, 40));

        jButton2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Forgot Password? Click Here to Reset");
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 460, 360, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/institute/images/loginimage.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!txt_username.getText().equals("") && txt_username.getText() != null
                && !txt_password.getPassword().equals("")) {
            try {
                String username = txt_username.getText();
                String password = new String(txt_password.getPassword());
                String hashpassword = MD5.getMd5(password);
                Connection connection = DB.getConnectionDB();
                String sql = "SELECT * FROM systemuser WHERE `username`=? AND `password`=? AND `status`='1'";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, hashpassword);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    SystemConfigData.setUserid(rs.getString("employee"));
                    SystemConfigData.setUsername(rs.getString("username"));
                    SystemConfigData.setUsertype(rs.getString("usertype"));
                    DB.push("INSERT INTO userlogin(employee,datetime) VALUES('"
                            + rs.getString("employee") + "','"
                            + DateAndTime.getDateTime() + "')");

                    load();
                } else {
                    JOptionPane.showMessageDialog(this, "Username and Password not match", "Login Error",
                            JOptionPane.ERROR_MESSAGE, this.getPwdErrorIcon());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (true) {
            try {
                ResultSet rs = DB.search("SELECT `fname`,`lname`,`email` FROM employee WHERE `employeeid`="
                        + "(SELECT `employee` FROM systemuser WHERE `username`='"
                        + txt_username.getText() + "' AND `status`='1')");
                if (rs.next()) {
                    String fullName = rs.getString("fname") + " " + rs.getString("lname");
                    Random rand = new Random();
                    int random = rand.nextInt(1000000);
                    String randomPass = String.valueOf(random);
                    String randomHashPassword = MD5.getMd5(randomPass);
                    try {
                        int confirmOption = JOptionPane.showConfirmDialog(this,
                                "Are you sure reset your password! New Password will be sent to your Email account",
                                "Forgot Password", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                                design.getQuestionIcon());
                        if (confirmOption == JOptionPane.YES_OPTION) {
                            SendEmail.sendMail(rs.getString("email"), SystemVariable.DEFAULT_EMAIL_ADDRESS,
                                    SystemVariable.DEFAULT_EMAIL_PASSWORD, "Education Institute System",
                                    "Dear " + fullName + ", Your System Login password has changed. New password is "
                                    + randomPass);

                            DB.push("UPDATE systemuser SET `password`='"
                                    + randomHashPassword + "' WHERE `username`='"
                                    + txt_username.getText() + "'");
                            JOptionPane.showMessageDialog(this, "Check your Email");
                        }
                    } catch (MessagingException mex) {
                        JOptionPane.showMessageDialog(this, "Error in Email send! Check your internet connection and Email!");
                    } catch (NullPointerException en) {
                        JOptionPane.showMessageDialog(this, "No Email address added to send mail");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "No registered user form this username");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_usernameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usernameKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            txt_password.grabFocus();
        }
    }//GEN-LAST:event_txt_usernameKeyReleased

    private void txt_passwordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            txt_username.grabFocus();
        }
    }//GEN-LAST:event_txt_passwordKeyReleased

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JProgressBar load_bar;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables

    private void load() {
        load_bar.setOpaque(false);
        if (home == null) {
            home = new Home();
        }
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int value = 0; value < 101; value++) {
                    load_bar.setValue(value);
                    if (value == 100) {
                        home.setVisible(true);
                        dispose();
                    }
                    try {
                        Thread.sleep(10);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();
    }

    private ImageIcon getPwdErrorIcon() {
        ImageIcon img = new ImageIcon("src/com/institute/images/password.png");
        return img;
    }
}
