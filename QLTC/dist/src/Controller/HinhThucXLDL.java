/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.TblHinhThuc;
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
public class HinhThucXLDL {
    KNCSDL kn=null;
    public HinhThucXLDL(){
        kn=new KNCSDL();
    }
    public ArrayList<TblHinhThuc> getListNV() throws SQLException{
        ArrayList<TblHinhThuc> list=new ArrayList<>();
        Connection conn=kn.getConnect();
        String sql="SELECT * FROM tbl_HinhThuc";
        Statement statement=(Statement) conn.createStatement();
        ResultSet result=statement.executeQuery(sql);
        while(result.next()){
            TblHinhThuc nv=new TblHinhThuc();
            nv.setMaHinhThuc(result.getLong(1));
            nv.setLoai(result.getString(2));
            nv.setGia(result.getDouble(3));
            list.add(nv);
        }
        return list;
    }
    public ArrayList<TblHinhThuc> getListHinhThuc(String tk) throws SQLException{
        ArrayList<TblHinhThuc> list=new ArrayList<>();
        Connection conn=kn.getConnect();
        String sql="SELECT * FROM tbl_HinhThuc where (MaHinhThuc like '%"+tk+"%' or Loai like N'%"+tk+"%')";
        Statement statement=(Statement) conn.createStatement();
        ResultSet result=statement.executeQuery(sql);
        while(result.next()){
            TblHinhThuc nv=new TblHinhThuc();
            nv.setMaHinhThuc(result.getLong(1));
            nv.setLoai(result.getString(2));
            nv.setGia(result.getDouble(3));
            list.add(nv);
        }
        return list;
    }
    public TblHinhThuc getHT(long ma) throws SQLException{
        Connection conn=kn.getConnect();
        String sql="SELECT * FROM tbl_HinhThuc where MaHinhThuc="+ma;
        Statement statement=(Statement) conn.createStatement();
        ResultSet result=statement.executeQuery(sql);
          TblHinhThuc nv=new TblHinhThuc();
        while(result.next()){
          
            nv.setMaHinhThuc(result.getLong(1));
            nv.setLoai(result.getString(2));
            nv.setGia(result.getDouble(3));
            
        }
        return nv;
    }
}
