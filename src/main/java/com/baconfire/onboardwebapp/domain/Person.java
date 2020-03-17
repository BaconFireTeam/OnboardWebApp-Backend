package com.baconfire.onboardwebapp.domain;
import javax.persistence.*;

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
    private long CellPhone;

    @Column(name="AlternatePhone")
    private long AlternatePhone;

    @Column(name="Gender")
    private String Gender;

    @Column(name="SSN")
    private String SSN;

    @Column(name="DOB")
    private String DOB;

    public Person() {
    }

    public Person(int id, String firstName, String lastName, String middleName, String email, long cellPhone, long alternatePhone, String gender, String SSN, String DOB) {
        Id = id;
        FirstName = firstName;
        LastName = lastName;
        MiddleName = middleName;
        Email = email;
        CellPhone = cellPhone;
        AlternatePhone = alternatePhone;
        Gender = gender;
        this.SSN = SSN;
        this.DOB = DOB;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public long getCellPhone() {
        return CellPhone;
    }

    public void setCellPhone(long cellPhone) {
        CellPhone = cellPhone;
    }

    public long getAlternatePhone() {
        return AlternatePhone;
    }

    public void setAlternatePhone(long alternatePhone) {
        AlternatePhone = alternatePhone;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }
}
