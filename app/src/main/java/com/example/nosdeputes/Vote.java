package com.example.nosdeputes;

import java.io.Serializable;
import java.util.ArrayList;

public class Vote implements Serializable {

    private ArrayList<Vote> votes;
    private int numero;
    private String date, titre, type, sort, nombres_votant, nombre_pours, nombre_contres, nombre_abstentions, parlementaire_groupe_acronyme;

    public Vote(int numero, String date, String titre, String type, String sort, String nombres_votant, String nombre_pours, String nombre_contres, String nombre_abstentions, String parlementaire_groupe_acronyme) {
        this.numero = numero;
        this.date = date;
        this.titre = titre;
        this.type = type;
        this.sort = sort;
        this.nombres_votant = nombres_votant;
        this.nombre_pours = nombre_pours;
        this.nombre_contres = nombre_contres;
        this.nombre_abstentions = nombre_abstentions;
        this.parlementaire_groupe_acronyme = parlementaire_groupe_acronyme;
        this.votes = new ArrayList<>();
    }

    public ArrayList<Vote> getVotes() {
        return votes;
    }

    public void setVotes(ArrayList<Vote> votes) {
        this.votes = votes;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getNombres_votant() {
        return nombres_votant;
    }

    public void setNombres_votant(String nombres_votant) {
        this.nombres_votant = nombres_votant;
    }

    public String getNombre_pours() {
        return nombre_pours;
    }

    public void setNombre_pours(String nombre_pours) {
        this.nombre_pours = nombre_pours;
    }

    public String getNombre_contres() {
        return nombre_contres;
    }

    public void setNombre_contres(String nombre_contres) {
        this.nombre_contres = nombre_contres;
    }

    public String getNombre_abstentions() {
        return nombre_abstentions;
    }

    public void setNombre_abstentions(String nombre_abstentions) {
        this.nombre_abstentions = nombre_abstentions;
    }

    public String getParlementaire_groupe_acronyme() {
        return parlementaire_groupe_acronyme;
    }

    public void setParlementaire_groupe_acronyme(String parlementaire_groupe_acronyme) {
        this.parlementaire_groupe_acronyme = parlementaire_groupe_acronyme;
    }
}
