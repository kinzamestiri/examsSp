package com.example.assuranceexamen.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Rdv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRDV;
    private LocalDate dateRDV;
    private String remarque;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    Medcin medcin;
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    Patient patient;


}
