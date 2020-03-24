package com.baconfire.onboardwebapp.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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
    private Integer contactID;

    @Column(name = "Address")
    private String address;

    @Column(name = "NumberOfPerson")
    private String numberOfPerson;

    @Column(name = "maxPerson")
    private String maxPerson;

    @OneToMany(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    @JoinColumn(name = "ID", updatable = false, insertable = false, nullable=false)
    private List<Facility> facilityList ;

}

