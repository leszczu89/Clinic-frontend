package com.clinic.forms;

import com.clinic.domain.DoctorDto;
import com.clinic.domain.SpecializationDto;
import com.clinic.service.DoctorService;
import com.clinic.service.SpecializationService;
import com.clinic.views.AdminView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;

public class DoctorForm extends FormLayout {

    private final TextField name = new TextField("Name");
    private final TextField surname = new TextField("Surname");
    private final EmailField email = new EmailField("Email");
    private final Button save = new Button("Save");
    private final Button cancel = new Button("Cancel");
    private final ComboBox<String> specializationDtoComboBox = new ComboBox<>("Specialization");
    private final AdminView parentLayout;
    private final DoctorService doctorService = new DoctorService();
    private final SpecializationService specializationService = new SpecializationService();

    public DoctorForm(AdminView adminView) {
        parentLayout = adminView;
        cancel();
        parentLayout.getMainContent().add(name, surname, email, specializationDtoComboBox, save, cancel);

        specializationDtoComboBox.setItems(specializationService.getAll().stream().map(SpecializationDto::getName));

        save.addClickListener(event -> save());

    }
    private void save() {
        DoctorDto doctorToSave = new DoctorDto();
        doctorToSave.setName(name.getValue());
        doctorToSave.setSurname(surname.getValue());
        doctorToSave.setEmail(email.getValue());
        doctorToSave.setSpecializationDto(specializationService.chooseSpecialization(specializationDtoComboBox.getValue()));

        try {
            doctorService.add(doctorToSave);
        } finally {
            cancel();
        }
    }

    private void cancel() {
        parentLayout.cancelMainContent();
    }
}
