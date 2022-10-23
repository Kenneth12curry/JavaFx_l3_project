package ism.inscriptions.services;

import java.util.ArrayList;
import java.util.List;

import ism.inscriptions.entities.Classe;
import ism.inscriptions.entities.Etudiant;
import ism.inscriptions.entities.Inscription;
import ism.inscriptions.entities.Professeur;
import ism.inscriptions.entities.ProfesseurClasse;
import ism.inscriptions.entities.User;
import ism.inscriptions.repositories.IClasseRepository;
import ism.inscriptions.repositories.IEtudiantRepository;
import ism.inscriptions.repositories.IInscriptionRepository;
import ism.inscriptions.repositories.IProfesseurClasseRepository;
import ism.inscriptions.repositories.IProfesseurRepository;
import ism.inscriptions.repositories.IUserRepository;
import ism.inscriptions.repositories.bd.ProfesseurClasseRepository;
import ism.inscriptions.repositories.bd.UserRepository;


public class Inscriptionservices implements IInscriptionservices{

    //Couplage faible => interface

    IClasseRepository classeRepository;
    IProfesseurRepository professeurRepository;
    IEtudiantRepository etudiantRepository;
    IInscriptionRepository inscriptionRepository;
    IProfesseurClasseRepository professeurclasseRepository;
    IUserRepository userRepository;
   
    //Constructeur

    public Inscriptionservices(IClasseRepository classeRepository,
    IProfesseurRepository  professeurRepository,
    IEtudiantRepository etudiantRepository,IInscriptionRepository inscriptionRepository,
    IProfesseurClasseRepository professeurclasseRepository, IUserRepository userRepository) {
        this.classeRepository = classeRepository;
        this.professeurRepository =  professeurRepository;
        this.etudiantRepository=etudiantRepository;
        this.inscriptionRepository=inscriptionRepository;
        this.professeurclasseRepository=professeurclasseRepository;
        this.userRepository=userRepository;
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

    @Override
    public Classe rechercherClasseByLibelle(String libelle) {
        return classeRepository.findByLibelle(libelle);
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

    @Override
    public List<Etudiant> listerEtudiantsClasse(String annee,String libelle) {
        return etudiantRepository.findByEtudiant(annee,libelle);
    }

    @Override
    public List<Etudiant> listerEtudiant() {
        // TODO Auto-generated method stub
        return etudiantRepository.findAll();
    }

   

    //Fonctionnalités liées aux inscriptions
    
    @Override
    public Inscription creerInscriptions(Inscription inscription){
        return inscriptionRepository.insert(inscription);
    }

    //Fonctionnalités liées à la connexion
    
    @Override
    public User seConnecter(String login, String password) {
        return userRepository.findUserByLoginAndPassword(login, password);
    }

      

   

    
}
