package at.fhhagenberg.sqelevator;

import static org.junit.jupiter.api.Assertions.*;

import java.rmi.RemoteException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import sqelevator.IElevator;

class ElevatorPanelTest {

	private static IElevator elevatorSystem;
	private final static int FLOORNUMBER = 4;
	private final static int ELEVATORNUMBER = 2;

	@BeforeAll
	public static void init() {
		elevatorSystem = new ElevatorSystemMock(FLOORNUMBER, ELEVATORNUMBER);
	}

	@Test
	public void testGetTarget() throws RemoteException {
		assertEquals(5, elevatorSystem.getTarget(0));
	}

	@Test
	public void testSetTarget() throws RemoteException {
		elevatorSystem.setTarget(0, 3);
		assertEquals(3, elevatorSystem.getTarget(0));

		elevatorSystem.setTarget(0, 5);
		assertEquals(5, elevatorSystem.getTarget(0));
	}

	@Test
	public void testCommitedDirection() throws RemoteException {
		assertEquals(0, elevatorSystem.getCommittedDirection(0));
		assertEquals(0, elevatorSystem.getCommittedDirection(1));
	}

	@Test
	public void testAcceleration() throws RemoteException {
		assertEquals(5, elevatorSystem.getElevatorAccel(0));
		assertEquals(5, elevatorSystem.getElevatorAccel(1));
	}

	@Test
	public void testDoorStatus() throws RemoteException {
		assertEquals(1, elevatorSystem.getElevatorDoorStatus(0));
		assertEquals(1, elevatorSystem.getElevatorDoorStatus(1));
	}

	@Test
	public void testFloorNumber() throws RemoteException {
		assertEquals(FLOORNUMBER, elevatorSystem.getFloorNum());
	}

	@Test
	public void testSpeed() throws RemoteException {
		assertEquals(2, elevatorSystem.getElevatorSpeed(0));
		assertEquals(2, elevatorSystem.getElevatorSpeed(1));
	}

	@Test
	public void testWeight() throws RemoteException {
		assertEquals(100, elevatorSystem.getElevatorWeight(0));
		assertEquals(100, elevatorSystem.getElevatorWeight(1));
	}

	@Test
	public void testTime() throws RemoteException {
		assertNotEquals(elevatorSystem.getClockTick(), elevatorSystem.getClockTick());

	}



}
