package entities;

import java.util.List;

public class Classe{
    
    private int id;
    private String filiere;
    private String libelle;
    private static int nbre;
    //attributs navigationnelles
    private List<Professeur> professeur;

   
   

    //Constructeur
    public Classe() {
        nbre++;
        id=nbre;
    }

    //Surchage du Constructeur
    public Classe(String filiere,String libelle) {
        this.filiere = filiere;
        this.libelle = libelle;
        nbre++;
        id=nbre;
    }

    public Classe(int id, String filiere, String libelle) {
        this.id = id;
        this.filiere = filiere;
        this.libelle = libelle;
    }
   

    public int getId() {
        return id;
    }
    public void setId(int id) {
       
    }
    public String getFiliere() {
        return filiere;
    }
    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }
   
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
     
    public List<Professeur> getProfesseur() {
        return professeur;
    }

    public void setProfesseur(List<Professeur> professeur) {
        this.professeur = professeur;
    }

   

    @Override
    public String toString() {
        return "Classe [id=" + id + ", filiere=" + filiere +  ", libelle=" + libelle +"]";
    }
    

}