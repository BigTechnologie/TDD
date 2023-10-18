package fr.dawan.formationtdd.beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Personne implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private long id;
    
    private String prenom;
    
    private String nom;

    private LocalDate dateNaissance;

    public Personne() {
    }

    public Personne(String prenom, String nom, LocalDate dateNaissance) {
        this.prenom = prenom;
        this.nom = nom;
        this.dateNaissance = dateNaissance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Personne other = (Personne) obj;
        return id == other.id;
    }

    @Override
    public String toString() {
        return "Personne [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", dateNaissance=" + dateNaissance + "]";
    }
    
}
