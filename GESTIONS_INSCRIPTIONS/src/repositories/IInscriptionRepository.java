package repositories;

import java.util.List;

import entities.Etudiant;
import entities.Inscription;
import entities.ProfesseurClasse;

public interface IInscriptionRepository {

    public List<Inscription> findAll();
    public Inscription insert(Inscription inscription);
    public Inscription findById(int id);
   

}
