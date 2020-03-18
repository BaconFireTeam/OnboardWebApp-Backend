package com.baconfire.onboardwebapp.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "Address")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "AddressLine1")
    private String addressLine1;

    @Column(name = "AddressLine2")
    private String addressLine2;

    @Column(name = "City")
    private String city;

    @Column(name = "Zipcode")
    private  String zipcode;

    @Column(name = "StateName")
    private String stateName;

    @Column(name = "StateAbbr")
    private String stateAbbr;

    @Column(name = "PersonID")
    private String personID;

}

