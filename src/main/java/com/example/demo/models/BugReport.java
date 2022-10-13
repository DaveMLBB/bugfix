package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BugReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean fixAccepted = false;
    private String reportContent;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "bugReport")
    @JsonManagedReference
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "bugReport")
    @JsonManagedReference
    private List<Fixxx> fixxxes = new ArrayList<>();

    @Override
    public String toString() {
        return "BugReport{" +
                "id=" + id +
                ", fixAccepted=" + fixAccepted +
                ", reportContent='" + reportContent + '\'' +
                ", comments=" + comments +
                ", fixxxes=" + fixxxes +
                '}';
    }
}
