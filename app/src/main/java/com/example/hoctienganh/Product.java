package com.example.hoctienganh;

public class Product {
    private int id ;
    private  String ten ;
    private double price;

    public Product(){}
    public Product(int id, String ten, double price) {
        this.id = id;
        this.ten = ten;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", ten='" + ten + '\'' +
                ", price=" + price +
                '}';
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
