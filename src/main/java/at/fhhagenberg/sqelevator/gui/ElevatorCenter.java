package at.fhhagenberg.sqelevator.gui;

 import at.fhhagenberg.sqelevator.gui.panes.ControlPane;
 import javafx.application.Application;
 import javafx.scene.Scene;
 import javafx.scene.layout.BorderPane;
 import javafx.scene.layout.VBox;
 import javafx.stage.Stage;

 public class ElevatorCenter extends Application {

     private ControlPane controlPane = new ControlPane();

     @Override
     public void start(Stage stage) throws Exception {

         BorderPane borderPane = new BorderPane();
         borderPane.setMinWidth(500);
         borderPane.setMinHeight(700);
         borderPane.setBottom(controlPane);


         Scene scene = new Scene(borderPane);

         stage.setTitle("sqelevator");
         stage.setScene(scene);

         stage.show();
     }
 }