package at.fhhagenberg.sqelevator.views;

import java.rmi.RemoteException;

import at.fhhagenberg.sqelevator.ElevatorExample;
import at.fhhagenberg.sqelevator.model.Floor;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import sqelevator.IElevator;

public class ElevatorFloorsListViewCell extends ListCell<Floor> {

	private IElevator elevatorSystem;
	private int elevatorNumber;
	 
	public ElevatorFloorsListViewCell(IElevator elevatorSystem, int elevatorNumber) {
		this.elevatorSystem = elevatorSystem;
		this.elevatorNumber = elevatorNumber;
	}
	 
	@Override
	public void updateItem(Floor floor, boolean empty) {
		super.updateItem(floor, empty);
		
		if (empty) {
			setText(null);
			setGraphic(null);
		} else {	
			 try {
				setText(null);
	            HBox root = new HBox();
	            root.setPadding(new Insets(0, 10, 0, 10));
	            root.setAlignment(Pos.CENTER);

	            Image img;
	            if(elevatorSystem.getElevatorButton(elevatorNumber, floor.getFloorNumber())) {
	            	img = new Image(ElevatorExample.class.getClassLoader().getResource("images/lamp_on.png").toString());
	            } else {
	            	img = new Image(ElevatorExample.class.getClassLoader().getResource("images/lamp_off.png").toString());
	            }
	            
	            Image floorStatus = null;
				floorStatus = elevatorTarget(floor, floorStatus);
				
	            ImageView elevatorFloorStatus = new ImageView(floorStatus);
	            elevatorFloorStatus.setFitHeight(25);
	            elevatorFloorStatus.setFitWidth(25);
	            root.getChildren().addAll(elevatorFloorStatus);
	            
	            ImageView lamp = new ImageView(img);
	            lamp.setFitHeight(25);
	            lamp.setFitWidth(25);
	            root.getChildren().addAll(lamp);
	 
	            setGraphic(root);
	            
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param floor
	 * @param floorStatus
	 * @return
	 * @throws RemoteException
	 */
	private Image elevatorTarget(Floor floor, Image floorStatus) throws RemoteException {
		if(elevatorSystem.getElevatorFloor(elevatorNumber) == floor.getFloorNumber()) {
			if(elevatorSystem.getTarget(elevatorNumber) == floor.getFloorNumber()) {
				floorStatus = new Image(ElevatorExample.class.getClassLoader().getResource("images/elevator_arrived.png").toString());
			}
			else if(elevatorSystem.getTarget(elevatorNumber) < floor.getFloorNumber()) {
			    floorStatus = new Image(ElevatorExample.class.getClassLoader().getResource("images/elevator_moving_down.png").toString());
			}
		    else if(elevatorSystem.getTarget(elevatorNumber) > floor.getFloorNumber()) {
		    	floorStatus = new Image(ElevatorExample.class.getClassLoader().getResource("images/elevator_moving_up.png").toString());
		    }
		} else {
			floorStatus = new Image(ElevatorExample.class.getClassLoader().getResource("images/elevator_not_moving.png").toString());
		}
		return floorStatus;
	}

	public int getElevatorNumber() {
		return elevatorNumber;
	}

	public void setElevatorNumber(int elevatorNumber) {
		this.elevatorNumber = elevatorNumber;
	}
}
