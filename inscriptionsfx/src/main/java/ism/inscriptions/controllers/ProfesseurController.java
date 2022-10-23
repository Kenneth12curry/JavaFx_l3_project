package ism.inscriptions.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ism.inscriptions.App;
import ism.inscriptions.core.Fabrique;
import ism.inscriptions.entities.Professeur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;


public class ProfesseurController implements Initializable{

    @FXML
    AnchorPane anchorContent;
    
    @FXML
    TableView<Professeur> tblvProfesseur= new TableView<>();
    @FXML
    TableColumn<Professeur,String> tblcId=new TableColumn<>();
    @FXML
    TableColumn<Professeur,String> tblcNomComplet=new TableColumn<>();
    @FXML
    TableColumn<Professeur,String> tblcNci=new TableColumn<>();
    @FXML
    TableColumn<Professeur,String> tblcGrade=new TableColumn<>();

    @FXML
    TextField txtNomComplet,txtNci,txtGrade;
    
   

    private ObservableList obProfesseur=FXCollections.observableList(Fabrique.getService().listerProfesseur());
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tblcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblcNomComplet.setCellValueFactory(new PropertyValueFactory<>("nomComplet"));
        tblcNci.setCellValueFactory(new PropertyValueFactory<>("nci"));
        tblcGrade.setCellValueFactory(new PropertyValueFactory<>("grade"));

        tblvProfesseur.setItems(obProfesseur);
        
    }

    public void handleCreerProfesseur(){

       
        String nomComplet=txtNomComplet.getText().trim();
        String nci=txtNci.getText().trim();
        String grade=txtGrade.getText().trim();
        //Création du professeur(objet)
        if(nomComplet.isEmpty() || nci.isEmpty() || grade.isEmpty()){

            Alert alert=new Alert(AlertType.INFORMATION);
            alert.setTitle("Gestion Inscription");
            alert.setContentText("Veuillez s'il vous plaît remplir tous les champs ");
            alert.show();
        }else{

            //A la création du profsseur on initialise le login et le password en null

            Professeur professeur=Fabrique.getService().creerProfesseur(new Professeur(null, null, nomComplet, nci, grade));
            Alert alert=new Alert(AlertType.INFORMATION);
            alert.setTitle("Gestion Inscription");
            alert.setContentText("Un professeur vient d'être crée avec succès");
            alert.show();
            obProfesseur.add(professeur);
            

        }
         //Effacer les champs après la création
        txtNomComplet.clear();
        txtNci.clear();
        txtGrade.clear();
       
    }

    //méthode 
    public void handleloadViewAffecterClasse() throws IOException{
        this.loadView("professeurclasse");
    }

    public void handleloadViewListeClasseProfesseur() throws IOException{
        this.loadView("listerclasseprof");
    }

    public void loadView(String fxml) throws IOException{
        AnchorPane root =(AnchorPane) App.loadFXML(fxml);
        anchorContent.getChildren().clear();
        anchorContent.getChildren().add(root);
    }


   
   
}
