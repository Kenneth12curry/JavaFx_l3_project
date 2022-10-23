package ism.inscriptions.entities;

public class ProfesseurClasse {

    private String anneeAffectation;
    
    //attributs navigationnels
    private Classe classe;
    private Professeur professeur;


    public ProfesseurClasse(Classe classe, Professeur professeur) {
        this.classe = classe;
        this.professeur = professeur;
    }
    
    public String getAnneeAffectation() {
        return anneeAffectation;
    }
    public void setAnneeAffectation(String anneeAffectation) {
        this.anneeAffectation = anneeAffectation;
    }
    
    public Classe getClasse() {
        return classe;
    }
    public void setClasse(Classe classe) {
        this.classe = classe;
    }
    public Professeur getProfesseur() {
        return professeur;
    }
    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }
}
