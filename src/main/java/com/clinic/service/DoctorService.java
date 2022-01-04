package com.clinic.service;

import com.clinic.domain.DoctorDto;
import com.clinic.forms.Paths;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class DoctorService {
    private final RestTemplate restTemplate = new RestTemplate();

    public void add(DoctorDto doctorDto) {
        restTemplate.postForObject(Paths.Doctor.getName(), doctorDto, DoctorDto.class);
    }

    public List<DoctorDto> getAll() {
        DoctorDto[] doctorDtos = restTemplate.getForObject(Paths.Doctor.getName(), DoctorDto[].class);
        return Optional.ofNullable(doctorDtos).map(Arrays::asList).orElse(Collections.emptyList());
    }
}
