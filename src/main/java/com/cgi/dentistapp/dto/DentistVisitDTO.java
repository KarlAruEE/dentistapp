package com.cgi.dentistapp.dto;

import com.cgi.dentistapp.entities.Doctor;
import com.cgi.dentistapp.entities.Patient;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class DentistVisitDTO {

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate date;

    @NotNull
    @DateTimeFormat(pattern = "hh:mm")
    LocalTime startTime;

    @NotNull
    @DateTimeFormat(pattern = "hh:mm")
    LocalTime endTime;
    @NotNull
    Doctor doctor;

    @NotNull
    Patient patient;

}
