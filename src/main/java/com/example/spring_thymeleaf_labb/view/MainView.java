package com.example.spring_thymeleaf_labb.view;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;

public class MainView extends AppLayout {

    public MainView() {

        HorizontalLayout navbarLayout = new HorizontalLayout();

        navbarLayout.add(new DrawerToggle(), new H1("WHAT TODO????"));

        navbarLayout.setWidthFull();
        navbarLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);
        navbarLayout.setAlignItems(FlexComponent.Alignment.CENTER);

        addToNavbar(navbarLayout);

        RouterLink toDoViewLink = new RouterLink("ToDoPosts", ToDoView.class);
        VerticalLayout sideDrawerContent = new VerticalLayout(toDoViewLink);

        RouterLink manageTodoPostLink = new RouterLink("Manage ToDo Posts", ManagePostsView.class);
        addToDrawer(manageTodoPostLink);
    }
}
