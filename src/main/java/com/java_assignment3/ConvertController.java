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
        conversionTypeChoiceBox.getItems().addAll("Weight", "Temperature");
        conversionOptionChoiceBox.getItems().addAll("LB to KG", "KG to LB", "Celsius to Fahrenheit", "Fahrenheit to Celsius");
        conversionTypeChoiceBox.getSelectionModel().selectFirst();
        conversionOptionChoiceBox.getSelectionModel().selectFirst();
    }

    @FXML
    public void handleConvertButton() {
        String inputValueStr = inputValueField.getText();
        double inputValue = 0.0;

        try {
            // Parse the input value as a double
            inputValue = Double.parseDouble(inputValueStr);
        } catch (NumberFormatException e) {
            // Display error message if input is not a valid number
            resultLabel.setText("Invalid input! Please enter a valid number.");
            return;
        }

        String conversionType = conversionTypeChoiceBox.getValue();
        String conversionOption = conversionOptionChoiceBox.getValue();
        double result = 0.0;


        // Perform the conversion based on the selected conversion type and option
        if (conversionType.equals("Weight")) {
            if (conversionOption.equals("LB to KG")) {
                result = convertModel.getMass(inputValue, 1); // Convert pounds to kilograms
            } else if (conversionOption.equals("KG to LB")) {
                result = convertModel.getMass(inputValue, 2); // Convert kilograms to pounds
            } else {
                // Display error message for invalid option
                resultLabel.setText("Invalid conversion option selected for weight.");
                return;
            }
        } else if (conversionType.equals("Temperature")) {
            if (conversionOption.equals("Celsius to Fahrenheit")) {
                result = convertModel.getTemperature(inputValue, 1); // Convert Celsius to Fahrenheit
            } else if (conversionOption.equals("Fahrenheit to Celsius")) {
                result = convertModel.getTemperature(inputValue, 2); // Convert Fahrenheit to Celsius
            } else {
                // Display error message for invalid option
                resultLabel.setText("Invalid conversion option selected for temperature.");
                return;
            }
        } else {
            // Display error message for invalid conversion type
            resultLabel.setText("Invalid conversion type selected.");
            return;
        }

        // Update the result label with the converted value
        resultLabel.setText(String.valueOf(result));
    }
}
