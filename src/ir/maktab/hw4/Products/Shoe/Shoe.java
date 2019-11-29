package ir.maktab.hw4.Products.Shoe;

import ir.maktab.hw4.Products.Product;

public abstract class Shoe extends Product {
    private String type; //پارجه، کتان، چرم، مصنوعی
    private String speciality;
    private String colsingType; //بندی، چسبی
    private String color;
    private int size;

    public Shoe(String name, int price, String category, String brand, double weight, int number, String type, String speciality, String colsingType, String color, int size) {
        super(name, price, category, brand, weight, number);
        this.type = type;
        this.speciality = speciality;
        this.colsingType = colsingType;
        this.color = color;
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getColsingType() {
        return colsingType;
    }

    public void setColsingType(String colsingType) {
        this.colsingType = colsingType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
