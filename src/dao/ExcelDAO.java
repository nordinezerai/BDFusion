package dao;

import model.Enseignant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExcelDAO {

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
            String myDB = "jdbc:odbc:Driver={Microsoft Excel Driver (*.xls)};DBQ=resources/Source1.xls;" + "DriverID=22;READONLY=false";

            Connection con = DriverManager.getConnection(myDB, "", "");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return listEns;
    }
}
