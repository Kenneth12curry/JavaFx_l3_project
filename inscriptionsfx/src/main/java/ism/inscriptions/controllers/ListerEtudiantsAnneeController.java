package ism.inscriptions.controllers;

import ism.inscriptions.core.Fabrique;
import ism.inscriptions.entities.Etudiant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListerEtudiantsAnneeController {

    @FXML
    TableView<Etudiant> tblvEtudiants= new TableView<>();
    @FXML
    TableColumn<Etudiant,String> tblcId=new TableColumn<>();
    @FXML
    TableColumn<Etudiant,String> tblcNomComplet=new TableColumn<>();
    @FXML
    TableColumn<Etudiant,String> tblcMatricule=new TableColumn<>();
    @FXML
    TableColumn<Etudiant,String> tblcTuteur=new TableColumn<>();


    @FXML
    TextField txtAnneeInscription,txtClasse;
    String annee;
    ObservableList obEtudiants;

    public void handleListerEtudiantsAnnee(){

        annee=txtAnneeInscription.getText().trim();
        obEtudiants=FXCollections.observableList(Fabrique.getService().listerEtudiantsAnnee(annee));
        // TODO Auto-generated method stub
        tblcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblcNomComplet.setCellValueFactory(new PropertyValueFactory<>("nomComplet"));
        tblcMatricule.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        tblcTuteur.setCellValueFactory(new PropertyValueFactory<>("tuteur"));
        //Ajiut de la liste de classse dans la table view (tableau) de classe
        tblvEtudiants.setItems(obEtudiants);

    }

    public void handlefilterEtudiantsByClasse(){
        annee=txtAnneeInscription.getText().trim();
        String libelle=txtClasse.getText().trim();

        obEtudiants=FXCollections.observableList(Fabrique.getService().listerEtudiantsClasse(annee, libelle));

        tblcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblcNomComplet.setCellValueFactory(new PropertyValueFactory<>("nomComplet"));
        tblcMatricule.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        tblcTuteur.setCellValueFactory(new PropertyValueFactory<>("tuteur"));
        //Ajiut de la liste de classse dans la table view (tableau) de classe
        tblvEtudiants.setItems(obEtudiants);
    }
}
