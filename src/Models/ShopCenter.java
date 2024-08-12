package Models;

import java.util.Arrays;

public class ShopCenter {
    private String shopCenterName;
    private Premise[] premises;
    private Parking parking;
    private Address address;
    private CenterWorkersSection[] centerWorkersSections;

    public ShopCenter(String shopCenterName, Premise[] premises, Parking parking, Address address, CenterWorkersSection[] centerWorkersSections) {
        this.shopCenterName = shopCenterName;
        this.premises = premises;
        this.parking = parking;
        this.address = address;
        this.centerWorkersSections = centerWorkersSections;
    }

    public ShopCenter() {
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

    public CenterWorkersSection[] getCenterWorkersSections() {
        return centerWorkersSections;
    }

    public void setCenterWorkersSections(CenterWorkersSection[] centerWorkersSections) {
        this.centerWorkersSections = centerWorkersSections;
    }
    public void addCenterWorkersSection(CenterWorkersSection centerWorkersSection) {
        if(centerWorkersSections != null) {
            this.centerWorkersSections[getCenterWorkersSections().length] = centerWorkersSection;
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
                "centerWorkersSections=" + Arrays.toString(centerWorkersSections) +
                '}';
    }
}
