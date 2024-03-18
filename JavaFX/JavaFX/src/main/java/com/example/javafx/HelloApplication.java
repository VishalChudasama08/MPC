package com.example.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
/*
file structure is -->

/JavaFX/JavaFX/      (in JavaFX folder sum other folder present like .idea, .mvn, and sum file like .gitgnore, mvnw, mvnw.cmd, pom.xml )
/JavaFX/JavaFX/target/     (in target folder sum folder and file present)
/JavaFX/JavaFX/src/main/java/com.example.javafx/HelloApplication.java
/JavaFX/JavaFX/src/main/java/com.example.javafx/HelloController.java
/JavaFX/JavaFX/src/main/java/module-info.java
/JavaFX/JavaFX/src/main/resources/com.example.javafx/hello-view.fxml
/JavaFX/openjfx-21.0.2_windows-x64_bin-sdk/javafx-sdk-21.0.2/bin/  ...
/JavaFX/openjfx-21.0.2_windows-x64_bin-sdk/javafx-sdk-21.0.2/lib/  ...
/JavaFX/openjfx-21.0.2_windows-x64_bin-sdk/javafx-sdk-21.0.2/legal/  ...

i create new folder is /j001_hello_world/
/JavaFX/JavaFX/j001_hello_world/

in j001_hello_world folder, i am how to create hello world javaFX program ? which minimum file required and which place to set it ?
i am beginner so please proveid me more information and details and explain me in step-by-step




 */