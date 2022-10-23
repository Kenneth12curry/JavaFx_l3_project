package ism.inscriptions.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ism.inscriptions.core.Fabrique;
import ism.inscriptions.entities.Classe;
import ism.inscriptions.entities.Etudiant;
import ism.inscriptions.entities.Inscription;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class EtudiantsController implements Initializable{
    
    @FXML
    TableView<Classe> tblvClasse= new TableView<>();
    @FXML
    TableColumn<Classe,String> tblcId=new TableColumn<>();
    @FXML
    TableColumn<Classe,String> tblcLibelle=new TableColumn<>();
    @FXML
    TableColumn<Classe,String> tblcFiliere=new TableColumn<>();
   
   
    @FXML
    Pane pnInscription,pnRsc;
    
    
    @FXML
    RadioButton radioInscription,radioRsc;

    @FXML
    TextField txtMatriculeEtudiant,txtTuteur,txtNomComplet,txtlibelle,txtAnneeInscription,txtDate,txtFiliere;
    
    @FXML
    TextField txtAnneeInscription1,txtDate1,txtFiliere1,txtlibelle1,txtTuteur1,txtNomComplet1;
   
    private ObservableList obClasse=FXCollections.observableList(Fabrique.getService().listerClasse());

    Etudiant etudiant;
    Classe classe;

    
    //initialisation de la liste de classe au lançement de la vuue
    
    @Override
    public void initialize(URL location, ResourceBundle resources){

     

         // TODO Auto-generated method stub
         tblcId.setCellValueFactory(new PropertyValueFactory<>("id"));
         tblcFiliere.setCellValueFactory(new PropertyValueFactory<>("filiere"));
         tblcLibelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));
         //Ajout de la liste de classe dans la table view (tableau) de classe
         tblvClasse.setItems(obClasse);

         //selection d'un bouton radio
         radioInscription.setSelected(true);
         pnRsc.setDisable(true);
        

        
        
    }

    //méthode pour rechercher un étudiant
  
    public void handleRechercherEtudiant(){

        String matricule=txtMatriculeEtudiant.getText().trim();
        etudiant=Fabrique.getService().rechercherEtudiant(matricule);

        if(etudiant!=null){
          
            //Chargement des informations de l'étudiant dans les panels(différents champs)
            txtNomComplet1.setText(etudiant.getNomComplet());
            txtTuteur1.setText(etudiant.getTuteur());
            //txtlibelle1.setText((etudiant.getClasse().getLibelle()));
            
        }else{

            //Effacer les informations de l'étudiant dans les panels(différents champs)
            txtNomComplet.clear();
            txtTuteur.clear();
            txtlibelle.clear();
        }
       
    }


    public void handleCreerInscription(){

        //Création de l'étudiant

        String nomComplet=txtNomComplet.getText().trim();
        String tuteur=txtTuteur.getText().trim();
        String libelle=txtlibelle.getText().trim();
        classe=Fabrique.getService().rechercherClasseByLibelle(libelle); 
        etudiant=new Etudiant(null, null, nomComplet,tuteur);
        etudiant.setClasse(classe);
        etudiant=Fabrique.getService().creerEtudiant(etudiant);
        
        //
        Inscription inscription;
        String annee=txtAnneeInscription.getText().trim();
        String date=txtDate.getText().trim();
        String filiere=txtFiliere.getText().trim();
        inscription=new Inscription(annee, date, filiere);
        etudiant=Fabrique.getService().rechercherEtudiant(etudiant.getMatricule());
        if(etudiant!=null){
            inscription.setEtudiant(etudiant);
            Fabrique.getService().creerInscriptions(inscription);
        }
       
       
    }


    public void handleCreerRsc(){
        Inscription inscription;
        if(etudiant!=null){
            String annee=txtAnneeInscription1.getText().trim();
            String date=txtDate1.getText().trim();
            inscription=new Inscription(annee, date, null);
            inscription.setEtudiant(etudiant);
            Fabrique.getService().creerInscriptions(inscription);
        
        
        }
      
    }
    

    public void isInsc(){
        pnInscription.setDisable(!radioInscription.isSelected());
        pnRsc.setDisable(radioInscription.isSelected());
        
    }
    public void isRsc(){
        pnRsc.setDisable(!radioRsc.isSelected());
        pnInscription.setDisable(radioRsc.isSelected());
    }
    
}