package com.cgi.dentistapp.service;

import com.cgi.dentistapp.entities.DentistVisit;
import com.cgi.dentistapp.entities.Doctor;
import com.cgi.dentistapp.entities.repositories.DentistVisitRepository;
import com.cgi.dentistapp.entities.repositories.DoctorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class DentistVisitService {
    private final DoctorRepository doctorRepository;
    private final DentistVisitRepository dentistVisitRepository;

    public void addVisit(){
        Doctor doctor = doctorRepository.findById(1L).get();
        DentistVisit dentistVisit = new DentistVisit("Liina");
        dentistVisit.setDoctor(doctor);
        dentistVisitRepository.save(dentistVisit);
    }
}
