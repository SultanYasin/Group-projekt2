package com.example.spring_thymeleaf_labb.repositories;

import com.example.spring_thymeleaf_labb.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
}
