package entities;

public class Inscription {

    private int id;
    private String nomEtudiant;
    private String anneeInsc;
    private String matriculeEtudiant;
    private  static int nbre;

     //attributs navaigationnels
     private Etudiant etudiant;
    
     
    //Constructeur

   

   
  

   
   

    public Inscription() {
        nbre++;
        id=nbre;
    }

    //Surchage du Constructeur

    public Inscription(String nomEtudiant, String anneeInsc, String matriculeEtudiant) {
        this.nomEtudiant = nomEtudiant;
        this.anneeInsc = anneeInsc;
        this.matriculeEtudiant = matriculeEtudiant;
    }

    public Inscription(int id, String nomEtudiant, String anneeInsc, String matriculeEtudiant) {
        this.id = id;
        this.nomEtudiant = nomEtudiant;
        this.anneeInsc = anneeInsc;
        this.matriculeEtudiant = matriculeEtudiant;
    }

   
    public Inscription(String nomEtudiant, String anneeInsc) {
        this.nomEtudiant = nomEtudiant;
        this.anneeInsc = anneeInsc;
    }



    public int getId() {
        return id;
    }
    public void setId(int id) {
        
    }
    public String getNomEtudiant() {
        return nomEtudiant;
    }
    public void setNomEtudiant(String nomEtudiant) {
        this.nomEtudiant = nomEtudiant;
    }
    public String getAnneeInsc() {
        return anneeInsc;
    }
    public void setAnneeInsc(String anneeInsc) {
        this.anneeInsc = anneeInsc;
    }
    public String getMatriculeEtudiant() {
        return matriculeEtudiant;
    }
    public void setMatriculeEtudiant(String matriculeEtudiant) {
        this.matriculeEtudiant = matriculeEtudiant;
    }
    
    //getters and setters
    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }
}
