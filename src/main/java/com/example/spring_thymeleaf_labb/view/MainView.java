package com.example.spring_thymeleaf_labb.view;

import com.example.spring_thymeleaf_labb.security.PrincipalUtil;
import com.vaadin.flow.component.UI;
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

        navbarLayout.add(new DrawerToggle(), new H1("What to do"));

        Button logInButton = new Button("Login" , evt -> UI.getCurrent().navigate(LoginView.class));
        Button logOutButton = new Button("LogOut" , evt -> PrincipalUtil.logout());
      //  navbarLayout.add(PrincipalUtil.IsAuthenticated() ? logInButton : logInButton);

       // navbarLayout.add(new DrawerToggle(), navbarTitle );

     /*   navbarLayout.add(new DrawerToggle(), new H1("Todo Posts"), logInButton);

        H1 navbarTitle = new H1("Todo Posts!");

        navbarTitle.addClassName("navbartitle");

      */



        if (PrincipalUtil.isLoggedIn()) { navbarLayout.add(logOutButton);}
        else { navbarLayout.add(logInButton);}


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
