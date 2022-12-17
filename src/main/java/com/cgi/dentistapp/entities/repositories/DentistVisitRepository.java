package com.cgi.dentistapp.entities.repositories;

import com.cgi.dentistapp.entities.DentistVisit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistVisitRepository extends JpaRepository<DentistVisit, Long> {
}
