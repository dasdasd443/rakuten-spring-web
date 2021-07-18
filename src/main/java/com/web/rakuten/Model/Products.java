package com.web.rakuten.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Products {
    @Id
    @GeneratedValue
    private Long product_id;
    private String product_name;
    private String brand;
    private double discount_price;
    private double price;

    public Products() {
    }

    public Products(Long product_id, String product_name, String brand, double discount_price, double price) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.brand = brand;
        this.discount_price = discount_price;
        this.price = price;
    }

    public Products(String product_name, String brand, double discount_price, double price) {
        this.product_name = product_name;
        this.brand = brand;
        this.discount_price = discount_price;
        this.price = price;
    }



    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getDiscount_price() {
        return discount_price;
    }

    public void setDiscount_price(double discount_price) {
        this.discount_price = discount_price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Products{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", brand='" + brand + '\'' +
                ", discount_price=" + discount_price +
                ", price=" + price +
                '}';
    }
}
