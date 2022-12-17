package com.cgi.dentistapp.service;

import com.cgi.dentistapp.dto.DentistVisitDTO;
import com.cgi.dentistapp.entities.DentistVisit;
import com.cgi.dentistapp.entities.Doctor;
import com.cgi.dentistapp.entities.Patient;
import com.cgi.dentistapp.entities.repositories.DentistVisitRepository;
import com.cgi.dentistapp.entities.repositories.DoctorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
@Transactional
@RequiredArgsConstructor
public class DentistVisitService {
    private final DoctorRepository doctorRepository;
    private final DentistVisitRepository dentistVisitRepository;

    public void addVisit(DentistVisitDTO dentistVisitDTO){
        LocalDate date = dentistVisitDTO.getDate();
        LocalTime startTime = dentistVisitDTO.getStartTime();
        LocalTime endTime = dentistVisitDTO.getEndTime();
        Doctor doctor = dentistVisitDTO.getDoctor();
        Patient patient = dentistVisitDTO.getPatient();

        LocalDateTime startDateTime = LocalDateTime.of(date, startTime);
        LocalDateTime endDateTime = LocalDateTime.of(date, endTime);

        DentistVisit dentistVisit = new DentistVisit(startDateTime, endDateTime, patient, doctor);

        dentistVisitRepository.save(dentistVisit);

    }
}
