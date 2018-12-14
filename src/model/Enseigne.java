package model;

public class Enseigne {

    public int idEnseignant;
    public int idCours;
    public int annee;
    public int heures;

    public Enseigne(){

    }

    public Enseigne(int idEnseignant, int idCours, int annee, int heures){
        this.idEnseignant = idEnseignant;
        this.idCours = idCours;
        this.annee = annee;
        this.heures = heures;
    }

    public int getIdEnseignant() {
        return idEnseignant;
    }

    public void setIdEnseignant(int idEnseignant) {
        this.idEnseignant = idEnseignant;
    }

    public int getIdCours() {
        return idCours;
    }

    public void setIdCours(int idCours) {
        this.idCours = idCours;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getHeures() {
        return heures;
    }

    public void setHeures(int heures) {
        this.heures = heures;
    }
}
