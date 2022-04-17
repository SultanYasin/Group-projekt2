package com.example.spring_thymeleaf_labb.security;


import com.example.spring_thymeleaf_labb.entities.AppUser;
import com.example.spring_thymeleaf_labb.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    AppUserRepository appUserRepository;


// m.h.a loadUserByUsername hämta en användare utifrån användarnamnet som finns och kollar om han som försöker att logga
// in matchar med någon av användarna som finns redan lagrade



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser appUser = appUserRepository.findByUsername(username).orElseThrow();

        return new User(appUser.getUsername(), appUser.getPassword(), List.of());

    }
}
