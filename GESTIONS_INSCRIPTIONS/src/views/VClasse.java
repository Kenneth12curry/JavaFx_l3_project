package views;

import java.lang.reflect.Array;
import java.util.Scanner;

import entities.Classe;
import services.IInscriptionservices;
import services.Inscriptionservices;

public class VClasse {

    public static void menu(IInscriptionservices inscriptionservices){
        
        Scanner clavier=new Scanner(System.in);
        Classe classe;
        int choix;
        do{
            System.out.println("1-Créér une Classe");
            System.out.println("2-Lister Classe");
            System.out.println("3-Quitter");
            System.out.println("Faites votre choix ?");
            choix=clavier.nextInt();
            clavier.nextLine();
            switch(choix){

                case 1:
                    System.out.println("Donner la filiere de la Classe");
                    String filiere=clavier.nextLine();
                    System.out.println("Saisir le libelle de la Classe");
                    String libelle=clavier.nextLine();
                    classe=new Classe(filiere, libelle);
                    inscriptionservices.creerClasse(classe);
                    break;
                case 2:
                    inscriptionservices.listerClasse().forEach(System.out::println);
                    break;
            }
       }while(choix!=3);
    }
}
