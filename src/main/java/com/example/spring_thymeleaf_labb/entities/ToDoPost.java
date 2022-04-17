package com.example.spring_thymeleaf_labb.entities;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class ToDoPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String title;

    @Column
    private String message;

    @Column
    private  LocalDate doneBy;

    @ManyToOne
    @JoinColumn(name = "appuser_id")
    private AppUser appUser;

    public ToDoPost(String title, String message, AppUser appUser, LocalDate doneBy) {
        this.title = title;
        this.message = message;
        this.appUser = appUser;
        this.doneBy = doneBy;
    }

    public void setDoneBy(LocalDate doneBy) {
        this.doneBy = doneBy;
    }

    public ToDoPost() {

    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public LocalDate getDoneBy() {
        return doneBy;
    }


}
