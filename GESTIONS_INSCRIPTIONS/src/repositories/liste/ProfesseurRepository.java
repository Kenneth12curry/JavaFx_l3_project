package repositories.liste;

import java.util.ArrayList;
import java.util.List;

import entities.Classe;
import entities.Professeur;
import repositories.IProfesseurRepository;
import entities.ProfesseurClasse;


public class ProfesseurRepository implements IProfesseurRepository{

    List<Professeur> professeurs=new ArrayList<>();

    //Création des trois méthodes principales
    @Override
    public  List<Professeur>  findAll(){
        return professeurs;
    };

    @Override
    public  Professeur insert(Professeur professeur){
       professeurs.add(professeur);
        return professeur;
    };

    @Override
    public Professeur findByNci(String nci){
        //Stream
        return professeurs
        .stream()
        .filter(l->l.getNci().compareTo(nci)==0)
        .findFirst()
        .orElse(null);
    }
    
    @Override
    public List<Classe> findByClasseProfesseur(String nci){
        for (Professeur professeur:professeurs){
            if(professeur.getNci()==nci){
                return professeur.getClasses();

            }
        }
        return null;
    }

    
   

}
