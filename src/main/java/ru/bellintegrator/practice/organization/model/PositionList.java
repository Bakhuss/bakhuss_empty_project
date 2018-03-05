package ru.bellintegrator.practice.organization.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Version;
import javax.persistence.Column;

/**
 * Список должностей
 */

@Entity
@Table(name = "Position_List")
public class PositionList {

    @Id
    @GeneratedValue
    private Long id;

    @Version
    private Integer version;

    @Column(nullable = false, unique = true, length = 200)
    private String name;

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
}
