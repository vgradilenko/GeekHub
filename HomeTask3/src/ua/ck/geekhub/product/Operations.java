package ua.ck.geekhub.product;

import java.text.ParseException;
import java.util.Collection;
import java.util.Date;

/**
 * Created by grava on 04.11.2016.
 */
public interface Operations {

    void addProduct(Date date, Product product);
    void removeProductByName(String name);
    Collection<Product> getProductSortedByDate();
    Collection<String> getPopularBrand();
    double calculatePrice();
    double calculatePriceForToday() throws ParseException;
    int getCounter();
    double culcPriceByBrand(String name);



}
