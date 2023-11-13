package com.example.hoctienganh;

public class PhuongTien {

    public String ten;
    public int banh ;
    public PhuongTien() {

    }
    public PhuongTien(String ten, int banh) {
        this.ten = ten;
        this.banh = banh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getBanh() {
        return banh;
    }

    public void setBanh(int banh) {
        this.banh = banh;
    }
}
