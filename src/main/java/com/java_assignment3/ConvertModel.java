package com.java_assignment3;

public class ConvertModel {
    public double getKilogramValue(double poundValue) {
        // Conversion formula: 1 pound = 0.45359237 kilograms
        return poundValue * 0.45359237;
    }

    public double getPoundValue(double kilogramValue) {
        // Conversion formula: 1 kilogram = 2.20462262 pounds
        return kilogramValue * 2.20462262;
    }

    public double getFahrenheitValue(double celsiusValue) {
        // Conversion formula: °F = (°C * 9/5) + 32
        return (celsiusValue * 9 / 5) + 32;
    }

    public double getCelsiusValue(double fahrenheitValue) {
        // Conversion formula: °C = (°F - 32) * 5/9
        return (fahrenheitValue - 32) * 5 / 9;
    }

    public double getTemperature(double value, int choice) {
        double result = 0.0; // Default result
        // Check user choice
        if (choice == 1) {
            // Convert Celsius to Fahrenheit if choice is 1
            result = getFahrenheitValue(value);
        } else if (choice == 2) {
            // Convert Fahrenheit to Celsius if choice is 2
            result = getCelsiusValue(value);
        } else {
            // Display error message for invalid choice
            System.err.println("Invalid Choice! Only 1 or 2 is allowed");
        }
        // Return the converted temperature value
        return result;
    }

    public double getMass(double value, int choice) {
        double result = 0.0; // Default result
        // Check user choice
        if (choice == 1) {
            // Convert pounds to kilograms if choice is 1
            result = getKilogramValue(value);
        } else if (choice == 2) {
            // Convert kilograms to pounds if choice is 2
            result = getPoundValue(value);
        } else {
            // Display error message for invalid choice
            System.err.println("Invalid Choice! Only 1 or 2 is allowed");
        }
        // Return the converted mass value
        return result;
    }
}