package com.example.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class jfx007_css_file extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("jfx007_css_file.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 680, 400);
        String css = this.getClass().getResource("fx007_css_file.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setTitle("Add Css File");
        stage.setScene(scene);
        stage.show();
    }
}
