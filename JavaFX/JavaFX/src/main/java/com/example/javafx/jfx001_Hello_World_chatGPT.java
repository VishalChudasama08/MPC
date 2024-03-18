package com.example.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class jfx001_Hello_World_chatGPT extends Application {
    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage primaryStage){
        Label label = new Label("Hello, World!");
        Scene scene = new Scene(label, 200, 100); // v = 200 is width, and v1 = 100 is height, only 1 Scene allow
//        Scene scene1 = new Scene(label, 200, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
