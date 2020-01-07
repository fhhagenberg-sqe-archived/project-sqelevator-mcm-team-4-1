package at.fhhagenberg.sqelevator.gui.cells;

import javafx.scene.control.TableCell;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

public class InfoCell extends TableCell {

    public InfoCell(String description) {

        Text sample = new Text(description);
        this.getChildren().add(sample);
    }
}
