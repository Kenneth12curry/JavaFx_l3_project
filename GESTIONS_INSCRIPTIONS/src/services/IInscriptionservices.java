package services;

import java.util.List;

import entities.Classe;
import entities.Etudiant;
import entities.Inscription;
import entities.Professeur;
import entities.ProfesseurClasse;

public interface IInscriptionservices {
    
    public Classe creerClasse(Classe classe);

    public List<Classe> listerClasse();
      
    public Classe rechercherClasse(int id);
   
    public List<Professeur> listerProfesseur();

    public Professeur creerProfesseur(Professeur professeur);

    public Professeur rechercherProfesseur(String nci);

    public List<Classe> listerClasseProfesseur(String nci);
   
    public Etudiant creerEtudiant(Etudiant etudiant);

    public Etudiant rechercherEtudiant(String matricule);

    public Inscription creerInscriptions(Inscription inscription);

    public ProfesseurClasse affecterClasseProfesseur(ProfesseurClasse professeurclasse);

    public List<Etudiant> listerEtudiantsAnnee(String annee);

}
