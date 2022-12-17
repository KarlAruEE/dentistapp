package com.cgi.dentistapp.controller;

import com.cgi.dentistapp.dto.DentistVisitDTO;
import com.cgi.dentistapp.entities.Doctor;
import com.cgi.dentistapp.entities.repositories.DentistVisitRepository;
import com.cgi.dentistapp.entities.repositories.DoctorRepository;
import com.cgi.dentistapp.entities.repositories.PatientRepository;
import com.cgi.dentistapp.service.DentistVisitService;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.Date;

@Controller
@RequiredArgsConstructor
@Data
public class DentistAppController{

    private final DentistVisitRepository dentistVisitRepository;
    private final DoctorRepository doctorRepository;
    private final DentistVisitService dentistVisitService;

    private final PatientRepository patientRepository;

    @GetMapping("/")
    public String getDentistVisits(final Model model){
        //model.addAttribute("doctors", doctorRepository.findAll());
        model.addAttribute("dentistVisitDTO", new DentistVisitDTO());
        model.addAttribute("doctors", doctorRepository.findAll());
        model.addAttribute("patients", patientRepository.findAll());
        model.addAttribute("module", "registrations");
        return "home";
    }

    @PostMapping("/")
    public String setDentistVisits(@Valid DentistVisitDTO dentistVisitDTO, BindingResult bindingResult, Model model){
        model.addAttribute("doctors", doctorRepository.findAll());
        model.addAttribute("patients", patientRepository.findAll());
        if (bindingResult.hasErrors()){
            return "home";
        }
        dentistVisitService.addVisit(dentistVisitDTO);
        return "success";
    }

    @GetMapping(path = "/docs",produces = "application/json")
    public Iterable<Doctor> getDoctors(){
        return doctorRepository.findAll();
    }

}
