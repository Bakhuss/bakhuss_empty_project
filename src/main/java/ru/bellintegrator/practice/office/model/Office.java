package ru.bellintegrator.practice.office.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Version;
import javax.persistence.Column;

/**
 * Офис
 */

@Entity
public class Office {

    @Id
    @GeneratedValue
    private Long id;

    @Version
    private Integer version;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(name = "organization_id")
    private Integer organizationId;

    @Column(length = 200)
    private String address;

    @Column
    private String phone;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;


    // constructors


    // getters and setters


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
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
}
