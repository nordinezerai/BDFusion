package model;

public class Inscription {

    public int idEtudiant;
    public int idCours;
    public int annee;
    public double note;

    public Inscription(){

    }

    public Inscription(int idEtudiant, int idCours, int annee, double note){
        this.idEtudiant = idEtudiant;
        this.idCours = idCours;
        this.annee = annee;
        this.note = note;
    }

    public int getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(int idEtudiant) {
        this.idEtudiant = idEtudiant;
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

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }
}
