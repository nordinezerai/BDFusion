package dao;

import model.Cours;
import model.Enseignant;
import model.Etudiant;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SQLDAO {

    String url = "jdbc:mysql://localhost:3306/source2";

    public SQLDAO(){

    }

    public List<Enseignant> listEnseignants() {
        List<Enseignant> listEns = new ArrayList<Enseignant>();

        try {
            Class.forName( "com.mysql.jdbc.Driver" );
            Connection connexion = null;
            Statement statement = null;
            ResultSet resultat = null;
            connexion = DriverManager.getConnection( url, "root", "" );
            statement = connexion.createStatement();
            resultat = statement.executeQuery( "SELECT ID_ens, nom, prenom FROM enseignant;" );

            while ( resultat.next() ) {
                int id = resultat.getInt( "ID_ens" );
                String nom = resultat.getString( "nom" );
                String prenom = resultat.getString( "prenom" );

                Enseignant ens = new Enseignant(id,nom,prenom,"");
                listEns.add(ens);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listEns;
    }

    public List<Etudiant> listEtudiants() {
        List<Etudiant> listEt = new ArrayList<Etudiant>();

        try {
            Class.forName( "com.mysql.jdbc.Driver" );
            Connection connexion = null;
            Statement statement = null;
            ResultSet resultat = null;
            connexion = DriverManager.getConnection( url, "root", "" );
            statement = connexion.createStatement();
            resultat = statement.executeQuery( "SELECT ID_etudiant, nom, prenom, provenance, Formation_precedente, Pays_Formation_precedente, Annee_debut, dateNaissance, Niveau_inscription FROM etudiant;" );

            while ( resultat.next() ) {
                int id = resultat.getInt( "ID_etudiant" );
                String nom = resultat.getString( "nom" );
                String prenom = resultat.getString( "prenom" );
                String provenance = resultat.getString( "provenance" );
                String formationPrecedente = resultat.getString( "Formation_precedente" );
                String paysFormationPrecedente = resultat.getString( "Pays_Formation_precedente" );
                String anneeDebut = resultat.getString( "Annee_debut" );
                String dateNaissance = resultat.getString( "dateNaissance" );
                String niveauInscription = resultat.getString( "Niveau_inscription" );

                // On souhaite l'age alors qu'on a la date de naissance
                int age = getAge(new SimpleDateFormat("yyyy-mm-dd").parse(dateNaissance),new Date());

                Etudiant et = new Etudiant(id,nom,prenom,provenance,formationPrecedente,paysFormationPrecedente,Integer.parseInt(anneeDebut),age,niveauInscription);

                listEt.add(et);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return listEt;
    }

    public List<Cours> listCours() {
        List<Cours> listCours = new ArrayList<Cours>();

        try {
            Class.forName( "com.mysql.jdbc.Driver" );
            Connection connexion = null;
            Statement statement = null;
            ResultSet resultat = null;
            connexion = DriverManager.getConnection( url, "root", "" );
            statement = connexion.createStatement();
            resultat = statement.executeQuery( "SELECT NumCours, libele, type, niveau FROM cours;" );

            while ( resultat.next() ) {
                int id = resultat.getInt( "NumCours" );
                String libele = resultat.getString( "libele" );
                String type = resultat.getString( "type" );
                String niveau = resultat.getString( "niveau" );

                Cours c = new Cours(id,libele,type,niveau,0);
                listCours.add(c);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listCours;
    }

    public int getAge(java.util.Date birthDate, Date currentDate){
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        int d1 = Integer.parseInt(formatter.format(birthDate));
        int d2 = Integer.parseInt(formatter.format(currentDate));
        int age = (d2 - d1) / 10000;
        return age;
    }
}
