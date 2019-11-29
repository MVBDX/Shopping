package ir.maktab.hw4.Products.Shoe;

public class Sport extends Shoe {
    private boolean airCirculation;

    public Sport(String name, int price, String category, String brand, double weight, int number, String type, String speciality, String colsingType, String color, int size, boolean airCirculation) {
        super(name, price, category, brand, weight, number, type, speciality, colsingType, color, size);
        this.airCirculation = airCirculation;
    }

    public boolean isAirCirculation() {
        return airCirculation;
    }

    public void setAirCirculation(boolean airCirculation) {
        this.airCirculation = airCirculation;
    }
}
