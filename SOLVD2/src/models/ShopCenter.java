package models;

import exception.BlankValueException;
import exception.NullValueException;
import models.parkings.Parking;
import models.premises.Premise;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Logger;

public class ShopCenter implements IShopCenter, Serializable {
    private static final Logger logger = Logger.getLogger(ShopCenter.class.getName());

    private String shopCenterName;
    private List<Premise> premises;
    private Parking parking;
    private Address address;
    private Set<MallRegion> mallRegions;

    public ShopCenter(String shopCenterName, Parking parking, Address address) {
        logger.info("Create ShopCenter with name " + shopCenterName);
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
            logger.info("Shop center name is blank");
            throw new BlankValueException("Shop center name cannot be blank.");
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
            throw new NullValueException("Address cannot be blank.");
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
            throw new NullValueException("CenterWorkersSection cannot be blank.");
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
