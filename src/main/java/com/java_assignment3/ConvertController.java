package com.java_assignment3;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ConvertController {

    @FXML
    private TextField inputValueField;

    @FXML
    private ChoiceBox<String> conversionTypeChoiceBox;

    @FXML
    private ChoiceBox<String> conversionOptionChoiceBox;

    @FXML
    private Button convertButton;

    @FXML
    private Label resultLabel;

    private ConvertModel convertModel;

    public ConvertController() {
        this.convertModel = new ConvertModel();
    }

    @FXML
    public void initialize() {
        // Populate choice boxes
        conversionTypeChoiceBox.getItems().addAll("Weight", "Temperature");
        conversionOptionChoiceBox.getItems().addAll("LB to KG", "KG to LB", "Celsius to Fahrenheit", "Fahrenheit to Celsius");

        // Set default selections
        conversionTypeChoiceBox.getSelectionModel().selectFirst();
        conversionOptionChoiceBox.getSelectionModel().selectFirst();
    }

    @FXML
    public void handleConvertButton() {
        // Get the input value from the text field
        String inputValueStr = inputValueField.getText();
        // Parse the input value as a double
        double inputValue = Double.parseDouble(inputValueStr);

        // Determine the conversion type (Weight or Temperature)
        String conversionType = conversionTypeChoiceBox.getValue();
        // Determine the conversion option selected
        String conversionOption = conversionOptionChoiceBox.getValue();

        // Perform the conversion based on the selected conversion type and option
        double result = 0.0;
        if (conversionType.equals("Weight")) {
            // If it's a weight conversion
            if (conversionOption.equals("LB to KG")) {
                result = convertModel.getMass(inputValue, 1); // Convert pounds to kilograms
            } else if (conversionOption.equals("KG to LB")) {
                result = convertModel.getMass(inputValue, 2); // Convert kilograms to pounds
            }
        } else if (conversionType.equals("Temperature")) {
            // If it's a temperature conversion
            if (conversionOption.equals("Celsius to Fahrenheit")) {
                result = convertModel.getTemperature(inputValue, 1); // Convert Celsius to Fahrenheit
            } else if (conversionOption.equals("Fahrenheit to Celsius")) {
                result = convertModel.getTemperature(inputValue, 2); // Convert Fahrenheit to Celsius
            }
        }

        // Update the result label with the converted value
        resultLabel.setText(String.valueOf(result));
    }
}
