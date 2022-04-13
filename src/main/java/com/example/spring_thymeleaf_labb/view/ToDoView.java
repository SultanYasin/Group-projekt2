package com.example.spring_thymeleaf_labb.view;

import com.example.spring_thymeleaf_labb.service.ToDoPostService;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "/", layout = MainView.class)
public class ToDoView extends VerticalLayout {

    public ToDoView(ToDoPostService toDoPostService) {

        add(new H2("All ToDo Posts"));

        setAlignItems(Alignment.CENTER);

        toDoPostService.findAll(null).forEach(toDoPost -> {

            H1 todoTitle = new H1(toDoPost.getTitle());
            Paragraph todoMessage = new Paragraph(toDoPost.getMessage());

            Paragraph writtenBy = new Paragraph("Author: ");
            Span author = new Span(toDoPost.getAppUser().getUsername());
            author.getStyle().set("font-weight", "italic");
            writtenBy.add(author);

            add(todoTitle, todoMessage, writtenBy, new Hr());

                });

    }
}
