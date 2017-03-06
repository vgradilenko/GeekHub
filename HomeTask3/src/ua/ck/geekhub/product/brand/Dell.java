package ua.ck.geekhub.product.brand;

/**
 * Created by grava on 04.11.2016.
 */
public class Dell implements Brand {

    private final String name = "Dell";

    public String getBrandName() {
        return name;
    }

    @Override
    public String toString() {
        return "Dell{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dell dell = (Dell) o;

        return name != null ? name.equals(dell.name) : dell.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
