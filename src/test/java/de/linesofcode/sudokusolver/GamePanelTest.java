package de.linesofcode.sudokusolver;

import de.linesofcode.sudokusolver.controls.GameCell;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.base.NodeMatchers.isVisible;

public class GamePanelTest extends ApplicationTest {

    @Test
    public void gamePaneShouldBeVisible() {
        verifyThat("#gamePane", isVisible());
    }

    @Test
    public void verifyAllCellsVisible() {

        int[] cols = {0,0,0,0,0,0,0,0,0};
        int[] rows = {0,0,0,0,0,0,0,0,0};

        GridPane gamePane = fx.lookup("#gamePane").queryFirst();
        gamePane.getChildren().stream().forEach(cell -> {
            Integer columnIndex = GridPane.getColumnIndex(cell);
            cols[columnIndex] += 1;

            Integer rowIndex = GridPane.getRowIndex(cell);
            rows[rowIndex] += 1;
        });

        for (int i = 0; i < 9; i++) {
            assertThat("Row [" + i + "] not complete.", rows[i], is(9));
            assertThat("Col [" + i + "] not complete.", cols[i], is(9));
        }
    }

    @Test
    public void verifyCellCSSClass() {
        GridPane gamePane = fx.lookup("#gamePane").queryFirst();

        ObservableList<Node> children = gamePane.getChildren();
        assertThat(children.size(), is(greaterThan(0)));

        Node node = children.get(0);

        assertThat(node, is(instanceOf(GameCell.class)));

        GameCell cell = (GameCell) node;

        assertThat(cell.getStylesheets(), contains(containsString("GameCell.css")));
    }

    @Test
    public void verifyAllCellsAreCorrectType() {
        GridPane gamePane = fx.lookup("#gamePane").queryFirst();
        gamePane.getChildren().stream().forEach(cell -> {
            Integer columnIndex = GridPane.getColumnIndex(cell);

            Integer rowIndex = GridPane.getRowIndex(cell);

            assertThat("GameCell at [" + columnIndex + "," + rowIndex + "] is of invalid type.", cell, is(instanceOf(GameCell.class)));
        });

    }
}
