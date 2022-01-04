package com.clinic.forms;

public enum Paths {
    Patient("http://localhost:8081/v1/patient"),
    Doctor("http://localhost:8081/v1/doctor"),
    Specialization("http://localhost:8081/v1/specialization"),
    Rating("http://localhost:8081/v1/rating"),
    Appointment("http://localhost:8081/v1/appointment");

    private final String name;

    Paths(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
