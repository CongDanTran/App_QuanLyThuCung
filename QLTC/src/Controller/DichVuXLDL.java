/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.TblDichVu;
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
public class DichVuXLDL {
    KNCSDL kn=null;
    public DichVuXLDL(){
        kn=new KNCSDL();
    }
    public ArrayList<TblDichVu> getListNV() throws SQLException{
        ArrayList<TblDichVu> list=new ArrayList<>();
        Connection conn=kn.getConnect();
        String sql="SELECT * FROM tbl_DichVu";
        Statement statement=(Statement) conn.createStatement();
        ResultSet result=statement.executeQuery(sql);
        while(result.next()){
            TblDichVu nv=new TblDichVu();
            nv.setMaDV(result.getLong(1));
            nv.setTenDichVu(result.getString(2));
            nv.setGia(result.getDouble(3));
            list.add(nv);
        }
        return list;
    }
    public ArrayList<TblDichVu> getListDichVu(String tk) throws SQLException{
        ArrayList<TblDichVu> list=new ArrayList<>();
        Connection conn=kn.getConnect();
        String sql="SELECT * FROM tbl_DichVu where (MaDV like '%"+tk+"%' or TenDichVu like N'%"+tk+"%')";
        Statement statement=(Statement) conn.createStatement();
        ResultSet result=statement.executeQuery(sql);
        while(result.next()){
            TblDichVu nv=new TblDichVu();
            nv.setMaDV(result.getLong(1));
            nv.setTenDichVu(result.getString(2));
            nv.setGia(result.getDouble(3));
            list.add(nv);
        }
        return list;
    }
    
    public TblDichVu getDichVu(long ma) throws SQLException{
        Connection conn=kn.getConnect();
        String sql="SELECT * FROM tbl_DichVu where MaDV="+ma;
        Statement statement=(Statement) conn.createStatement();
        ResultSet result=statement.executeQuery(sql);
          TblDichVu nv=new TblDichVu();
        while(result.next()){
          
            nv.setMaDV(result.getLong(1));
            nv.setTenDichVu(result.getString(2));
            nv.setGia(result.getDouble(3));
            
        }
        return nv;
    }
}
