package ir.maktab.hw4.User;

import ir.maktab.hw4.DatabaseConfig;
import ir.maktab.hw4.Products.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserAccountDAO {
    private static final String tableName = "users";
    private static int userId;

    public int add(UserAccount userAccount) { //return new id from db
        try {
            Connection connection = DatabaseConfig.getDatabaseConnection(); //Connection

            String insertQuery = "INSERT INTO " + tableName +
                    " (username,password,firstname,lastname,mobile,email,province,city,streetname,postalcode) " +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);"; //Query
            //Statement
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            //Execute query
            preparedStatement.setString(1, userAccount.getUserName());
            preparedStatement.setString(2, userAccount.getPassword());
            preparedStatement.setString(3, userAccount.getFirstName());
            preparedStatement.setString(4, userAccount.getLastName());
            preparedStatement.setString(5, userAccount.getMobileNo());
            preparedStatement.setString(6, userAccount.getEmail());
            preparedStatement.setString(7, userAccount.getAddress().getProvince());
            preparedStatement.setString(8, userAccount.getAddress().getCity());
            preparedStatement.setString(9, userAccount.getAddress().getStreetName());
            preparedStatement.setString(10, userAccount.getAddress().getPostalCode());
            preparedStatement.execute();

            insertQuery = "SELECT * FROM " + tableName + " ORDER BY id DESC LIMIT 1"; //Getting inserted auto-increment id
            preparedStatement = connection.prepareStatement(insertQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt("id");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static UserAccount findUser(String userName, String password) { //Find unique record by it's ID field
        ResultSet resultSet = null;
        UserAccount userAccount = null;
        try {
            Connection connection = DatabaseConfig.getDatabaseConnection();
            String findQuery = "SELECT * FROM " + tableName +
                    " WHERE username = ? && password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(findQuery);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                userAccount = new UserAccount(resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getString("mobile"),
                        resultSet.getString("email"),
                        new Address(resultSet.getString("province"),
                                resultSet.getString("city"),
                                resultSet.getString("streetname"),
                                resultSet.getString("postalcode")), false);
                userAccount.setId(resultSet.getInt("id"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userAccount;
    }

    public static List<Product> findAll() throws SQLException { //Return all records of table
        ResultSet resultSet = null;
        try {
            Connection connection = DatabaseConfig.getDatabaseConnection();
            String insertQuery = "SELECT * FROM " + tableName + " WHERE userid = " + userId;
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
            products.add(new Product(name, price, category, type, weight, quantity) {
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
            String insertQuery = "DELETE FROM " + tableName + " WHERE productid = " + id + " && userid = " + userId;
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
