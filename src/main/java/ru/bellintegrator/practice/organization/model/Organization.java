package ru.bellintegrator.practice.organization.model;

import ru.bellintegrator.practice.office.model.Office;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.persistence.Column;
import java.util.List;
import java.util.Set;

/**
 * Организация
 */
@Entity
public class Organization {

    @Id
    @GeneratedValue
    private Long id;

    @Version
    private Integer version;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(name = "full_name", length = 150)
    private String fullName;

    @Column(length = 12)
    private String inn;

    @Column(length = 9)
    private String kpp;

    @Column(length = 200)
    private String address;

    @Column
    private String phone;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Office> offices;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public List<Office> getOffices() {
        return offices;
    }

    public void setOffices(List<Office> offices) {
        this.offices = offices;
    }

    public void addOffice(Office office) {
        getOffices().add(office);
        office.setOrganization(this);
    }

    public void removeOffice(Office office) {
        getOffices().remove(office);
        office.setOrganization(null);
    }
}
