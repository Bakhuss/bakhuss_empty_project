package ru.bellintegrator.practice.organization.model;

import javax.persistence.*;

// Список должностей

@Entity
@Table(name = "Position_List")
public class PositionList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Version
    private Integer version;

    @Column(nullable = false, unique = true)
    private String name;

    // constructor

    public PositionList() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
