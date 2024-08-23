package models;

import java.time.LocalDate;
import java.util.Objects;

public class Shop implements IShop{
    private String shopName;
    private float shopRating;
    private LocalDate paymentDate;

    public Shop(String shopName, LocalDate paymentDate) {
        this.shopName = shopName;
        this.paymentDate = paymentDate;
    }

    public float getShopRating() {
        return shopRating;
    }

    public void setShopRating(int shopRating) {
        if(shopRating >= 0 && shopRating <= 5) {
            this.shopRating = shopRating;
        } else {
            throw new IllegalArgumentException("Shop Rating must be between 0 and 5");
        }
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        if(shopName != null) {
            this.shopName = shopName;
        } else {
            throw  new IllegalArgumentException("Shop Name cannot be null");
        }
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        if(paymentDate != null) {
            this.paymentDate = paymentDate;
        } else {
            throw  new IllegalArgumentException("Payment Date cannot be null");
        }
    }

    @Override
    public String toString() {
        return "\nShop{" +
                "shopName='" + shopName + '\'' +
                "shopRating=" + shopRating +
                "paymentDate=" + paymentDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return Float.compare(shopRating, shop.shopRating) == 0 && Objects.equals(shopName, shop.shopName) && Objects.equals(paymentDate, shop.paymentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shopName, shopRating, paymentDate);
    }
}
