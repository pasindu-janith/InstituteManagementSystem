/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package institute_management;

import com.institute.common.MD5;
import com.institute.common.SystemConfigData;
import com.institute.db.DB;
import java.awt.Color;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

/**
 *
 * @author pasindu hathurushigh
 */
public class SystemUserManagement extends javax.swing.JFrame {

    EmployeeManagement empManage;
    private Home home;
    private Design design;
    boolean usernameStat = false;

    /**
     * Creates new form SystemUserManagement
     */
    //default constructor
    public SystemUserManagement() {
        initComponents();
        loadUserType();
        txt_username.grabFocus();
        btn_create.setVisible(false);
        design = new Design();
        setIconImage(design.getIconImage());
    }

    //constructor call from EmployeeManagement
    SystemUserManagement(String empid, String nic, String fullName, EmployeeManagement empManage) {
        this();
        txt_employee.setText(empid + "-" + fullName + "/" + nic);
        this.empManage = empManage;
        empManage.setEnabled(false);
        combo_usertype.setVisible(true);
        combo_employee.setVisible(false);
    }

    //constructor called from Home
    SystemUserManagement(Home home) {
        this();
        this.home = home;
        try {
            ResultSet rs = DB.search("SELECT `fname`,`lname`,`nic` FROM employee WHERE `employeeid`='"
                    + SystemConfigData.getUserid() + "'");
            if (rs.next()) {
                String fullName = rs.getString("fname") + " " + rs.getString("lname");
                txt_employee.setText(SystemConfigData.getUserid() + "-" + fullName + "/" + rs.getString("nic"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        txt_username.setText(SystemConfigData.getUsername());
        usernameStat = true;
        if (SystemConfigData.getUsertype().equals("ADM")) {
            loadEmployee();
            combo_usertype.setEnabled(true);
            combo_employee.setVisible(true);
        } else if (SystemConfigData.getUsertype().equals("USR")) {
            combo_usertype.setEnabled(false);
            combo_employee.setVisible(false);
            rad_active.setVisible(false);
            rad_inactive.setVisible(false);
            combo_usertype.setSelectedItem("USR-USER");
        }
        jButton2.setVisible(false);
        jButton1.setText("UPDATE");
    }

    private SystemUserManagement(String empid, String nic, String fullName, Home h) {
        this();
        this.home = h;
        txt_employee.setText(empid + "-" + fullName + "/" + nic);
        combo_usertype.setVisible(true);
        combo_employee.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        combo_employee = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txt_employee = new javax.swing.JTextField();
        btn_create = new javax.swing.JButton();
        combo_usertype = new javax.swing.JComboBox<>();
        txt_username = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_password = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_repassword = new javax.swing.JPasswordField();
        rad_active = new javax.swing.JRadioButton();
        rad_inactive = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("System User Management");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                homeEnable(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        combo_employee.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        combo_employee.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_employee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_employeeActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel5.setText("Employee");

        txt_employee.setEditable(false);
        txt_employee.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        btn_create.setBackground(new java.awt.Color(102, 102, 102));
        btn_create.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btn_create.setForeground(new java.awt.Color(255, 255, 255));
        btn_create.setText("Create New Account");
        btn_create.setContentAreaFilled(false);
        btn_create.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_create.setFocusPainted(false);
        btn_create.setOpaque(true);
        btn_create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_createActionPerformed(evt);
            }
        });

        combo_usertype.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        combo_usertype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txt_username.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txt_username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_usernameKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel2.setText("User Name");

        txt_password.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel3.setText("Password");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel4.setText("Re-Enter Password");

        txt_repassword.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        buttonGroup1.add(rad_active);
        rad_active.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        rad_active.setSelected(true);
        rad_active.setText("Active");
        rad_active.setContentAreaFilled(false);
        rad_active.setFocusPainted(false);

        buttonGroup1.add(rad_inactive);
        rad_inactive.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        rad_inactive.setText("Inactive");
        rad_inactive.setContentAreaFilled(false);
        rad_inactive.setFocusPainted(false);

        jButton2.setBackground(new java.awt.Color(204, 0, 0));
        jButton2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("No");
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setFocusPainted(false);
        jButton2.setOpaque(true);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 153, 0));
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Save");
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.setOpaque(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel6.setText("Do you want to make this employee System user?");

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel7.setText("User Type");

        jLabel1.setBackground(new java.awt.Color(0, 102, 153));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("    SYSTEM USER DETAILS");
        jLabel1.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rad_active)
                                .addGap(49, 49, 49)
                                .addComponent(rad_inactive)
                                .addGap(0, 208, Short.MAX_VALUE))
                            .addComponent(txt_repassword)
                            .addComponent(txt_password))
                        .addGap(135, 135, 135))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(320, 320, 320))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txt_username)
                                        .addGap(30, 30, 30)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(combo_usertype, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txt_employee, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(combo_employee, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_create)))))
                        .addGap(40, 40, 40))))
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(txt_employee, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combo_employee, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_create, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel5)))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_usertype, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_repassword, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rad_active)
                    .addComponent(rad_inactive))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (usernameStat) {
            if (txt_password.getPassword().length >= 5 || !txt_password.isEditable()) {
                String password = new String(txt_password.getPassword());
                String repassword = new String(txt_repassword.getPassword());
                if (password.equals(repassword)) {
                    String hashPassword = MD5.getMd5(password);
                    try {
                        if (SystemConfigData.getUserid().equals(txt_employee.getText().split("-")[0])) {
                            //update self account
                            DB.push("UPDATE systemuser SET `username`='"
                                    + txt_username.getText() + "',`password`='"
                                    + hashPassword + "',`usertype`='"
                                    + combo_usertype.getSelectedItem().toString().split("-")[0] + "' WHERE `employee`='"
                                    + txt_employee.getText().split("-")[0] + "'");
                            JOptionPane.showMessageDialog(this, "System User updated");
                            home.setEnabled(true);
                            this.dispose();
                        } else {
                            //update or enter another ones account
                            //Create anotherones account from employee   
                            int status = (rad_active.isSelected()) ? 1 : 0;
                            try {
                                DB.push("INSERT INTO systemuser VALUES('"
                                        + txt_employee.getText().split("-")[0] + "','"
                                        + combo_usertype.getSelectedItem().toString().split("-")[0] + "','"
                                        + txt_username.getText() + "','"
                                        + hashPassword + "','" + status + "')");
                                JOptionPane.showMessageDialog(this, "Employee and systemuser Registered successfully!",
                                        "Success", JOptionPane.PLAIN_MESSAGE, design.getSuccessIcon());
                                if (empManage != null) {
                                    empManage.setEnabled(true);
                                    empManage.clearFields();
                                } else if (home != null) {
                                    home.setEnabled(true);
                                }
                            } catch (java.sql.SQLIntegrityConstraintViolationException e) {
                                DB.push("UPDATE systemuser SET `username`='"
                                        + txt_username.getText() + "',`usertype`='"
                                        + combo_usertype.getSelectedItem().toString().split("-")[0] + "',`status`='"
                                        + status+"' WHERE `employee`='"
                                        + txt_employee.getText().split("-")[0] + "'");
                                JOptionPane.showMessageDialog(this, "System User updated");
                                home.setEnabled(true);
                            } finally {
                                this.dispose();
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Passwords not match");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Enter valid password");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Duplicate username. try another one.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JOptionPane.showMessageDialog(this, "Employee Registered successfully!",
                "Success", JOptionPane.PLAIN_MESSAGE, design.getSuccessIcon());
        empManage.clearFields();
        this.dispose();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void combo_employeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_employeeActionPerformed
        txt_employee.setText(combo_employee.getSelectedItem().toString());
        try {
            ResultSet rs = DB.search("SELECT `username`,`usertype`,`status` FROM systemuser WHERE `employee`='"
                    + combo_employee.getSelectedItem().toString().split("-")[0] + "'");
            if (rs.next()) {
                txt_username.setForeground(Color.BLACK);
                txt_username.setText(rs.getString("username"));
                btn_create.setVisible(false);
                if (rs.getString("usertype").equals("ADM")) {
                    combo_usertype.setSelectedItem("ADM-ADMIN");
                } else {
                    combo_usertype.setSelectedItem("USR-USER");
                }
                
                if(rs.getString("status").equals("1"))
                    rad_active.setSelected(true);
                else
                    rad_inactive.setSelected(true);
            
            } else {
                txt_username.setForeground(Color.RED);
                txt_username.setText("NO SYSTEM USER ACCOUNT");
                if (SystemConfigData.getUsertype().equals("ADM")) {
                    btn_create.setVisible(true);
                } else {
                    btn_create.setVisible(false);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (combo_employee.getSelectedItem().toString().split("-")[0].equals(SystemConfigData.getUserid())) {
            txt_username.setEditable(true);
            txt_password.setEditable(true);
            txt_repassword.setEditable(true);
            txt_username.grabFocus();
            usernameStat = true;
        } else {
            txt_username.setEditable(false);
            txt_password.setEditable(false);
            txt_repassword.setEditable(false);
        }
    }//GEN-LAST:event_combo_employeeActionPerformed

    private void btn_createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_createActionPerformed
        String empName[] = combo_employee.getSelectedItem().toString().split("-");
        SystemUserManagement suser = new SystemUserManagement(empName[0],
                empName[1].split("/")[1], empName[1].split("/")[0], this.home);
        suser.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_createActionPerformed

    private void homeEnable(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_homeEnable
        if (home != null) {
            home.setEnabled(true);
        }
        this.dispose();
    }//GEN-LAST:event_homeEnable

    private void txt_usernameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usernameKeyReleased
        try {
            ResultSet rs = DB.search("SELECT * FROM systemuser WHERE `username`='"
                    + txt_username.getText() + "' AND `employee` != '" + txt_employee.getText().split("-")[0] + "'");
            if (rs.next() || txt_username.getText().equals("")) {
                txt_username.setBorder(new LineBorder(Color.RED));
                usernameStat = false;
            } else {
                txt_username.setBorder(new LineBorder(Color.GREEN));
                usernameStat = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_txt_usernameKeyReleased

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
            java.util.logging.Logger.getLogger(SystemUserManagement.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SystemUserManagement.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SystemUserManagement.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SystemUserManagement.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SystemUserManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_create;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> combo_employee;
    private javax.swing.JComboBox<String> combo_usertype;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rad_active;
    private javax.swing.JRadioButton rad_inactive;
    private javax.swing.JTextField txt_employee;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JPasswordField txt_repassword;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables

    private void loadUserType() {
        try {
            ResultSet rs = DB.search("SELECT * FROM usertype");
            Vector v = new Vector();
            while (rs.next()) {
                v.add(rs.getString("id") + "-" + rs.getString("type"));
            }
            combo_usertype.setModel(new DefaultComboBoxModel<>(v));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadEmployee() {
        try {
            ResultSet rs = DB.search("SELECT `employeeid`,`fname`,`lname`,`nic` FROM employee WHERE `status`='1'");
            Vector v = new Vector();
            while (rs.next()) {
                v.add(rs.getString("employeeid") + "-" + rs.getString("fname") + " "
                        + rs.getString("lname") + "/" + rs.getString("nic"));
            }
            combo_employee.setModel(new DefaultComboBoxModel<>(v));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
