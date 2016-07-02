package de.linesofcode.sudokusolver;

import javafx.stage.Stage;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.api.FxAssert;
import org.testfx.api.FxToolkit;
import org.testfx.matcher.base.NodeMatchers;

import java.util.concurrent.TimeoutException;

import static org.hamcrest.core.Is.is;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.api.FxToolkit.registerPrimaryStage;
import static org.testfx.api.FxToolkit.setupStage;
import static org.testfx.matcher.base.NodeMatchers.isVisible;

public class MainTest {

    private static Stage primaryStage;

    @BeforeClass
    public static void setupSpec() throws Exception {
        primaryStage = registerPrimaryStage();
        setupStage(Stage::show);
    }
    @Before
    public void setup() throws TimeoutException {
        FxToolkit.setupApplication(Main.class);
    }

    @Test
    public void shouldBeStarted() {
        verifyThat(primaryStage.getTitle(), is("Sudoku Solver"));
    }

    @Test
    public void mainPanelShouldBeVisibile() {
        verifyThat("#mainPanel", isVisible());
    }

    @Test
    public void gamePaneShouldBeVisible() {
        verifyThat("#gamePane", isVisible());
    }

    @Test
    public void controlPanelShouldBeVisible() {
        verifyThat("#controlPanel", isVisible());
    }

}
