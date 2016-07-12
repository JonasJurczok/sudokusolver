package de.linesofcode.sudokusolver.controls;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;

public class NumberPane extends GridPane {
    public NumberPane() {
        URL resource = getClass().getResource("NumberPane.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(resource);
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
