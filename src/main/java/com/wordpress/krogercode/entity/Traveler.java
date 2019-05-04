package com.wordpress.krogercode.entity;

import com.wordpress.krogercode.interfaces.Transportation;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.MetaValue;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Traveler {

    @Id
    @GeneratedValue
    private long id;

    private String firstName;

    private String lastName;

    @ManyToAny(metaColumn = @Column(name = "trans_mode"))
    @AnyMetaDef(
            idType="long",
            metaValues = {
                    @MetaValue(value = "C", targetEntity = Car.class),
                    @MetaValue(value = "A", targetEntity = Airplane.class),
            },
            metaType = "char"
    )
    @JoinTable(
            name="traveler_transportation",
            joinColumns = @JoinColumn(name = "traveler_id"),
            inverseJoinColumns = @JoinColumn(name = "mode_id")
    )
    private Set<Transportation> transportation = new HashSet<>();

    public Traveler() {
        //  Empty constructor used by Hibernate.
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Transportation> getTransportation() {
        return transportation;
    }

    public void setTransportation(Set<Transportation> transportation) {
        this.transportation = transportation;
    }
}
