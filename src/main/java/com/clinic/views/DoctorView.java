package com.clinic.views;

import com.clinic.domain.AppointmentDto;
import com.clinic.domain.PatientDto;
import com.clinic.service.PatientService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route("doctor")
public class DoctorView extends VerticalLayout {

    private MenuView menuView = new MenuView();
    private HorizontalLayout content = new HorizontalLayout();
    private final VerticalLayout sideBar = new VerticalLayout();
    private final VerticalLayout mainContent = new VerticalLayout();
    private final Button findPatient = new Button("Find patient");
    private final Button findAppointment = new Button("Find appointment");
    private final Grid<PatientDto> patients = new Grid<>(PatientDto.class);
    private final Grid<AppointmentDto> appointments = new Grid<>(AppointmentDto.class);
    private final Label info = new Label("Welcome in the doctor panel");
    private final PatientService patientService = new PatientService();

    public DoctorView() {
        sideBar.add(findPatient, findAppointment);
        content.add(mainContent, sideBar);
        add(menuView, content);

        findPatient.addClickListener(event -> {
            cancelMainContent();
            displayAllPatients();
        });
    }


    private void displayAllPatients() {
        List<PatientDto> patientDtos = patientService.getAll();
        patients.setItems(patientDtos);
        cancelMainContent();
        mainContent.add(patients);
    }

    protected void cancelMainContent() {
        mainContent.removeAll();
        mainContent.add(info);
    }

    public VerticalLayout getMainContent() {
        return mainContent;
    }
}
