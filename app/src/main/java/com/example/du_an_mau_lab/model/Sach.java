package com.example.du_an_mau_lab.model;

public class Sach {
    public String maSach;
    public String maTL;
    public String tieuDe;
    public String tacGia;
    public String NXB;
    public  int soLuong;

    public Sach() {
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getMaTL() {
        return maTL;
    }

    public void setMaTL(String maTL) {
        this.maTL = maTL;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getNXB() {
        return NXB;
    }

    public void setNXB(String NXB) {
        this.NXB = NXB;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Sach(String maSach, String maTL, String tieuDe, String tacGia, String NXB, int soLuong) {
        this.maSach = maSach;
        this.maTL = maTL;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        this.NXB = NXB;
        this.soLuong = soLuong;
    }
}
