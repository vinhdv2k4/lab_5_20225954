package hust.soict.dsai.javafx;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {    
   
        @FXML
        private VBox drawingAreaPane;
        @FXML
        private RadioButton penRadioButton;
        @FXML
        private RadioButton eraserRadioButton;
        @FXML
        private ToggleGroup identical;
        @FXML
        void clearButtonPressed(ActionEvent event) {
            drawingAreaPane.getChildren().clear();
        }
        @FXML
        void drawingAreaMouseDragged(MouseEvent event) {
           try{ Circle newcircle ;
        if(eraserRadioButton.isSelected()){
            newcircle = new Circle(event.getX(), event.getY(),4,Color.WHITE);
        }
        else{
            newcircle = new Circle(event.getX(), event.getY(),4,Color.BLACK);
    }
        drawingAreaPane.getChildren().add(newcircle);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
    
