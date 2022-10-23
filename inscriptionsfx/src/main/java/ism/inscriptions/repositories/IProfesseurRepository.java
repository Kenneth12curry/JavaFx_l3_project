package ism.inscriptions.repositories;

import java.util.List;

import ism.inscriptions.entities.Classe;
import ism.inscriptions.entities.Professeur;
import ism.inscriptions.entities.ProfesseurClasse;

public interface IProfesseurRepository {

    public List<Professeur> findAll();
    public Professeur insert(Professeur professeur);
    public Professeur findByNci(String  nci);
    public List<Classe> findByClasseProfesseur(String nci);
    

}
