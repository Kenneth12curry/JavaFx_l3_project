package views;

import java.util.Scanner;

import entities.Etudiant;
import entities.Inscription;
import entities.User;
import services.IInscriptionservices;
import services.Inscriptionservices;

public class VEtudiant {

    public static void menu(IInscriptionservices inscriptionservices){
        Scanner clavier=new Scanner(System.in);
        int choix;
        String login,password,nomComplet,tuteur,matricule;
        do{
            System.out.println("1-Effectuer l'inscription ou la réisncription d'un étudiant");
            System.out.println("2-Lister les étudiants inscrits dans une année");
            System.out.println("3-Quitter");
            choix=clavier.nextInt();
            Etudiant etudiant;
            clavier.nextLine();
            switch(choix){
                case 1:

                    System.out.println("Donner Le matricule de l'etudiant");
                    matricule=clavier.nextLine();
                    etudiant=inscriptionservices.rechercherEtudiant(matricule);
                    if(etudiant==null){
                        System.out.println("____Informations de l'etudiant_____");
                        System.out.println("Donner le nom complet de l'etudiant");
                        nomComplet=clavier.nextLine();
                        // System.out.println("Donner le login de l'etudiant");
                        // login=clavier.nextLine();
                        // System.out.println("Donner le password de l'etudiant");
                        // password=clavier.nextLine();
                        System.out.println("Saisir le matricule de l'etudiant");
                        matricule=clavier.nextLine();
                        System.out.println("Saisir le tuteur de l'etudiant");
                        tuteur=clavier.nextLine();
                        etudiant=new Etudiant(null, null, nomComplet, matricule, tuteur);
                        inscriptionservices.creerEtudiant(etudiant);
                    }

                    System.out.println("____Informations sur l'inscription  de l'etudiant_____");
                    System.out.println("Saisir le nom complet de l'etudiant");
                    String nomEtudiant=clavier.nextLine();
                    System.out.println("Saisir l'année d'inscription de l'etudiant");
                    String anneeInsc=clavier.nextLine();
                   /*  System.out.println("Saisir le matricule de l'etudiant");
                    String matriculeEtudiant=clavier.nextLine(); */
                    Inscription inscription=new Inscription(nomEtudiant, anneeInsc);
                    inscription.setEtudiant(etudiant);
                    inscriptionservices.creerInscriptions(inscription);
            
                    break;

                case 2:
                    System.out.println("Entrer l'année d'inscription");
                    String annee=clavier.nextLine();
                    inscriptionservices.listerEtudiantsAnnee(annee).forEach(System.out::println);;
                    break;
            }
        }while(choix!=3);
    }

    private static User getEtudiant() {
        return null;
    }
    
}
