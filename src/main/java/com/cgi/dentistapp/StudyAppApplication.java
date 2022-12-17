package com.cgi.dentistapp;

import com.cgi.dentistapp.entities.DentistVisit;
import com.cgi.dentistapp.entities.Doctor;
import com.cgi.dentistapp.entities.Patient;
import com.cgi.dentistapp.entities.repositories.DentistVisitRepository;
import com.cgi.dentistapp.entities.repositories.DoctorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class StudyAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(DentistVisitRepository dentistVisitRepository, DoctorRepository doctorRepository){
		return args -> {
			dentistVisitRepository.saveAll(List.of(
					new DentistVisit(LocalDateTime.now(),LocalDateTime.now(),new Patient("Liina"), new Doctor("Karl Aru")),
					new DentistVisit(LocalDateTime.now(),LocalDateTime.now(),new Patient("Kalle"), new Doctor("Max Black"))));

			doctorRepository.save(new Doctor("King Kong"));
		};
	}
}
