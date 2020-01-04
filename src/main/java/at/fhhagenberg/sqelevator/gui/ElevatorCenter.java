package at.fhhagenberg.sqelevator.gui;

 import at.fhhagenberg.sqelevator.gui.panes.ControlPane;
 import javafx.application.Application;
 import javafx.scene.Scene;
 import javafx.scene.layout.BorderPane;
 import javafx.stage.Stage;

 public class ElevatorCenter extends Application {

     private ControlPane controlPane = new ControlPane();

     @Override
     public void start(Stage stage) throws Exception {

         BorderPane root = new BorderPane();
         root.setMinWidth(1280);
         root.setMinHeight(720);
         root.setBottom(controlPane);


         Scene scene = new Scene(root);

         stage.setTitle("sqelevator");
         stage.setScene(scene);

         stage.show();
     }
 }