package com.cgi.dentistapp.service;

import com.cgi.dentistapp.dto.PatientDTO;
import com.cgi.dentistapp.entities.Patient;
import com.cgi.dentistapp.entities.repositories.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    public void addVisit(PatientDTO patientDTO){

        Patient patient = new Patient(patientDTO.getName(), patientDTO.getEmail());

        patientRepository.save(patient);

    }
}
