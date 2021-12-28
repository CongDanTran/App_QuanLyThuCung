/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author CongDan
 */
public class reportHoaDon {
    Long maPhieuGui;
    String tenKH,trangThai,ngayGui,hinhThuc,tenThuCung,tenChuong,ngay,buoi,dichVu,trangThaiThuCung;
    float tongTien,thanhTien;

    public reportHoaDon() {
    }

    public reportHoaDon(long maPhieuGui, String tenKH, String trangThai, String ngayGui, String hinhThuc, String tenThuCung, String tenChuong, String ngay, String buoi, String dichVu, String trangThaiThuCung, float tongTien, float thanhTien) {
        this.maPhieuGui = maPhieuGui;
        this.tenKH = tenKH;
        this.trangThai = trangThai;
        this.ngayGui = ngayGui;
        this.hinhThuc = hinhThuc;
        this.tenThuCung = tenThuCung;
        this.tenChuong = tenChuong;
        this.ngay = ngay;
        this.buoi = buoi;
        this.dichVu = dichVu;
        this.trangThaiThuCung = trangThaiThuCung;
        this.tongTien = tongTien;
        this.thanhTien = thanhTien;
    }

    public long getMaPhieuGui() {
        return maPhieuGui;
    }

    public void setMaPhieuGui(long maPhieuGui) {
        this.maPhieuGui = maPhieuGui;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getNgayGui() {
        return ngayGui;
    }

    public void setNgayGui(String ngayGui) {
        this.ngayGui = ngayGui;
    }

    public String getHinhThuc() {
        return hinhThuc;
    }

    public void setHinhThuc(String hinhThuc) {
        this.hinhThuc = hinhThuc;
    }

    public String getTenThuCung() {
        return tenThuCung;
    }

    public void setTenThuCung(String tenThuCung) {
        this.tenThuCung = tenThuCung;
    }

    public String getTenChuong() {
        return tenChuong;
    }

    public void setTenChuong(String tenChuong) {
        this.tenChuong = tenChuong;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getBuoi() {
        return buoi;
    }

    public void setBuoi(String buoi) {
        this.buoi = buoi;
    }

    public String getDichVu() {
        return dichVu;
    }

    public void setDichVu(String dichVu) {
        this.dichVu = dichVu;
    }

    public String getTrangThaiThuCung() {
        return trangThaiThuCung;
    }

    public void setTrangThaiThuCung(String trangThaiThuCung) {
        this.trangThaiThuCung = trangThaiThuCung;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }
    
}
