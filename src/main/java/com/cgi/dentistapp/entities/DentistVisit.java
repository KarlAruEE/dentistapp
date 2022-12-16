package com.cgi.dentistapp.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


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
    private LocalDateTime time;

    @NotBlank
    private String patient;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="doctor_id", referencedColumnName = "id")
    private Doctor doctor;

    public DentistVisit(LocalDateTime time, String patient, Doctor doctor) {
        this(null, time, patient, doctor);
    }

    public DentistVisit(String patient) {
        this(null, LocalDateTime.now(), patient,null);
    }
}
