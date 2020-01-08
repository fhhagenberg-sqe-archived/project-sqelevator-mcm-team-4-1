package at.fhhagenberg.sqelevator.gui;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class Util {

    /**
     * Some method to get a center layout for nodes
     * @return centered VBox with nested centered HBox
     */
    public static VBox getCenterBox(Node node) {
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        vBox.getChildren().add(hBox);
        hBox.getChildren().add(node);
        vBox.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        return vBox;
    }

    public static RowConstraints getMaxRowConstraint() {
        RowConstraints rc = new RowConstraints();
        rc.setVgrow(Priority.ALWAYS) ; // allow row to grow
        rc.setFillHeight(true); // ask nodes to fill height for row
        return rc;
    }

    public static ColumnConstraints getMaxColumnConstraint() {
        ColumnConstraints cc = new ColumnConstraints();
        cc.setHgrow(Priority.ALWAYS) ; // allow column to grow
        cc.setFillWidth(true); // ask nodes to fill space for column
        return cc;
    }

    public static Button getMaxButton(String text) {
        Button button = new Button(text);
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        //button.setStyle("-fx-focus-color: transparent; -fx-faint-focus-color: transparent;");
        return button;
    }

    public static Border getBorder() {
        return new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
    }
}
