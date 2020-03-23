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
@Table(name = "PersonalDocument")
public class PersonalDocument implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "EmployeeID")
    private int employeeID;

    @Column(name = "Type")
    private String type;

    @Column(name = "Path")
    private String path;

    @Column(name = "Title")
    private String title;

    @Column(name = "Comment")
    private  String comment;

    @Column(name = "CreateDate")
    private String createDate;

    @Column(name = "CreateBy")
    private String createBy;

}

