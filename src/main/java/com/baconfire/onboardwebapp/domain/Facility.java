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
@Table(name = "Facility")
public class Facility implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "Type")
    private String type;

    @Column(name = "Description")
    private String description;

    @Column(name = "Quantity")
    private String quantity;


//    @ManyToOne
//    @JoinColumn(name = "HouseID")
//    private House house;

    @Column(name = "HouseID")
    private Integer houseID;



}

