package ism.inscriptions.entities;

import java.util.List;
import java.util.UUID;

import ism.inscriptions.core.Fabrique;

public class Etudiant extends User {

    private String matricule;
    private String tuteur;
   
   
    

    //attributs navaigationnels
    private List<Inscription> inscriptions;
    private Classe classe;

    //Constructeur

   
   

    public Etudiant(String login, String password, String nomComplet, String matricule, String tuteur) {
        super(login, password, nomComplet);
        this.matricule = matricule;
        this.tuteur = tuteur;
        role=Role.ETUDIANT;
    }

    public Etudiant(int id, String login, String password, String nomComplet, Role role, String matricule,
    String tuteur) {
        super(id, login, password, nomComplet, role);
        this.matricule = matricule;
        this.tuteur = tuteur;
        role=Role.ETUDIANT;
    }

    public Etudiant(String login, String password, String nomComplet, String matricule, String tuteur, Classe classe) {
        super(login, password, nomComplet);
        this.matricule = matricule;
        this.tuteur = tuteur;
        this.classe = classe;
        role=Role.ETUDIANT;
       
    }

    public Etudiant(String login, String password, String nomComplet, String tuteur) {
        super(login, password, nomComplet);
        this.tuteur = tuteur;
        role=Role.ETUDIANT;
        matricule="ETUDIANT_"+Fabrique.getService().listerEtudiant().stream().count()+1;
    
    }

   

  


    public String getMatricule() {
        return matricule;
    }
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
    public String getTuteur() {
        return tuteur;
    }
    public void setTuteur(String tuteur) {
        this.tuteur = tuteur;
    }
    
    //getters and setters

    public List<Inscription> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(List<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    @Override
    public String toString() {
        return "Etudiant "+super.toString()+" ,matricule=" + matricule + ", tuteur=" + tuteur + "]";
    }
}
