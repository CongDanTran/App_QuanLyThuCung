/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ReportPhieuGui;
import Model.TblNhanVien;
import Model.TblPhieuGui;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Cong Dan
 */
public class PhieuGuiXLDL {
    KNCSDL kn=null;
    public PhieuGuiXLDL(){
        kn=new KNCSDL();
    }
     public ArrayList<TblPhieuGui> getThongKe(String tungay,String denngay) throws SQLException{
        ArrayList<TblPhieuGui> list=new ArrayList<>();
        Connection conn=kn.getConnect();
        String sql="SELECT tbl_PhieuGui.*,tbl_KhachHang.TenKH,tbl_HinhThuc.Loai FROM tbl_PhieuGui,tbl_KhachHang,tbl_HinhThuc where tbl_PhieuGui.MaKH=tbl_KhachHang.MaKH and tbl_PhieuGui.MaHinhThuc=tbl_HinhThuc.MaHinhThuc AND tbl_PhieuGui.NgayGui Between + '" +tungay+"' and '"+denngay+"'";
        Statement statement=(Statement) conn.createStatement();
        ResultSet result=statement.executeQuery(sql);
        while(result.next()){
            TblPhieuGui nv=new TblPhieuGui();
            nv.setMaPhieuGui(result.getLong(1));
            nv.setMaKH(result.getLong(2));
            nv.setNgayGui(result.getDate(3));
            nv.setMaHinhThuc(result.getLong(4));
            nv.setTrangThai(result.getString(5));
            nv.setTongTien(result.getFloat(6));
            nv.setTenKH(result.getString(7));
            nv.setLoai(result.getString(8));
            list.add(nv);
        }
        return list;
    }
    
    
    public ArrayList<TblPhieuGui> getListNV() throws SQLException{
        ArrayList<TblPhieuGui> list=new ArrayList<>();
        Connection conn=kn.getConnect();
        String sql="SELECT tbl_PhieuGui.*,tbl_KhachHang.TenKH,tbl_HinhThuc.Loai FROM tbl_PhieuGui,tbl_KhachHang,tbl_HinhThuc where tbl_PhieuGui.MaKH=tbl_KhachHang.MaKH and tbl_PhieuGui.MaHinhThuc=tbl_HinhThuc.MaHinhThuc";
        Statement statement=(Statement) conn.createStatement();
        ResultSet result=statement.executeQuery(sql);
        while(result.next()){
            TblPhieuGui nv=new TblPhieuGui();
            nv.setMaPhieuGui(result.getLong(1));
            nv.setMaKH(result.getLong(2));
            nv.setNgayGui(result.getDate(3));
            nv.setMaHinhThuc(result.getLong(4));
            nv.setTrangThai(result.getString(5));
            nv.setTongTien(result.getFloat(6));
            nv.setTenKH(result.getString(7));
            nv.setLoai(result.getString(8));
            list.add(nv);
        }
        return list;
    }
   
    public ArrayList<TblPhieuGui> getListPhieuGui(String tk) throws SQLException{
        ArrayList<TblPhieuGui> list=new ArrayList<>();
        Connection conn=kn.getConnect();
        String sql="SELECT tbl_PhieuGui.*,tbl_KhachHang.TenKH,tbl_HinhThuc.Loai FROM tbl_PhieuGui,tbl_KhachHang,tbl_HinhThuc where tbl_PhieuGui.MaKH=tbl_KhachHang.MaKH and tbl_PhieuGui.MaHinhThuc=tbl_HinhThuc.MaHinhThuc and (MaPhieuGui like '%"+tk+"%' or TenKH like N'%"+tk+"%')";
        Statement statement=(Statement) conn.createStatement();
        ResultSet result=statement.executeQuery(sql);
        while(result.next()){
            TblPhieuGui nv=new TblPhieuGui();
            nv.setMaPhieuGui(result.getLong(1));
            nv.setMaKH(result.getLong(2));
            nv.setNgayGui(result.getDate(3));
            nv.setMaHinhThuc(result.getLong(4));
            nv.setTrangThai(result.getString(5));
            nv.setTongTien(result.getFloat(6));
            nv.setTenKH(result.getString(7));
            nv.setLoai(result.getString(8));
            list.add(nv);
        }
        return list;
    }

}
