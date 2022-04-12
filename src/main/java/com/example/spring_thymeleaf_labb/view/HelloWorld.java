package com.example.spring_thymeleaf_labb.view;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;


@Route("/helloworld")
public class HelloWorld extends VerticalLayout {

    public HelloWorld() {
        add(new H1("Hej"));
    }
}
