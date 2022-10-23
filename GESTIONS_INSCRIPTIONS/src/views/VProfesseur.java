package views;

import java.util.List;
import java.util.Scanner;

import entities.Classe;
import entities.Professeur;
import entities.ProfesseurClasse;
import services.IInscriptionservices;
import services.Inscriptionservices;

public class VProfesseur {
    /**
     * @param inscriptionservices
     */
    public static void menu(IInscriptionservices inscriptionservices){

        Scanner clavier=new Scanner(System.in);
        Professeur professeur;
        int choix;
        do{
            System.out.println("1-Créer professeur");
            System.out.println("2-Lister professeur");
            System.out.println("3-Affecter classe aux professeurs");
            System.out.println("4-Lister les classes d'un professeur");
            System.out.println("5-Quitter");
            System.out.println("Faites votre choix ?");
            choix=clavier.nextInt();
            clavier.nextLine();
            switch(choix){

                case 1:
                    System.out.println("Saisir le nom et le prénom du professeur");
                    String nomComplet=clavier.nextLine();
                    System.out.println("Saisir le login du professeur");
                    String login=clavier.nextLine();
                    System.out.println("Saisir le password du professeur");
                    String password=clavier.nextLine();
                    System.out.println("Saisir le numéro de la carte d'identité du professeur");
                    String nci=clavier.nextLine();
                    System.out.println("Saisir le grade du professeur");
                    String grade=clavier.nextLine();
                    professeur=new Professeur(login, password, nomComplet, nci, grade);
                    inscriptionservices.creerProfesseur(professeur);
                    break;
                
                case 2:
                    inscriptionservices.listerProfesseur().forEach(System.out::println);
                    break;
                
                case 3:
                    String nci1="";
                    String id="";
                    do{
                       
                        if(nci1.compareTo("")==0){
                            System.out.println("Saisir le nci");
                            nci1=clavier.nextLine();
                        }
                        professeur= inscriptionservices.rechercherProfesseur(nci1);
                        if(professeur!=null){
                            List<Classe> classes=inscriptionservices.listerClasse();
                            for (Classe classe : classes) {
                                menuClasse(classe.getId(), classe.getLibelle());

                            }
                            System.out.println("Saisir l'id de la classe ou  0 pour quitter");
                            id=clavier.nextLine();
                            Classe classe=inscriptionservices.rechercherClasse(Integer.parseInt(id));
                                if(classe!=null){
                                    ProfesseurClasse professeurclasse=new ProfesseurClasse(classe, professeur);
                                    inscriptionservices.affecterClasseProfesseur(professeurclasse);
                                }
                        }
                    }while(Integer.parseInt(id)!=0);
                    break;
                
                case 4:
                    System.out.println("Saisir le nci du professeur");
                    String nci2=clavier.nextLine();
                    professeur= inscriptionservices.rechercherProfesseur(nci2);
                    if(professeur!=null){
                       inscriptionservices.listerClasseProfesseur(nci2).forEach(System.out::println); 
                    
                    }
                   
                    
                    break;
            }
            

        }while(choix!=5);
    }

    public static void menuClasse(int numero,String libelle){
        System.out.println(numero+")"+libelle);

    }
}
