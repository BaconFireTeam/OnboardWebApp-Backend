package com.baconfire.onboardwebapp.domain;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="Person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int Id;

    @Column(name="FirstName")
    private String FirstName;

    @Column(name="LastName")
    private String LastName;

    @Column(name="MiddleName")
    private String MiddleName;

    @Column(name="Email")
    private String Email;

    @Column(name="CellPhone")
    private String CellPhone;

    @Column(name="AlternatePhone")
    private String AlternatePhone;

    @Column(name="Gender")
    private String Gender;

    @Column(name="SSN")
    private String SSN;

    @Column(name="DOB")
    private String DOB;
}
