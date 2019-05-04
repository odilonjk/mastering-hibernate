package com.wordpress.krogercode.entity;

import com.wordpress.krogercode.interfaces.Transportation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Airplane implements Transportation {

    @Id
    @GeneratedValue
    private long id;

    private String departureAirport;

    private String arrivalAirport;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airplane)) return false;
        Airplane airplane = (Airplane) o;
        return id == airplane.id &&
                departureAirport.equals(airplane.departureAirport) &&
                arrivalAirport.equals(airplane.arrivalAirport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, departureAirport, arrivalAirport);
    }

    @Override
    public double calculateCost() {
        return 0;
    }
}
