package at.fhhagenberg.sqelevator.gui.cells;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class ElevatorCell extends CustomCell {

    private Button call = new Button("Call");
    private Button here = new Button("Here");

    public ElevatorCell() {

        Pane pane = new Pane();
        VBox.setVgrow(pane, Priority.ALWAYS);
        HBox.setHgrow(pane, Priority.ALWAYS);
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(call, here);
        //here.setVisible(false);
        here.setDisable(true);
        //call.setVisible(false);
        call.setDisable(true);
        this.getChildren().addAll(pane, vBox);
    }

    public void setHere(boolean here) {
        if (here) {
            this.here.setVisible(true);
        } else {
            this.here.setVisible(false);
        }
    }

    public void setCall(boolean call) {
        if (call) {
            this.call.setVisible(true);
        } else {
            this.call.setVisible(false);
        }
    }
}
