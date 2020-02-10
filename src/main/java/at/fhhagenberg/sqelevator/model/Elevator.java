package at.fhhagenberg.sqelevator.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Elevator {
	
	public IntegerProperty weightProperty;
	public IntegerProperty speedProperty;
	public IntegerProperty numberProperty;
	public IntegerProperty elevatorPositionProperty;
	
	public StringProperty doorStatusProperty;
	 
	public BooleanProperty automaticProperty;
 
	private List<Integer> targets = new ArrayList<>();

	/**
	 * initialize string and integer properties
	 * @param number returns elevator number from elevator simulator 
	 * @since 1.0
	 */
	public Elevator(int number) {
		this.numberProperty = new SimpleIntegerProperty(number);
		this.weightProperty = new SimpleIntegerProperty(0);
		this.speedProperty = new SimpleIntegerProperty(0);
		this.elevatorPositionProperty = new SimpleIntegerProperty(0);
		this.doorStatusProperty = new SimpleStringProperty("Closed");
		automaticProperty = new SimpleBooleanProperty(false);

	}

	/**
	 * @return  number
	 * @since 1.0
	 */
	public int getNumber() {
		return numberProperty.get();
	} 

	/**
	 * Sets weight/payload of the elevator
	 * @since 1.0
	 */
	public void setWeight(int payload) {
		weightProperty.set(payload);
	}

	/**
	 * Sets speed of the elevator
	 * @since 1.0
	 */
	public void setSpeed(int speed) {
		speedProperty.set(speed);
	}

	/**
	 * @param doorStatus - integer value about the status of the door 
	 * Sets door status of the elevator
	 * @since 1.0
	 */
	public void setDoorStatus(int doorStatus) {
		String doorStatusString = "";

		switch (doorStatus) {
		case 1:
			doorStatusString = "Open";
			break;
		case 2:
			doorStatusString = "Closed";
		}

		doorStatusProperty.set(doorStatusString);
	}

	/**
	 * @return automatic mode
	 * @since 1.0
	 */
	public boolean getAutomatic() {
		return automaticProperty.get();
	}

	/**
	 * @param index - integer
	 * @param target - integer
	 * insert target destination
	 * @since 1.0
	 */
	public void insertTarget(int index, int target) {
		if (!targets.contains(target)) {
			if (targets.isEmpty() || index == -1) {
				targets.add(target);
			} else {
				targets.add(index, target);
			}
		}
	}

	/**
	 * @return next target value 
	 * @since 1.0
	 */
	public int getNextTarget() {
		if (!targets.isEmpty()) {
			return targets.get(0);
		} else {
			return -1;
		}
	}

	/**
	 * Removes target value 
	 * @since 1.0
	 */
	public void removeTargetFromList() {
		if (!targets.isEmpty()) {
			int currentFloor = targets.get(0);
			targets.remove(0);

			if (!targets.isEmpty()) {
				refresh(currentFloor, targets.get(0));
			}
		}

	}

	private void refresh(int currentFloor, int nextFloor) {
		List<Integer> targetsInBetween = new ArrayList<>();

		for (int i = 0; i < targets.size(); i++) {
			if (currentFloor < nextFloor && targets.get(i) > currentFloor && targets.get(i) < nextFloor) {
				targetsInBetween.add(targets.get(i));
				targets.remove(i);
			} else if (currentFloor > nextFloor && targets.get(i) < currentFloor && targets.get(i) > nextFloor) {
				targetsInBetween.add(targets.get(i));
				targets.remove(i);
			}
		}

		if (currentFloor < nextFloor) {
			Collections.sort(targetsInBetween);
		} else {
			Collections.sort(targetsInBetween, Collections.reverseOrder());
		}

		targets.addAll(0, targetsInBetween);
	}

	/**
	 * @param currentPosition - integer 
	 * sets current elevator position
	 * @since 1.0
	 */
	public void setCurrentElePosition(int currentPosition) {
		elevatorPositionProperty.set(currentPosition + 1);

	}
}
