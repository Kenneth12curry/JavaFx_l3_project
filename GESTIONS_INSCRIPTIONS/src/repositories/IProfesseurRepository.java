package repositories;

import java.util.List;

import entities.Classe;
import entities.Professeur;
import entities.ProfesseurClasse;

public interface IProfesseurRepository {

    public List<Professeur> findAll();
    public Professeur insert(Professeur professeur);
    public Professeur findByNci(String  nci);
    public List<Classe> findByClasseProfesseur(String nci);
    

}
