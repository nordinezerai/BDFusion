import dao.Mediateur;
import model.Enseignant;
import model.Etudiant;

import java.util.List;

public class Main {
    public static void main(String[] args) {
       Mediateur mediateur = new Mediateur();


       System.out.println("1. Nombres d'heures par enseignants") ;

       //Récupération de tout les enseignants toutes sources confondues
       List<Enseignant> listEns = mediateur.listEnseignants();

       //Affichage des informations de tout les enseignants ainsi que le nombres total d'heures de cours assurées
       for(int i = 0 ; i < listEns.size() ; i++){

           System.out.println("Id : " +listEns.get(i).getId());
           System.out.println("Nom " +listEns.get(i).getNom());
           System.out.println("Prénom : " +listEns.get(i).getPrenom());
           System.out.println("Nombres d'heures total : " + mediateur.heureTotalEnseignant(listEns.get(i)));
       }

        System.out.println("=====================================================") ;
        System.out.println("2. Nombres d'etudiants dont le pays de provenance est la France") ;

        // Récupération de tout les étudiants toutes sources confondues
        List<Etudiant> listEt = mediateur.listEtudiants();

        int nb = 0;
        for(int i = 0 ; i < listEt.size() ; i++){
            if(listEt.get(i).getProvenance().equalsIgnoreCase("France")
                    || listEt.get(i).getProvenance().equalsIgnoreCase("Fr") ) nb++;
        }

        System.out.println("Total : " + nb);
    }
}
