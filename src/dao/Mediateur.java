package dao;

import model.Cours;
import model.Enseignant;
import model.Etudiant;

import java.util.ArrayList;
import java.util.List;

public class Mediateur {

    private XMLDAO xmldao = new XMLDAO();
    private ExcelDAO exceldao = new ExcelDAO();
    private SQLDAO sqldao = new SQLDAO();

    public Mediateur() {

    }

    // Le nombre d'heures par enseignants n'apparait que dans la source XML
    public int heureTotalEnseignant(Enseignant e){
        int heures=xmldao.heureTotalEnseignant(e);

        return heures;
    }


    public List<Enseignant> listEnseignants(){
        List<Enseignant> list = new ArrayList<Enseignant>();

        list.addAll(xmldao.listEnseignants());
        list.addAll(exceldao.listEnseignants());
        list.addAll(sqldao.listEnseignants());

        //Suppression des doublons
        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                if(list.get(i).getId()==list.get(j).getId()) list.remove(j);
            }
        }

        return list;
    }


    public List<Etudiant> listEtudiants() {
        List<Etudiant> list = new ArrayList<Etudiant>();

        list.addAll(xmldao.listEtudiants());
        list.addAll(exceldao.listEtudiants());
        list.addAll(sqldao.listEtudiants());

        //Suppression des doublons
        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                if(list.get(i).getId()==list.get(j).getId()) list.remove(j);
            }
        }

        return list;
    }

    public List<Cours> listCours() {
        List<Cours> list = new ArrayList<Cours>();

        list.addAll(xmldao.listCours());
        list.addAll(exceldao.listCours());
        list.addAll(sqldao.listCours());

        //Suppression des doublons
        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                if(list.get(i).getId()==list.get(j).getId()) list.remove(j);
            }
        }

        return list;
    }
}
