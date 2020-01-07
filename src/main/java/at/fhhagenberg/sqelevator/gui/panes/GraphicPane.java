package at.fhhagenberg.sqelevator.gui.panes;

import at.fhhagenberg.sqelevator.gui.Util;
import at.fhhagenberg.sqelevator.gui.cells.ElevatorCell;
import at.fhhagenberg.sqelevator.gui.cells.InfoCell;
import javafx.geometry.Insets;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.LinkedList;

public class GraphicPane extends GridPane {

    // TODO move to config file
    private final int FLOORS = 5;
    private final int ELEVATORS = 3;

    private TableView<Pane> tableView = new TableView<>();

    public GraphicPane() {

        VBox detailBox = Util.getCenterBox(tableView);
        this.add(detailBox, 0, 0);

        TableColumn<String, InfoCell> infoColumn = new TableColumn<>("Info");
        LinkedList<InfoCell> infoCells = new LinkedList<>();
        for (int i = FLOORS - 1; i >= 0; i--) {
            InfoCell infoCell = new InfoCell(String.valueOf(i));
            infoCells.add(infoCell);
            infoColumn.setCellFactory(cell -> infoCell);
        }

        LinkedList<LinkedList<ElevatorCell>> elevatorCells = new LinkedList<>();
        for (int i = 0; i < FLOORS; i++) {
            elevatorCells.add(new LinkedList<ElevatorCell>());
            TableColumn<String, ElevatorCell> elevatorColumn = new TableColumn<>("Elevator");
            for (int j = 0; j < ELEVATORS; j++) {
                ElevatorCell elevatorCell = new ElevatorCell();
                elevatorCells.get(i).add(elevatorCell);
                elevatorColumn.setCellFactory(cell -> elevatorCell);
            }
        }
    }
}
