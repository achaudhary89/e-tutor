package com.alok.mytutorwebapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Tuition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String tuitionSubject;

    String mode;

    String location;

    @ManyToMany(mappedBy = "tuitions")
    Set<Tutor> tutors    =   new HashSet<>();

    public Tuition(){

    }

    public Tuition(String tuitionSubject, String mode, String location) {
        this.tuitionSubject = tuitionSubject;
        this.mode = mode;
        this.location = location;
    }

    public Tuition(String tuitionSubject, String mode, String location, Set<Tutor> tutorSet) {
        this.tuitionSubject = tuitionSubject;
        this.mode = mode;
        this.location = location;
        this.tutors = tutorSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTuitionSubject() {
        return tuitionSubject;
    }

    public void setTuitionSubject(String tuitionSubject) {
        this.tuitionSubject = tuitionSubject;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<Tutor> getTutorSet() {
        return tutors;
    }

    public void setTutorSet(Set<Tutor> tutorSet) {
        this.tutors = tutorSet;
    }
}
