package ru.bellintegrator.practice.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Version;

/**
 * Логин и пароль (хэш)
 */
@Entity
public class Login {

    @Id
    @Column(name = "user_id")
    private Long id;

    @Version
    private Integer version;

    @Column(unique = true, nullable = true)
    private String login;

    @Column(nullable = false)
    private String password;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    private User user;


    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
