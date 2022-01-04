package com.clinic.service;

import com.clinic.domain.AppointmentDto;
import com.clinic.forms.Paths;
import org.springframework.web.client.RestTemplate;

public class AppointmentService {

    private final RestTemplate restTemplate = new RestTemplate();

    public void add(AppointmentDto appointmentDto) {
        restTemplate.postForObject(Paths.Appointment.getName(), appointmentDto, AppointmentDto.class);
    }

}
