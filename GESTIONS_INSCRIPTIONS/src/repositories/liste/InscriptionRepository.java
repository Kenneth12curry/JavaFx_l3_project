package repositories.liste;

import java.lang.reflect.AnnotatedArrayType;
import java.util.ArrayList;
import java.util.List;

import entities.Etudiant;
import entities.Inscription;
import repositories.IInscriptionRepository;

public class InscriptionRepository implements IInscriptionRepository{
    
    List<Inscription> inscriptions=new ArrayList<>();

    @Override
    public  List<Inscription> findAll(){
        return inscriptions;
    }

    @Override
    public Inscription insert(Inscription inscription){
        inscriptions.add(inscription);
        return inscription;
    }

    @Override
    public Inscription findById(int id){
        return inscriptions
        .stream()
        .filter(a->a.getId()==id)
        .findFirst()
        .orElse(null);
    }

   
}
