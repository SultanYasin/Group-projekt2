package com.example.spring_thymeleaf_labb.view;

import com.example.spring_thymeleaf_labb.components.ToDoForm;
import com.example.spring_thymeleaf_labb.entities.AppUser;
import com.example.spring_thymeleaf_labb.entities.ToDoPost;
import com.example.spring_thymeleaf_labb.repositories.AppUserRepository;
import com.example.spring_thymeleaf_labb.security.PrincipalUtil;
import com.example.spring_thymeleaf_labb.service.ToDoPostService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;

import javax.annotation.security.PermitAll;

@Route(value = "/manageposts", layout = MainView.class)
@PermitAll
public class ManagePostsView extends VerticalLayout {

    Grid<ToDoPost> grid = new Grid<>(ToDoPost.class, false);
    ToDoPostService toDoPostService;
    ToDoForm toDoForm;
    AppUserRepository appUserRepository;

    public ManagePostsView(ToDoPostService toDoPostService, AppUserRepository appUserRepository) {
        this.toDoPostService = toDoPostService;
        this.appUserRepository = appUserRepository;
        this.toDoForm = new ToDoForm(toDoPostService, this);
        setAlignItems(Alignment.CENTER);


        grid.setItems(toDoPostService.findPostByAuthor(PrincipalUtil.getPrincipalName()));
        grid.setWidthFull();
        grid.addComponentColumn(toDoPost -> {
            Button closeButton = new Button(new Icon(VaadinIcon.CLOSE_SMALL), e -> {
                Notification.show(toDoPost.getTitle());
                toDoPostService.deleteById(toDoPost.getId());
                updateItems();
            });

            closeButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_SMALL);
            closeButton.getElement().setAttribute("aria-label", "Close");

            return closeButton;
        });

        grid.addColumn(ToDoPost::getTitle).setHeader("Title");
        grid.addColumn(ToDoPost::getMessage).setHeader("Message");
      grid.addColumn(ToDoPost::getDoneBy ).setHeader("Done by");
        grid.asSingleSelect().addValueChangeListener(e -> {
           toDoForm.setToDoPost(e.getValue());
        });

        HorizontalLayout mainContent = new HorizontalLayout(grid, toDoForm);
        mainContent.setSizeFull();

        Button addButton = new Button("Add new Todo Post", e -> {
            Dialog dialog = new Dialog();
            ToDoForm dialogForm = new ToDoForm(toDoPostService, this);

            ToDoPost toDoPost = new ToDoPost();
            AppUser currentUser = appUserRepository.findByUsername(PrincipalUtil.getPrincipalName()).orElseThrow();

            toDoPost.setAppUser(currentUser);

            dialogForm.setToDoPost(toDoPost);

            dialog.add(dialogForm);
            dialog.open();
        });

        addButton.addThemeVariants(
                ButtonVariant.LUMO_LARGE,
                ButtonVariant.LUMO_PRIMARY
        );


        add(mainContent ,addButton );
    }

    public void updateItems() {
        grid.setItems(toDoPostService.findPostByAuthor(PrincipalUtil.getPrincipalName()));

    }



}
