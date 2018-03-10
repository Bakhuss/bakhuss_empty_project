package ru.bellintegrator.practice.dictionary;

import ru.bellintegrator.practice.user.model.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Version;
import java.util.ArrayList;
import java.util.List;

/**
 * Государство
 */
@Entity
public class Country {

    @Id
    @GeneratedValue
    private Long id;

    @Version
    private Integer version;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 10, nullable = false)
    private String code;


    @ManyToMany(mappedBy = "citizenships")
    private List<User> users;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<User> getUsers() {
        if (users == null) users = new ArrayList<>();
        return users;
    }
}
