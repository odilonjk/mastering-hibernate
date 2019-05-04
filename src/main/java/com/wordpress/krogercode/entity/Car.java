package com.wordpress.krogercode.entity;

import interfaces.Transportation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Car implements Transportation {

    @Id
    @GeneratedValue
    private long id;

    private String pickupLocation;

    private String dropOffLocation;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return id == car.id && pickupLocation.equals(car.pickupLocation) &&
                dropOffLocation.equals(car.dropOffLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pickupLocation, dropOffLocation);
    }

    @Override
    public double calculateCost() {
        return 0;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDropOffLocation() {
        return dropOffLocation;
    }

    public void setDropOffLocation(String dropOffLocation) {
        this.dropOffLocation = dropOffLocation;
    }
}
