package com.clinic.service;

import com.clinic.domain.SpecializationDto;
import com.clinic.forms.Paths;
import org.springframework.web.client.RestTemplate;

import java.util.*;

public class SpecializationService {

    private final RestTemplate restTemplate = new RestTemplate();

    public void add(SpecializationDto specializationDto) {
        try {
            restTemplate.postForObject(Paths.Specialization.getName(), specializationDto, SpecializationDto.class);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public List<SpecializationDto> getAll() {
        SpecializationDto[] specializationDtos = restTemplate.getForObject(Paths.Specialization.getName(), SpecializationDto[].class);
        return Optional.ofNullable(specializationDtos).map(Arrays::asList).orElse(Collections.emptyList());
    }

    public SpecializationDto chooseSpecialization(String specializationName) {
        List<SpecializationDto> specializationDtos = getAll();
        Map<String, SpecializationDto> stringSpecializationDtoMap = new HashMap<>();
        specializationDtos.forEach(dto -> {
            stringSpecializationDtoMap.put(dto.getName(), dto);
        });
        return stringSpecializationDtoMap.get(specializationName);
    }
}
