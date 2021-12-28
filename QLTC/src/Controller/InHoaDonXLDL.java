/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.TblInHoaDon;
import Model.TblPhieuGui;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author CongDan
 */
public class InHoaDonXLDL {
    KNCSDL kn=null;
    public InHoaDonXLDL(){
        kn=new KNCSDL();
    }
    public ArrayList<TblInHoaDon> getListNV(String id) throws SQLException{
        ArrayList<TblInHoaDon> list=new ArrayList<>();
        Connection conn=kn.getConnect();
        String sql="select tbl_PhieuGui.*,tbl_ChiTietPhieuGui.MaSoThuCung,tbl_ChiTietPhieuGui.MaChuong from tbl_PhieuGui,tbl_ChiTietPhieuGui where (tbl_PhieuGui.MaPhieuGui=tbl_ChiTietPhieuGui.MaPhieuGui and tbl_PhieuGui.MaPhieuGui="+id+")";
        Statement statement=(Statement) conn.createStatement();
        ResultSet result=statement.executeQuery(sql);
        while(result.next()){
            TblInHoaDon nv=new TblInHoaDon();
            nv.setMaPhieuGui(result.getLong(1));
            nv.setMaKhachHang(result.getLong(2));
            nv.setNgayGui(result.getDate(3));
            nv.setMaHinhThuc(result.getLong(4));
            nv.setTrangThai(result.getString(5));
            nv.setMathuCung(result.getLong(6));
            nv.setMaChuong(result.getLong(7));
            list.add(nv);
        }
        return list;
    }
}
