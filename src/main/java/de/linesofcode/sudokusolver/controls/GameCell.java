package de.linesofcode.sudokusolver.controls;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Popup;

import java.io.IOException;
import java.net.URL;

public class GameCell extends StackPane {

    @FXML private Label label;

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

        setOnMouseClicked(mouseEvent -> {
            Bounds bounds = localToScreen(getBoundsInLocal());
            Popup popup = new Popup();
            popup.setX(bounds.getMinX());
            popup.setY(bounds.getMaxY());
            popup.getContent().addAll(new NumberPane(popup));
            popup.setAutoHide(true);
            popup.show(getScene().getWindow());
        });
    }

    public void setValue(Integer value) {
        label.setText(value == null ? "0" : value.toString());
    }

    public Integer getValue() {
        return Integer.valueOf(label.getText());
    }

}
