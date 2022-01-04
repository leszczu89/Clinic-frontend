package com.clinic.views;

import com.clinic.forms.DoctorForm;
import com.clinic.forms.SpecializationForm;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("admin")
public class AdminView extends VerticalLayout {

    private final Button addDoctor = new Button("New doctor");
    private final Button addSpecialization = new Button("New specialization");
    private final Button addAppointment = new Button("New appointment");
    private final HorizontalLayout content = new HorizontalLayout();
    private final VerticalLayout mainContent = new VerticalLayout();
    private final VerticalLayout sideBar = new VerticalLayout();
    private final Label info = new Label("Welcome in the admin panel.");

    public AdminView() {
        addSpecialization.addClickListener(event -> addSpecialization());
        addDoctor.addClickListener(event -> addDoctor());

        sideBar.add(addSpecialization, addDoctor, addAppointment);
        mainContent.add(info);
        content.add(mainContent, sideBar);
        add(new MenuView(), content);
    }

    private void addSpecialization() {
        SpecializationForm specializationForm = new SpecializationForm(this);
        mainContent.add(specializationForm);
    }

    private void addDoctor() {
        DoctorForm doctorForm = new DoctorForm(this);
        mainContent.add(doctorForm);
    }

    public void cancelMainContent() {
        mainContent.removeAll();
        mainContent.add(info);
    }

    public VerticalLayout getMainContent() {
        return mainContent;
    }
}
