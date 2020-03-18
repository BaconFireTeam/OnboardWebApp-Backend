package com.baconfire.onboardwebapp.domain;

import javax.persistence.*;

@Entity
@Table(name="UserRole")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name="UserID")
    private int userId;

    @Column(name="RoleID")
    private int roleId;

    @Column(name="ActiveFlag")
    private int activeFlag;

    @Column(name="CreateDate")
    private String createDate;

    @Column(name="ModificationDate")
    private String modificationDate;

    @Column(name="LastModificationUser")
    private String lastModificationUser;

    public UserRole() {
    }

    public UserRole(int id, int userId, int roleId, int activeFlag, String createDate, String modificationDate, String lastModificationUser) {
        this.id = id;
        this.userId = userId;
        this.roleId = roleId;
        this.activeFlag = activeFlag;
        this.createDate = createDate;
        this.modificationDate = modificationDate;
        this.lastModificationUser = lastModificationUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(int activeFlag) {
        this.activeFlag = activeFlag;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(String modificationDate) {
        this.modificationDate = modificationDate;
    }

    public String getLastModificationUser() {
        return lastModificationUser;
    }

    public void setLastModificationUser(String lastModificationUser) {
        this.lastModificationUser = lastModificationUser;
    }
}
