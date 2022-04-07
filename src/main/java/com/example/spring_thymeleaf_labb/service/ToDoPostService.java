package com.example.spring_thymeleaf_labb.service;


import com.example.spring_thymeleaf_labb.entities.ToDoPost;
import com.example.spring_thymeleaf_labb.repositories.ToDoPostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoPostService {

    ToDoPostRepository toDoPostRepository;

    public ToDoPostService(ToDoPostRepository toDoPostRepository) {
        this.toDoPostRepository = toDoPostRepository;
    }

    public List<ToDoPost> findAll(String username) {
        if (username != null) {
            return toDoPostRepository.findByAppUser_Username(username);
        } else {
            return toDoPostRepository.findAll();
        }
    }

    public ToDoPost findPostById(int id) {
        return toDoPostRepository.findById(id).orElseThrow();
    }

    public void deleteById(int id) {
        toDoPostRepository.deleteById(id);
    }

    public ToDoPost save(ToDoPost toDoPost) {
        return toDoPostRepository.save(toDoPost);
    }

}
