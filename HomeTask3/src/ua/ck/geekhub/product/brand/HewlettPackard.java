package ua.ck.geekhub.product.brand;

/**
 * Created by grava on 04.11.2016.
 */
public class HewlettPackard implements Brand {

    private final String name = "HP";

    public String getBrandName() {
        return name;
    }

    @Override
    public String toString() {
        return "HewlettPackard{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HewlettPackard that = (HewlettPackard) o;

        return name != null ? name.equals(that.name) : that.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}

