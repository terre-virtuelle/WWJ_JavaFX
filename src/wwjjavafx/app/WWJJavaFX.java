/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wwjjavafx.app;

import gov.nasa.worldwind.BasicModel;
import gov.nasa.worldwind.WorldWindow;
import gov.nasa.worldwind.awt.WorldWindowGLJPanel;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import wwjjavafx.app.controller.WWJController;

/**
 *
 * @author Serge
 */
public class WWJJavaFX extends Application {

    protected static WorldWindow wwd;
    protected WWJController ctrl;
    protected FXMLLoader loader;
    protected Scene scene;
    protected StackPane root;

    public WWJJavaFX() {
        loader = new FXMLLoader(getClass().getResource("/wwjjavafx/app/view/WWJGui.fxml"));
        try {
            root = loader.load();
            ctrl = loader.getController();
        } catch (IOException ex) {
            Logger.getLogger(WWJJavaFX.class.getName()).log(Level.SEVERE, null, ex);
        }
        scene = new Scene(root);
        SwingNode swingNode = new SwingNode();
        wwd = new WorldWindowGLJPanel();
        wwd.setModel(new BasicModel());
        swingNode.setContent((WorldWindowGLJPanel) wwd);
        ctrl.centerStackPane.getChildren().add(swingNode);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(scene);
        stage.setOnCloseRequest((WindowEvent event) -> {
            System.exit(1);
        });
        stage.show();
    }

    public static WorldWindow getWWD() {
        return wwd;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
