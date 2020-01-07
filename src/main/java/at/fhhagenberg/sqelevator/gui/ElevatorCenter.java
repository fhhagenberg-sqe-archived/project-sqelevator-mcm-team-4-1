package at.fhhagenberg.sqelevator.gui;

 import at.fhhagenberg.sqelevator.gui.panes.AlertPane;
 import at.fhhagenberg.sqelevator.gui.panes.ControlPane;
 import at.fhhagenberg.sqelevator.gui.panes.GraphicPane;
 import javafx.application.Application;
 import javafx.scene.Scene;
 import javafx.scene.layout.BorderPane;
 import javafx.scene.layout.VBox;
 import javafx.stage.Stage;

 public class ElevatorCenter extends Application {

     private GraphicPane graphicPane = new GraphicPane();
     private ControlPane controlPane = new ControlPane();
     private AlertPane alertPane = new AlertPane();

     @Override
     public void start(Stage stage) throws Exception {

         BorderPane borderPane = new BorderPane();
         borderPane.setMinWidth(500);
         borderPane.setMinHeight(700);
         borderPane.setBottom(controlPane);
         borderPane.setCenter(graphicPane);
         borderPane.setRight(alertPane);


         Scene scene = new Scene(borderPane);

         stage.setTitle("sqelevator");
         stage.setScene(scene);

         stage.show();
     }
 }