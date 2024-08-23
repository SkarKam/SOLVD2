package models;

import models.parkings.Parking;
import models.premises.Premise;

import java.util.Arrays;
import java.util.Objects;

public class ShopCenter implements IShopCenter {
    private String shopCenterName;
    private Premise[] premises;
    private Parking parking;
    private Address address;
    private MallRegion[] mallRegions;

    public ShopCenter(String shopCenterName, Parking parking, Address address) {
        this.shopCenterName = shopCenterName;
        this.parking = parking;
        this.address = address;
    }


    public String getShopCenterName() {
        return shopCenterName;
    }

    public void setShopCenterName(String shopCenterName) {
        if(!shopCenterName.isBlank()) {
            this.shopCenterName = shopCenterName;
        } else {
            throw new IllegalArgumentException("Shop center name cannot be blank.");
        }
    }

    public Premise[] getPremises() {
        return premises;
    }

    public void setPremises(Premise[] premises) {
        this.premises = premises;
    }

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        if(address != null) {
            this.address = address;
        } else {
            throw new IllegalArgumentException("Address cannot be blank.");
        }
    }

    public MallRegion[] getCenterWorkersSections() {
        return mallRegions;
    }

    public void setCenterWorkersSections(MallRegion[] mallRegions) {
        this.mallRegions = mallRegions;
    }
    public void addCenterWorkersSection(MallRegion mallRegion) {
        if(mallRegions != null) {
            this.mallRegions[getCenterWorkersSections().length] = mallRegion;
        } else {
            throw new IllegalArgumentException("CenterWorkersSection cannot be blank.");
        }
    }

    @Override
    public String toString() {
        return "\nShopCenter{" +
                "shopCenterName='" + shopCenterName + '\'' +
                "premises=" + Arrays.toString(premises) +
                "parking=" + parking +
                "address=" + address +
                "centerWorkersSections=" + Arrays.toString(mallRegions) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopCenter that = (ShopCenter) o;
        return Objects.equals(shopCenterName, that.shopCenterName) && Objects.deepEquals(premises, that.premises) && Objects.equals(parking, that.parking) && Objects.equals(address, that.address) && Objects.deepEquals(mallRegions, that.mallRegions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shopCenterName, Arrays.hashCode(premises), parking, address, Arrays.hashCode(mallRegions));
    }
}
