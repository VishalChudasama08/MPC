package com.example.javafx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class jfx003_icon_yt1 extends Application {
    public static void main(String[] args){
        launch(args);
    }
    public void start(Stage stage){
        Group root = new Group();
        Scene scene = new Scene(root, 500, 250, Color.BLUE);

        String imagePath = "icon.png"; // location allows only in the "resources" folder not inner and outer
        Image icon = new Image(imagePath);
        stage.getIcons().add(icon);
        stage.setTitle("Stage and Icon demo program");

        stage.setScene(scene);
        stage.show();
    }
}
