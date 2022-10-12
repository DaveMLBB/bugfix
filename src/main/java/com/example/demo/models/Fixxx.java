package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fixxx {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ideaFix;

    private Boolean accepted = false;

    private Integer goFix = Integer.parseInt("0");
    @ManyToOne
    @JoinColumn(name = "BugId",referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private BugReport bugReport= new BugReport();

}
