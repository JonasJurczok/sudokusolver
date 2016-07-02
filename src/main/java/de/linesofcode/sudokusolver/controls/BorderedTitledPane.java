package de.linesofcode.sudokusolver.controls;

import javafx.beans.DefaultProperty;
import javafx.beans.NamedArg;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

import java.util.List;

@DefaultProperty("Content")
public class BorderedTitledPane extends StackPane {

    private final Label title;
    private final StackPane contentPane;

    public BorderedTitledPane(@NamedArg("title") String titleString, @NamedArg("content") Node content) {
        title = new Label(" " + titleString + " ");
        title.getStyleClass().add("bordered-titled-title");
        StackPane.setAlignment(title, Pos.TOP_LEFT);

        contentPane = new StackPane();
        content.getStyleClass().add("bordered-titled-content");
        contentPane.getChildren().add(content);

        getStyleClass().add("bordered-titled-border");
        getChildren().addAll(title, contentPane);
    }

    public void setContent(List<Node> content) {
        contentPane.getChildren().clear();
        contentPane.getChildren().addAll(content);
    }

    public ObservableList<Node> getContent() {
        return contentPane.getChildren();
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }


}