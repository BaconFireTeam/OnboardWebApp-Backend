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
@Table(name = "FacilityReportDetail")
public class FacilityReportDetail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "ReportID")
    private String reportID;

    @Column(name = "EmployeeID")
    private String employeeID;

    @Column(name = "Comments")
    private String comments;

    @Column(name = "CreatedDate")
    private  String createdDate;

    @Column(name = "LastModificationDate")
    private String lastModificationDate;


}
