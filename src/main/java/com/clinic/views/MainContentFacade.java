package com.clinic.views;

import com.vaadin.flow.component.Component;

public class MainContentFacade {

    public Component createContent(ViewType viewType) {
        Component component = returnView(viewType);
        return component;
    }

    public Component returnView(ViewType viewType) {

        return viewType.getView();
    }
}
