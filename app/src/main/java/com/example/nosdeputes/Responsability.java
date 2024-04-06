package com.example.nosdeputes;

import java.io.Serializable;

public class Responsability implements Serializable {

    private String organisme, fonction, debut_fonction;


    public Responsability(String organisme, String fonction, String debut_fonction) {
        this.organisme = organisme;
        this.fonction = fonction;
        this.debut_fonction = debut_fonction;
    }

    public String getOrganisme() {
        return organisme;
    }

    public void setOrganisme(String organisme) {
        this.organisme = organisme;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getDebut_fonction() {
        return debut_fonction;
    }

    public void setDebut_fonction(String debut_fonction) {
        this.debut_fonction = debut_fonction;
    }
}
