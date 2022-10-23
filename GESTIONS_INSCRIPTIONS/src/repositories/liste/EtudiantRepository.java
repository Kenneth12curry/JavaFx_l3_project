package repositories.liste;

import java.util.ArrayList;
import java.util.List;

import entities.Etudiant;
import repositories.IEtudiantRepository;

public class EtudiantRepository implements IEtudiantRepository{

    List<Etudiant> etudiants=new ArrayList<>();

    @Override
    public  List<Etudiant> findAll(){
        return etudiants;
    }

    @Override
    public Etudiant insert(Etudiant etudiant){
        etudiants.add(etudiant);
        return etudiant;
    }

    @Override
    public Etudiant finByMatricule(String matricule){
        //Stream
        return etudiants
        .stream()
        .filter(a->a.getMatricule().compareTo(matricule)==0)
        .findFirst()
        .orElse(null);
        
    }

    @Override
    public List<Etudiant> findByEtudiants(String annee) {
        // TODO Auto-generated method stub
        return null;
    }

   
}
