package Models;

import java.time.LocalDate;

public class Shop {
    private String shopName;
    private float shopRating;
    private LocalDate paymentDate;

    public Shop(String shopName, float shopRating, LocalDate paymentDate) {
        this.shopName = shopName;
        this.shopRating = shopRating;
        this.paymentDate = paymentDate;
    }
    public Shop() {}

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
}
