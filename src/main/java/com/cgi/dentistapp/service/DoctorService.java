package com.cgi.dentistapp.service;

import com.cgi.dentistapp.dto.DoctorDTO;
import com.cgi.dentistapp.dto.PatientDTO;
import com.cgi.dentistapp.entities.Doctor;
import com.cgi.dentistapp.entities.Patient;
import com.cgi.dentistapp.entities.repositories.DoctorRepository;
import com.cgi.dentistapp.entities.repositories.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;
    public void addVisit(DoctorDTO doctorDTO){

        Doctor doctor = new Doctor(doctorDTO.getName(), doctorDTO.getEmail());

        doctorRepository.save(doctor);

    }
}
