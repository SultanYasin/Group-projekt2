package com.example.spring_thymeleaf_labb.dto;



public class ToDoResponseDTO {

    private int id;
    private String title;
    private String message;
    private int appUserId;

    public ToDoResponseDTO(int id, String title, String message, int appUserId) {

        this.id = id;
        this.title = title;
        this.message = message;
        this.appUserId = appUserId;

    }

    public ToDoResponseDTO() {

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

    public void setAppUserId(int appUserId) {
        this.appUserId = appUserId;
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

    public int getAppUserId() {
        return appUserId;
    }
}
