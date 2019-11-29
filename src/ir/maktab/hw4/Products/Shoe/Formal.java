package ir.maktab.hw4.Products.Shoe;

public class Formal extends Shoe {
    private boolean medical;

    public Formal(String name, int price, String category, String brand, double weight, int number, String type, String speciality, String colsingType, String color, int size, boolean medical) {
        super(name, price, category, brand, weight, number, type, speciality, colsingType, color, size);
        this.medical = medical;
    }

    public boolean isMedical() {
        return medical;
    }

    public void setMedical(boolean medical) {
        this.medical = medical;
    }
}
