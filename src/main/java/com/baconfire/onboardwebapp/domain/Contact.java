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
@Table(name = "Contact")
public class Contact extends Person implements Serializable {

    @Column(name = "EmployeeID")
    private int employeeID;

    @Column(name = "Relationship")
    private String relationship;

    @Column(name = "Title")
    private String title;

    @Column(name = "isReferrence")
    private  String isReferrence;

    @Column(name = "isEmergency")
    private String isEmergency;

    @Column(name = "isLandlord")
    private String isLandlord;


}
