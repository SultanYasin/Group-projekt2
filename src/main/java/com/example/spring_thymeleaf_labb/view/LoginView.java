package com.example.spring_thymeleaf_labb.view;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;

@Route("/login")
public class LoginView extends Div implements BeforeEnterObserver {

    //BeforeEntreObserver används för att kunna göra olika typer av checking


    LoginOverlay loginOverlay = new LoginOverlay();

    public LoginView(){

        loginOverlay.setTitle("spring_thymeleaf_labb");
        loginOverlay.setDescription("What to do");
        loginOverlay.setOpened(true);
        loginOverlay.setAction("login");

        add(loginOverlay);
    }


    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {

        if ( beforeEnterEvent
                .getLocation() // var befinner vi oss just nu med webbsidan -> Vilken avdelning.
                .getQueryParameters() // för att kunna hämta parameter som finns i själva URL:n
                .getParameters() // hämta varje enskild styck av parameter
                .containsKey("error")){ // kollar om det finns ett error ord i själva url:n
            loginOverlay.setError(true); // -> Det kan berätta att det finns fel med lösenord eller username
        }

    }
}
