package dao;

import model.Enseignant;

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
            ResultSet rs = stmt.executeQuery("select ID, Nom, Prenom from [2006$]");

            while (rs.next()) {
                int id = rs.getInt(1);
                String nom = rs.getString(2);
                String prenom = rs.getString(3);

                System.out.println(id + " " + nom + " " + prenom);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return listEns;
    }
}
