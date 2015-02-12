/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wwjjavafx.app.controller;

import gov.nasa.worldwind.geom.Position;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;
import wwjjavafx.app.WWJJavaFX;
import wwjjavafx.widgets.Instrument;

/**
 *
 * @author Serge
 */
public class WWJController implements Initializable {

    @FXML
    public StackPane centerStackPane;

    @FXML
    private void loadWidget(ActionEvent event) {
        Instrument instrument = new Instrument();
        centerStackPane.getChildren().add(instrument);
        instrument.schedule();
    }

    @FXML
    private void exit(ActionEvent event) {
        System.exit(1);
    }

    @FXML
    private void about(ActionEvent event) {
       WWJJavaFX.getWWD().getView().goTo(Position.fromDegrees(48.40, -4.4853, 15000), 5000);//;-)
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
