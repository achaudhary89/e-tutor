package com.alok.mytutorwebapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
public class Tutor extends BaseEntity {

    private String firstName;

    private String lastName;

    private String mobileNumber;

    private String email;


    @ManyToMany
    @JoinTable(name = "tuition_tutor", joinColumns = @JoinColumn(name = "tutor_id"), inverseJoinColumns = @JoinColumn(name = "tuition_id"))
    private Set<Tuition> tuitions =   new HashSet<>();

    public Tutor() {
    }

    public Tutor(String firstName, String lastName, String mobileNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Tuition> getTuitions() {
        return tuitions;
    }

    public void setTuitions(Set<Tuition> tuitions) {
        this.tuitions = tuitions;
    }


}
