package com.cgi.dentistapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String name;

    private String email;

    @OneToMany(mappedBy = "doctor")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Set<DentistVisit> dentistVisit;


    public Doctor(Long id, String name, String email) {
        this(id, name,email, null);
    }

    public Doctor(String name, String email) {
        this(null, name, email);
    }
}
