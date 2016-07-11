package de.linesofcode.sudokusolver;

import javafx.stage.Stage;
import org.junit.Before;
import org.junit.BeforeClass;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;

import java.util.concurrent.TimeoutException;

import static org.testfx.api.FxToolkit.registerPrimaryStage;
import static org.testfx.api.FxToolkit.setupStage;

public class ApplicationTest {
    protected static Stage primaryStage;
    protected FxRobot fx = new FxRobot();

    @BeforeClass
    public static void setupSpec() throws Exception {
        primaryStage = registerPrimaryStage();
        setupStage(Stage::show);
    }

    @Before
    public void setup() throws TimeoutException {
        FxToolkit.setupApplication(Main.class);
    }
}
