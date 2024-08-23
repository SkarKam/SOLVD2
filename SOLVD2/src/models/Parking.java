package models;


import java.time.LocalTime;
import java.util.Arrays;
import java.util.Objects;

public class Parking {
    private int parkingLevels;
    private LocalTime openTime;
    private LocalTime closeTime;
    private ParkingSpace[] parkingSpaces;

    public Parking(int parkingLevels) {
        this.parkingLevels = parkingLevels;
        openTime = LocalTime.of(6,30);
        closeTime = LocalTime.of(22,30);
    }

    public int getParkingLevels() {
        return parkingLevels;
    }

    public void setParkingLevels(int parkingLevels) {
        if(parkingLevels>=1) {
            this.parkingLevels = parkingLevels;
        } else throw new IllegalArgumentException("Parking Levels must be greater or equal 1");
    }

    public int getParkingSpacesPerLevels(){
        return parkingSpaces.length/parkingLevels;
    }

    public LocalTime getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(LocalTime closeTime) {
        if(closeTime == null){
            throw new IllegalArgumentException("Close Time cannot be null");
        }
        if(closeTime.isAfter(openTime)) {
            this.closeTime = closeTime;
        } else throw new IllegalArgumentException("Close Time must be greater than open Time");
    }

    public LocalTime getOpenTime() {
        return openTime;
    }

    public void setOpenTime(LocalTime openTime) {
        if(openTime == null){
            throw new IllegalArgumentException("Open Time cannot be null");
        }
        if(openTime.isBefore(closeTime)) {
            this.openTime = openTime;
        } else throw new IllegalArgumentException("Close Time must be greater than open Time");
    }

    public ParkingSpace[] getParkingSpaces() {
        return parkingSpaces;
    }

    public void setParkingSpaces(ParkingSpace[] parkingSpaces) {
        this.parkingSpaces = parkingSpaces;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parking parking = (Parking) o;
        return parkingLevels == parking.parkingLevels && Objects.equals(openTime, parking.openTime) && Objects.equals(closeTime, parking.closeTime) && Objects.deepEquals(parkingSpaces, parking.parkingSpaces);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parkingLevels, openTime, closeTime, Arrays.hashCode(parkingSpaces));
    }

    @Override
    public String toString() {
        return "Parking{" +
                "parkingLevels=" + parkingLevels +
                ", openTime=" + openTime +
                ", closeTime=" + closeTime +
                ", parkingSpaces=" + Arrays.toString(parkingSpaces) +
                '}';
    }
}
