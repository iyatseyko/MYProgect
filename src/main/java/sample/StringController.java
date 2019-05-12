package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import sample.StringOperations.Palindrome;
import sample.StringOperations.StringReverse;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StringController implements Initializable {

    @FXML
    private TextField string_text;

    @FXML
    private Label result;

    public void clickBack (ActionEvent event) throws IOException {
        Controller.openWindow(event, "sample");
    }

    @FXML private javafx.scene.control.Button closeButton;


    @FXML
    private void closeButtonAction(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void clickIsPolyndrome (ActionEvent event) {
        if (string_text.getText().isEmpty()){
            result.setText("Please, type a string value");
            return;
        }
        result.setText(Palindrome.checkIsTheWordAPolindrom(string_text.getText()));
    }

    public void clickReverseString (ActionEvent event) {
        if (string_text.getText().isEmpty()){
            result.setText("Please, type a string value");
            return;
        }
        result.setText((StringReverse.stringReverse(string_text.getText())));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        string_text.addEventFilter(KeyEvent.KEY_TYPED , numeric_Validation(225));

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
