package model;

public class Cours {

    public int id;
    public String libele;
    public String type;
    public String niveau;
    public int heures;

    public Cours() {

    }

    public Cours(int id, String libelle, String type, String niveau, int heures) {
        this.id = id;
        this.libele = libele;
        this.type = type;
        this.niveau = niveau;
        this.heures = heures;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibele() {
        return libele;
    }

    public void setLibele(String libele) {
        this.libele = libele;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public int getHeures() {
        return heures;
    }

    public void setHeures(int heures) {
        this.heures = heures;
    }
}
