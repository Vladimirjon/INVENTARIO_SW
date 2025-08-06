package com.mycompany.inventario;

import java.io.IOException;

import InventarioDAL.BodegueroVista;
import inventarioBLL.BodegueroService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML private TextField txtUser;       // Nombre + Apellido
    @FXML private PasswordField txtPass;   // La contraseña

    @FXML
    private void handleIniciarSesion(ActionEvent event) {
        String nombreCompleto = txtUser.getText().trim();
        String pass           = txtPass.getText().trim();

        if (nombreCompleto.isEmpty() || pass.isEmpty()) {
            new Alert(Alert.AlertType.WARNING,
                "Debe ingresar nombre y contraseña."
            ).showAndWait();
            return;
        }

        BodegueroService svc = new BodegueroService();
        BodegueroVista user = svc.autenticarUsuarioPorNombre(nombreCompleto, pass);

        if (user != null) {
            // carga la pantalla principal
            try {
                App.setRoot("INVENTARIO_GUI");
            } catch (IOException e) {
                new Alert(Alert.AlertType.ERROR,
                    "No se pudo cargar la aplicación:\n" + e.getMessage()
                ).showAndWait();
            }
        } else {
            new Alert(Alert.AlertType.ERROR,
                "Nombre o contraseña incorrectos."
            ).showAndWait();
        }
    }
}
