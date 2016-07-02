package de.linesofcode.sudokusolver;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        URL resource = getClass().getResource("Main.fxml");
        Parent parent = FXMLLoader.<Parent>load(resource);

        primaryStage.setTitle("Sudoku Solver");
        primaryStage.setScene(new Scene(parent));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
