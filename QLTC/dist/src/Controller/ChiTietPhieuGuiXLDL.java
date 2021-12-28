/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.TblChiTietPhieuGui;
import Model.TblKhachHang;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Cong Dan
 */
public class ChiTietPhieuGuiXLDL {
    KNCSDL kn=null;
    public ChiTietPhieuGuiXLDL(){
        kn=new KNCSDL();
    }
    public ArrayList<TblChiTietPhieuGui> getListNV(String id) throws SQLException{
        ArrayList<TblChiTietPhieuGui> list=new ArrayList<>();
        Connection conn=kn.getConnect();
        String sql="SELECT tbl_ChiTietPhieuGui.*,tbl_ThuCungKyGui.Giong,tbl_Chuong.TenChuong FROM tbl_ChiTietPhieuGui,tbl_ThuCungKyGui,tbl_Chuong where tbl_ChiTietPhieuGui.MaChuong=tbl_Chuong.MaChuong and tbl_ChiTietPhieuGui.MaSoThuCung=tbl_ThuCungKyGui.MaSoThuCung and MaPhieuGui="+id;
        Statement statement=(Statement) conn.createStatement();
        ResultSet result=statement.executeQuery(sql);
        while(result.next()){
            TblChiTietPhieuGui nv=new TblChiTietPhieuGui();
            nv.setMaPhieuGui(result.getLong(1));
            nv.setmaSoThuCung(result.getLong(2));          
            nv.setMaChuong(result.getLong(3));
            nv.setTongTien(result.getFloat(4));
            nv.setTenChuong(result.getString(6));
            nv.setGiong(result.getString(5));
            list.add(nv);
        }
        return list;
    }
    public ArrayList<TblChiTietPhieuGui> getListCTPG(String tk) throws SQLException{
        ArrayList<TblChiTietPhieuGui> list=new ArrayList<>();
        Connection conn=kn.getConnect();
        String sql="SELECT tbl_ChiTietPhieuGui.*,tbl_ThuCungKyGui.Giong,tbl_Chuong.TenChuong FROM tbl_ChiTietPhieuGui,tbl_Chuong where tbl_ChiTietPhieuGui.MaChuong=tbl_Chuong.MaChuong and tbl_ChiTietPhieuGui.MaSoThuCung=tbl_ThuCungKyGui.MaSoThuCung and (MaPhieuGui like '%"+tk+"%' or Giong like '%"+tk+"%' or TenChuong like N'%"+tk+"%')";
        Statement statement=(Statement) conn.createStatement();
        ResultSet result=statement.executeQuery(sql);
        while(result.next()){
            TblChiTietPhieuGui nv=new TblChiTietPhieuGui();
            nv.setMaPhieuGui(result.getLong(1));
            nv.setmaSoThuCung(result.getLong(2));
            nv.setMaChuong(result.getLong(3));
            nv.setTongTien(result.getFloat(4));
            nv.setTenChuong(result.getString(5));
            nv.setGiong(result.getString(6));
            list.add(nv);
        }
        return list;
    }
}
