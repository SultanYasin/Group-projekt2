package com.example.spring_thymeleaf_labb;

import com.example.spring_thymeleaf_labb.entities.AppUser;
import com.example.spring_thymeleaf_labb.entities.ToDoPost;
import com.example.spring_thymeleaf_labb.repositories.AppUserRepository;
import com.example.spring_thymeleaf_labb.repositories.ToDoPostRepository;
import com.example.spring_thymeleaf_labb.service.ToDoPostService;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import com.vaadin.flow.theme.material.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@Theme(themeClass = Lumo.class, variant = Lumo.DARK)
public class SpringThymeleafLabbApplication implements AppShellConfigurator {

  //  @Autowired
 //   PasswordEncoder passwordEncoder;


    public static void main(String[] args) {
        SpringApplication.run(SpringThymeleafLabbApplication.class, args);

    }
     @Bean
    CommandLineRunner init(ToDoPostRepository toDoPostRepository, AppUserRepository appUserRepository) {
        return args -> {

            AppUser appUser = new AppUser("Svante" ,"A1");
            AppUser tom = new AppUser("tom" , "55");
            appUserRepository.saveAll(List.of(appUser , tom) );

            ToDoPost toDoPost = new ToDoPost("ToDo Post 1", "Brödtext 1", appUser , LocalDate.of(1994,12,03));
            toDoPostRepository.save(toDoPost);
            ToDoPost toDoPost2 = new ToDoPost("ToDo Post 2", "Brödtext 2", appUser, LocalDate.of(1994,12,03));
            toDoPostRepository.save(toDoPost2);
            ToDoPost toDoPost3 = new ToDoPost("ToDo Post 3", "Brödtext 3", tom , LocalDate.of(1994,12,03));
            toDoPostRepository.save(toDoPost3);
        };


    }

}
