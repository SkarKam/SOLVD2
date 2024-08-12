package Models;

import java.time.LocalDate;

public class Premise {
    private static int costForM2ForMonth = 5000;
    private Shop shop;
    private LocalDate rentalDate;
    private Dimension dimension;

    public Premise(Shop shop, Dimension dimension) {
        this.shop = shop;
        this.rentalDate = LocalDate.now();
        this.dimension = dimension;
    }
    //Premise can exist without shop
    public Premise(Dimension dimension) {
        this.dimension = dimension;
    }
    public Premise(){
    }

    public static int getCostForM2ForMonth() {
        return costForM2ForMonth;
    }

    public static void setCostForM2ForMonth(int costForM2ForMonth) {
        if(costForM2ForMonth > 1000) {
            Premise.costForM2ForMonth = costForM2ForMonth;
        } else {
            throw new IllegalArgumentException("costForM2 must be greater than 1000");
        }
    }

    public Shop getShop() {
        if(shop!=null) {
            return shop;
        } else {
            return null;
        }
    }

    public void setShop(Shop shop) {
            if(shop == null) {
                this.shop = shop;
                setRentalDate();
                return;
            }
            if(getShop()==null){
                this.shop = shop;
                setRentalDate();
            } else {
                throw new IllegalArgumentException("Other shop already use this premise");
            }
        }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        if(dimension != null) {
            this.dimension = dimension;
        } else {
            throw new IllegalArgumentException("Dismension cannot be null");
        }
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    private void setRentalDate() {
        if(getShop()==null) {
            this.rentalDate = null;
        }
        else{
            this.rentalDate = LocalDate.now();
        }
    }

    public int getCostForThisPremise(){
        return getDimension().getSurface() * costForM2ForMonth;
    }

    public static int getCostFor40M2ForYear(){
        return costForM2ForMonth *40*12;
    }

    public static int getCostForDimensionForMonth(int m2){
        return costForM2ForMonth *m2;
    }
    public static int getCostForDimensionForMonth(int width, int length){
        return costForM2ForMonth *width*length;
    }

    @Override
    public String toString() {
        return "\nPremise{" +
                "shop=" + shop +
                "rentalDate=" + rentalDate +
                "dimension=" + dimension +
                '}';
    }
}
