package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;


public class AvvioServerController {
    
    private Process process; // Variabile per il processo del server

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

    @FXML
    private TextArea logTextArea;

    @FXML
    private void handledocs(ActionEvent event) {
        // Logica per gestire il pulsante Docs
        logTextArea.appendText("Documentazione aperta.\n");
    }

    @FXML
    private void handledata(ActionEvent event) {
        // Logica per gestire il pulsante Data
        logTextArea.appendText("Dati aperti.\n");
    }

    @FXML
    private void handleLog(ActionEvent event) {
        // Logica per gestire il pulsante Log
        logTextArea.appendText("Visualizzazione log.\n");
        // Aggiungi qui la logica per uscire
         try {
            // Carica la schermata precedente
            FXMLLoader loader = new FXMLLoader(getClass().getResource("visualizzalog.fxml")); 
            Parent root = loader.load();
            
            // Ottieni la finestra attuale
            Stage stage = (Stage) exitButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    @FXML
    private void handleExit(ActionEvent event) {
        // Logica per gestire il pulsante Exit
        logTextArea.appendText("Uscita dall'applicazione.\n");
        if (process != null && process.isAlive()) {
            process.destroy(); 
        }// Termina il processo del server
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

    @FXML
    private void avvioserver(ActionEvent event) {
        // Avvio del server in un nuovo thread
         // Controlla se il server è già in esecuzione
    if (process != null && process.isAlive()) {
        logTextArea.appendText("Il server è già in esecuzione. Chiudi prima il server attuale.\n");
        return; // Esci se il server è attivo
    }
        new Thread(() -> {
            try {
                // Imposta il comando corretto per avviare il server
                //System.out.println(" Directory: " + new File(".").getAbsolutePath());
                ProcessBuilder processBuilder = new ProcessBuilder("java", "-cp", ".;..\\..\\lib\\mysql-connector-java-8.0.17.jar", "Main");
                processBuilder.directory(new File("Server\\src")); // Imposta la directory corretta
                processBuilder.redirectErrorStream(true); // Unisci stdout e stderr
                process = processBuilder.start();
    
                // Leggi l'output del server e appendilo all'area di testo
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                    String line; // Dichiarazione della variabile 'line' qui
    
                    while ((line = reader.readLine()) != null) {
                        // Usa Platform.runLater per aggiornare l'UI nel thread della UI
                        final String outputLine = line; // Crea una variabile finale
                        Platform.runLater(() -> logTextArea.appendText(outputLine + "\n"));
                    }
                }
    
                // Attendi la fine del processo (opzionale)
                
            } catch (IOException e) {
                e.printStackTrace();
                // Append l'errore all'area di testo se necessario
                Platform.runLater(() -> logTextArea.appendText("Errore nell'avvio del server: " + e.getMessage() + "\n"));
            }
        }).start();
    }
    
    
    


// Altri metodi per gestire i pulsanti e l'interfaccia
@FXML
private void chiusuraserver(ActionEvent event) {
    if (process != null) {
        process.destroy(); // Termina il processo del server
        logTextArea.appendText("Server chiuso.\n");
        process = null; // Reset del riferimento al processo
    } else {
        logTextArea.appendText("Nessun server in esecuzione.\n");
    }
}
}
