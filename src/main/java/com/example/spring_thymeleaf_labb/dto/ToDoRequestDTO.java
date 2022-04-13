package com.example.spring_thymeleaf_labb.dto;

public class ToDoRequestDTO {

    private String title;
    private String message;
    private int appuser_id;

    public ToDoRequestDTO(String title, String message, int appuser_id) {
        this.title = title;
        this.message = message;
        this.appuser_id = appuser_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getAppuser_id() {
        return appuser_id;
    }

    public void setAppuser_id(int appuser_id) {
        this.appuser_id = appuser_id;
    }
}
