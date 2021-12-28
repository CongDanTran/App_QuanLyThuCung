/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ChiTietPhieuGuiXLDL;
import Controller.ChuongXLDL;
import Controller.DAO;
import Controller.InHoaDonXLDL;
import Controller.KyGuiXLDL;
import Controller.PhieuGuiXLDL;
import Model.TblChiTietPhieuGui;
import Model.TblChuong;
import Model.TblKhachHang;
import Model.TblPhieuGui;
import Model.TblThuCungKyGui;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Cong Dan
 */
public class frmChiTietPhieuGui extends javax.swing.JFrame {

    /**
     * Creates new form frmChiTietPhieuGui
     */
    ChiTietPhieuGuiXLDL pgDL;
    DefaultTableModel table;
    KyGuiXLDL kgXLDL;
    ChuongXLDL cXLDL;
    PhieuGuiXLDL pgXLDL;

    DAO dao;
    Color mauxanh = new Color(0, 112, 192);

   static String maphieu;
    public frmChiTietPhieuGui(String id,String idKhachHang) {
        
        initComponents();
        kgXLDL = new KyGuiXLDL();
        cXLDL = new ChuongXLDL();
        pgXLDL = new PhieuGuiXLDL();
        pgDL = new ChiTietPhieuGuiXLDL();
        maphieu=id;
        maKhachHang=idKhachHang;
        loadAnh(lblSearch, "src\\img\\tk.png");
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        loadNV();
        loadmaThuCung();
        loadmaChuong();
        txtMaPhieuGui.setText(id);
        dao = new DAO("jdbc:sqlserver://localhost:1433;databaseName=QLTC;username=sa;password=123;");
        btnLuu.setEnabled(false);
        btnLuu.setBackground(Color.GRAY);
    }

    void loadAnh(JLabel lbl, String fileanh) {
        //TODO add your handling code here:
        ImageIcon icon = new ImageIcon(fileanh);
        Image image = icon.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_SMOOTH);
        lbl.setIcon(new ImageIcon(image));
    }

    void loadNV() {
        ArrayList<TblChiTietPhieuGui> list;
        try {
            list = pgDL.getListNV(maphieu);
            table = (DefaultTableModel) tblChiTietPhieuGui.getModel();
            for (TblChiTietPhieuGui nv : list) {
                table.addRow(new Object[]{nv.getMaPhieuGui(), nv.getGiong(), nv.getTenChuong(), nv.getTongTien()});
            }
        } catch (SQLException ex) {

        }
    }
public static String maKhachHang;
    void loadmaThuCung() {
        try {
            ArrayList<TblThuCungKyGui> KG = kgXLDL.getListThuCungKyGui(maKhachHang);
            for (TblThuCungKyGui kg : KG) {
                cboMaThuCung.addItem(kg);
            }
        } catch (Exception ex) {

        }
    }

    void loadmaChuong() {
        try {
            ArrayList<TblChuong> ch = cXLDL.getListNV("1");
            for (TblChuong c : ch) {
                cboMaChuong.addItem(c);
            }
        } catch (Exception ex) {

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

        jPanel2 = new javax.swing.JPanel();
        txtMaPhieuGui = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        cboMaChuong = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cboMaThuCung = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnThem = new rojerusan.RSButtonMetro();
        btnSua = new rojerusan.RSButtonMetro();
        btnXoa = new rojerusan.RSButtonMetro();
        btnLuu = new rojerusan.RSButtonMetro();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblChiTietPhieuGui = new rojeru_san.complementos.RSTableMetro();
        btnThem2 = new rojerusan.RSButtonMetro();
        btnHuy = new rojerusan.RSButtonMetro();
        txtTimKiem = new app.bolivia.swing.JCTextField();
        lblSearch = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        txtMaPhieuGui.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtMaPhieuGui.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Mã Phiếu Gửi:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setText("Chi Tiết Phiếu Gửi");

        txtTongTien.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        cboMaChuong.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cboMaChuong.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboMaChuongItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Tên Thú Cưng:");

        cboMaThuCung.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setText("Tổng Tiền:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setText("Tên Chuồng:");

        btnThem.setText("Thêm");
        btnThem.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnLuu.setText("Lưu");
        btnLuu.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        tblChiTietPhieuGui.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phiếu gửi", "Tên thú cưng", "Tên chuồng", "Tổng tiền"
            }
        ));
        tblChiTietPhieuGui.setFuenteFilas(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tblChiTietPhieuGui.setFuenteFilasSelect(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tblChiTietPhieuGui.setRowHeight(25);
        tblChiTietPhieuGui.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChiTietPhieuGuiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblChiTietPhieuGui);

        btnThem2.setText("Trở về");
        btnThem2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnThem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem2ActionPerformed(evt);
            }
        });

        btnHuy.setText("Hủy");
        btnHuy.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        txtTimKiem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTimKiem.setPlaceholder("Tìm kiếm tại đây...");

        lblSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSearchMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(btnThem2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(566, 566, 566)
                .addComponent(jLabel1))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addComponent(jLabel2)
                .addGap(21, 21, 21)
                .addComponent(txtMaPhieuGui, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addComponent(jLabel8)
                .addGap(35, 35, 35)
                .addComponent(cboMaChuong, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addComponent(jLabel3)
                .addGap(11, 11, 11)
                .addComponent(cboMaThuCung, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addComponent(jLabel7)
                .addGap(56, 56, 56)
                .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(152, 152, 152)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(163, 163, 163)
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143)
                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(1380, 1380, 1380)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1820, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnThem2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addGap(86, 86, 86)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2))
                    .addComponent(txtMaPhieuGui, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cboMaChuong, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(cboMaThuCung, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel7))
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(142, 142, 142)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    boolean them, sua, xoa;
    private void btnThem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnThem2ActionPerformed

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
                TblThuCungKyGui tc = (TblThuCungKyGui) cboMaThuCung.getSelectedItem();
                String mathucung = String.valueOf(tc.getMaSoThuCung());

                TblChuong ch = (TblChuong) cboMaChuong.getSelectedItem();
                String machuong = String.valueOf(ch.getMaChuong());
                try {
                    Connection conn = dao.getConnect();
                    String caulenh = "INSERT INTO tbl_ChiTietPhieuGui VALUES('" + txtMaPhieuGui.getText() + "','" + mathucung + "','" + machuong + "','" + txtTongTien.getText() + "')";
                    boolean a = dao.Lenh(caulenh, conn);
                    String capnhat="UPDATE tbl_Chuong SET TrangThai=N'Đầy' WHERE MaChuong="+machuong;
                    String capnhatphieu="UPDATE tbl_PhieuGui SET TongTien=TongTien+ "+Double.parseDouble(txtTongTien.getText().toString())+" WHERE MaPhieuGui="+txtMaPhieuGui.getText().toString();
                    boolean b=dao.Lenh(capnhat, conn);
                    boolean c= dao.Lenh(capnhatphieu, conn);
                    if (a) {
                        tblChiTietPhieuGui.removeAll();
                        table.setRowCount(0);
                        loadNV();
                        JOptionPane.showMessageDialog(this, "Thêm thành công");
                    } else {
                        JOptionPane.showMessageDialog(this, "Thêm KHÔNG thành công");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(frmChiTietPhieuGui.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        if (sua) {
            TblThuCungKyGui tc = (TblThuCungKyGui) cboMaThuCung.getSelectedItem();
                String mathucung = String.valueOf(tc.getMaSoThuCung());

            TblChuong ch = (TblChuong) cboMaChuong.getSelectedItem();
            String machuong = String.valueOf(ch.getMaChuong());
            try {
                Connection conn = dao.getConnect();
                String caulenh = "UPDATE tbl_ChiTietPhieuGui SET TongTien='" + txtTongTien.getText() + "',MaChuong='" + machuong + "'where MaPhieuGui=" + txtMaPhieuGui.getText() + "AND MaSoThuCung=" + mathucung;
                boolean a = dao.Lenh(caulenh, conn);
                if (a) {
                    tblChiTietPhieuGui.removeAll();
                    table.setRowCount(0);
                    loadNV();
                    JOptionPane.showMessageDialog(this, "Sửa thành công");
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa KHÔNG thành công");
                }
            } catch (SQLException ex) {
                Logger.getLogger(frmChiTietPhieuGui.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (xoa) {
            TblThuCungKyGui tc = (TblThuCungKyGui) cboMaThuCung.getSelectedItem();
                String mathucung = String.valueOf(tc.getMaSoThuCung());
            try {
                Connection conn = dao.getConnect();
                String caulenh = "DELETE FROM tbl_ChiTietPhieuGui WHERE MaPhieuGui=" + txtMaPhieuGui.getText() + "AND MaSoThuCung=" + mathucung;
                boolean a = dao.Lenh(caulenh, conn);
                if (a) {
                    tblChiTietPhieuGui.removeAll();
                    table.setRowCount(0);
                    loadNV();
                    JOptionPane.showMessageDialog(this, "Xóa thành công");
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa KHÔNG thành công");
                }
            } catch (SQLException ex) {
                Logger.getLogger(frmChiTietPhieuGui.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
        txtTongTien.setText("");
        tblChiTietPhieuGui.removeAll();
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
        TableModel model = tblChiTietPhieuGui.getModel();
        txtMaPhieuGui.setText(model.getValueAt(i, 0).toString());
        String cbosub1 = model.getValueAt(i, 1).toString();
        for (int j = 0; j < cboMaThuCung.getItemCount(); j++) {
            if (cboMaThuCung.getItemAt(j).toString().equalsIgnoreCase(cbosub1)) {
                cboMaThuCung.setSelectedIndex(j);
            }
        }
        txtTongTien.setText(model.getValueAt(i, 3).toString());
        String cbosub = model.getValueAt(i, 2).toString();
        for (int j = 0; j < cboMaChuong.getItemCount(); j++) {
            if (cboMaChuong.getItemAt(j).toString().equalsIgnoreCase(cbosub)) {
                cboMaChuong.setSelectedIndex(j);
            }
        }
    }
    private void tblChiTietPhieuGuiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChiTietPhieuGuiMouseClicked
        // TODO add your handling code here:
        int i = tblChiTietPhieuGui.getSelectedRow();
        hienthitxt(i);
    }//GEN-LAST:event_tblChiTietPhieuGuiMouseClicked

    private void lblSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSearchMouseClicked
        // TODO add your handling code here:
        tblChiTietPhieuGui.removeAll();
        table.setRowCount(0);
        String tk = txtTimKiem.getText();
        ArrayList<TblChiTietPhieuGui> list;
        try {
            list = pgDL.getListCTPG(tk);
            table = (DefaultTableModel) tblChiTietPhieuGui.getModel();
            for (TblChiTietPhieuGui nv : list) {
                table.addRow(new Object[]{nv.getMaPhieuGui(), nv.getGiong(), nv.getTenChuong(), nv.getTongTien()});
            }
        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_lblSearchMouseClicked

    private void cboMaChuongItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboMaChuongItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange() == ItemEvent.SELECTED){
           TblChuong ch = (TblChuong) cboMaChuong.getSelectedItem();
            long machuong = ch.getMaChuong();
            try {
                TblChuong chuong= cXLDL.getChuong(machuong);
                txtTongTien.setText(chuong.getGia().toString());
            } catch (SQLException ex) {
                Logger.getLogger(frmChiTietPhieuGui.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_cboMaChuongItemStateChanged

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
            java.util.logging.Logger.getLogger(frmChiTietPhieuGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmChiTietPhieuGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmChiTietPhieuGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmChiTietPhieuGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmChiTietPhieuGui(maphieu,maKhachHang).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonMetro btnHuy;
    private rojerusan.RSButtonMetro btnLuu;
    private rojerusan.RSButtonMetro btnSua;
    private rojerusan.RSButtonMetro btnThem;
    private rojerusan.RSButtonMetro btnThem2;
    private rojerusan.RSButtonMetro btnXoa;
    private javax.swing.JComboBox<TblChuong> cboMaChuong;
    private javax.swing.JComboBox<TblThuCungKyGui> cboMaThuCung;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblSearch;
    private rojeru_san.complementos.RSTableMetro tblChiTietPhieuGui;
    private javax.swing.JTextField txtMaPhieuGui;
    private app.bolivia.swing.JCTextField txtTimKiem;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}