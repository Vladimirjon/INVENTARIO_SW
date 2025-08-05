package com.mycompany.inventario;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML private Button btnIniciarSesion;
    @FXML private TextField txtUser;
    @FXML private PasswordField txtPass;

    /** Se ejecuta tras cargar el FXML (puedes dejarlo vacío si no necesitas inicializar nada). */
    @FXML
    private void initialize() {
        // Inicialización opcional
    }

    /** Invocado al pulsar "Iniciar sesión". */
    @FXML
    private void handleIniciarSesion(ActionEvent event) {
        String user = txtUser.getText().trim().toUpperCase();
        String pass = txtPass.getText().trim();

        boolean ok = 
            ("ADMIN".equals(user)        && "admin".equals(pass))     ||
            ("JOELTINITANA".equals(user) && "inventario".equals(pass));

        if (!ok) {
            new Alert(Alert.AlertType.ERROR, "Usuario o contraseña incorrectos").showAndWait();
            return;
        }

        try {
            // Cambia la vista a INVENTARIO_GUI.fxml
            App.setRoot("INVENTARIO_GUI");
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,
                "No se pudo cargar la pantalla:\n" + e.getMessage()
            ).showAndWait();
        }
    }
}
