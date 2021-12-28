/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.TblHoaDon;
import Model.TblNhanVien;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Cong Dan
 */
public class HoaDonXLDL {
    KNCSDL kn=null;
    public HoaDonXLDL(){
        kn=new KNCSDL();
    }
    public ArrayList<TblHoaDon> getListHoaDon(String ma) throws SQLException{
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
}
