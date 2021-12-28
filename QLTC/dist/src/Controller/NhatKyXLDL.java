/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.TblDichVu;
import Model.TblNhanVien;
import Model.TblNhatKyNuoi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Cong Dan
 */
public class NhatKyXLDL {
    KNCSDL kn=null;
    public NhatKyXLDL(){
        kn=new KNCSDL();
    }
    public ArrayList<TblNhatKyNuoi> getListNV() throws SQLException{
        ArrayList<TblNhatKyNuoi> list=new ArrayList<>();
        Connection conn=kn.getConnect();
        String sql="SELECT tbl_NhatKyNuoi.*,tbl_ThuCungKyGui.Giong FROM tbl_NhatKyNuoi,tbl_ThuCungKyGui where tbl_NhatKyNuoi.MaSoThuCung=tbl_ThuCungKyGui.MaSoThuCung and tbl_ThuCungKyGui.TrangThai LIKE N'%Chưa nhận%'";
        Statement statement=(Statement) conn.createStatement();
        ResultSet result=statement.executeQuery(sql);
        while(result.next()){
            TblNhatKyNuoi nv=new TblNhatKyNuoi();
            nv.setMaNhatKy(result.getLong(1));
            nv.setMaSoThuCung(result.getLong(2));
            nv.setNgay(result.getDate(3));
            nv.setBuoi(result.getString(4));
            nv.setTrangThai(result.getString(5));
            nv.setGhiChu(result.getString(6));
            nv.setDichVu(result.getString(7));
            nv.setThanhTien(result.getFloat(8));
            nv.setGiong(result.getString(9));
            list.add(nv);
        }
        return list;
    }
    public ArrayList<TblNhatKyNuoi> getListNhatKy(String tk) throws SQLException{
        ArrayList<TblNhatKyNuoi> list=new ArrayList<>();
        Connection conn=kn.getConnect();
        String sql="SELECT tbl_NhatKyNuoi.*,tbl_ThuCungKyGui.Giong FROM tbl_NhatKyNuoi,tbl_ThuCungKyGui where tbl_NhatKyNuoi.MaSoThuCung=tbl_ThuCungKyGui.MaSoThuCung and (MaNhatKy like '%"+tk+"%' or Giong like '%"+tk+"%' or DichVu like N'%"+tk+"%')";
        Statement statement=(Statement) conn.createStatement();
        ResultSet result=statement.executeQuery(sql);
        while(result.next()){
            TblNhatKyNuoi nv=new TblNhatKyNuoi();
            nv.setMaNhatKy(result.getLong(1));
            nv.setMaSoThuCung(result.getLong(2));
            nv.setNgay(result.getDate(3));
            nv.setBuoi(result.getString(4));
            nv.setTrangThai(result.getString(5));
            nv.setGhiChu(result.getString(6));
            nv.setDichVu(result.getString(7));
            nv.setThanhTien(result.getFloat(8));
            nv.setGiong(result.getString(9));
            list.add(nv);
        }
        return list;
    }
    
}
