package com.cgi.dentistapp.controller;

import com.cgi.dentistapp.entities.DentistVisit;
import com.cgi.dentistapp.entities.Doctor;
import com.cgi.dentistapp.entities.repositories.DentistVisitRepository;
import com.cgi.dentistapp.entities.repositories.DoctorRepository;
import com.cgi.dentistapp.service.DentistVisitService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Data
@RequestMapping("/")
public class DentistAppController {

    private final DentistVisitRepository dentistVisitRepository;
    private final DoctorRepository doctorRepository;
    private final DentistVisitService dentistVisitService;

    @GetMapping(produces = "application/json")
    public Iterable<DentistVisit> getDentistVisits(){
        return dentistVisitRepository.findAll();
    }

    @GetMapping(path = "/docs",produces = "application/json")
    public Iterable<Doctor> getDoctors(){
        return doctorRepository.findAll();
    }

    @GetMapping("/add")
    public void addAppointment(){
        dentistVisitService.addVisit();
    }
}
