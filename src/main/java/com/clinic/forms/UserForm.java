package com.clinic.forms;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;

public class UserForm extends FormLayout {

    private final TextField name = new TextField("Name");
    private final TextField surname = new TextField("Surname");
    private final EmailField email = new EmailField();
    private final Button save = new Button("Save");
    private final Button cancel = new Button("Cancel");

    public UserForm() {
        add(name, surname, email);
        add(save, cancel);
    }
}
