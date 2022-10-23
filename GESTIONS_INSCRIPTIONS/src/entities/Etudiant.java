package entities;

import java.util.List;

public class Etudiant extends User {

    private String matricule;
    private String tuteur;
    

    //attributs navaigationnels
    private List<Inscription> inscriptions;

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

    @Override
    public String toString() {
        return "Etudiant "+super.toString()+" ,matricule=" + matricule + ", tuteur=" + tuteur + "]";
    }
}
