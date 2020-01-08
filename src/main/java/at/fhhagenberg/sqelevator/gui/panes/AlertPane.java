package at.fhhagenberg.sqelevator.gui.panes;

import at.fhhagenberg.sqelevator.gui.Util;
import at.fhhagenberg.sqelevator.gui.cells.AlertCell;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class AlertPane extends VBox {

    // TODO move to config file
    public static final int PREF_WIDTH = 200;

    private ListView<AlertCell> listView = new ListView<>();

    public AlertPane() {

        this.setAlignment(Pos.CENTER);
        this.setBorder(Util.getBorder());
        listView.setPrefWidth(PREF_WIDTH);
        listView.getItems().add(new AlertCell("sample alert"));

        Pane pane = new Pane();
        VBox.setVgrow(pane, Priority.ALWAYS);
        Pane pane2 = new Pane();
        VBox.setVgrow(pane2, Priority.ALWAYS);
        ToggleButton toggleButton = new ToggleButton("Manual Mode");
        this.getChildren().addAll(listView, pane, toggleButton, pane2);
        //this.getChildren().addAll(listView, toggleButton);
    }
}
