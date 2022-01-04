package com.clinic.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class MenuView extends HorizontalLayout {

    private Button contact;
    private Button homePage;
    private Button login;

    public MenuView() {
        contact = new Button("Contact");
        homePage = new Button("Home Page");
        login = new Button("Login");

        homePage.addClickListener(event -> getUI().ifPresent(ui -> ui.navigate(MainView.class)));

        add(homePage, contact, login);
    }


}
