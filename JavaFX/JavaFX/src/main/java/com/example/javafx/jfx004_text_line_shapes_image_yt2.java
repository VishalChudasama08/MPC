package com.example.javafx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class jfx004_text_line_shapes_image_yt2 extends Application {
    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage stage){
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600, Color.GRAY);

        Text text = new Text();
        text.setText("Hiii....! I am text");
        text.setX(50);
        text.setY(50);
        text.setFont(Font.font("Roboto", 18));
        text.setFill(Color.BLUE);

        Line line = new Line();
        line.setStartX(80);
        line.setStartY(80);
        line.setEndX(720);
        line.setEndY(80);
        line.setStrokeWidth(5);
        line.setStroke(Color.LIGHTGREY);
        line.setOpacity(0.3);
        line.setRotate(14);

        Rectangle rectangle = new Rectangle();
        rectangle.setX(100);
        rectangle.setY(100);
        rectangle.setWidth(100);
        rectangle.setHeight(100);
        rectangle.setFill(Color.LIGHTGREEN);
        rectangle.setStrokeWidth(5);
        rectangle.setStroke(Color.DARKGREEN);

        Polygon triangle = new Polygon();
        triangle.getPoints().setAll(
                205.0, 210.0,
                305.0, 305.0,
                205.0, 305.0
        );
        triangle.setFill(Color.YELLOWGREEN);
        triangle.setStrokeWidth(5);
        triangle.setStroke(Color.YELLOW);

        Circle circle = new Circle();
        circle.setCenterX(150);
        circle.setCenterY(150);
        circle.setRadius(40);
        circle.setFill(Color.ORANGE);
        circle.setStrokeWidth(5);
        circle.setStroke(Color.DARKMAGENTA);

        Image image = new Image("icon.png");
        ImageView imageView = new ImageView(image);
        imageView.setX(380);
        imageView.setY(180);
        imageView.setFitWidth(400);
        imageView.setFitHeight(400);

        root.getChildren().add(text);
        root.getChildren().add(line);
        root.getChildren().add(rectangle);
        root.getChildren().add(triangle);
        root.getChildren().add(circle);
        root.getChildren().add(imageView);
        stage.setScene(scene);
        stage.show();
    }
}
