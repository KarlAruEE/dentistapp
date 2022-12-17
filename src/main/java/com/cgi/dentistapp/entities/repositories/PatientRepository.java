package com.cgi.dentistapp.entities.repositories;

import com.cgi.dentistapp.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
