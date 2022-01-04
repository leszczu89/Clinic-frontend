package com.clinic.service;

import com.clinic.domain.PatientDto;
import com.clinic.forms.Paths;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class PatientService {

    private final RestTemplate restTemplate = new RestTemplate();

    public void add(PatientDto patientDto) {
        restTemplate.postForObject(Paths.Patient.getName(), patientDto, PatientDto.class);
    }

    public List<PatientDto> getAll() {
        PatientDto[] patientDtos = restTemplate.getForObject(Paths.Patient.getName(), PatientDto[].class);
        return Optional.ofNullable(patientDtos).map(Arrays::asList).orElse(Collections.emptyList());
    }
}
