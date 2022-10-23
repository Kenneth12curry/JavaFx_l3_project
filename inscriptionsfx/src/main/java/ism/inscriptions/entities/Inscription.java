package ism.inscriptions.entities;

public class Inscription {

    private int id;
    private String anneeInsc;
    private String nomEtudiant;
    private String dateInsc;
    private String filiereEtudiant;
    private  static int nbre;

     //attributs navaigationnels
     private Etudiant etudiant;
   
     
    //Constructeur
   
    public Inscription() {
        nbre++;
        id=nbre;
    }

    public Inscription(String anneeInsc, String dateInsc, String filiereEtudiant) {
        this.anneeInsc = anneeInsc;
        this.dateInsc = dateInsc;
        this.filiereEtudiant = filiereEtudiant;
    }


    //Surchage du Constructeur

    public Inscription(String anneeInsc, String nomEtudiant) {
        this.anneeInsc = anneeInsc;
        this.nomEtudiant = nomEtudiant;
    }

    public Inscription(int id,String anneeInsc, String nomEtudiant) {
        this.id = id;
        this.anneeInsc = anneeInsc;
        this.nomEtudiant = nomEtudiant;
    }

    public Inscription(String anneeInsc, String nomEtudiant, String dateInsc, String filiereEtudiant) {
        this.anneeInsc = anneeInsc;
        this.nomEtudiant = nomEtudiant;
        this.dateInsc = dateInsc;
        this.filiereEtudiant = filiereEtudiant;
    }

    
    
 

    public int getId() {
        return id;
    }
    public void setId(int id) {
        
    }
  
    
    public String getAnneeInsc() {
        return anneeInsc;
    }
    public void setAnneeInsc(String anneeInsc) {
        this.anneeInsc = anneeInsc;
    }
    public String getNomEtudiant() {
        return nomEtudiant;
    }
    public void setMatriculeEtudiant(String nomEtudiant) {
        this.nomEtudiant = nomEtudiant;
    }
    
    //getters and setters
    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public void setNomEtudiant(String nomEtudiant) {
        this.nomEtudiant = nomEtudiant;
    }

    public String getDateInsc() {
        return dateInsc;
    }

    public void setDateInsc(String dateInsc) {
        this.dateInsc = dateInsc;
    }

    public String getFiliereEtudiant() {
        return filiereEtudiant;
    }

    public void setFiliereEtudiant(String filiereEtudiant) {
        this.filiereEtudiant = filiereEtudiant;
    }

    public static int getNbre() {
        return nbre;
    }

    public static void setNbre(int nbre) {
        Inscription.nbre = nbre;
    }
}
