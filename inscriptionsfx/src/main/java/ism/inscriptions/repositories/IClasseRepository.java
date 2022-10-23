package ism.inscriptions.repositories;

import java.util.List;

import ism.inscriptions.entities.Classe;

public interface IClasseRepository {

    public List<Classe> findAll();
    public Classe insert(Classe classe);
    public Classe findById(int id);
    public Classe findByLibelle(String libelle);
   
}
