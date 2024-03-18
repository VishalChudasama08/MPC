package com.example.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.nio.Buffer;

public class jfx002_User_input_and_button_chatGPT extends Application {
    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage primaryStage){
        // Create UI components
        Label instructionLabel = new Label("Enter a Number:");
        TextField numberField = new TextField();
        Button checkButton = new Button("Check");
        Label resultLabel = new Label();

        // Event handler for the check button
        checkButton.setOnAction(e -> {
            try{
                // get the entered number from the text field by user
                int number = Integer.parseInt(numberField.getText());

                // check the condition using if-else
                if (number % 2 == 0){
                    resultLabel.setText(number + " is Even Number.");
                } else {
                    resultLabel.setText(number + " is Odd Number.");
                }
            } catch (NumberFormatException ex){
                // Handle invalid input - if user not enters any numeric value then
                resultLabel.setText("Please enter a valid number.");
            }
        });

        // Layout setup
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(instructionLabel, numberField, checkButton, resultLabel);

        // Set up the scene and stage
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("User Input and Button");
        primaryStage.show();
    }
}
