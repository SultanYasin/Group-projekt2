package com.example.spring_thymeleaf_labb.controllers;


import com.example.spring_thymeleaf_labb.entities.ToDoPost;
import com.example.spring_thymeleaf_labb.service.ToDoPostService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/todo")
public class ToDoController {

    ToDoPostService toDoPostService;

    public ToDoController(ToDoPostService toDoPostService) {
        this.toDoPostService = toDoPostService;
    }

    @GetMapping
    public String getToDoPostList(@RequestParam(required = false) String username, Model model) {

        List<ToDoPost> toDoPostList = toDoPostService.findAll(username);
        model.addAttribute("toDoPostList", toDoPostList);
        return "todo";
    }

    @GetMapping("/addtodo")
    public String addToDo() {
        return "todoForm";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteToDoById(@PathVariable("id") int id) {
        toDoPostService.deleteById(id);
        return ResponseEntity.status(303).header("Location", "/todo").build();
    }

    @PostMapping
    public String createToDoPost(@ModelAttribute ToDoPost toDoPost) {
        toDoPostService.save(toDoPost);
        return "redirect:/todo";
    }

}
