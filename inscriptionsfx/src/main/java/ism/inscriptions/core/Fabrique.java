package ism.inscriptions.core;
import ism.inscriptions.repositories.IClasseRepository;
import ism.inscriptions.repositories.IEtudiantRepository;
import ism.inscriptions.repositories.IInscriptionRepository;
import ism.inscriptions.repositories.IProfesseurClasseRepository;
import ism.inscriptions.repositories.IProfesseurRepository;
import ism.inscriptions.repositories.IUserRepository;
import ism.inscriptions.repositories.bd.ClasseRepository;
import ism.inscriptions.repositories.bd.EtudiantRepository;
import ism.inscriptions.repositories.bd.InscriptionRepository;
import ism.inscriptions.repositories.bd.ProfesseurClasseRepository;
import ism.inscriptions.repositories.bd.ProfesseurRepository;
import ism.inscriptions.repositories.bd.UserRepository;
import ism.inscriptions.services.IInscriptionservices;
import ism.inscriptions.services.Inscriptionservices;

public class Fabrique {
    
    public static IInscriptionservices getService(){
        //couplage faible
        IClasseRepository classeRepository=new ClasseRepository();
        IProfesseurRepository professeurRepository=new ProfesseurRepository();
        IEtudiantRepository etudiantRepository=new EtudiantRepository();
        IInscriptionRepository inscriptionRepository=new InscriptionRepository();
        IProfesseurClasseRepository professeurclasseRepository=new ProfesseurClasseRepository();
        IUserRepository userRepository=new UserRepository();
        
        return new Inscriptionservices(classeRepository,professeurRepository,etudiantRepository,inscriptionRepository,professeurclasseRepository,userRepository);


    }
    
}
