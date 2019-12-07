package ir.maktab.hw4.User;

import ir.maktab.hw4.DatabaseConfig;
import ir.maktab.hw4.Products.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartDAO {
    private static final String tableName = "cart";

    public boolean add(Product product) {
        try {
            Connection connection = DatabaseConfig.getDatabaseConnection(); //Connection
            String insertQuery = "INSERT INTO " + tableName +
                    " (id,name,quantity,price,weight,type,category) VALUES(?, ?, ?, ?, ?, ?, ?);"; //Query
            //Statement
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            //Execute query
            preparedStatement.setInt(1, product.getId());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setInt(3, product.getNumber());
            preparedStatement.setInt(4, product.getPrice());
            preparedStatement.setDouble(5, product.getWeight());
            preparedStatement.setString(6, product.getBrand());
            preparedStatement.setString(7, product.getCategory());
            //USERID TODO
            preparedStatement.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public Product findById(int id) { //Find unique record by it's ID field
        ResultSet resultSet = null;
        Product product = null;
        try {
            Connection connection = DatabaseConfig.getDatabaseConnection();
            String insertQuery = "select * from " + tableName + " where id=" + id;
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            product.setName(resultSet.getString("name"));
            product.setNumber(resultSet.getInt("quantity"));
            product.setPrice(resultSet.getInt("price"));
            product.setWeight(resultSet.getDouble("weight"));
            product.setBrand(resultSet.getString("type"));
            product.setCategory(resultSet.getString("category"));
            //USER ID TODO
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public static List<Product> findAll() throws SQLException { //Return all records of table
        ResultSet resultSet = null;
        try {
            Connection connection = DatabaseConfig.getDatabaseConnection();
            String insertQuery = "select * from " + tableName; //+ " where userid = "; TODO
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            resultSet = preparedStatement.executeQuery();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return convertResultset2Array(resultSet);
    }

    private static List<Product> convertResultset2Array(ResultSet resultSet) throws SQLException {
        List<Product> products = new ArrayList<Product>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int quantity = resultSet.getInt("quantity");
            int price = resultSet.getInt("price");
            int weight = resultSet.getInt("weight");
            String type = resultSet.getString("type");
            String category = resultSet.getString("category");
            products.add(new Product(name,price,category,type,weight,quantity) {
                @Override //Override just for using an abstract class
                public String toString() {
                    return super.toString();
                }
            });
        }
        return products;
    }

    public boolean edit() {
        //TODO
        return true;
    }

    public boolean delete(int id) { //Delete record by it's ID
        try {
            Connection connection = DatabaseConfig.getDatabaseConnection();
            String insertQuery = "DELETE FROM " + tableName + " WHERE id=" + id;
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }
}
