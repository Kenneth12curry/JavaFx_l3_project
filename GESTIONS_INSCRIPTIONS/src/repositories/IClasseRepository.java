package repositories;

import java.util.List;

import entities.Classe;

public interface IClasseRepository {

    public List<Classe> findAll();
    public Classe insert(Classe classe);
    public Classe findById(int id);
   
}
