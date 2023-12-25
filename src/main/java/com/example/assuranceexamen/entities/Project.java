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
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Project  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String description;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    Set<Sprint> sprints = new HashSet<>();

    @ManyToMany(mappedBy = "projects")
    @JsonIgnore
    Set<User> users = new HashSet<>();

    @Override
    public String toString() {
        return "Project{" +
                "title='" + title + '\'' +
                '}';
    }
}

