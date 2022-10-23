package ism.inscriptions.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;



import ism.inscriptions.core.Fabrique;
import ism.inscriptions.entities.Classe;
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


public class ClasseController implements Initializable {

    @FXML
    TableView<Classe> tblvClasse= new TableView<>();
    @FXML
    TableColumn<Classe,String> tblcId=new TableColumn<>();
    @FXML
    TableColumn<Classe,String> tblcFiliere=new TableColumn<>();
    @FXML
    TableColumn<Classe,String> tblcLibelle=new TableColumn<>();

    @FXML
    TextField txtFiliere,txtLibelle;
    /* ComboBox <Classe> cbox;
    Classe classe;
 */


    //Conversion de la liste de classe retounée par la classe inscriptionsservices en un objet de type ObservablesList

    private ObservableList obClasse=FXCollections.observableList(Fabrique.getService().listerClasse());

    @Override
    public void initialize(URL location, ResourceBundle resources) {
      /*   List<Classe> classes=Fabrique.getService().listerClasse();
        for(Classe classe: classes){
            cbox.getItems().add(classe);
        }
        cbox.setOnAction(this::selectClasse);
 */
        
        // TODO Auto-generated method stub
        tblcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblcFiliere.setCellValueFactory(new PropertyValueFactory<>("filiere"));
        tblcLibelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));
        //Ajiut de la liste de classse dans la table view (tableau) de classe
        tblvClasse.setItems(obClasse);
        
    }
    
   /*  public void selectClasse(ActionEvent event){
        classe=cbox.getValue();
    }
 */
    //méthode pour Créer une classe
    public void handleCreerClasse(){

        String filiere=txtFiliere.getText().trim();
        String libelle=txtLibelle.getText().trim();
        //Création de la classe
        if(filiere.isEmpty() || libelle.isEmpty()){

            Alert alert=new Alert(AlertType.INFORMATION);
            alert.setTitle("Gestion Inscription");
            alert.setContentText("Veuillez s'il vous plaît remplir tous les champs");
            alert.show();

        }else{

            Classe classe=Fabrique.getService().creerClasse(new Classe(filiere, libelle));
            Alert alert=new Alert(AlertType.INFORMATION);
            alert.setTitle("Gestion Inscription");
            alert.setContentText("Une classe vient d'être crée avec succès");
            alert.show();
            obClasse.add(classe);
        }
      
      
        txtFiliere.clear();
        txtLibelle.clear();


    }
   
}
