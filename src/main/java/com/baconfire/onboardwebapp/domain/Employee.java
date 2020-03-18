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
@Table(name = "Employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "PersonID")
    private String personID;

    @Column(name = "Tile")
    private String title;

    @Column(name = "ManagerID")
    private String managerID;

    @Column(name = "StartDate")
    private  String startDate;

    @Column(name = "EndDate")
    private String endDate;

    @Column(name = "Avartar")
    private String avartar;

    @Column(name = "Car")
    private String car;

    @Column(name = "VisaStartDate")
    private String visaStartDate;

    @Column(name = "VisaEndDate")
    private String visaEndDate;

    @Column(name = "DriverLisence")
    private String driverLisence;

    @Column(name = "DriverLisence_ExpirationDate")
    private String driverLisence_ExpirationDate;

    @Column(name = "HouseID")
    private String houseID;


}