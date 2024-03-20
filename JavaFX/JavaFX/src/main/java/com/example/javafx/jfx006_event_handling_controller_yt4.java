package com.example.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;

public class jfx006_event_handling_controller_yt4 {
    @FXML
    private Circle myCircle; // fx:id myCircle
    private double x;
    private double y;
    public void up(ActionEvent e){
        myCircle.setCenterY(y-=4);
    }
    public void right(ActionEvent e){
        myCircle.setCenterX(x+=4);
    }
    public void down(ActionEvent e){
        myCircle.setCenterY(y+=4);
    }
    public void left(ActionEvent e){
        myCircle.setCenterX(x-=4);
    }
}
