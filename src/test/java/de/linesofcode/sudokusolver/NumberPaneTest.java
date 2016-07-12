package de.linesofcode.sudokusolver;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class NumberPaneTest extends ApplicationTest {

    @Test
    public void allNumbersShouldBeVisible() {
        GridPane gamePane = fx.lookup("#gamePane").queryFirst();
        Node cell = gamePane.getChildren().get(0);
        fx.clickOn(cell);

        GridPane numberPane = fx.lookup("#numberPane").queryFirst();

        List<Integer> values = Lists.newArrayList(1,2,3,4,5,6,7,8,9);

        numberPane.getChildren().stream().forEach(child -> {
            Label label = (Label) child;
            Integer value = Integer.valueOf(label.getText());

            assertThat(values, hasItem(value));
            values.remove(value);
        });

        String joinedValues = Joiner.on(",").join(values);
        assertThat("Expected empty list but got [" + joinedValues + "]. These values could not be found in the NumberPane", values.size(), is(0));
    }

    @Test
    public void allNumberShouldHaveCorrectCSSClass() {
        GridPane gamePane = fx.lookup("#gamePane").queryFirst();
        Node cell = gamePane.getChildren().get(0);
        fx.clickOn(cell);

        GridPane numberPane = fx.lookup("#numberPane").queryFirst();
        numberPane.getChildren().stream().forEach(numberCell -> assertThat(numberCell.getStyleClass(), hasItem("numberPaneCell")));
    }

    @Test
    public void numberPaneShouldHaveCorrectCSSClass() {
        GridPane gamePane = fx.lookup("#gamePane").queryFirst();
        Node cell = gamePane.getChildren().get(0);
        fx.clickOn(cell);

        GridPane numberPane = fx.lookup("#numberPane").queryFirst();
        assertThat(numberPane.getStyleClass(), hasItem("numberPane"));
    }

    @Test
    public void clickingANumberShouldCloseNumberPane() {
        GridPane gamePane = fx.lookup("#gamePane").queryFirst();
        Node cell = gamePane.getChildren().get(0);

        for (int i= 0; i < 9; i++) {
            fx.clickOn(cell);

            GridPane numberPane = fx.lookup("#numberPane").queryFirst();
            Node numberPaneCell = numberPane.getChildren().get(i);
            fx.clickOn(numberPaneCell);

            assertThat(fx.lookup("#numberPane").queryAll(), is(empty()));
        }
    }

}
