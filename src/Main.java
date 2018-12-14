import dao.Mediateur;
import dao.XMLDAO;
import model.Enseignant;

import java.util.List;

public class Main {
    public static void main(String[] args) {
       Mediateur mediateur = new Mediateur();

       // Nombres d'heures par enseignants
       List<Enseignant> listEns = mediateur.listEnseignants();

       for(int i = 0 ; i < listEns.size() ; i++){

           System.out.println("Id : " +listEns.get(i).getId());
           System.out.println("Nom " +listEns.get(i).getNom());
           System.out.println("Prénom : " +listEns.get(i).getPrenom());
           System.out.println("Nombres d'heures total : " + mediateur.heureTotalEnseignant(listEns.get(i)));

       }
    }
}
