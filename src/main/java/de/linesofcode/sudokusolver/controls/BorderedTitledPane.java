package de.linesofcode.sudokusolver.controls;

import javafx.beans.DefaultProperty;
import javafx.beans.NamedArg;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.List;

@DefaultProperty("content")
public class BorderedTitledPane extends StackPane {

    @FXML
    private Label title;
    @FXML
    private StackPane contentPane;

    public BorderedTitledPane() {
        URL resource = getClass().getResource("BorderedTitledPane.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(resource);
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ObservableList<Node> getContent() {
        return contentPane.getChildren();
    }

    public void setTitle(String title) {
        this.title.setText(" " + title + " ");
    }

    public String getTitle() {
        return title.getText();
    }
}