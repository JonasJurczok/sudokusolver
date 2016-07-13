package de.linesofcode.sudokusolver.controls;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Popup;

import java.io.IOException;
import java.net.URL;

import static java.lang.Integer.valueOf;

public class NumberPane extends GridPane {
    private Popup popup;
    private GameCell gameCell;

    public NumberPane(Popup popup, GameCell gameCell) {
        this.popup = popup;
        this.gameCell = gameCell;

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
        Label source = (Label) event.getSource();
        Integer value = valueOf(source.getText());
        gameCell.setValue(value);
        popup.hide();
    }
}
