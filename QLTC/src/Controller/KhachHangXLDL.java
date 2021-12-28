/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.TblKhachHang;
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
public class KhachHangXLDL {
    KNCSDL kn=null;
    public KhachHangXLDL(){
        kn=new KNCSDL();
    }
    public ArrayList<TblKhachHang> getListNV() throws SQLException{
        ArrayList<TblKhachHang> list=new ArrayList<>();
        Connection conn=kn.getConnect();
        String sql="SELECT * FROM tbl_KhachHang";
        Statement statement=(Statement) conn.createStatement();
        ResultSet result=statement.executeQuery(sql);
        while(result.next()){
            TblKhachHang nv=new TblKhachHang();
            nv.setMaKH(result.getLong(1));
            nv.setTenKH(result.getString(2));
            nv.setDiaChi(result.getString(3));
            nv.setSdt(result.getInt(4));
            nv.setLoai(result.getString(5));
            list.add(nv);
        }
        return list;
    }
    public ArrayList<TblKhachHang> getListNhanVien(String tk) throws SQLException{
        ArrayList<TblKhachHang> list=new ArrayList<>();
        Connection conn=kn.getConnect();
        String sql="SELECT * FROM tbl_KhachHang where (MaKH like '%"+tk+"%' or TenKH like N'%"+tk+"%' or SDT like '%"+tk+"%' or Loai like N'%"+tk+"%')";
        Statement statement=(Statement) conn.createStatement();
        ResultSet result=statement.executeQuery(sql);
        while(result.next()){
            TblKhachHang nv=new TblKhachHang();
            nv.setMaKH(result.getLong(1));
            nv.setTenKH(result.getString(2));
            nv.setDiaChi(result.getString(3));
            nv.setSdt(result.getInt(4));
            nv.setLoai(result.getString(5));
            list.add(nv);
        }
        return list;
    }
}
