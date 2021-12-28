/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.TblChuong;
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
public class ChuongXLDL {

    KNCSDL kn = null;

    public ChuongXLDL() {
        kn = new KNCSDL();
    }

    public ArrayList<TblChuong> getListNV(String tt) throws SQLException {
        ArrayList<TblChuong> list = new ArrayList<>();
        Connection conn = kn.getConnect();
        String sql = "";
        if (tt.equals("1")) {
            sql = "SELECT * FROM tbl_Chuong WHERE TrangThai like N'Trống'";
        } else {
            sql = "SELECT * FROM tbl_Chuong";
        }

        Statement statement = (Statement) conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            TblChuong nv = new TblChuong();
            nv.setMaChuong(result.getLong(1));
            nv.setTenChuong(result.getString(2));
            nv.setLoaiChuong(result.getString(3));
            nv.setGia(result.getDouble(4));
            nv.setTrangThai(result.getString(5));
            list.add(nv);
        }
        return list;
    }

    public ArrayList<TblChuong> getListChuong(String tk) throws SQLException {
        ArrayList<TblChuong> list = new ArrayList<>();
        Connection conn = kn.getConnect();
        String sql = "SELECT * FROM tbl_Chuong where (MaChuong like '%" + tk + "%' or TenChuong like N'%" + tk + "%' or LoaiChuong like N'%" + tk + "%')";
        Statement statement = (Statement) conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            TblChuong nv = new TblChuong();
            nv.setMaChuong(result.getLong(1));
            nv.setTenChuong(result.getString(2));
            nv.setLoaiChuong(result.getString(3));
            nv.setGia(result.getDouble(4));
            nv.setTrangThai(result.getString(5));
            list.add(nv);
        }
        return list;
    }

    public TblChuong getChuong(long ma) throws SQLException {
        Connection conn = kn.getConnect();
        String sql = "SELECT * FROM tbl_Chuong where MaChuong=" + ma;
        Statement statement = (Statement) conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        TblChuong nv = new TblChuong();
        while (result.next()) {

            nv.setMaChuong(result.getLong(1));
            nv.setTenChuong(result.getString(2));
            nv.setLoaiChuong(result.getString(3));
            nv.setGia(result.getDouble(4));
            nv.setTrangThai(result.getString(5));

        }
        return nv;
    }
}
