package ir.maktab.hw4.Products;

public abstract class Product {
    private static int idCounter = 0;
    private int id;
    private String name;
    private int price; //Rials
    private String category;
    private String brand;
    private double weight; //Grams
    private int number;

    public Product(String name, int price, String category, String brand, double weight, int number) {
        this.idCounter++;
        this.id = idCounter;
        this.name = name;
        this.price = price;
        this.category = category;
        this.brand = brand;
        this.weight = weight;
        this.number = number;
    }

    @Override
    public String toString() {
        return "ID: " + getId() +
                ", Name: " + getName() +
                ", Quantity: " + getNumber() +
                ", Category: " + getCategory() +
                ", Type: " + getClass().getSimpleName() +
                ", Price: " + getPrice() +
                ", Weight: " + getWeight();
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
