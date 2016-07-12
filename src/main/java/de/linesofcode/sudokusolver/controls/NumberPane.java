package de.linesofcode.sudokusolver.controls;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Popup;

import java.io.IOException;
import java.net.URL;

public class NumberPane extends GridPane {
    private Popup popup;

    public NumberPane(Popup popup) {
        this.popup = popup;
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

    @FXML
    public void onClick(MouseEvent event) {
        System.out.println("click");
        Node source = (Node) event.getSource();
        popup.hide();
    }
}
