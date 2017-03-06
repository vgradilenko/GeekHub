package ua.ck.geekhub.product;

import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by grava on 04.11.2016.
 */
public class ProductManager implements Operations {

    private Map<Date, Product> data;

    public ProductManager(){
        data = new HashMap<>();
    }

    public Map<Date, Product> getData() {
        return data;
    }

    @Override
    public void addProduct(Date date, Product product) {
        data.put(date, product);
    }

    @Override
    public void removeProductByName(String name) {

        Iterator<Map.Entry<Date, Product>> iterator = data.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Date, Product> pair = iterator.next();
            Product tmpProd = pair.getValue();
            if (tmpProd.getName().equals(name)){
                iterator.remove();
            }
        }
    }

    @Override
    public Collection<Product> getProductSortedByDate() {

        Map<Date, Product> sortedMap = new TreeMap<>(data);
        List<Product> sortedList = new ArrayList<>();

        Iterator<Map.Entry<Date, Product>> iterator = sortedMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Date, Product> pair = iterator.next();
             sortedList.add(pair.getValue());
        }
        return  sortedList;
    }

    @Override
    public Collection<String> getPopularBrand() {

        List<String> allBrand = new ArrayList<>();
        Set<String> brandSet = new HashSet<>();
        List<String> popularBrandList = new ArrayList<>();

        Iterator<Map.Entry<Date, Product>> iterator = data.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Date, Product> pair = iterator.next();
            String brand = pair.getValue().getBrand().getBrandName();
            allBrand.add(brand);
        }

        brandSet.addAll(allBrand);

        popularBrandList.addAll(brandSet.stream().map(str -> str + ": " + Collections.frequency(allBrand, str)).collect(Collectors.toList()));

        return popularBrandList;
    }

    @Override
    public double calculatePrice() {

        Iterator<Map.Entry<Date, Product>> iterator = data.entrySet().iterator();
        double culcPrice = 0;
        while (iterator.hasNext()){
            Map.Entry<Date, Product> pair = iterator.next();
             culcPrice += pair.getValue().getPrice();
        }
        return Math.rint(culcPrice * 100)/100;
    }

    @Override
    public double calculatePriceForToday() throws ParseException {

        Calendar calendar = new GregorianCalendar();
        calendar.set(GregorianCalendar.HOUR_OF_DAY, 0);
        calendar.set(GregorianCalendar.MINUTE, 0);
        calendar.set(GregorianCalendar.SECOND, 0);
        calendar.set(GregorianCalendar.MILLISECOND,0);
        calendar.add(GregorianCalendar.SECOND,-1);
        Date dayBegin = calendar.getTime();
        calendar.add(GregorianCalendar.HOUR_OF_DAY,24);
        calendar.add(GregorianCalendar.SECOND,1);
        Date dayEnd = calendar.getTime();

        double culcPriceToday = 0;
        Iterator<Map.Entry<Date, Product>> iterator = data.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Date, Product> pair = iterator.next();
            if (pair.getKey().after(dayBegin) && pair.getKey().before(dayEnd)){
                culcPriceToday += pair.getValue().getPrice();
            }
        }
        return Math.rint(culcPriceToday * 100)/100;
    }

    @Override
    public int getCounter() {
        return Product.getCount();
    }

    @Override
    public double culcPriceByBrand(String name) {

        Iterator<Map.Entry<Date, Product>> iterator = data.entrySet().iterator();
        double price = 0;

        while (iterator.hasNext()){
            Map.Entry<Date, Product> pair = iterator.next();
            String currentBrand = pair.getValue().getBrand().getBrandName();
            if (currentBrand.equals(name)){
                price += pair.getValue().getPrice();
            }
        }

        return Math.rint(price * 100)/100;
    }

}
