package ism.inscriptions.repositories;

import java.util.List;

import ism.inscriptions.entities.Etudiant;
import ism.inscriptions.entities.Inscription;
import ism.inscriptions.entities.ProfesseurClasse;

public interface IInscriptionRepository {

    public List<Inscription> findAll();
    public Inscription insert(Inscription inscription);
    public Inscription findById(int id);
   

}
