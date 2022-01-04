package com.clinic.views;

import com.clinic.domain.SpecializationDto;
import com.clinic.forms.Paths;
import com.clinic.service.SpecializationService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class HomeView extends HorizontalLayout {

    private static final String welcomeNote = "Welcome in ours Clinic Page. You can check ours specialist below";
    private final Label welcome = new Label(welcomeNote);
    private final Button specialists = new Button("Show all available specialists");
    private Grid<SpecializationDto> grid;
    private final VerticalLayout sideBar = new VerticalLayout();
    private final VerticalLayout mainContent = new VerticalLayout();
    private final Button admin = new Button("Admin");
    private final Button doctor = new Button("Doctor");
    private final Button patient = new Button("Patient");
    private final SpecializationService service = new SpecializationService();

    public HomeView() {
        specialists.addClickListener(event -> displaySpecializations());

        cancelMainContent();
        add(mainContent, prepareSideBar());
    }

    private VerticalLayout prepareSideBar() {
        sideBar.add(admin, doctor, patient);
        admin.addClickListener(event -> {
            cancelMainContent();
            getUI().ifPresent(ui -> ui.navigate(AdminView.class));
        });
        doctor.addClickListener(event -> {
            cancelMainContent();
            getUI().ifPresent(ui -> ui.navigate(DoctorView.class));
        });
        patient.addClickListener(event -> {
            cancelMainContent();
            getUI().ifPresent(ui -> ui.navigate(PatientView.class));
        });
        return sideBar;
    }

    private void displaySpecializations() {
        grid = new Grid<>(SpecializationDto.class);
        grid.setItems(fetchSpecializations());
        mainContent.add(grid);
    }

    private List<SpecializationDto> fetchSpecializations() {
        return service.getAll();
    }

    protected void cancelMainContent() {
        mainContent.removeAll();
        mainContent.add(welcome, specialists);
    }
}
