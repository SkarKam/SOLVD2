package models.persons.clients;

import models.Shop;
import models.persons.Person;

import java.util.Arrays;
import java.util.Objects;

/**
 * Shop owner - client of the shopCenter.
 */
public final class ShopOwner extends Person {

    private int rating;
    private Shop[] shops;


    public ShopOwner(String name, String surname, int rating) {
        super(name, surname);
        this.rating = rating;
    }

    public Shop[] getShops() {
        return shops;
    }

    public void setShops(Shop[] shops) {
        this.shops = shops;
    }

    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "ShopOwner{" +
                "rating=" + rating +
                ", shops=" + Arrays.toString(shops) +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ShopOwner shopOwner = (ShopOwner) o;
        return rating == shopOwner.rating && Objects.deepEquals(shops, shopOwner.shops);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), rating, Arrays.hashCode(shops));
    }
}
