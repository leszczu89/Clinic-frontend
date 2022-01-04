package com.clinic.views;

import com.vaadin.flow.component.Component;

public enum ViewType {

    Home(new HomeView()), Admin(new AdminView());

    private final Component view;

    ViewType(Component view) {
        this.view = view;
    }

    public Component getView() {
        return this.view;
    }
}
