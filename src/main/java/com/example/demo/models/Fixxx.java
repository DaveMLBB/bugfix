package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
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


    @Override
    public String toString() {
        return "Fixxx{" +
                "id=" + id +
                ", ideaFix='" + ideaFix + '\'' +
                ", accepted=" + accepted +
                ", goFix=" + goFix +
                '}';
    }
}
