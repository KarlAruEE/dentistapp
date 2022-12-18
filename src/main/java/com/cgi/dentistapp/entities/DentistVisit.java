package com.cgi.dentistapp.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "dentist_visit")
public class DentistVisit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private LocalDateTime startTime;

    @NotNull
    private LocalDateTime endTime;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="patient_id", referencedColumnName = "id")
    private Patient patient;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="doctor_id", referencedColumnName = "id")
    private Doctor doctor;

    public DentistVisit(LocalDateTime startTime, LocalDateTime endTime, Patient patient, Doctor doctor) {
        this(null, startTime, endTime, patient, doctor);
    }

    public LocalDate getDate(){
        return this.startTime.toLocalDate();
    }
}
