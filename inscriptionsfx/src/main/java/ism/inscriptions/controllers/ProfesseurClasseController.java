package ism.inscriptions.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import ism.inscriptions.App;
import ism.inscriptions.core.Fabrique;
import ism.inscriptions.entities.Classe;
import ism.inscriptions.entities.Professeur;
import ism.inscriptions.entities.ProfesseurClasse;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class ProfesseurClasseController implements Initializable{


    @FXML
    TableView<Classe> tblvClasse= new TableView<>();
    @FXML
    TableColumn<Classe,String> tblcId=new TableColumn<>();
    @FXML
    TableColumn<Classe,String> tblcFiliere=new TableColumn<>();
    @FXML
    TableColumn<Classe,String> tblcLibelle=new TableColumn<>();
    
    @FXML
    TextField txtNci,txtlibelleClasse;
    @FXML
    Text txtErrorClasse,txtErrorProfesseur;
    @FXML
    Pane pnClasse;
   
    private ObservableList obClasse=FXCollections.observableList(Fabrique.getService().listerClasse());
  
    

    //Methode pour rechercher un professeur

    public Professeur handleRechercherProfesseur(){
        String nci=txtNci.getText().trim();
        Professeur professeur=Fabrique.getService().rechercherProfesseur(nci);
        if(professeur!=null){
            //Désactivation des panels
            pnClasse.setDisable(false);
            txtErrorProfesseur.setVisible(false);
        }else{
             //Activaction des panels
            pnClasse.setDisable(true);
            txtErrorProfesseur.setVisible(true);
        }
        return professeur;
    }

    public void handleRechercherClasse(){
        String libelle=txtlibelleClasse.getText().trim();
        Classe classe=Fabrique.getService().rechercherClasseByLibelle(libelle);
        if(classe!=null){
                //Affecation de la classe aux professeurs
                Professeur professeur=handleRechercherProfesseur();
                ProfesseurClasse professeurClasse=Fabrique.getService().affecterClasseProfesseur(new ProfesseurClasse(classe, professeur));
                Alert alert=new Alert(AlertType.INFORMATION);
                alert.setTitle("Gestion Inscription");
                alert.setContentText("Cette classe vient d'être affecté à ce professeur avec succès");
                alert.show();
                //efface l'id de la classe saisie
                txtlibelleClasse.clear();
               
        }else{

            txtErrorClasse.setVisible(true);
            
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        //Affihage de la liste de classe
        tblcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblcFiliere.setCellValueFactory(new PropertyValueFactory<>("filiere"));
        tblcLibelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));

        //Ajiut de la liste de classe dans la table view (tableau) de classe
        tblvClasse.setItems(obClasse);

        //Désactiavtion des erreurs de la classe et du professeur

        txtErrorClasse.setVisible(false);
        txtErrorProfesseur.setVisible(false);
    }

   
   

}
