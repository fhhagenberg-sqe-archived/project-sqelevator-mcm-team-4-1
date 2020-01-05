package at.fhhagenberg.sqelevator.gui.panes;

import at.fhhagenberg.sqelevator.gui.Util;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

/**
 * Pane that contains the elevator details and manual floor buttons
 */
public class ControlPane extends GridPane {

    // TODO move button labels to config file
    private String[] buttons = {"4", "3", "2", "1", "0"};

    private DetailPane detailPane = new DetailPane();
    private ButtonPane buttonPane = new ButtonPane(buttons);

    public ControlPane() {

        // scuffed column spacing
        ColumnConstraints column = new ColumnConstraints();
        column.setHgrow(Priority.ALWAYS);
        this.getColumnConstraints().addAll(column, column);

        VBox detailBox = Util.getCenterBox(detailPane);
        detailPane.prefWidthProperty().bind(detailBox.widthProperty());
        detailPane.prefHeightProperty().bind(detailBox.heightProperty());
        detailPane.setHgap(5);
        detailPane.setVgap(5);
        detailPane.setPadding(new Insets(5,5,5,5));
        this.add(detailBox, 0, 0);

        VBox buttonBox = Util.getCenterBox(buttonPane);
        buttonPane.prefWidthProperty().bind(buttonBox.widthProperty());
        buttonPane.prefHeightProperty().bind(buttonBox.heightProperty());
        buttonPane.setHgap(5);
        buttonPane.setVgap(5);
        buttonPane.setPadding(new Insets(5,5,5,5));
        this.add(buttonBox, 1, 0);
    }

    // TODO check how API value updates are provided
    public void update(int position, String direction, String floor, int speed,
                       String door, String target, int weight, int acceleration) {
        detailPane.update(position, direction, floor, speed,
        door, target, weight, acceleration);
    }

    // TODO edit layout
    protected class DetailPane extends GridPane {

        private int position = 0;
        private String direction = "NaN";
        private String floor = "NaN";
        private int speed = 0;
        private String door = "NaN";
        private String target = "NaN";
        private int weight = 0;
        private int acceleration = 0;

        private Text positionField = new Text();
        private Text directionField = new Text();
        private Text floorField = new Text();
        private Text speedField = new Text();
        private Text doorField = new Text();
        private Text targetField = new Text();
        private Text weightField = new Text();
        private Text accelerationField = new Text();

        private final int columns = 2;
        private final int rows = 8;

        public DetailPane() {

            for (int i = 0; i < rows; i++) {
                this.getRowConstraints().add(Util.getMaxRowConstraint());
            }
            for (int i = 0; i < columns; i++) {
                this.getColumnConstraints().add(Util.getMaxColumnConstraint());
            }

            // TODO create strings config
            this.add(new Text("Elevator position\t"), 0, 0);
            this.add(new Text("Direction\t"), 0, 1);
            this.add(new Text("Elevator floor\t"), 0, 2);
            this.add(new Text("Speed\t"), 0, 3);
            this.add(new Text("Status of door\t"), 0, 4);
            this.add(new Text("Target\t"), 0, 5);
            this.add(new Text("Weight\t"), 0, 6);
            this.add(new Text("Acceleration\t"), 0, 7);


            this.add(positionField, 1, 0);
            this.add(directionField, 1, 1);
            this.add(floorField, 1, 2);
            this.add(speedField, 1, 3);
            this.add(doorField, 1, 4);
            this.add(targetField, 1, 5);
            this.add(weightField, 1, 6);
            this.add(accelerationField, 1, 7);

            redraw();
        }

        private void update(int position, String direction, String floor, int speed,
                           String door, String target, int weight, int acceleration) {
            // TODO check values
            this.position = position;
            this.direction = direction;
            this.floor = floor;
            this.speed = speed;
            this.door = door;
            this.target = target;
            this.weight = weight;
            this.acceleration = acceleration;
        }

        private void redraw() {
            this.positionField.setText(position + " m");
            this.directionField.setText(direction);
            this.floorField.setText(floor);
            this.speedField.setText(speed + " m/s");
            this.doorField.setText(door);
            this.targetField.setText(target);
            this.weightField.setText(weight + " kg");
            this.accelerationField.setText(acceleration + " m/s");
        }
    }

    protected class ButtonPane extends GridPane {

        private final int columns = 2;

        public ButtonPane(String[] buttons) {

            for (int i = 0; i < Math.ceil((double)buttons.length / 2.00); i++) {
                this.getRowConstraints().add(Util.getMaxRowConstraint());
            }
            for (int i = 0; i < columns; i++) {
                this.getColumnConstraints().add(Util.getMaxColumnConstraint());
            }

            int r = 0;
            int c = 0;
            for (String s : buttons) {
                Button button = Util.getMaxButton(s);
                this.add(button, c, r);
                if (c == 1) r++;
                c = c == 0 ? 1 : 0;

                button.setOnAction(actionEvent -> {
                    System.out.println("Button " + button.getText() + " pressed");
                });
            }
        }
    }
}
