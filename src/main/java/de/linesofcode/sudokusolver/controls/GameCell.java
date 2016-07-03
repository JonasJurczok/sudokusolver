package de.linesofcode.sudokusolver.controls;

import javafx.beans.NamedArg;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;

public class GameCell extends StackPane {

    @FXML Label label;
    @FXML private TextField edit;

    public GameCell() {
        URL resource = getClass().getResource("GameCell.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(resource);
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setValue(Integer value) {
        label.setText(value == null ? "0" : value.toString());
    }

    public Integer getValue() {
        return Integer.valueOf(label.getText());
    }

}
