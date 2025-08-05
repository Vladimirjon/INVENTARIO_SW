package com.mycompany.inventario;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        // Llama a loadFXML con el nombre base "Login"
        scene = new Scene(loadFXML("Login"), 750, 500);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Permite cambiar la raíz de la escena desde cualquier controlador:
     * App.setRoot("INVENTARIO_GUI");
     */
    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /**
     * Carga un FXML ubicado en:
     *   src/main/resources/com/mycompany/inventario/{name}.fxml
     *
     * @param name nombre base del FXML (sin ".fxml")
     */
    private static Parent loadFXML(String name) throws IOException {
        String path = "/com/mycompany/inventario/" + name + ".fxml";
        FXMLLoader loader = new FXMLLoader(App.class.getResource(path));
        return loader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}
