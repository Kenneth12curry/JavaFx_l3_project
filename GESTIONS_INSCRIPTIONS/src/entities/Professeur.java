package entities;

import java.util.ArrayList;
import java.util.List;

public class Professeur extends User {

    private String nci;
    private String grade;


    //attributs navigationnelles
    private List<Classe> classes=new ArrayList<>();;
    
    //Surchage du Constructeur
    
    

    public Professeur(String login, String password, String nomComplet, String nci, String grade) {
        super(login, password, nomComplet);
        this.nci = nci;
        this.grade = grade;
        role=Role.PROFESSEUR;
    }

    public Professeur(int id, String login, String password, String nomComplet, Role role, String nci, String grade) {
        super(id, login, password, nomComplet, role);
        this.nci = nci;
        this.grade = grade;
        role=Role.PROFESSEUR;
    }

    public String getNci() {
        return nci;
    }
    public void setNci(String nci) {
        this.nci = nci;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }


    public List<Classe> getClasses() {
        return classes;
    }

    public void setClasses(List<Classe> classes) {
        this.classes = classes;
    }

    public void addClasse(Classe classe){
        classes.add(classe);

    }


    @Override
    public String toString() {
        return "Professeur " +super.toString()+ " ,grade=" + grade + ", nci=" + nci + "]";
    }

}
