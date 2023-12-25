package com.example.assuranceexamen.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String pwd;
    private String fName;
    private String lName;
    @Enumerated(EnumType.STRING)
    private Role role;
    @ManyToMany(cascade = CascadeType.ALL)
    Set<Project>projects;
    @OneToMany
    @JsonIgnore
    Set<Project>projectSet;
}
