package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BugReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reportContent;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "bugReport")
    @JsonManagedReference
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "bugReport")
    @JsonManagedReference
    private List<Fixxx> fixxxes = new ArrayList<>();

}
