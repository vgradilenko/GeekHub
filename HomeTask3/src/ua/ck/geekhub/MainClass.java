package ua.ck.geekhub;

import ua.ck.geekhub.product.Product;
import ua.ck.geekhub.product.ProductManager;
import ua.ck.geekhub.product.brand.Apple;
import ua.ck.geekhub.product.brand.Brand;
import ua.ck.geekhub.product.brand.Dell;
import ua.ck.geekhub.product.brand.HewlettPackard;
import ua.ck.geekhub.util.Utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Date;

/**
 * Created by grava on 05.11.16.
 */
public class MainClass {
    public static void main(String[] args) throws ParseException, IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ProductManager manager = new ProductManager();

        manager.addProduct(Utility.stringToDate("14-04-2000"), new Product(new Apple(), "1", 50.2));
        manager.addProduct(Utility.stringToDate("15-04-1989"), new Product(new Dell(), "2", 10.2));
        manager.addProduct(Utility.stringToDate("11-04-2001"), new Product(new Dell(), "4", 130.2));
        manager.addProduct(Utility.stringToDate("13-01-2005"), new Product(new HewlettPackard(), "1", 1332.2));
        manager.addProduct(Utility.stringToDate("13-02-2016"), new Product(new Dell(), "dell", 13.2));
        manager.addProduct(Utility.stringToDate("13-04-1990"), new Product(new Dell(), "dell", 13231.2));
        manager.addProduct(Utility.stringToDate("13-04-1999"), new Product(new Apple(), "6", 1345.2));
        manager.addProduct(Utility.stringToDate("13-04-2015"), new Product(new Apple(), "8", 122.2));
        manager.addProduct(Utility.stringToDate("05-11-2016"), new Product(new Apple(), "app", 30.34));
        manager.addProduct(new Date(), new Product(new Apple(), "app", 10.2));

        System.out.println("We have custom db. You must add new product or write exit");

        while (true){
            if (reader.readLine().equals("exit")){
                break;
            } else {
                System.out.println("Write date in format dd-MM-yyyy");
                String date = reader.readLine();
                System.out.println("Ok, next step we need enter Product");
                System.out.println("Select Brand: 1 - Apple, 2 - Dell, 3 - HP.");

                String choice = reader.readLine();
                Brand brand;

                if (choice.equals("1")) {
                    brand = new Apple();
                } else if (choice.equals(2)) {
                    brand = new Dell();
                } else if (choice.equals("3")) {
                    brand = new HewlettPackard();
                } else {
                    brand = new Dell();
                }

                System.out.println("Good, please enter model name");

                String name = reader.readLine();

                System.out.println("Last step: enter price of product");

                int price = Integer.parseInt(reader.readLine());

                manager.addProduct(Utility.stringToDate(date), new Product(brand, name, price));
            }
        }

        System.out.println("Choice method:");
        System.out.println("1 - removeProductByName(String name)");
        System.out.println("2 - getProductSortedByDate()");
        System.out.println("3 - getPopularBrand()");
        System.out.println("4 - calculatePrice()");
        System.out.println("5 - calculatePriceForToday()");
        System.out.println("6 - culcPriceByBrand(String name)");

        while (true){
            if (reader.readLine().equals("exit")){
                break;
            } else {
                String choice = reader.readLine();
                switch (choice){
                    case "1": manager.removeProductByName(reader.readLine());
                        break;
                    case "2": manager.getProductSortedByDate();
                        break;
                    case "3": manager.getPopularBrand();
                        break;
                    case "4": manager.calculatePrice();
                        break;
                    case "5": manager.calculatePriceForToday();
                        break;
                    case "6": manager.culcPriceByBrand(reader.readLine());
                        break;
                    default: manager.getCounter();
                }
            }
        }
        reader.close();
    }
}
