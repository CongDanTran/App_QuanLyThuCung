/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DAO;
import Controller.HoaDonXLDL;
import Controller.KNCSDL;
import Controller.NhanVienXLDL;
import Controller.PhieuGuiXLDL;
import Model.ReportPhieuGui;
import Model.TblHoaDon;
import Model.TblNhanVien;
import Model.TblPhieuGui;
import static View.frmPhieuGui.print;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Cong Dan
 */
public class frmHoaDon extends javax.swing.JInternalFrame implements Runnable, ThreadFactory {

    /**
     * Creates new form frmHoaDon
     */
    private WebcamPanel panel = null;
    private Webcam webcam = null;

    private static final long serialVersionUID = 6441489157408381878L;
    private Executor executor = Executors.newSingleThreadExecutor(this);
    HoaDonXLDL hdXLDL;
    DefaultTableModel table;

    Color mauxanh = new Color(0, 112, 192);

    public frmHoaDon() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        hdXLDL = new HoaDonXLDL();

        //initWebcam();
    }

    void loadAnh(JLabel lbl, String fileanh) {
        //TODO add your handling code here:
        ImageIcon icon = new ImageIcon(fileanh);
        Image image = icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        lbl.setIcon(new ImageIcon(image));
    }

    void loadhd(String mahd) {
        ArrayList<TblHoaDon> list;
        try {
           
            list = hdXLDL.getListHoaDon(mahd);
            TblHoaDon hd = list.get(1);
            txtMaphieugui.setText(hd.getMaPhieuGui().toString());
            txtHinhThuc.setText(hd.getLoai().toString());
            txtTenKhachHang.setText(hd.getTenKH());
            txtTongTien.setText(hd.getTongTien() + "");
            txtTrangThai.setText(hd.getTrangThaiHD());
            Date date =null;
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(hd.getNgay());
            } catch (ParseException ex) {
                Logger.getLogger(frmHoaDon.class.getName()).log(Level.SEVERE, null, ex);
            }
            jdcNgayGui.setDate(date);
            table = (DefaultTableModel) tblHoaDon.getModel();
            for (TblHoaDon nv : list) {
                table.addRow(new Object[]{nv.getGiong(), nv.getTenChuong(), nv.getNgay(), nv.getBuoi(), nv.getDichVu(), nv.getTrangThai(), nv.getThanhTien()});
            }
        } catch (SQLException ex) {

        }
    }
    //report
     private static JasperReport report;
     private static Collection getData(String ma) throws Exception {
        KNCSDL kn=new KNCSDL();
          ArrayList<TblHoaDon> list=new ArrayList<>();
        Connection conn=kn.getConnect();
        String sql="select pg.MaPhieuGui,kh.TenKH,pg.NgayGui,ht.Loai, tc.Giong, c.TenChuong, nkn.Ngay,nkn.Buoi, nkn.DichVu,nkn.TrangThai,nkn.ThanhTien, pg.TongTien,pg.TrangThai from tbl_PhieuGui pg,tbl_ChiTietPhieuGui ctpg, tbl_KhachHang kh,tbl_ThuCungKyGui tc,tbl_HinhThuc ht,tbl_NhatKyNuoi  nkn,tbl_Chuong c \n" +
"		where (pg.MaPhieuGui=ctpg.MaPhieuGui and pg.MaKH=kh.MaKH and pg.MaHinhThuc=ht.MaHinhThuc and ctpg.MaSoThuCung=tc.MaSoThuCung and c.MaChuong= ctpg.MaChuong  and tc.MaSoThuCung=nkn.MaSoThuCung and  pg.MaPhieuGui="+ma+")";
        Statement statement=(Statement) conn.createStatement();
        ResultSet result=statement.executeQuery(sql);
        while(result.next()){
            TblHoaDon nv=new TblHoaDon();
            nv.setMaPhieuGui(result.getLong(1));
            nv.setTenKH(result.getString(2));
            nv.setNgayGui(result.getString(3));
            nv.setLoai(result.getString(4));
            nv.setGiong(result.getString(5));
            nv.setTenChuong(result.getString(6));
            nv.setNgay(result.getString(7));
            nv.setBuoi(result.getString(8));
            nv.setDichVu(result.getString(9));
            nv.setTrangThai(result.getString(10));
            nv.setThanhTien(result.getFloat(11));
            nv.setTongTien(result.getFloat(12));
            nv.setTrangThaiHD(result.getString(13));
            list.add(nv);
        }
        return list;
        
    }

 
    public static void print(String ma) {
        try {
            JRBeanCollectionDataSource jcd = new JRBeanCollectionDataSource(getData(ma));
            JasperPrint print = JasperFillManager.fillReport(report, null, jcd);
            if (false) {
                JasperPrintManager.printReport(print, true);    //  print auto
            } else {
                JasperViewer.viewReport(print, false);  //  view
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initWebcam() {
        Dimension size = WebcamResolution.QVGA.getSize();
        webcam = Webcam.getWebcams().get(0); //0 is default webcam
        webcam.setViewSize(size);

        panel = new WebcamPanel(webcam);
        panel.setPreferredSize(size);
        panel.setFPSDisplayed(true);

        jPanel2.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 460));

        executor.execute(this);
    }

    @Override
    public void run() {
        do {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Result result = null;
            BufferedImage image = null;

            if (webcam.isOpen()) {
                if ((image = webcam.getImage()) == null) {
                    continue;
                }
            }

            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            try {
                result = new MultiFormatReader().decode(bitmap);
            } catch (NotFoundException e) {
                //No result...
            }

            if (result != null) {
                txtMaphieugui.setText(result.getText());
                loadhd(txtMaphieugui.getText().toString());
                if (webcam.isOpen()) {
                    webcam.close();
                }
                break;

            }
        } while (true);
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t;
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
        jdcNgayGui = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtHinhThuc = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtTrangThai = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtMaphieugui = new javax.swing.JTextField();
        txtTenKhachHang = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        btnThem = new rojerusan.RSButtonMetro();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDon = new rojeru_san.complementos.RSTableMetro();
        jPanel2 = new javax.swing.JPanel();
        btnThem1 = new rojerusan.RSButtonMetro();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jdcNgayGui.setDateFormatString("yyyy-MM-dd");
        jdcNgayGui.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(jdcNgayGui, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 350, 510, 50));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setText("Ngày Gửi:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 360, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel12.setText("Hình Thức:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 440, -1, -1));

        txtHinhThuc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(txtHinhThuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 430, 510, 48));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel13.setText("Tổng Tiền:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 520, -1, -1));

        txtTrangThai.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(txtTrangThai, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 280, 510, 48));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setText("Mã Phiếu Gửi:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 120, -1, -1));

        txtMaphieugui.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtMaphieugui.setEnabled(false);
        jPanel1.add(txtMaphieugui, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 110, 510, 48));

        txtTenKhachHang.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(txtTenKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 190, 510, 48));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setText("Thông Tin Hóa Đơn");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(669, 13, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setText("Tên Khách Hàng:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 200, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setText("Trạng thái:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 280, -1, -1));

        txtTongTien.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(txtTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 510, 510, 48));

        btnThem.setText("In");
        btnThem.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel1.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 580, 117, 55));

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên thú cưng", "Tên chuồng", "Ngày", "Buổi", "Dịch vụ", "Trạng thái", "Thành tiền"
            }
        ));
        tblHoaDon.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tblHoaDon.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tblHoaDon.setFuenteFilas(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tblHoaDon.setFuenteFilasSelect(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tblHoaDon.setRowHeight(25);
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblHoaDon);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 660, 1580, 310));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 530, 460));

        btnThem1.setText("Mở");
        btnThem1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnThem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnThem1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 430, 117, 55));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    boolean them, sua, xoa;
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
             try {
           
             report = JasperCompileManager.compileReport("src/View/ReportHoaDon.jrxml");
            print(txtMaphieugui.getText().toString());
        } catch (Exception e) {
            System.out.println(e);

        }

        
    }//GEN-LAST:event_btnThemActionPerformed
    void hienthitxt(int i) {

    }
    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void btnThem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem1ActionPerformed
        // TODO add your handling code here:
        initWebcam();
    }//GEN-LAST:event_btnThem1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonMetro btnThem;
    private rojerusan.RSButtonMetro btnThem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jdcNgayGui;
    private rojeru_san.complementos.RSTableMetro tblHoaDon;
    private javax.swing.JTextField txtHinhThuc;
    private javax.swing.JTextField txtMaphieugui;
    private javax.swing.JTextField txtTenKhachHang;
    private javax.swing.JTextField txtTongTien;
    private javax.swing.JTextField txtTrangThai;
    // End of variables declaration//GEN-END:variables
}
