/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DangNhapXLDL;
import java.awt.Color;
import java.awt.Image;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


/**
 *
 * @author Cong Dan
 */
public class frmDangNhap extends javax.swing.JFrame {

    /**
     * Creates new form frmDangNhap
     */
    //Color c=new Color(1,1,1,.5f);
    DangNhapXLDL dnDL;
    public frmDangNhap() {
        initComponents();
        //jPanel2.setBackground(c);
        setLocationRelativeTo(null);
        loadAnh(lblImgDangNhap, "src\\img\\dangnhapthucung.jpg");
        dnDL= new DangNhapXLDL();
    }
    
    void loadAnh(JLabel lbl,String fileanh){
        //TODO add your handling code here:
        ImageIcon icon= new ImageIcon(fileanh);
        Image image= icon.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_SMOOTH);
        lbl.setIcon(new ImageIcon(image));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnThoat = new rojerusan.RSButtonMetro();
        btnDangNhap = new rojerusan.RSButtonMetro();
        rSButtonMetro2 = new rojerusan.RSButtonMetro();
        rSButtonMetro1 = new rojerusan.RSButtonMetro();
        chkShow = new javax.swing.JCheckBox();
        txtUsername = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        lblImgDangNhap = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnThoat.setBackground(new java.awt.Color(201, 39, 39));
        btnThoat.setText("Thoát");
        btnThoat.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });
        jPanel1.add(btnThoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 470, 130, 50));

        btnDangNhap.setBackground(new java.awt.Color(201, 39, 39));
        btnDangNhap.setText("Đăng nhập");
        btnDangNhap.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });
        jPanel1.add(btnDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 470, 130, 50));

        rSButtonMetro2.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonMetro2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconmk.jpg"))); // NOI18N
        jPanel1.add(rSButtonMetro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, 70, 70));

        rSButtonMetro1.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonMetro1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icontk.jpg"))); // NOI18N
        jPanel1.add(rSButtonMetro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 70, 70));

        chkShow.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        chkShow.setText("Hiện mật khẩu");
        chkShow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chkShowMouseClicked(evt);
            }
        });
        chkShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkShowActionPerformed(evt);
            }
        });
        jPanel1.add(chkShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 420, 140, -1));

        txtUsername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtUsername.setText("Tên tài khoản");
        txtUsername.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsernameFocusGained(evt);
            }
        });
        jPanel1.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 300, 40));

        txtPass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPass.setText("Mật khẩu");
        txtPass.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtPass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPassFocusGained(evt);
            }
        });
        jPanel1.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, 300, 40));

        lblImgDangNhap.setBackground(new java.awt.Color(204, 204, 204));
        lblImgDangNhap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImgDangNhap.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lblImgDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 700));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chkShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkShowActionPerformed
        // TODO add your handling code here:
        if(chkShow.isSelected()){
            txtPass.setEchoChar((char)0);
        }
        else{
            txtPass.setEchoChar('*');
        }
    }//GEN-LAST:event_chkShowActionPerformed

    private void chkShowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkShowMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_chkShowMouseClicked

    private void txtPassFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPassFocusGained
        // TODO add your handling code here:
        txtPass.setText("");
    }//GEN-LAST:event_txtPassFocusGained

    private void txtUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusGained
        // TODO add your handling code here:
        txtUsername.setText("");
    }//GEN-LAST:event_txtUsernameFocusGained

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        // TODO add your handling code here:
        String taikhoan=txtUsername.getText().trim().toString();
        String matkhau=txtPass.getText().trim().toString();
        try {
           String tt= dnDL.dangnhap(taikhoan, matkhau);
            if(!tt.equals("0")){
               
                frmTrangChu frm= new frmTrangChu(tt);
                frm.setVisible(true);
                
                
            }else{
                JOptionPane.showMessageDialog(this, "Tài khoản mật khẩu không chính xác");
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmDangNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDangNhapActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        int chon = JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát?", "Thoát", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (chon == JOptionPane.YES_NO_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnThoatActionPerformed

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
            java.util.logging.Logger.getLogger(frmDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmDangNhap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonMetro btnDangNhap;
    private rojerusan.RSButtonMetro btnThoat;
    private javax.swing.JCheckBox chkShow;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblImgDangNhap;
    private rojerusan.RSButtonMetro rSButtonMetro1;
    private rojerusan.RSButtonMetro rSButtonMetro2;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}