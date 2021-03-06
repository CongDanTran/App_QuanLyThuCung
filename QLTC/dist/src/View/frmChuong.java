/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ChuongXLDL;
import Controller.DAO;
import Controller.NhanVienXLDL;
import Model.TblChuong;
import Model.TblNhanVien;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Cong Dan
 */
public class frmChuong extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmChuong
     */
    ChuongXLDL nvDL;
    DefaultTableModel table;
    DAO dao;
    Color mauxanh = new Color(0, 112, 192);

    public frmChuong() {
        initComponents();
        nvDL = new ChuongXLDL();
        loadAnh(lblSearch, "src\\img\\tk.png");
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        loadNV();
        dao = new DAO("jdbc:sqlserver://localhost:1433;databaseName=QLTC;username=sa;password=123;");
        btnLuu.setEnabled(false);
        btnLuu.setBackground(Color.GRAY);
    }

    void loadAnh(JLabel lbl, String fileanh) {
        //TODO add your handling code here:
        ImageIcon icon = new ImageIcon(fileanh);
        Image image = icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        lbl.setIcon(new ImageIcon(image));
    }

    void loadNV() {
        ArrayList<TblChuong> list;
        try {
            list = nvDL.getListNV("0");
            table = (DefaultTableModel) tblChuongThu.getModel();
            for (TblChuong nv : list) {
                table.addRow(new Object[]{nv.getMaChuong(), nv.getTenChuong(), nv.getLoaiChuong(), nv.getGia(), nv.getTrangThai()});
            }
        } catch (SQLException ex) {

        }
    }

    private boolean KTDL() throws HeadlessException {
        StringBuilder sb = new StringBuilder();
        if (txtTenChuong.getText().equals("")) {
            sb.append("Vui l??ng nh???p t??n chu???ng\n");
            txtTenChuong.requestFocus();
        }
        if (txtLoaiChuong.getText().equals("")) {
            sb.append("Vui l??ng nh???p lo???i chu???ng\n");
            txtLoaiChuong.requestFocus();
        }
        if (txtGia.getText().equals("")) {
            sb.append("Vui l??ng nh???p gi??\n");
            txtGia.requestFocus();
        }
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(this, sb.toString(), "Th??ng b??o", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
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
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaChuong = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtTenChuong = new javax.swing.JTextField();
        txtLoaiChuong = new javax.swing.JTextField();
        txtTrangThai = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        btnThem = new rojerusan.RSButtonMetro();
        btnSua = new rojerusan.RSButtonMetro();
        btnXoa = new rojerusan.RSButtonMetro();
        btnLuu = new rojerusan.RSButtonMetro();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblChuongThu = new rojeru_san.complementos.RSTableMetro();
        btnHuy = new rojerusan.RSButtonMetro();
        txtTimKiem = new app.bolivia.swing.JCTextField();
        lblSearch = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setText("Tr???ng Th??i:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Lo???i Chu???ng:");

        txtMaChuong.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtMaChuong.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setText("Th??ng Tin Chu???ng Th??");

        txtTenChuong.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtLoaiChuong.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtTrangThai.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("M?? Chu???ng:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("T??n Chu???ng:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setText("Gi??:");

        txtGia.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnThem.setText("Th??m");
        btnThem.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("S???a");
        btnSua.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("X??a");
        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnLuu.setText("L??u");
        btnLuu.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        tblChuongThu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "M?? chu???ng", "T??n chu???ng", "Lo???i chu???ng", "Gi??", "Tr???ng th??i"
            }
        ));
        tblChuongThu.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tblChuongThu.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tblChuongThu.setFuenteFilas(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tblChuongThu.setFuenteFilasSelect(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tblChuongThu.setRowHeight(25);
        tblChuongThu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChuongThuMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblChuongThu);

        btnHuy.setText("H???y");
        btnHuy.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        txtTimKiem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTimKiem.setPlaceholder("T??m ki???m t???i ????y...");

        lblSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSearchMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(542, 542, 542)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(54, 54, 54)
                        .addComponent(txtMaChuong, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(243, 243, 243)
                        .addComponent(jLabel8)
                        .addGap(86, 86, 86)
                        .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(46, 46, 46)
                        .addComponent(txtTenChuong, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(243, 243, 243)
                        .addComponent(jLabel7)
                        .addGap(5, 5, 5)
                        .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(43, 43, 43)
                        .addComponent(txtLoaiChuong, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(152, 152, 152)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(153, 153, 153)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(153, 153, 153)
                        .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(149, 149, 149)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1088, 1088, 1088)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1572, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(343, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtMaChuong, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel8))
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel2))
                    .addComponent(txtTenChuong, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel5))
                    .addComponent(txtLoaiChuong, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    boolean them, sua, xoa;
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        them = true;
        sua = false;
        xoa = false;
        btnThem.setEnabled(false);
        btnThem.setBackground(Color.GRAY);
        btnSua.setEnabled(false);
        btnSua.setBackground(Color.GRAY);
        btnXoa.setEnabled(false);
        btnXoa.setBackground(Color.GRAY);
        btnLuu.setEnabled(true);
        btnLuu.setBackground(mauxanh);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        them = false;
        sua = true;
        xoa = false;
        btnThem.setEnabled(false);
        btnThem.setBackground(Color.GRAY);
        btnSua.setEnabled(false);
        btnSua.setBackground(Color.GRAY);
        btnXoa.setEnabled(false);
        btnXoa.setBackground(Color.GRAY);
        btnLuu.setEnabled(true);
        btnLuu.setBackground(mauxanh);
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        them = false;
        sua = false;
        xoa = true;
        btnThem.setEnabled(false);
        btnThem.setBackground(Color.GRAY);
        btnSua.setEnabled(false);
        btnSua.setBackground(Color.GRAY);
        btnXoa.setEnabled(false);
        btnXoa.setBackground(Color.GRAY);
        btnLuu.setEnabled(true);
        btnLuu.setBackground(mauxanh);
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
        if (them) {
            if (KTDL()) {
                float gia = Float.parseFloat(txtGia.getText());
                try {
                    Connection conn = dao.getConnect();
                    String caulenh = "INSERT INTO tbl_Chuong VALUES(N'" + txtTenChuong.getText() + "',N'" + txtLoaiChuong.getText() + "','" + gia + "',N'" + txtTrangThai.getText() + "')";
                    boolean a = dao.Lenh(caulenh, conn);
                    if (a) {
                        tblChuongThu.removeAll();
                        table.setRowCount(0);
                        loadNV();
                        JOptionPane.showMessageDialog(this, "Th??m th??nh c??ng");
                    } else {
                        JOptionPane.showMessageDialog(this, "Th??m KH??NG th??nh c??ng");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(frmChuong.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (sua) {
            float gia = Float.parseFloat(txtGia.getText());
            try {
                Connection conn = dao.getConnect();
                String caulenh = "UPDATE tbl_Chuong SET TenChuong=N'" + txtTenChuong.getText() + "',LoaiChuong=N'" + txtLoaiChuong.getText() + "',Gia='" + gia + "',TrangThai=N'" + txtTrangThai.getText() + "'where MaChuong=" + txtMaChuong.getText();
                boolean a = dao.Lenh(caulenh, conn);
                if (a) {
                    tblChuongThu.removeAll();
                    table.setRowCount(0);
                    loadNV();
                    JOptionPane.showMessageDialog(this, "S???a th??nh c??ng");
                } else {
                    JOptionPane.showMessageDialog(this, "S???a KH??NG th??nh c??ng");
                }
            } catch (SQLException ex) {
                Logger.getLogger(frmChuong.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (xoa) {

            try {
                Connection conn = dao.getConnect();
                String caulenh = "DELETE FROM tbl_Chuong WHERE MaChuong=" + txtMaChuong.getText();
                boolean a = dao.Lenh(caulenh, conn);
                if (a) {
                    tblChuongThu.removeAll();
                    table.setRowCount(0);
                    loadNV();
                    JOptionPane.showMessageDialog(this, "X??a th??nh c??ng");
                } else {
                    JOptionPane.showMessageDialog(this, "X??a KH??NG th??nh c??ng");
                }
            } catch (SQLException ex) {
                Logger.getLogger(frmChuong.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
        txtMaChuong.setText("");
        txtTenChuong.setText("");
        txtLoaiChuong.setText("");
        txtGia.setText("");
        txtTrangThai.setText("");
        tblChuongThu.removeAll();
        table.setRowCount(0);
        loadNV();
        btnThem.setEnabled(true);
        btnThem.setBackground(mauxanh);
        btnSua.setEnabled(true);
        btnSua.setBackground(mauxanh);
        btnXoa.setEnabled(true);
        btnXoa.setBackground(mauxanh);
        btnLuu.setEnabled(false);
        btnLuu.setBackground(Color.GRAY);
    }//GEN-LAST:event_btnHuyActionPerformed
    void hienthitxt(int i) {
        TableModel model = tblChuongThu.getModel();
        txtMaChuong.setText(model.getValueAt(i, 0).toString());
        txtTenChuong.setText(model.getValueAt(i, 1).toString());
        txtLoaiChuong.setText(model.getValueAt(i, 2).toString());
        txtGia.setText(model.getValueAt(i, 3).toString());
        txtTrangThai.setText(model.getValueAt(i, 4).toString());
    }
    private void tblChuongThuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChuongThuMouseClicked
        // TODO add your handling code here:
        int i = tblChuongThu.getSelectedRow();
        hienthitxt(i);
    }//GEN-LAST:event_tblChuongThuMouseClicked

    private void lblSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSearchMouseClicked
        // TODO add your handling code here:
        tblChuongThu.removeAll();
        table.setRowCount(0);

        String tk = txtTimKiem.getText();
        ArrayList<TblChuong> list;
        try {
            list = nvDL.getListChuong(tk);
            table = (DefaultTableModel) tblChuongThu.getModel();
            for (TblChuong nv : list) {
                table.addRow(new Object[]{nv.getMaChuong(), nv.getTenChuong(), nv.getLoaiChuong(), nv.getGia(), nv.getTrangThai()});
            }
        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_lblSearchMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonMetro btnHuy;
    private rojerusan.RSButtonMetro btnLuu;
    private rojerusan.RSButtonMetro btnSua;
    private rojerusan.RSButtonMetro btnThem;
    private rojerusan.RSButtonMetro btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblSearch;
    private rojeru_san.complementos.RSTableMetro tblChuongThu;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtLoaiChuong;
    private javax.swing.JTextField txtMaChuong;
    private javax.swing.JTextField txtTenChuong;
    private app.bolivia.swing.JCTextField txtTimKiem;
    private javax.swing.JTextField txtTrangThai;
    // End of variables declaration//GEN-END:variables
}
