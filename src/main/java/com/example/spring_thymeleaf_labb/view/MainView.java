package com.example.spring_thymeleaf_labb.view;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

@CssImport("./styles/styles.css")
public class MainView extends AppLayout {

    public MainView() {

        HorizontalLayout navbarLayout = new HorizontalLayout();
        H1 navbarTitle = new H1("Todo Posts!");
        navbarTitle.addClassName("navbartitle");


        navbarLayout.add(new DrawerToggle(), navbarTitle);


        navbarLayout.setWidthFull();
        navbarLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);
        navbarLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        navbarLayout.setMargin(true);

        addToNavbar(navbarLayout);

        RouterLink toDoViewLink = new RouterLink("ToDo Posts", ToDoView.class);
        VerticalLayout sideDrawerContent = new VerticalLayout(toDoViewLink);

        RouterLink manageTodoPostLink = new RouterLink("Manage ToDo Posts", ManagePostsView.class);
        VerticalLayout sideDrawerContent1 = new VerticalLayout(manageTodoPostLink);

        addToDrawer(sideDrawerContent1, sideDrawerContent);
    }
}
