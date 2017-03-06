package ua.ck.geekhub.product;
import ua.ck.geekhub.product.brand.Brand;

/**
 * Created by grava on 04.11.2016.
 */
public class Product implements Comparable<Product> {
    private Brand brand;
    private String name;
    private double price;

    private static int count;

    static{
        Product.count = 0;
    }

    public Product(Brand brand, String name, double price) {
        this.brand = brand;
        this.name = name;
        this.price = price;
        Product.count++;
    }

    public String getName() {
        return name;
    }

    public static int getCount() {
        return count;
    }

    public Brand getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (Double.compare(product.price, price) != 0) return false;
        if (brand != null ? !brand.equals(product.brand) : product.brand != null) return false;
        return name != null ? name.equals(product.name) : product.name == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = brand != null ? brand.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public int compareTo(Product o) {
        if (this.price < o.price){
            return -1;
        } else if (this.price > o.price){
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Product{" +
                "brand=" + brand +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}


