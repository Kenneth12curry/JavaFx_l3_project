import java.util.Scanner;

import repositories.IClasseRepository;
import repositories.IEtudiantRepository;
import repositories.IInscriptionRepository;
import repositories.IProfesseurClasseRepository;
import repositories.IProfesseurRepository;

import repositories.bd.ClasseRepository;
import repositories.bd.EtudiantRepository;
import repositories.bd.InscriptionRepository;
import repositories.bd.ProfesseurClasseRepository;
import repositories.bd.ProfesseurRepository;

import services.IInscriptionservices;
import services.Inscriptionservices;
import views.VClasse;
import views.VEtudiant;
import views.VProfesseur;

public class App {
    public static void main(String[] args) throws Exception {
        
        //couplage faible
        IClasseRepository classeRepository=new ClasseRepository();
        IProfesseurRepository professeurRepository=new ProfesseurRepository();
        IEtudiantRepository etudiantRepository=new EtudiantRepository();
        IInscriptionRepository inscriptionRepository=new InscriptionRepository();
        IProfesseurClasseRepository professeurclasseRepository=new ProfesseurClasseRepository();
        
        IInscriptionservices inscriptionservices=new Inscriptionservices(classeRepository, 
        professeurRepository,
        etudiantRepository,inscriptionRepository,professeurclasseRepository);
        Scanner clavier=new Scanner(System.in);
        int choix;
       do{
            System.out.println("1-Classe");
            System.out.println("2-Professeur");
            System.out.println("3-Etudiant");
            System.out.println("4-Quitter");
            System.out.println("Faites votre choix ?");
            choix=clavier.nextInt();
            clavier.nextLine();
            switch(choix){

                case 1:
                    VClasse.menu(inscriptionservices);
                    break;
                case 2:
                    VProfesseur.menu(inscriptionservices);
                    break;
                case 3:
                    VEtudiant.menu(inscriptionservices);
                    break;
            }
       }while(choix!=4);
    }
}
