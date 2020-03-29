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
@Table(name = "ApplicationWorkFlow")
public class ApplicationWorkFlow implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "EmployeeID")
    private int employeeID;

    @Column(name = "CreatedDate")
    private String createdDate;

    @Column(name = "ModificationDate")
    private String modificationDate;

    @Column(name = "Status") //open, pending, closed
    private String status;

    @Column(name = "Comments")
    private String comments;

    @Column(name = "Type")
    private String type;
}

