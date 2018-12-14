package dao;

import model.Enseignant;

import java.util.ArrayList;
import java.util.List;

public class Mediateur {

    XMLDAO xmldao = new XMLDAO();
    ExcelDAO exceldao = new ExcelDAO();

    public Mediateur() {

    }

    public int heureTotalEnseignant(Enseignant e){
        int heures=xmldao.heureTotalEnseignant(e);
        //heures = heures + exceldao.heureTotalEnseignant(e);
        return heures;
    }


    public List<Enseignant> listEnseignants(){
        List<Enseignant> list = new ArrayList<Enseignant>();

        list.addAll(xmldao.listEnseignants());
        //list.addAll(exceldao.listEnseignants());
        return list;
    }

}
