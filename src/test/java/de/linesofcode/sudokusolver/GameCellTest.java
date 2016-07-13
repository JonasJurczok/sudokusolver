package de.linesofcode.sudokusolver;

import de.linesofcode.sudokusolver.controls.GameCell;
import de.linesofcode.sudokusolver.controls.NumberPane;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import org.junit.Test;

import java.util.Set;

import static java.lang.Integer.valueOf;
import static javafx.scene.input.MouseButton.PRIMARY;
import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GameCellTest extends ApplicationTest {

    @Test
    public void clickOnCellShouldMakeNumberPaneVisible() {
        GridPane gamePane = fx.lookup("#gamePane").queryFirst();

        Bounds gamePanelBounds = gamePane.localToScreen(gamePane.getBoundsInLocal());

        gamePane.getChildren().stream().forEach(cell -> {
            Integer columnIndex = GridPane.getColumnIndex(cell);
            Integer rowIndex = GridPane.getRowIndex(cell);
            String message = "Testing cell [" + columnIndex + ", " + rowIndex + "].";

            //click on the cell
            fx.clickOn(cell);
            Set<Node> nodes = fx.lookup("#numberPane").queryAll();
            assertThat(message, nodes.size(), is(1));
            nodes.forEach(node -> assertThat(node.isVisible(), is(true)));

            // check that the panel is shown directly below the cell
            Bounds cellBounds = cell.localToScreen(cell.getBoundsInLocal());
            Node numberPane = fx.lookup("#numberPane").queryFirst();
            Bounds numberPaneBounds = numberPane.localToScreen(numberPane.getBoundsInLocal());

            assertThat(message, numberPaneBounds.getMinX(), is(cellBounds.getMinX()));
            assertThat(message, numberPaneBounds.getMinY(), is(both(greaterThan(cellBounds.getMaxY() - 4)).and(lessThan(cellBounds.getMaxY() + 4))));

            // click outside of the number pane
            fx.clickOn(gamePanelBounds.getMinX(), gamePanelBounds.getMinY(), PRIMARY);
            assertThat(message, fx.lookup("#numberPane").queryAll().size(), is(0));
        });
    }

    @Test
    public void numberPaneShouldBeOfCorrectClass() {
        GridPane gamePane = fx.lookup("#gamePane").queryFirst();
        Node cell = gamePane.getChildren().get(0);
        fx.clickOn(cell);

        Node node = fx.lookup("#numberPane").queryFirst();

        assertThat(node, is(instanceOf(NumberPane.class)));
    }

    @Test
    public void clickNumberPaneShouldSetCellValue() {
        GridPane gamePane = fx.lookup("#gamePane").queryFirst();
        GameCell cell = (GameCell) gamePane.getChildren().get(0);

        for (int i= 0; i < 9; i++) {
            fx.clickOn(cell);

            GridPane numberPane = fx.lookup("#numberPane").queryFirst();
            Label numberPaneCell = (Label) numberPane.getChildren().get(i);
            fx.clickOn(numberPaneCell);

            assertThat(cell.getValue(), is(valueOf(numberPaneCell.getText())));
        }
    }

}
