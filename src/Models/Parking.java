package Models;

public class Parking {
    //Capacity for cars
    private int parkingCapacity;
    private int parkingLevels;

    public Parking(int parkingCapacity, int parkingLevels) {
        this.parkingCapacity = parkingCapacity;
        this.parkingLevels = parkingLevels;
    }
    public Parking(){
    }

    public int getParkingCapacity() {
        return parkingCapacity;
    }

    public void setParkingCapacity(int parkingCapacity) {
        if(parkingCapacity>0) {
            this.parkingCapacity = parkingCapacity;
        } else {
            throw new IllegalArgumentException("Parking Capacity must be greater than 0");
        }
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
        return parkingCapacity/parkingLevels;
    }

    @Override
    public String toString() {
        return "\nParking{" +
                "parkingCapacity=" + parkingCapacity +
                "parkingLevels=" + parkingLevels +
                '}';
    }
}
