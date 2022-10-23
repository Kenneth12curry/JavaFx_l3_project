package repositories;

import java.util.List;
import entities.Etudiant;

public interface IEtudiantRepository {

    public List<Etudiant> findAll();
    public Etudiant insert(Etudiant etudiant);
    public Etudiant finByMatricule(String matricule);
    public List<Etudiant> findByEtudiants(String annee);
}
