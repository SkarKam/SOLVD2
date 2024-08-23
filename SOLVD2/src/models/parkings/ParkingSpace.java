package models.parkings;

import java.awt.*;
import java.util.Objects;

public class ParkingSpace {
    private final Dimension dimension;
    private boolean isPaid;
    private boolean isOccupied;
    private static int cost = 10;

    public ParkingSpace(Dimension dimension) {
        this.dimension = dimension;
        this.isPaid = false;
        this.isOccupied = false;
    }

    public Dimension getDimension() {
        return dimension;
    }


    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public static int getCost() {
        return cost;
    }

    public static void setCost(int cost) {
        if(cost >= 0) {
            ParkingSpace.cost = cost;
        } else {
            throw new IllegalArgumentException("Cost cannot be negative");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingSpace that = (ParkingSpace) o;
        return isPaid == that.isPaid && isOccupied == that.isOccupied && Objects.equals(dimension, that.dimension);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dimension, isPaid, isOccupied);
    }

    @Override
    public String toString() {
        return "ParkingSpace{" +
                "dimension=" + dimension +
                ", isPaid=" + isPaid +
                ", isOccupied=" + isOccupied +
                '}';
    }
}
