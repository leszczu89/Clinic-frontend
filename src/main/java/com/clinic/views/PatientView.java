package com.clinic.views;

import com.clinic.domain.DoctorDto;
import com.clinic.service.DoctorService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route("patient")
public class PatientView extends VerticalLayout {

    private MenuView menuView = new MenuView();
    private HorizontalLayout content = new HorizontalLayout();
    private final VerticalLayout sideBar = new VerticalLayout();
    private final VerticalLayout mainContent = new VerticalLayout();
    private final Label info = new Label("Welcome in the patient panel");
    private final Button findDoctor = new Button("Find doctor");
    private final Grid<DoctorDto> doctorDtoGrid = new Grid<>(DoctorDto.class);
    private final DoctorService doctorService = new DoctorService();


    public PatientView() {
        sideBar.add(findDoctor);
        content.add(mainContent, sideBar);
        add(menuView, content);

        findDoctor.addClickListener(event -> {
           cancelMainContent();
           fetchAllDoctors();
        });
    }

    protected void cancelMainContent() {
        mainContent.removeAll();
        mainContent.add(info);
    }

    private void fetchAllDoctors() {
        doctorDtoGrid.setItems(doctorService.getAll());
        mainContent.removeAll();
        mainContent.add(doctorDtoGrid);
    }
}
