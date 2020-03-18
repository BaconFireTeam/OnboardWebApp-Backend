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
@Table(name = "DigitalDocument")
public class DigitalDocument implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "Type")
    private String type;

    @Column(name = "Required")
    private String required;

    @Column(name = "TemplateLocation")
    private String templateLocation;

    @Column(name = "Description")
    private  String description;


}

