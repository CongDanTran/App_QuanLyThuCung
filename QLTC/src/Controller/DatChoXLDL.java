/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.TblDatCho;
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
public class DatChoXLDL {
    KNCSDL kn=null;
    public DatChoXLDL(){
        kn=new KNCSDL();
    }
    public ArrayList<TblDatCho> getListNV() throws SQLException{
        ArrayList<TblDatCho> list=new ArrayList<>();
        Connection conn=kn.getConnect();
        String sql="SELECT tbl_DatCho.*, tbl_Chuong.TenChuong FROM tbl_DatCho,tbl_Chuong where tbl_DatCho.MaChuong=tbl_Chuong.MaChuong";
        Statement statement=(Statement) conn.createStatement();
        ResultSet result=statement.executeQuery(sql);
        while(result.next()){
            TblDatCho nv=new TblDatCho();
            nv.setMaDatCho(result.getLong(1));
            nv.setMaChuong(result.getLong(2));
            nv.setTenKhachHang(result.getString(3));
            nv.setSdt(result.getInt(4));
            nv.setNgayDat(result.getDate(5));
            nv.setNgaySD(result.getDate(6));
            nv.setSoLuong(result.getInt(7));
            nv.setTenChuong(result.getString(8));
            list.add(nv);
        }
        return list;
    }
    public ArrayList<TblDatCho> getListDatCho(String tk) throws SQLException{
        ArrayList<TblDatCho> list=new ArrayList<>();
        Connection conn=kn.getConnect();
        String sql="SELECT tbl_DatCho.*, tbl_Chuong.TenChuong FROM tbl_DatCho,tbl_Chuong where tbl_DatCho.MaChuong=tbl_Chuong.MaChuong and (MaDatCho like '%"+tk+"%' or TenChuong like N'%"+tk+"%' or TenKhachHang like N'%"+tk+"%' or SDT like '%"+tk+"%')";
        Statement statement=(Statement) conn.createStatement();
        ResultSet result=statement.executeQuery(sql);
        while(result.next()){
            TblDatCho nv=new TblDatCho();
            nv.setMaDatCho(result.getLong(1));
            nv.setMaChuong(result.getLong(2));
            nv.setTenKhachHang(result.getString(3));
            nv.setSdt(result.getInt(4));
            nv.setNgayDat(result.getDate(5));
            nv.setNgaySD(result.getDate(6));
            nv.setSoLuong(result.getInt(7));
            nv.setTenChuong(result.getString(8));
            list.add(nv);
        }
        return list;
    }
}
