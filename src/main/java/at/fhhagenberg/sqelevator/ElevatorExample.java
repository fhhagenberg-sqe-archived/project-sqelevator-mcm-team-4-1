package at.fhhagenberg.sqelevator;

import java.rmi.Naming;
import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import at.fhhagenberg.sqelevator.controller.ElevatorControlPanel;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sqelevator.IElevator;

public class ElevatorExample extends Application {

	private static final int WINDOW_HEIGHT = 800;
	private static final int WINDOW_WIDTH = 1000;

	private IElevator elevatorSystem;
	private ElevatorControlPanel controlPanel;

	public static ScheduledExecutorService pollingExecutor;

	public ElevatorExample() {
		rmiSimulatorConnection();
	}
	
	private void rmiSimulatorConnection() {
		try {
			elevatorSystem = (IElevator) Naming.lookup("rmi://localhost/ElevatorSim");
		} catch (Exception e) {
			alertConnectionFailed();
		}
	}

	public ElevatorExample(IElevator elevatorSystem) {
		this.elevatorSystem = elevatorSystem;
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("layouts/elevator_control_center.fxml"));
			Pane root = fxmlLoader.load();

			controlPanel = fxmlLoader.<ElevatorControlPanel>getController();
			controlPanel.init(elevatorSystem);

			Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
			scene.getStylesheets().add(getClass().getClassLoader().getResource("application.css").toExternalForm());

			primaryStage.setTitle("Elevator Control Panel");
			primaryStage.setMinWidth(WINDOW_WIDTH);
			primaryStage.setMinHeight(WINDOW_HEIGHT);
			primaryStage.setScene(scene);
			primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				public void handle(WindowEvent we) {
					System.exit(0);
				}
			});
			primaryStage.show();

			startPolling();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void alertConnectionFailed() {
		Alert alert = new Alert(AlertType.CONFIRMATION);

		alert.setTitle("Connection failed!");
		alert.setHeaderText("The simulator connection failed!");
		alert.setContentText("Do you want to retry? :(");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			rmiSimulatorConnection();
		} else {
			System.exit(0);
		}
	}

	private void startPolling() {
		Runnable pollingRunnable = new Runnable() {
			public void run() {
				Platform.runLater(controlPanel.updateRunnable);
			}
		};

		pollingExecutor = Executors.newScheduledThreadPool(1);
		pollingExecutor.scheduleAtFixedRate(pollingRunnable, 0, 100, TimeUnit.MILLISECONDS);
	}
	
	public static void main(String[] args) {
	    launch();
	  }
}
