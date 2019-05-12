package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import sample.MathOperations.MathOperation;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MathController implements Initializable {


    @FXML
    private TextField a_text;

    @FXML
    private Label result;

    @FXML private javafx.scene.control.Button closeButton;

    public void clickBack (ActionEvent event) throws IOException {
        Controller.openWindow(event, "sample");
    }

    @FXML
    private void closeButtonAction(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public List<Double>  parseData (ActionEvent event) {
        List<Double> integers = new ArrayList();
        String [] a = a_text.getText().split("," );
        for(String b : a){
           integers.add(Double.parseDouble(b));
        }
        return integers;
    }

    public void clickMin (ActionEvent event) {
        if (a_text.getText().isEmpty()) {
            result.setText("Please, type numbers");
            return;
        }
        result.setText((MathOperation.min(parseData(event)).toString()));
    }

    public void clickMax (ActionEvent event) {
        if (a_text.getText().isEmpty()) {
            result.setText("Please, type numbers");
            return;
        }
        result.setText((MathOperation.max(parseData(event)).toString()));
    }

    public void clickAverage (ActionEvent event) {
        if (a_text.getText().isEmpty()) {
            result.setText("Please, type numbers");
            return;
        }
        result.setText((MathOperation.average(parseData(event)).toString()));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        a_text.addEventFilter(KeyEvent.KEY_TYPED , numeric_Validation(225));

    }

    public EventHandler<KeyEvent> numeric_Validation(final Integer max_Lengh) {
        return new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent e) {

                TextField txt_TextField = (TextField) e.getSource();

                if (e.getCharacter().matches("[0-9.,]")) {
                    if (txt_TextField.getText().length() == 0 && ((e.getCharacter().matches("[.]")) || e.getCharacter().matches("[,]"))) {
                        e.consume();
                    }
                    if (txt_TextField.getText().lastIndexOf(",") == txt_TextField.getLength() - 1 && ((e.getCharacter().matches("[.]")) || e.getCharacter().matches("[,]"))) {
                        e.consume();
                    }

                    if (txt_TextField.getText().lastIndexOf(".") == txt_TextField.getLength() - 1 && ((e.getCharacter().matches("[.]")) || e.getCharacter().matches("[,]"))) {
                        e.consume();
                    }
                    if (!txt_TextField.getText().contains(",")) {
                        if (txt_TextField.getText().contains(".") && e.getCharacter().matches("[.]")) {
                            e.consume();
                        }
                    }
                        if (txt_TextField.getText().contains(",")) {
                            if (txt_TextField.getText(txt_TextField.getText().lastIndexOf(","), txt_TextField.getLength()).contains(".") && e.getCharacter().matches("[.]")) {
                                e.consume();
                            }
                        }
                    } else {
                        e.consume();
                    }
                }
            };
        }
}
