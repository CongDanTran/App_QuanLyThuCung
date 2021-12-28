/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
public class NhanVienXLDL {
    KNCSDL kn=null;
    public NhanVienXLDL(){
        kn=new KNCSDL();
    }
    public ArrayList<TblNhanVien> getListNV() throws SQLException{
        ArrayList<TblNhanVien> list=new ArrayList<>();
        Connection conn=kn.getConnect();
        String sql="SELECT * FROM tbl_NhanVien";
        Statement statement=(Statement) conn.createStatement();
        ResultSet result=statement.executeQuery(sql);
        while(result.next()){
            TblNhanVien nv=new TblNhanVien();
            nv.setMaNV(result.getLong(1));
            nv.setTenNV(result.getString(2));
            nv.setDiaChi(result.getString(3));
            nv.setGioiTinh(result.getString(4));
            nv.setNgaySinh(result.getDate(5));
            nv.setLoaiNV(result.getString(6));
            nv.setSdt(result.getInt(7));
            nv.setHinhAnh(result.getString(8));
            nv.setGhiChu(result.getString(9));
            list.add(nv);
        }
        return list;
    }
    public ArrayList<TblNhanVien> getListNhanVien(String tk) throws SQLException{
        ArrayList<TblNhanVien> list=new ArrayList<>();
        Connection conn=kn.getConnect();
        String sql="SELECT * FROM tbl_NhanVien where (MaNV like '%"+tk+"%' or TenNV like N'%"+tk+"%' or GioiTinh like N'%"+tk+"%' or LoaiNV like N'%"+tk+"%' or SDT like '%"+tk+"%')";
        Statement statement=(Statement) conn.createStatement();
        ResultSet result=statement.executeQuery(sql);
        while(result.next()){
            TblNhanVien nv=new TblNhanVien();
            nv.setMaNV(result.getLong(1));
            nv.setTenNV(result.getString(2));
            nv.setDiaChi(result.getString(3));
            nv.setGioiTinh(result.getString(4));
            nv.setNgaySinh(result.getDate(5));
            nv.setLoaiNV(result.getString(6));
            nv.setSdt(result.getInt(7));
            nv.setHinhAnh(result.getString(8));
            nv.setGhiChu(result.getString(9));
            list.add(nv);
        }
        return list;
    }
    
}
