package ism.inscriptions.repositories;

import java.util.List;
import ism.inscriptions.entities.Etudiant;

public interface IEtudiantRepository {

    public List<Etudiant> findAll();
    public Etudiant insert(Etudiant etudiant);
    public Etudiant finByMatricule(String matricule);
    public List<Etudiant> findByEtudiants(String annee);
    public List<Etudiant> findByEtudiant(String annee,String libelle);

}
