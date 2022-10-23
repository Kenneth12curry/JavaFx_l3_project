package ism.inscriptions.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ism.inscriptions.App;

import ism.inscriptions.entities.Role;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;


public class HomeController implements Initializable{

    @FXML
    private Label Menu;

    @FXML
    private AnchorPane slider;

    
    @FXML
    private Label MenuBack;

    @FXML
    AnchorPane anchorContent;

    @FXML
    Button btnClasse,btnEtudiant,btnProfesseur,btnEtudiantAnnee,btnEtudiantClasse;

    public void handleDeconnexion() throws IOException{
        App.setRoot("connexion");
    }

    //Chargement des autres vues à droite de la page
    
    public void handleloadViewClasse() throws IOException{
        this.loadView("classe");
    }

    public void handleloadViewProfesseur() throws IOException{
        this.loadView("professeur");
    }

    public void handleloadViewEtudiant() throws IOException{
        this.loadView("etudiants");
    }

   
   public void handleloadViewEtudiantsAnnee() throws IOException{
        this.loadView("listeretudiantsannee");
    }

    /*public void handleloadViewEtudiantsClasse() throws IOException{
        this.loadView("listeretudiantsclasse");
    }*/

   

    
    

    public void loadView(String fxml) throws IOException{
        AnchorPane root =(AnchorPane) App.loadFXML(fxml);
        anchorContent.getChildren().clear();
        anchorContent.getChildren().add(root);
    }

    //Chargement de la vue classe par défaut au lançement de l'application

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        slider.setTranslateX(-212);
        
        Menu.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);

            slide.setToX(0);
            slide.play();

            slider.setTranslateX(-212);

            slide.setOnFinished((ActionEvent e)->{
                Menu.setVisible(false);
                MenuBack.setVisible(true);
            });

        });

        MenuBack.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);

            slide.setToX(-212);
            slide.play();

            slider.setTranslateX(0);

            slide.setOnFinished((ActionEvent e)->{
                Menu.setVisible(true);
                MenuBack.setVisible(false);
            });

        });
        
      
        try {
           
            //On effectue un test le rôle de l'utilisateur
            if(ConnexionController.user.getRole()==Role.RP) {
                this.loadView("classe");
                isRP();
            }
            if(ConnexionController.user.getRole()==Role.AC) {
                this.loadView("etudiants");
                isAC();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void isRP(){
        btnEtudiant.setDisable(true);
        btnEtudiantAnnee.setDisable(true);
    }

    private void isAC(){
        btnClasse.setDisable(true);
        btnProfesseur.setDisable(true);
    }

   
}