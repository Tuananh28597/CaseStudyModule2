package com.codegym.model;

public class Product {
    private String id;
    private String name;
    private String wareHouseDay;   //ngày nhập kho
    private double price;
    private Category category;
    public Product() {
    }

    public Product(String id, String name, String wareHouseDay, double price) {
        this.id = id;
        this.name = name;
        this.wareHouseDay = wareHouseDay;
        this.price = price;
    }



    public Product(String id, String name, String wareHouseDay, double price, Category category) {
        this.id = id;
        this.name = name;
        this.wareHouseDay = wareHouseDay;
        this.price = price;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getWareHouseDay() {
        return wareHouseDay;
    }

    public void setWareHouseDay(String wareHouseDay) {
        this.wareHouseDay = wareHouseDay;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String display(){
        return " id="+id+ " "+  "Tên sản phẩm:"  + name+ " giá sản phẩm=" + price +" vnđ";
    }

    @Override
    public String toString() {
        return " Thông tin sản phẩm " + " , " +
                " id= " + id + " , " +
                " name= " + name + " , " +
                " wareHouseDay= " + wareHouseDay + " , " +
                " price= " + price + " , " +
                " classProduct= " + category ;
    }
}
