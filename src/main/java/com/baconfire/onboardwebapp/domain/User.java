package com.baconfire.onboardwebapp.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="User")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int ID;

    @Column(name="UserName")
    private String UserName;

    @Column(name="Email")
    private String Email;

    @Column(name="Password")
    private String Password;

    @Column(name="PersonID")
    private int PersonID;

    @Column(name="CreateDate")
    private String CreateDate;

    @Column(name="ModificationDate")
    private String ModificationDate;

    public User() {
    }

    public User(int ID, String userName, String email, String password, int personID, String createDate, String modificationDate) {
        this.ID = ID;
        UserName = userName;
        Email = email;
        Password = password;
        PersonID = personID;
        CreateDate = createDate;
        ModificationDate = modificationDate;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getPersonID() {
        return PersonID;
    }

    public void setPersonID(int personID) {
        PersonID = personID;
    }

    public String getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(String createDate) {
        CreateDate = createDate;
    }

    public String getModificationDate() {
        return ModificationDate;
    }

    public void setModificationDate(String modificationDate) {
        ModificationDate = modificationDate;
    }
}
