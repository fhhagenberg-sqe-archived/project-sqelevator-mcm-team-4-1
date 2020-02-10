package at.fhhagenberg.sqelevator.model;

public class Floor {
	
	private int number;
	
	/**
	 * @param number returns floor number 
	 * @since 1.0
	 */
	public Floor(int number) {
		this.number = number;
	}
	 
	/**
	 * @return floor number
	 * @since 1.0
	 */
	public int getFloorNumber() {
		return number;
	}
}
