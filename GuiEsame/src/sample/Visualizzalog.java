package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import java.io.IOException;

public class Visualizzalog {

    @FXML
    private TextArea logTextArea;

    @FXML
    private Button docsButton;
    @FXML
    private Button serverButton;
    @FXML
    private Button dataButton;
    @FXML
    private Button log;
    @FXML
    private Button exitButton;

    // Metodo che verrà chiamato quando il pulsante "Docs" viene premuto
    @FXML
    private void handledocs() {
        // Implementa qui la logica per visualizzare i documenti
        System.out.println("Visualizza documenti");
    }

    // Metodo che verrà chiamato quando il pulsante "Server" viene premuto
    @FXML
    private void handleServer() {
        // Implementa qui la logica per gestire il server
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

    // Metodo che verrà chiamato quando il pulsante "Data" viene premuto
    @FXML
    private void handledata() {
        // Implementa qui la logica per gestire i dati
        System.out.println("Gestisci i dati");
    }

    // Metodo che verrà chiamato quando il pulsante "Log" viene premuto
    @FXML
    private void handleLog() {
        // Qui puoi aggiungere logica per visualizzare i log nel TextArea
        logTextArea.appendText("Log visualizzato...\n");
    }

    // Metodo che verrà chiamato quando il pulsante "Exit" viene premuto
    @FXML
    private void handleExit() {
     logTextArea.appendText("Uscita dall'applicazione.\n");
        // Aggiungi qui la logica per uscire
         try {
            // Carica la schermata precedente
            FXMLLoader loader = new FXMLLoader(getClass().getResource("menuprincipale.fxml")); 
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
