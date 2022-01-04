package com.clinic.forms;

import com.clinic.domain.SpecializationDto;
import com.clinic.service.SpecializationService;
import com.clinic.views.AdminView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;

public class SpecializationForm extends FormLayout {

    private final TextField name = new TextField("Specialization name");
    private Button save = new Button("Save");
    private Button cancel = new Button("Cancel");
    private final SpecializationService service = new SpecializationService();
    private final AdminView parentLayout;

    public SpecializationForm(AdminView adminView) {
        parentLayout = adminView;
        cancel();
        parentLayout.getMainContent().add(name, save, cancel);

        save.addClickListener(event -> save());
        cancel.addClickListener(event -> cancel());
    }

    private void save() {
        SpecializationDto specializationToSave = new SpecializationDto();
        specializationToSave.setName(name.getValue());

        try {
            service.add(specializationToSave);
        } finally {
            cancel();
        }
    }

    private void cancel() {
        parentLayout.cancelMainContent();
    }
}
