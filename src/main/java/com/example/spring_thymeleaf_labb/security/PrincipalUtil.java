package com.example.spring_thymeleaf_labb.security;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.server.VaadinServletRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

public class PrincipalUtil {

  /*  public static boolean IsAuthenticated(){
        return !SecurityContextHolder.getContext()
                .getAuthentication().getName().equalsIgnoreCase("anonymousUser");
    }


    public static String getPrincipalName(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    public static boolean isLoggedIn(){
      return   !SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName()
                .equalsIgnoreCase("anonymousUser");
    }


    public static void logout(){
        UI.getCurrent().navigate("/"); // kommer till huvud sidan
        new SecurityContextLogoutHandler()
                .logout(VaadinServletRequest.getCurrent().getHttpServletRequest(), null , null );
    }
*/

    public static String getPrincipalName(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    public static boolean isLoggedIn(){
        return !SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName().equalsIgnoreCase("anonymousUser");
    }

    public static void logout(){
        new SecurityContextLogoutHandler()
                .logout(VaadinServletRequest.getCurrent().getHttpServletRequest(), null, null);
    }


}
