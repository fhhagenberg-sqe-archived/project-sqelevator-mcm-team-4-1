package at.fhhagenberg.sqelevator.gui.cells;


import javafx.scene.control.Label;

public class AlertCell extends CustomCell {

    private Label text = new Label();

    public AlertCell(String text) {

        this.getChildren().add(this.text);

        this.text.setText(text);
    }
}
