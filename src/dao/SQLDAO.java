package dao;

import model.Enseignant;

import java.sql.*;
import java.util.ArrayList;
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
}
