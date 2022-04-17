package com.example.spring_thymeleaf_labb.components;

import com.example.spring_thymeleaf_labb.entities.ToDoPost;
import com.example.spring_thymeleaf_labb.service.ToDoPostService;
import com.example.spring_thymeleaf_labb.view.ManagePostsView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;

public class ToDoForm extends FormLayout {

    TextField title = new TextField("Title");
    TextArea message = new TextArea("Message");
    Button saveButton = new Button("Save");

    DatePicker doneBy = new DatePicker("Done by "); //***///

    Binder<ToDoPost> binder = new BeanValidationBinder<>(ToDoPost.class);
    ToDoPostService toDoPostService;
    ManagePostsView managePostsView;

    public ToDoForm(ToDoPostService toDoPostService, ManagePostsView managePostsView) {

        this.managePostsView = managePostsView;
        this.toDoPostService = toDoPostService;
        binder.bindInstanceFields(this);
        setVisible(false);

        saveButton.addClickListener(e -> handleSave());

        add(title, message,doneBy, saveButton);

    }

    private void handleSave() {
        ToDoPost toDoPost = binder.validate().getBinder().getBean();
        if (toDoPost.getId() == 0){
            toDoPostService.save(toDoPost);
        } else {
            toDoPostService.updateById(toDoPost.getId(), toDoPost);
        }

        setToDoPost(null);
        managePostsView.updateItems();

        this.getParent().ifPresent(component -> {
            if (component instanceof Dialog) {
                ((Dialog) component).close();
            }
        });
    }

    public void setToDoPost(ToDoPost toDoPost) {
        if (toDoPost != null) {
            binder.setBean(toDoPost);
            setVisible(true);
        } else {
            setVisible(false);
        }
    }



}
