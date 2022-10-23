package ism.inscriptions.controllers;

import ism.inscriptions.core.Fabrique;
import ism.inscriptions.entities.Classe;
import ism.inscriptions.entities.Professeur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListerClasseProfController {
    

    @FXML
    TableView<Classe> tblvClasse= new TableView<>();
    @FXML
    TableColumn<Classe,String> tblcId=new TableColumn<>();
    @FXML
    TableColumn<Classe,String> tblcFiliere=new TableColumn<>();
    @FXML
    TableColumn<Classe,String> tblcLibelle=new TableColumn<>();
   
    @FXML
    private TextField txtGrade;

    @FXML
    private TextField txtNci;

    @FXML
    private TextField txtNomComplet;


    public void handleListeClasseProfesseur(){

        String nci=txtNci.getText().trim();
        Professeur professeur=Fabrique.getService().rechercherProfesseur(nci);
        if(professeur!=null){
            ObservableList obClasse=FXCollections.observableList(Fabrique.getService().listerClasseProfesseur(nci));
            
            tblcId.setCellValueFactory(new PropertyValueFactory<>("id"));
            tblcFiliere.setCellValueFactory(new PropertyValueFactory<>("filiere"));
            tblcLibelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));
            //Ajout de la liste de classse dans la table view (tableau) de classe
            tblvClasse.setItems(obClasse);
            //Chargement des informations du professeur
            txtNomComplet.setText(professeur.getNomComplet());
            txtGrade.setText(professeur.getGrade());
        }else{
            
            Alert alert=new Alert(AlertType.INFORMATION);
            alert.setTitle("Gestion Inscription");
            alert.setContentText("Le professeur n'existe pas !");
            alert.show();
            tblvClasse.getItems().clear();
            txtNomComplet.clear();
            txtNci.clear();
            txtGrade.clear();
        }

       

    }
}
