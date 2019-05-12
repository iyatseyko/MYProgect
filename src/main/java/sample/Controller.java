package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML private javafx.scene.control.Button closeButton;


    public static void openWindow (ActionEvent event, String name) throws IOException {

        Parent math_page_parent = FXMLLoader.load(Controller.class.getClassLoader().getResource(String.format("%s.fxml", name)));
        Scene math_page_scene = new Scene(math_page_parent);

        Stage mathApp =  (Stage) ((Node) event.getSource()).getScene().getWindow();

        mathApp.setScene(math_page_scene);
        mathApp.show();
    }
    public void clickMath (ActionEvent event) throws IOException {
        openWindow(event,"Math" );
    }

    public void clickString (ActionEvent event) throws IOException {
        openWindow(event,"String" );
    }

    public void clickEmployee (ActionEvent event) throws IOException {
        openWindow(event,"Employee" );
    }

    @FXML
    private void closeButtonAction(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
