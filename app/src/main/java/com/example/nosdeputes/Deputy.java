package com.example.nosdeputes;

import androidx.annotation.Nullable;

import java.io.Serializable;
import java.util.ArrayList;

public class Deputy implements Serializable {
    private int id;
    private String firstname;
    private String lastname;
    private String department;
    private int numCirco;
    private String nameCirco;
    private String sexe;

    private ArrayList<Responsability> responsabilities;

    public Deputy(int id, String firstname, String lastname, String department, int numCirco, String nameCirco, String sexe) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.department = department;
        this.numCirco = numCirco;
        this.nameCirco = nameCirco;
        this.sexe = sexe;
        this.responsabilities = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getNumCirco() {
        return numCirco;
    }

    public void setNumCirco(int numCirco) {
        this.numCirco = numCirco;
    }

    public String getNameCirco() {
        return nameCirco;
    }

    public void setNameCirco(String nameCirco) {
        this.nameCirco = nameCirco;
    }

    public String getNameForAvatar() {
        return this.firstname.replace(' ', '-').toLowerCase() + '-' + lastname.replace(' ', '-').toLowerCase();
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public ArrayList<Responsability> getResponsabilities() {
        return responsabilities;
    }

    public void setResponsabilities(ArrayList<Responsability> responsabilities) {
        this.responsabilities = responsabilities;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        Deputy d = (Deputy) obj;
        return id == d.getId();
    }
}
