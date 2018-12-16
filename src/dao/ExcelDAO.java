package dao;

import model.Cours;
import model.Enseignant;
import model.Etudiant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExcelDAO {

    String filepath = "resources\\Source1.xls";

    public ExcelDAO(){

    }

    public static int heureTotalEnseignant(Enseignant e) {
        int heures = 0;

        return heures;
    }

    public List<Enseignant> listEnseignants() {
        List<Enseignant> listEns = new ArrayList<Enseignant>();

        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String myDB = "jdbc:odbc:Driver={Microsoft Excel Driver (*.xls, *.xlsx, *.xlsm, *.xlsb)};DBQ="+ filepath +";" + "DriverID=22;READONLY=false";

            Connection con = DriverManager.getConnection(myDB, "", "");
            Statement stmt = con.createStatement();

            // On merge les deux table 2006 et 2007 avec le mot clé UNION
            ResultSet rs = stmt.executeQuery("select distinct ID, Nom, Prenom from [2006$] where Statut='enseignant' UNION select distinct ID, Nom, Prenom from [2007$] where Statut='enseignant' ");

            while (rs.next()) {
                int id = rs.getInt(1);
                String nom = rs.getString(2);
                String prenom = rs.getString(3);

                Enseignant ens = new Enseignant(id,nom,prenom,"");
                listEns.add(ens);
            }

            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return listEns;
    }

    public List<Etudiant> listEtudiants() {
        List<Etudiant> listEt = new ArrayList<Etudiant>();

        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String myDB = "jdbc:odbc:Driver={Microsoft Excel Driver (*.xls, *.xlsx, *.xlsm, *.xlsb)};DBQ="+ filepath +";" + "DriverID=22;READONLY=false";

            Connection con = DriverManager.getConnection(myDB, "", "");
            Statement stmt = con.createStatement();

            // On merge les deux table 2006 et 2007 avec le mot clé UNION
            ResultSet rs = stmt.executeQuery("select ID, Nom, Prenom, Provenance, FormationPrecedente, NiveauInsertion from [2006$] where Statut='etudiant' UNION select distinct ID, Nom, Prenom, Provenance, FormationPrecedente, NiveauInsertion from [2007$] where Statut='etudiant' ");

            while (rs.next()) {
                int id = rs.getInt(1);
                String nom = rs.getString(2);
                String prenom = rs.getString(3);
                String provenance = rs.getString(4);
                String formationPrecedente = rs.getString(5);
                String niveauInsertion = rs.getString(6);

                Etudiant et = new Etudiant(id,nom,prenom,provenance,formationPrecedente,"",0,0,niveauInsertion);

                listEt.add(et);
            }

            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return listEt;
    }

    public List<Cours> listCours() {
        List<Cours> listCours = new ArrayList<Cours>();

        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String myDB = "jdbc:odbc:Driver={Microsoft Excel Driver (*.xls, *.xlsx, *.xlsm, *.xlsb)};DBQ="+ filepath +";" + "DriverID=22;READONLY=false";

            Connection con = DriverManager.getConnection(myDB, "", "");
            Statement stmt = con.createStatement();

            // On merge les deux table 2006 et 2007 avec le mot clé UNION
            ResultSet rs = stmt.executeQuery("select distinct ID_Cours, Libelle_Cours, Type_Cours, Niveau_Cours from [2006$]  UNION select distinct ID_Cours, Libelle_Cours, Type_Cours, Niveau_Cours from [2007$]  ");

            while (rs.next()) {
                int id = rs.getInt(1);
                String libele = rs.getString(2);
                String type = rs.getString(3);
                String niveau = rs.getString(4);

                Cours c = new Cours(id,libele,type,niveau,0);

                listCours.add(c);
            }

            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return listCours;
    }
}
