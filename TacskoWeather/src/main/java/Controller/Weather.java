package Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import org.controlsfx.control.textfield.TextFields;

import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;

public class Weather  implements Initializable {

    @FXML
    private TextField orszagTextField;

    @FXML
    private TextField telepulesTextField;


    public void orszagAction(){
    }

    public void telepulesTextAction(){

    }


    public void telepulesKeyTyped() {
/*
        ArrayList<String> suggestions = Handler.StringLike(cities, orszagTextField.getText(), telepulesTextField.getText());
        System.out.println(suggestions);
*/

    }

    public void telepulesAction(){}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Map<String, ArrayList<String>> cities = Handler.createMapOfCities();

        orszagTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(orszagTextField.getText());
        });

        telepulesTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (telepulesTextField.getText().length() > 1) {
                ArrayList<String> suggestions = Handler.StringLike(cities, orszagTextField.getText(), telepulesTextField.getText());
                System.out.println(suggestions);
                TextFields.bindAutoCompletion(telepulesTextField, suggestions);
                suggestions.clear();
            }
        });


    }}


