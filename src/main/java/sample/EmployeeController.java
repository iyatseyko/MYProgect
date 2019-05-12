package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import sample.EmployeeCreation.EmployeeRun;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class EmployeeController implements Initializable {

    @FXML
    private Label result;

    @FXML
    private TextField emp_text;

    @FXML private javafx.scene.control.Button closeButton;


    public void setRes (ActionEvent event) {
            result.setText(EmployeeRun.runEmployee(emp_text.getText()));
        }

        public void clickBack (ActionEvent event) throws IOException {
            Controller.openWindow(event, "sample");
        }

        @FXML
        private void closeButtonAction(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

        @Override
        public void initialize(URL location, ResourceBundle resources) {
            emp_text.addEventFilter(KeyEvent.KEY_TYPED , numeric_Validation(225));
        }

        public EventHandler<KeyEvent> numeric_Validation(final Integer max_Lengh) {
            return new EventHandler<KeyEvent>() {

                @Override
                public void handle(KeyEvent e) {

                    TextField txt_TextField = (TextField) e.getSource();

                    if (txt_TextField.getText().length() >= max_Lengh) {
                        e.consume();
                    }
                    if(!e.getCharacter().matches("[aA-zZ]")){
                        e.consume();
                    }
                }
            };
        }

}
