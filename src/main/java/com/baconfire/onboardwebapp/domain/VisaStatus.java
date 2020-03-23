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
@Table(name = "VisaStatus")
public class VisaStatus implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "VisaType")
    private String visaType;

    @Column(name = "Active")
    private String active;

    @Column(name = "ModificationDate")
    private String modificationDate;

    @Column(name = "CreateUser")
    private  String createUser;

}

