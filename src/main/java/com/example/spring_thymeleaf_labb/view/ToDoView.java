package com.example.spring_thymeleaf_labb.view;

import com.example.spring_thymeleaf_labb.service.ToDoPostService;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

@AnonymousAllowed
@Route(value = "/", layout = MainView.class)
public class ToDoView extends VerticalLayout {

    public ToDoView(ToDoPostService toDoPostService) {


        add(new H1("All ToDo Posts"), new Hr());

        setAlignItems(Alignment.CENTER);

        toDoPostService.findAll(null).forEach(toDoPost -> {

            H2 todoTitle = new H2(toDoPost.getTitle());
            Paragraph todoMessage = new Paragraph(toDoPost.getMessage());

            Avatar avatarImage = new Avatar("Svante");
            avatarImage.setImage("https://cdn.pixabay.com/photo/2018/08/28/13/29/avatar-3637561_960_720.png");

            Paragraph writtenBy = new Paragraph();
            //Span author = new Span(toDoPost.getAppUser().getUsername());
            //author.getStyle().set("font-weight", "italic");
            writtenBy.add(avatarImage);

            add(todoTitle, todoMessage, writtenBy, new Hr());

                });

    }
}
