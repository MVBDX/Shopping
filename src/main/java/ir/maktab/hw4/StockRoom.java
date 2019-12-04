package ir.maktab.hw4;

import ir.maktab.hw4.Products.Product;

import java.util.ArrayList;
import java.util.List;

public class StockRoom {

    private List<Product> products = new ArrayList<Product>();

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void printItems() {
        for (Product product : products) {
            System.out.println(product.toString());
        }

    }

}

