package ir.maktab.hw4.User;

import ir.maktab.hw4.Products.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShoppingCart {
    private static final int maxSize = 5; //Maximize size of the cart to hold the ordered items

    HashMap<Integer, Integer> cart = new HashMap<>(); //2dimensional hashmap to save productId and number of product

    public boolean addItemToCart(int productId, int productNo) {
        System.out.println(cart.size()); //for test delete later

        if (cart.size() >= maxSize) {
            System.out.println("You can't add more products to your cart because it's full.\nmaximum size = " + maxSize);
            return false; //because cart size reached to it's limitation
        }

        if (cart.containsKey(productId)) { //If the product already exist in list, just increase the quantity
            System.out.println("old quantity:" + cart.get(productId)); //for debug
            cart.put(productId, cart.get(productId) + productNo);
            System.out.println("new quantity:" + cart.get(productId)); //for debug
        } else {
            cart.put(productId, productNo); //Save ID and Number of ordered product
        }
        return true;
    }

    public int getItemQuantity(int itemId) {
        if (cart.containsKey(itemId))
            return cart.get(itemId);
        else return 0;
    }

    public boolean removeItemFromCart(int productId) {
        System.out.println(cart.size()); //for test delete later

        if (cart.size() == 0) {
            System.out.println("The shopping cart is empty.");
            return false;
        } else if (cart.containsKey(productId)) {
            cart.remove(productId); //Remove ordered product by ID
            System.out.println("Product with id " + productId + " deleted from your cart");
            return true;
        } else {
            System.out.println("There isn't such a product with this id in your cart.");
            return false;
        }
    }

    public boolean finalizeOrder(List<Product> productArrayList) {
        if (cart.isEmpty()) {
            System.out.println("Your cart is Empty!");
            return false;
        } else {
            for (Integer i : cart.keySet()) {
                productArrayList.get(i - 1).setNumber(productArrayList.get(i - 1).getNumber() - cart.get(i));
            }
            cart.clear();
            return true;
        }
    }

    public void printCartItems(List<Product> productArrayList) {
        System.out.println("Your cart items:");
        if (cart.isEmpty()) System.out.println("Empty!");
        for (Integer i : cart.keySet()) {
            System.out.println("Product ID: " + i +
                    ", Quantity: " + cart.get(i) +
                    ", Name: " + productArrayList.get(i - 1).getName());
        }
    }

    public boolean printCartTotalPrice(List<Product> productArrayList) {
        if (cart.isEmpty()) {
            System.out.println("Your cart is Empty!");
            return false;
        } else {
            int sum = 0;
            for (Integer i : cart.keySet()) {
                sum += cart.get(i) * productArrayList.get(i - 1).getPrice();
            }
            System.out.println("Total price of your cart is: " + sum + " rials");
            return true;
        }
    }

}
