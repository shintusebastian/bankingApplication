package co.pragra.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Address {
    @Id
    private Integer id;
    private int streetNumber;
    private String streetName;
    private int unitNumber;
    private String city;
    private String state;
    private String postalCode;
    @ManyToOne()//both sides has to be EAGER.
    @JoinColumn(name = "profile_id")
    private Profile profile;
}
