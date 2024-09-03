package models;

import models.parkings.Parking;
import models.premises.Premise;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class ShopCenter implements IShopCenter, Serializable {
    private String shopCenterName;
    private List<Premise> premises;
    private Parking parking;
    private Address address;
    private Set<MallRegion> mallRegions;

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

    public List<Premise> getPremises() {
        return premises;
    }

    public void setPremises(List<Premise> premises) {
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

    public Set<MallRegion> getMallRegion() {
        return mallRegions;
    }

    public void setCenterWorkersSections(Set<MallRegion> mallRegions) {
        this.mallRegions = mallRegions;
    }
    public void addCenterWorkersSection(MallRegion mallRegion) {
        if(mallRegions != null) {
            this.mallRegions.add(mallRegion);
        } else {
            throw new IllegalArgumentException("CenterWorkersSection cannot be blank.");
        }
    }

    @Override
    public String toString() {
        return "\nShopCenter{" +
                "shopCenterName='" + shopCenterName + '\'' +
                "premises=" + premises +
                "parking=" + parking +
                "address=" + address +
                "centerWorkersSections=" + mallRegions +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopCenter that = (ShopCenter) o;
        return Objects.equals(shopCenterName, that.shopCenterName) && Objects.equals(premises, that.premises) && Objects.equals(parking, that.parking) && Objects.equals(address, that.address) && Objects.equals(mallRegions, that.mallRegions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shopCenterName, premises, parking, address, mallRegions);
    }
}
