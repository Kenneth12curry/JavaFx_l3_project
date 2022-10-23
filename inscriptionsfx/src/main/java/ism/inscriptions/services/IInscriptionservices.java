package ism.inscriptions.services;

import java.util.List;

import ism.inscriptions.entities.Classe;
import ism.inscriptions.entities.Etudiant;
import ism.inscriptions.entities.Inscription;
import ism.inscriptions.entities.Professeur;
import ism.inscriptions.entities.ProfesseurClasse;
import ism.inscriptions.entities.User;

public interface IInscriptionservices {
    
    public Classe creerClasse(Classe classe);

    public List<Classe> listerClasse();
      
    public Classe rechercherClasse(int id);

    public Classe rechercherClasseByLibelle(String libelle);
   
    public List<Professeur> listerProfesseur();

    public Professeur creerProfesseur(Professeur professeur);

    public Professeur rechercherProfesseur(String nci);

    public List<Classe> listerClasseProfesseur(String nci);
   
    public Etudiant creerEtudiant(Etudiant etudiant);

    public Etudiant rechercherEtudiant(String matricule);

    public Inscription creerInscriptions(Inscription inscription);

    public ProfesseurClasse affecterClasseProfesseur(ProfesseurClasse professeurclasse);

    public List<Etudiant> listerEtudiantsAnnee(String annee);

    public List<Etudiant> listerEtudiantsClasse(String annee,String libelle);

    public List<Etudiant> listerEtudiant();

    public User seConnecter(String login,String password);

}
