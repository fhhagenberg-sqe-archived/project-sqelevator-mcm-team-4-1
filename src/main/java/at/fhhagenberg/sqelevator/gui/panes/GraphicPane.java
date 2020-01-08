package at.fhhagenberg.sqelevator.gui.panes;

import at.fhhagenberg.sqelevator.gui.Util;
import at.fhhagenberg.sqelevator.gui.cells.ElevatorCell;
import at.fhhagenberg.sqelevator.gui.cells.InfoCell;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class GraphicPane extends GridPane {

    // TODO move floor names to config file
    private final String[] FLOOR_NAMES = {"Floor 4", "Floor 3", "Floor 2",
    "Floor 1", "Ground"};

    // TODO move to config file
    private final int FLOORS = 5;
    private final int ELEVATORS = 3;

    private ArrayList<InfoCell> infoCells = new ArrayList<>();
    private ArrayList<ArrayList<ElevatorCell>> elevatorCells = new ArrayList<>();

    public GraphicPane() {

        for (int i = 0; i < FLOORS + 1; i++) {
            this.getRowConstraints().add(Util.getMaxRowConstraint());
        }
        for (int i = 0; i < ELEVATORS + 1; i++) {
            this.getColumnConstraints().add(Util.getMaxColumnConstraint());
        }

        for (int i = 0; i < FLOORS; i++) {
            InfoCell cell = new InfoCell(FLOOR_NAMES[i]);
            cell.setBorder(Util.getBorder());
            infoCells.add(cell);
            cell.setAlignment(Pos.CENTER);
            this.add(cell, 0, i);
        }

        for (int i = 1; i <= ELEVATORS; i++) {
            elevatorCells.add(new ArrayList<>());
            for (int j = 0; j < FLOORS; j++) {
                ElevatorCell cell = new ElevatorCell();
                cell.setBorder(Util.getBorder());
                elevatorCells.get(i - 1).add(cell);
                cell.setAlignment(Pos.CENTER);
                this.add(cell, i, j);
            }
        }
    }

    public void updateCall(int elevator, int floor) {

    }

    public void updateHere(int elevator, int floor) {

    }
}
