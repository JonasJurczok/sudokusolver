package de.linesofcode.sudokusolver;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.base.NodeMatchers.isVisible;

public class MainTest extends ApplicationTest {

    @Test
    public void shouldBeStarted() {
        verifyThat(primaryStage.getTitle(), is("Sudoku Solver"));
    }

    @Test
    public void mainPanelShouldBeVisibile() {
        verifyThat("#mainPanel", isVisible());
    }

    @Test
    public void controlPanelShouldBeVisible() {
        verifyThat("#controlPanel", isVisible());
    }

}
