package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginSqlController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    // Metodo per gestire il click del pulsante di login
    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Esegui il tentativo di connessione a MySQL con le credenziali inserite
        if (attemptLogin(username, password)) {
            showAlert(Alert.AlertType.INFORMATION, "Login Effettuato", "Buonsalve, " + username + "!");
            // Se il login ha successo, esegui il file SQL
            executeSqlFile("GuiEsame/src/resources/exampletab.sql", username, password);
        } else {
            showAlert(Alert.AlertType.ERROR, "Login Failed", "Invalid credentials or unable to connect to the database.");
        }
    }

    // Metodo per tentare la connessione a MySQL
    private boolean attemptLogin(String username, String password) {
        String url = "jdbc:mysql://localhost:3306?serverTimezone=UTC";   // Sostituisci con il tuo URL MySQL

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            if (connection != null) {
                System.out.println("Connected to the database!");
                return true;
            } else {
                System.out.println("Failed to make connection!");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("MySQL connection failed!");
            e.printStackTrace();
            return false;
        }
    }

    private void executeSqlFile(String filePath, String username, String password) {
        String url = "jdbc:mysql://localhost:3306?serverTimezone=UTC";   // Sostituisci con il tuo URL MySQL
        
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {
            
            try (// Leggi il contenuto del file SQL
            BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                
                StringBuilder sql = new StringBuilder();
                
                while ((line = reader.readLine()) != null) {
                    // Aggiungi ogni riga al comando SQL
                    sql.append(line).append("\n");
                    
                    // Se la riga termina con un punto e virgola, esegui il comando
                    if (line.trim().endsWith(";")) {
                        statement.execute(sql.toString());
                        sql.setLength(0); // Pulisci il costruttore per il prossimo comando
                    }
                }
            }
            System.out.println("File SQL eseguito correttamente.");
            showAlert(Alert.AlertType.INFORMATION, "Successo", "Script SQL eseguito con successo!");
            showAlert(Alert.AlertType.INFORMATION, "Successo", "Adesso, puoi avviare il server.");
            // Chiudi la finestra di login
            usernameField.getScene().getWindow().hide();
            
        } catch (SQLException e) {
            System.out.println("Errore nell'esecuzione del file SQL.");
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Errore", "Errore durante l'esecuzione dello script SQL.");
            // Chiudi la finestra di login
            usernameField.getScene().getWindow().hide();
        } catch (IOException e) {
            System.out.println("Errore nella lettura del file SQL.");
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Errore", "Errore durante la lettura del file SQL.");
            // Chiudi la finestra di login
            usernameField.getScene().getWindow().hide();
        }
    }
    
    @FXML
    private void Indietro() {
        usernameField.getScene().getWindow().hide(); // Chiudi la finestra di login
    }

    // Metodo per mostrare un messaggio di alert
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
