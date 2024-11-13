package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;


public class SampleController {

    @FXML
    private Button btnAvviaProgramma;

    @FXML
    private Button btnUscita;

    @FXML
    private Button btnDocumentazione;

    @FXML
    private Button btnAlessandro;

    @FXML
    private Button btnClaudio;

    // Metodo per il pulsante "Avvia il programma"
 @FXML
private void handleAvviaProgramma(ActionEvent event) {
    try {
        // Carica il file FXML di dashfx
        FXMLLoader loader = new FXMLLoader(getClass().getResource("menuprincipale.fxml"));
        Parent root = loader.load();

        // Crea una nuova scena e la aggiunge a una nuova finestra
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED); // Rimuove la decorazione della finestra
        stage.setTitle("Dashboard");
        stage.setScene(new Scene(root));
        stage.show();
        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
        // Puoi anche chiudere la finestra attuale se necessario
        // ((Node)(event.getSource())).getScene().getWindow().hide();
    } catch (IOException e) {
        e.printStackTrace(); // Gestisci eventuali errori di caricamento
    }
}
    // Metodo per il pulsante "Uscita"
    @FXML
    private void handleUscita() {
        System.out.println("Uscita clicked!");
        // Logica per l'uscita qui
        System.exit(0);
    }

    // Metodo per il pulsante "Alessandro"
    @FXML
    private void handleAlessandro() {
        System.out.println("De Benedictis Alessandro clicked!");
        try {
            // Ottieni il file PDF dalla cartella resources
            File pdfFile = new File(getClass().getResource("/resources/AlessandroDeBenedictisEUCV.pdf").toURI());
            
            // Controlla se il file esiste
            if (pdfFile.exists()) {
                // Apri il file PDF con l'applicazione predefinita
                Desktop.getDesktop().open(pdfFile);
            } else {
                System.out.println("Il file PDF non esiste.");
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    // Metodo per il pulsante "Docuemntazione"
    @FXML
    private void handleDocumentazione() {
        System.out.println("Documentazione clicked!");
        // Logica per questo pulsante
    }

    // Metodo per il pulsante "De Benedictis Claudio"
    @FXML
    private void handleClaudio() {
        System.out.println("De Benedictis Claudio clicked!");
        try {
            // Ottieni il file PDF dalla cartella resources
            File pdfFile = new File(getClass().getResource("/resources/AlessandroDeBenedictisEUCV.pdf").toURI()); //MODIFICA PDF
            
            // Controlla se il file esiste
            if (pdfFile.exists()) {
                // Apri il file PDF con l'applicazione predefinita
                Desktop.getDesktop().open(pdfFile);
            } else {
                System.out.println("Il file PDF non esiste.");
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
