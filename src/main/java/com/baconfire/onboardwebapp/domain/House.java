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
@Table(name = "House")
public class House implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "ContactID")
    private String contactID;

    @Column(name = "Address")
    private String address;

    @Column(name = "NumberOfPerson")
    private String NumberOfPerson;

    @Column(name = "MaxPerson")
    private String MaxPerson;

}

