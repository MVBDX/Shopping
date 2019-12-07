package ir.maktab.hw4;

import ir.maktab.hw4.Products.Electric.Radio;
import ir.maktab.hw4.Products.Electric.Television;
import ir.maktab.hw4.Products.ProductDAO;
import ir.maktab.hw4.Products.Read.Book;
import ir.maktab.hw4.Products.Read.Magazine;
import ir.maktab.hw4.Products.Product;
import ir.maktab.hw4.Products.Shoe.Formal;
import ir.maktab.hw4.Products.Shoe.Sport;
import ir.maktab.hw4.User.Address;
import ir.maktab.hw4.User.UserAccount;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int ch = 0;
    static StockRoom stockRoom = new StockRoom();
    static UserAccount userAccount;

    public static void main(String[] args) throws SQLException {
        loadProductsToStockRoom(); //Load products to empty stock room product list from db
        registerNewUser();
        menu();
    }

    public static void loadProductsToStockRoom() throws SQLException {
//        products.add(new Book("یک عاشقانه آرام", 210000, "خواندنی", "1", 121, 3,
//                1371, "کاهی", "فرهنگ نشر نو", 134, "فارسی", "رمان",
//                "رقعی", "جلد نرم", "نادر ابراهیمی", 3));
//        products.add(new Magazine("دنیای بازی", 100000, "خواندنی", "1", 59, 9,
//                1398, "گلاسه", "بازی رایانه", 200, "فارسی", "علمی",
//                "ماهنامه", "آذر", true));
//        products.add(new Radio("ضبط", 2000000, "Radio", "Panasonic", 800, 7,
//                "Dolby", 2, 100, false, true, true,
//                true, 4));
//        products.add(new Television("نلویزیون خمیده ال جی", 150000000, "TV", "LG", 5000, 2,
//                "7.1", 7, 500, true, true, "webOS",
//                true, 47, 4, true, true));
//        products.add(new Formal("کفش مردانه", 1200000, "کفش", "Nike", 95, 21,
//                "مخصوص پیاده روی", "هوازی", "چسبی", "صورتی", 47, false));
//        products.add(new Sport("کفش دویدن", 5000000, "کفش", "ADIDAS", 300,
//                3, "Running", "", "بندی", "نارنجی", 35, true));

        List<Product> products = ProductDAO.findAll(); //Import data from database instead of add new to stock
        stockRoom.setProducts(products);
    }

    public static void startScreen() {
        System.out.println("1. Display Store Products");
        System.out.println("2. Display Cart");
        System.out.println("3. Display Cart Total Price");
        System.out.println("4. Finalize order");
        System.out.println("0. Exit");
    }

    public static void storeProductsMenu() {
        System.out.println("1. Add to Cart");
        System.out.println("2. Remove From Cart");
        System.out.println("0. Exit");
    }

    public static void menu() {
        do {
            startScreen();
            getUserInput("Select an option to continue, 0-4");

            switch (ch) {
                case 1:
                    displayStoreProducts();
                    storeProductsMenu();
                    getUserInput("Select an option to continue, 0-2");
                    innerChoice1();
                    break;
                case 2:
                    showCart();
                    break;
                case 3:
                    userAccount.shoppingCart.printCartTotalPrice(stockRoom.getProducts());
                    break;
                case 4:
                    userAccount.shoppingCart.finalizeOrder(stockRoom.getProducts());
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        } while (ch != 0);
    }

    private static void innerChoice1() {
        switch (ch) {
            case 1:
                addProductToCart();
                showCart();
                break;
            case 2:
                removeProductFromCart();
                break;
            default:
                break;
        }
    }

    private static int getUserInput(String systemOut) throws NumberFormatException {
        System.out.println(systemOut);
        Scanner in = new Scanner(System.in);
        ch = Integer.parseInt(in.nextLine());
        return ch;
    }

    private static void displayStoreProducts() {
        for (Product prod : stockRoom.getProducts()) {
            System.out.println(prod.toString()
//                    prod.getId() + "- " +
//                            prod.getName() + " " +
//                            prod.getPrice() + " " +
//                            prod.getStock()
            );
        }
    }

    private static void addProductToCart() {
        int pid = getUserInput("Please enter item id:");
        int quantity = getUserInput("How many?");

        if (stockRoom.getProducts().get(pid - 1) == null) {
            System.out.println("You entered wrong item id.");
        } else if (stockRoom.getProducts().get(pid - 1).getNumber() < userAccount.shoppingCart.getItemQuantity(pid) + quantity) {
            System.out.println("You can't enter a quantity more than in store!");
        } else {
            userAccount.shoppingCart.addItemToCart(pid, quantity, stockRoom.getProducts().get(pid - 1));
        }
    }

    private static void showCart() {
        userAccount.shoppingCart.printCartItems(stockRoom.getProducts());
    }

    private static void removeProductFromCart() {
        int pid = getUserInput("Please enter item id:");
        userAccount.shoppingCart.removeItemFromCart(pid);
    }

    private static void registerNewUser() {
        System.out.println("Please register an account to continue and shop");
        Scanner scanner = new Scanner(System.in);

        //Get user details to register a new account
        System.out.println("Enter account name:");
        String userName = scanner.nextLine();
        System.out.println("Enter account password:");
        String userPassword = scanner.nextLine();
        System.out.println("Enter your first name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name:");
        String lastName = scanner.nextLine();
        System.out.println("Enter your mobile number:");
        String mobileNo = scanner.nextLine();
        System.out.println("Enter your email:");
        String email = scanner.nextLine();

        //Get user full address
        System.out.println("Enter your province name:");
        String province = scanner.nextLine();
        System.out.println("Enter city name:");
        String city = scanner.nextLine();
        System.out.println("Enter your street name:");
        String streetName = scanner.nextLine();
        System.out.println("Enter postal code:");
        String postalCode = scanner.nextLine();

        userAccount = new UserAccount(userName, userPassword, firstName,
                lastName, mobileNo, email,
                new Address(province, city, streetName, postalCode));
    }
}
