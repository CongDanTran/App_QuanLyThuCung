/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.TblPhieuGui;
import Model.TblTaiKhoan;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author CongDan
 */
public class TaiKhoanXLDL {
    KNCSDL kn=null;
    public TaiKhoanXLDL(){
        kn=new KNCSDL();
    }
    public ArrayList<TblTaiKhoan> getListNV() throws SQLException{
        ArrayList<TblTaiKhoan> list=new ArrayList<>();
        Connection conn=kn.getConnect();
        String sql="SELECT tbl_TaiKhoan.*,tbl_NhanVien.TenNV FROM tbl_TaiKhoan,tbl_NhanVien where tbl_TaiKhoan.MaNV=tbl_NhanVien.MaNV";
        Statement statement=(Statement) conn.createStatement();
        ResultSet result=statement.executeQuery(sql);
        while(result.next()){
            TblTaiKhoan nv=new TblTaiKhoan();
            nv.setMaNV(result.getLong(1));
            nv.setTenTK(result.getString(2));
            nv.setMatKhau(result.getString(3));
            nv.setQuyen(result.getString(4));
            nv.setTenNV(result.getString(5));
            list.add(nv);
        }
        return list;
    }
    public ArrayList<TblTaiKhoan> getListNhanVien(String tk) throws SQLException{
        ArrayList<TblTaiKhoan> list=new ArrayList<>();
        Connection conn=kn.getConnect();
        String sql="SELECT tbl_TaiKhoan.*,tbl_NhanVien.TenNV FROM tbl_TaiKhoan,tbl_NhanVien where tbl_TaiKhoan.MaNV=tbl_NhanVien.MaNV and (TenTK like N'%"+tk+"%' or TenNV like N'%"+tk+"%')";
        Statement statement=(Statement) conn.createStatement();
        ResultSet result=statement.executeQuery(sql);
        while(result.next()){
            TblTaiKhoan nv=new TblTaiKhoan();
            nv.setMaNV(result.getLong(1));
            nv.setTenTK(result.getString(2));
            nv.setMatKhau(result.getString(3));
            nv.setQuyen(result.getString(4));
            nv.setTenNV(result.getString(5));
            list.add(nv);
        }
        return list;
    }
}
