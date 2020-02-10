package at.fhhagenberg.sqelevator;

import static org.junit.jupiter.api.Assertions.*;

import java.rmi.Naming;
import java.rmi.RemoteException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import sqelevator.IElevator;

class ElevatorFloorsManuelControllerTest {

	private static IElevator elevatorSystem;
	private int elevatorNumber;

	@BeforeAll
	public static void init() {
		try {
			elevatorSystem = (IElevator) Naming.lookup("rmi://localhost/ElevatorSim");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testNumberOfFloors() throws RemoteException {
		assertTrue(elevatorSystem.getFloorNum() == 10);
	}

	@Test
	public void testSetTarget() throws RemoteException, InterruptedException {
		assertEquals(0, elevatorSystem.getTarget(0));
		elevatorSystem.setTarget(0, 3);
		assertEquals(3, elevatorSystem.getTarget(0));

		elevatorSystem.setTarget(0, 5);
		assertEquals(5, elevatorSystem.getTarget(0));

		elevatorSystem.setTarget(0, 9);
		assertEquals(9, elevatorSystem.getTarget(0));

		elevatorSystem.setTarget(0, 12);
		assertEquals(9, elevatorSystem.getTarget(0));
		elevatorSystem.setTarget(0, 0);
	}

	@Test
	public void testFloorButtons() throws RemoteException, InterruptedException {
		elevatorSystem.setTarget(0, 8);
		Thread.sleep(1000);
		elevatorSystem.setTarget(0, 0);
		Thread.sleep(1000);
		assertFalse(elevatorSystem.getFloorButtonDown(0));
	}

}
