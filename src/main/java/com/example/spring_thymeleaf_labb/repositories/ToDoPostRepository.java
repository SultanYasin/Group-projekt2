package com.example.spring_thymeleaf_labb.repositories;

import com.example.spring_thymeleaf_labb.entities.ToDoPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoPostRepository extends JpaRepository<ToDoPost, Integer> {

    List<ToDoPost> findByAppUser_Username(String username);
}
