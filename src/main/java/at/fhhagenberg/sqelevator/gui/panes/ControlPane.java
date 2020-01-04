package at.fhhagenberg.sqelevator.gui.panes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 * Pane that contains the elevator details and manual floor buttons
 */
public class ControlPane extends FlowPane {

    private DetailPane detailPane = new DetailPane();
    private ButtonPane buttonPane = new ButtonPane();

    public ControlPane() {

        this.getChildren().add(detailPane);
        this.getChildren().add(buttonPane);
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

        public DetailPane() {

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

        //TODO rework string concatenation
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

        // TODO dynamic button creation?
        public ButtonPane(/*String[] buttons*/) {
            Button button0 = new Button("0");
            Button button1 = new Button("1");
            Button button2 = new Button("2");
            Button button3 = new Button("3");
            Button button4 = new Button("4");

            this.add(button4, 0, 0);
            this.add(button3, 1, 0);
            this.add(button2, 0, 1);
            this.add(button1, 1, 1);
            this.add(button0, 0, 2);

            // TODO connect to controller
            button4.setOnAction(actionEvent -> {
                System.out.println("Button 4 pressed");
            });
            button3.setOnAction(actionEvent -> {
                System.out.println("Button 3 pressed");
            });
            button2.setOnAction(actionEvent -> {
                System.out.println("Button 2 pressed");
            });
            button1.setOnAction(actionEvent -> {
                System.out.println("Button 1 pressed");
            });
            button0.setOnAction(actionEvent -> {
                System.out.println("Button 0 pressed");
            });
        }
    }
}
