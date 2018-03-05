package ru.bellintegrator.practice.user.model;

import javax.persistence.*;

// Сотрудник

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Version
    private Integer version;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "second_name", nullable = false)
    private String secondName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "office_position_id")
    private Integer officePositionId;

    @Column
    private Integer phone;

    @Column(name = "citizenship_code")
    private Integer citizenshipCode;

    @Column(name = "is_identified", nullable = false)
    private Boolean isIdentified;

    // constructors

    public User() {
    }

    // getters and setters


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Integer getOfficePositionId() {
        return officePositionId;
    }

    public void setOfficePositionId(Integer officePositionId) {
        this.officePositionId = officePositionId;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Integer getCitizenshipCode() {
        return citizenshipCode;
    }

    public void setCitizenshipCode(Integer citizenshipCode) {
        this.citizenshipCode = citizenshipCode;
    }

    public Boolean getIdentified() {
        return isIdentified;
    }

    public void setIdentified(Boolean identified) {
        isIdentified = identified;
    }
}
