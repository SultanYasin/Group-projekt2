package com.example.spring_thymeleaf_labb.dto;


import com.example.spring_thymeleaf_labb.entities.AppUser;
import com.example.spring_thymeleaf_labb.entities.ToDoPost;
import com.example.spring_thymeleaf_labb.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoDTOConverter {

    @Autowired
    AppUserRepository appUserRepository;

    public ToDoPost ToDoRequestDTOToEntity(ToDoRequestDTO toDoRequestDTO) {

        AppUser appUser = appUserRepository
                .findById(toDoRequestDTO.getAppuser_id())
                .orElseThrow();

        return new ToDoPost(toDoRequestDTO.getTitle(),
                toDoRequestDTO.getMessage(),
                appUser
        );
    }

    public ToDoResponseDTO entityToBlogResponseDTO(ToDoPost toDoPost) {

        return new ToDoResponseDTO(
                toDoPost.getId(),
                toDoPost.getTitle(),
                toDoPost.getMessage(),
                toDoPost.getAppUser().getId()
        );
    }
}
