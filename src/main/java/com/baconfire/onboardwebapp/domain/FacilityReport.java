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
@Table(name = "FacilityReport")
public class FacilityReport implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "Title")
    private String title;

    @Column(name = "EmployeeID")
    private Integer EmployeeID;

    @Column(name = "ReportDate")
    private String reportDate;

    @Column(name = "Description")
    private  String description;

    @Column(name = "Status")
    private String status;


}

