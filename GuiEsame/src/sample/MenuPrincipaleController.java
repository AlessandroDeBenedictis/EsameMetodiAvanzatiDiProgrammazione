package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MenuPrincipaleController {

    @FXML
    private Button docsButton;
    @FXML
    private Button serverButton;
    @FXML
    private Button dataButton;
    @FXML
    private Button exitButton;
    @FXML
    private Button yesButton;
    @FXML
    private Button noButton;

    @FXML
    public void initialize() {
        // Associa le azioni ai pulsanti
        docsButton.setOnAction(event -> handleDocs());
        serverButton.setOnAction(event -> handleServer());
        dataButton.setOnAction(event -> handleData());
        exitButton.setOnAction(event -> handleExit());
        yesButton.setOnAction(event -> handleYes());
        noButton.setOnAction(event -> handleNo());
    }

    private void handleDocs() {
        System.out.println("Aprendo i documenti...");
        // Aggiungi qui la logica per aprire i documenti
    }

    private void handleServer() {
        System.out.println("Gestendo il server...");
        // Aggiungi qui la logica per uscire
        try {
            // Carica la schermata precedente
            FXMLLoader loader = new FXMLLoader(getClass().getResource("avvioserver.fxml")); 
            Parent root = loader.load();
            
            // Ottieni la finestra attuale
            Stage stage = (Stage) exitButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    private void handleData() {
        System.out.println("Mostrando i dati...");
        // Aggiungi qui la logica per mostrare i dati
    }

    private void handleExit() {
        System.out.println("Tornando al menu principale...");
        // Aggiungi qui la logica per uscire
         try {
            // Carica la schermata precedente
            FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml")); 
            Parent root = loader.load();
            
            // Ottieni la finestra attuale
            Stage stage = (Stage) exitButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
    }

    private void handleYes() {
        System.out.println("Hai scelto 'Si'.");
        try {
        // Carica il file FXML di dashfx
        FXMLLoader loader = new FXMLLoader(getClass().getResource("loginsql.fxml"));
        Parent root = loader.load();

        // Crea una nuova scena e la aggiunge a una nuova finestra
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED); // Rimuove la decorazione della finestra
        stage.setTitle("Dashboard");
        stage.setScene(new Scene(root));
        stage.show();
        // Puoi anche chiudere la finestra attuale se necessario
        // ((Node)(event.getSource())).getScene().getWindow().hide();
    } catch (IOException e) {
        e.printStackTrace(); // Gestisci eventuali errori di caricamento
    }
    }

    private void handleNo() {
        System.out.println("Hai scelto 'No'.");
        // Aggiungi qui la logica per uscire
        try {
            // Carica la schermata precedente
            FXMLLoader loader = new FXMLLoader(getClass().getResource("avvioserver.fxml")); 
            Parent root = loader.load();
            
            // Ottieni la finestra attuale
            Stage stage = (Stage) exitButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
