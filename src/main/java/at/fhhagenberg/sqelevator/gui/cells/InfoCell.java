package at.fhhagenberg.sqelevator.gui.cells;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class InfoCell extends CustomCell {

    private Label name = new Label();
    private Button up = new Button("▲");
    private Button down = new Button("▼");

    public InfoCell(String name) {
        this.name.setText(name);
        Pane pane = new Pane();
        HBox.setHgrow(pane, Priority.ALWAYS);
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(up, down);
        up.setDisable(true);
        down.setDisable(true);
        this.getChildren().addAll(this.name, pane, vBox);
    }
}
