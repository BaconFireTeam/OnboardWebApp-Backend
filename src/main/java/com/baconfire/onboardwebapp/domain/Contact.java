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
public class Contact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "PersonID")
    private String personID;

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
