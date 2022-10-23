package repositories.liste;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import entities.Classe;
import repositories.IClasseRepository;

public class ClasseRepository implements IClasseRepository{
    
    List <Classe> classes=new ArrayList<>();

    @Override
    public List <Classe> findAll(){
        return classes;
    }

    @Override
    public  Classe insert(Classe classe){
        classes.add(classe);
        return classe;
    };

    @Override
    public  Classe findById(int id){
        //Stream
        return classes
        .stream()
        .filter(a->a.getId()==id)
        .findFirst()
        .orElse(null);
    };

   


}
