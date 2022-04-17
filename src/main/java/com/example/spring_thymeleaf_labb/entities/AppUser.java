package com.example.spring_thymeleaf_labb.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "appUser")
    @JsonIgnoreProperties("appUser")
    private Set<ToDoPost> toDoPosts;

    public AppUser(String username , String password) {
        this.username = username;
        this.password = password;
    }

    public AppUser(){

    }

    public Set<ToDoPost> getToDoPosts() {
        return toDoPosts;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setToDoPosts(Set<ToDoPost> toDoPosts) {
        this.toDoPosts = toDoPosts;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
