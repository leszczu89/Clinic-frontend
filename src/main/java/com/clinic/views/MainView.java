package com.clinic.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {

    private MenuView menuView = new MenuView();
    private HorizontalLayout content = new HorizontalLayout();
    private final MainContentFacade mainContentFacade = new MainContentFacade();

    public MainView() {
        content.add(createContent(ViewType.Home));
        add(menuView, content);
    }

    public MainView(ViewType viewType) {
        content.add(createContent(viewType));
        add(menuView, content);
    }

    private Component createContent(ViewType viewType) {
        return mainContentFacade.createContent(viewType);
    }





}
