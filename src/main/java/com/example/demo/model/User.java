package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by Paksi Péter on 27/02/2018.
 */
@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String email;

    @Override
    public int hashCode() {
        int hash = 1;
        hash = hash * 17 + id;
        hash = hash * 31 + username.hashCode();
        hash = hash * 13 + password.hashCode();
        return hash;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
