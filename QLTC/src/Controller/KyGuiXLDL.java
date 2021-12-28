/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.TblNhanVien;
import Model.TblThuCungKyGui;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Cong Dan
 */
public class KyGuiXLDL {
    KNCSDL kn=null;
    public KyGuiXLDL(){
        kn=new KNCSDL();
    }
    public ArrayList<TblThuCungKyGui> getListNV() throws SQLException{
        ArrayList<TblThuCungKyGui> list=new ArrayList<>();
        Connection conn=kn.getConnect();
        String sql="SELECT tbl_ThuCungKyGui.*,tbl_KhachHang.TenKH FROM tbl_ThuCungKyGui,tbl_KhachHang where tbl_KhachHang.MaKH=tbl_ThuCungKyGui.MaKH";
        Statement statement=(Statement) conn.createStatement();
        ResultSet result=statement.executeQuery(sql);
        while(result.next()){
            TblThuCungKyGui nv=new TblThuCungKyGui();
            nv.setMaSoThuCung(result.getLong(1));
            nv.setGiong(result.getString(2));
            nv.setLoai(result.getString(3));
            nv.setCanNang(result.getDouble(4));
            nv.setTinhTrangSK(result.getString(5));
            nv.setMaKH(result.getLong(6));
            nv.setHinhAnh(result.getString(7));
            nv.setTrangThai(result.getString(8));
            nv.setTenKH(result.getString(9));
            list.add(nv);
        }
        return list;
    }
    public ArrayList<TblThuCungKyGui> getListKyGui(String tk) throws SQLException{
        ArrayList<TblThuCungKyGui> list=new ArrayList<>();
        Connection conn=kn.getConnect();
        String sql="SELECT tbl_ThuCungKyGui.*,tbl_KhachHang.TenKH FROM tbl_ThuCungKyGui,tbl_KhachHang where tbl_KhachHang.MaKH=tbl_ThuCungKyGui.MaKH and (MaSoThuCung like '%"+tk+"%' or Giong like N'%"+tk+"%' or Loai like N'%"+tk+"%' or TenKH like N'%"+tk+"%' or TrangThai like N'%"+tk+"%')";
        Statement statement=(Statement) conn.createStatement();
        ResultSet result=statement.executeQuery(sql);
        while(result.next()){
            TblThuCungKyGui nv=new TblThuCungKyGui();
            nv.setMaSoThuCung(result.getLong(1));
            nv.setGiong(result.getString(2));
            nv.setLoai(result.getString(3));
            nv.setCanNang(result.getDouble(4));
            nv.setTinhTrangSK(result.getString(5));
            nv.setMaKH(result.getLong(6));
            nv.setHinhAnh(result.getString(7));
            nv.setTrangThai(result.getString(8));
            nv.setTenKH(result.getString(9));
            list.add(nv);
        }
        return list;
    }
      public ArrayList<TblThuCungKyGui> getListThuCungKyGui(String tk) throws SQLException{
        ArrayList<TblThuCungKyGui> list=new ArrayList<>();
        Connection conn=kn.getConnect();
        String sql="SELECT tbl_ThuCungKyGui.*,tbl_KhachHang.TenKH FROM tbl_ThuCungKyGui,tbl_KhachHang where tbl_KhachHang.MaKH=tbl_ThuCungKyGui.MaKH and tbl_KhachHang.MaKH="+ tk;
        Statement statement=(Statement) conn.createStatement();
        ResultSet result=statement.executeQuery(sql);
        while(result.next()){
            TblThuCungKyGui nv=new TblThuCungKyGui();
            nv.setMaSoThuCung(result.getLong(1));
            nv.setGiong(result.getString(2));
            nv.setLoai(result.getString(3));
            nv.setCanNang(result.getDouble(4));
            nv.setTinhTrangSK(result.getString(5));
            nv.setMaKH(result.getLong(6));
            nv.setHinhAnh(result.getString(7));
            nv.setTrangThai(result.getString(8));
            nv.setTenKH(result.getString(9));
            list.add(nv);
        }
        return list;
    }
}
