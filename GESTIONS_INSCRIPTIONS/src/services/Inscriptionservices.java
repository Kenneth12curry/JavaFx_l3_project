package services;

import java.util.ArrayList;
import java.util.List;

import entities.Classe;
import entities.Etudiant;
import entities.Inscription;
import entities.Professeur;
import entities.ProfesseurClasse;
import repositories.IClasseRepository;
import repositories.IEtudiantRepository;
import repositories.IInscriptionRepository;
import repositories.IProfesseurClasseRepository;
import repositories.IProfesseurRepository;
import repositories.bd.ProfesseurClasseRepository;
import repositories.liste.ClasseRepository;
import repositories.liste.EtudiantRepository;
import repositories.liste.InscriptionRepository;
import repositories.liste.ProfesseurRepository;

public class Inscriptionservices implements IInscriptionservices{

    //Couplage faible => interface

    IClasseRepository classeRepository;
    IProfesseurRepository professeurRepository;
    IEtudiantRepository etudiantRepository;
    IInscriptionRepository inscriptionRepository;
    IProfesseurClasseRepository professeurclasseRepository;
   
    //Constructeur

    public Inscriptionservices(IClasseRepository classeRepository,
    IProfesseurRepository  professeurRepository,
    IEtudiantRepository etudiantRepository,IInscriptionRepository inscriptionRepository,
    IProfesseurClasseRepository professeurclasseRepository) {
        this.classeRepository = classeRepository;
        this.professeurRepository =  professeurRepository;
        this.etudiantRepository=etudiantRepository;
        this.inscriptionRepository=inscriptionRepository;
        this.professeurclasseRepository=professeurclasseRepository;
    }

    //Fonctionnalités liées aux classes

    @Override
    public Classe creerClasse(Classe classe){
        return classeRepository.insert(classe);
    }

    @Override
    public List<Classe> listerClasse(){
        return classeRepository.findAll();
    }

    @Override
    public Classe rechercherClasse(int id){
        return classeRepository.findById(id);
    }
   


     //Fonctionnalités liées aux professeurs

    @Override
    public List<Professeur> listerProfesseur(){
        return professeurRepository.findAll();
    }

    @Override
    public Professeur creerProfesseur(Professeur professeur){
        return professeurRepository.insert(professeur);
    }

    @Override
    public Professeur rechercherProfesseur(String nci){
        return professeurRepository.findByNci(nci);
    }

    @Override
    public List<Classe> listerClasseProfesseur(String nci){
        return professeurRepository.findByClasseProfesseur(nci);
    }

    @Override
    public ProfesseurClasse affecterClasseProfesseur(ProfesseurClasse professeurclasse) {
        return professeurclasseRepository.insertClasseprof(professeurclasse);
    }


    //Fonctionnalités liées aux étudiants


    @Override
    public Etudiant creerEtudiant(Etudiant etudiant){
        return etudiantRepository.insert(etudiant);
    }

    @Override
    public Etudiant rechercherEtudiant(String matricule){
        return etudiantRepository.finByMatricule(matricule);
    }

    @Override
    public List<Etudiant> listerEtudiantsAnnee(String annee) {
        return etudiantRepository.findByEtudiants(annee);
    }

   

    //Fonctionnalités liées aux inscriptions
    
    @Override
    public Inscription creerInscriptions(Inscription inscription){
        return inscriptionRepository.insert(inscription);
    }

   
    
   

   
  

    
}
