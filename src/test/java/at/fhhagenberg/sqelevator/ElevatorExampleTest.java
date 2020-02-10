package at.fhhagenberg.sqelevator;

import static org.junit.jupiter.api.Assertions.*;

import java.rmi.Naming;

import org.junit.jupiter.api.Test;

import at.fhhagenberg.sqelevator.model.Elevator;
import sqelevator.IElevator;

class ElevatorExampleTest {
	private static IElevator elevatorSystem;
	
	@Test
	public void testRMIConnection() throws Exception {
		try {
			ElevatorExample.rmiSimulatorConnection();
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
	}
	
	@Test
	public void testAlertConnectionFail() throws Exception {
		
		try {
			elevatorSystem = (IElevator) Naming.lookup("rmi://localhost/");
			ElevatorExample.alertConnectionFailed();
		} catch (Exception e) {
			assertTrue(true);
		}
	}
}
