package com.cgi.dentistapp.controller;

import com.cgi.dentistapp.dto.DentistVisitDTO;
import com.cgi.dentistapp.dto.DoctorDTO;
import com.cgi.dentistapp.dto.PatientDTO;
import com.cgi.dentistapp.entities.repositories.DentistVisitRepository;
import com.cgi.dentistapp.entities.repositories.DoctorRepository;
import com.cgi.dentistapp.entities.repositories.PatientRepository;
import com.cgi.dentistapp.service.DentistVisitService;
import com.cgi.dentistapp.service.DoctorService;
import com.cgi.dentistapp.service.PatientService;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Data
public class DentistAppController{

    private final DentistVisitService dentistVisitService;
    private final PatientService patientService;
    private final DoctorService doctorService;
    private final DentistVisitRepository dentistVisitRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @GetMapping("/")
    public String getDentistVisits(final Model model){
        model.addAttribute("dentistVisitDTO", new DentistVisitDTO());
        model.addAttribute("doctors", doctorRepository.findAll());
        model.addAttribute("patients", patientRepository.findAll());
        model.addAttribute("dentistVisits", dentistVisitRepository.findAll());
        model.addAttribute("module", "registrations");
        return "home";
    }

    @PostMapping("/")
    public String setDentistVisits(@Valid DentistVisitDTO dentistVisitDTO, BindingResult bindingResult, Model model){
        model.addAttribute("doctors", doctorRepository.findAll());
        model.addAttribute("patients", patientRepository.findAll());
        model.addAttribute("dentistVisits", dentistVisitRepository.findAll());
        model.addAttribute("module", "registrations");
        if (bindingResult.hasErrors()){
            return "home";
        }
        dentistVisitService.addVisit(dentistVisitDTO);
        return "redirect:/";
    }

    @GetMapping("/patient")
    public String getPatients(final Model model){
        model.addAttribute("patientDTO", new PatientDTO());
        model.addAttribute("patients", patientRepository.findAll());
        model.addAttribute("module", "patients");
        return "patients";
    }

    @PostMapping("/patient")
    public String setPatient(@Valid PatientDTO patientDTO, BindingResult bindingResult, Model model){
        model.addAttribute("patients", patientRepository.findAll());
        model.addAttribute("module", "patients");
        if (bindingResult.hasErrors()){
            return "patients";
        }
        patientService.addVisit(patientDTO);
        return "redirect:/patient";
    }

    @GetMapping("/doctor")
    public String getDoctors(final Model model){
        model.addAttribute("doctorDTO", new DoctorDTO());
        model.addAttribute("doctors", doctorRepository.findAll());
        model.addAttribute("module", "doctors");
        return "doctors";
    }

    @PostMapping("/doctor")
    public String setDoctor(@Valid DoctorDTO doctorDTO, BindingResult bindingResult, Model model){
        model.addAttribute("doctors", patientRepository.findAll());
        model.addAttribute("module", "doctors");
        if (bindingResult.hasErrors()){
            return "doctors";
        }
        doctorService.addVisit(doctorDTO);
        return "redirect:/doctor";
    }

}
