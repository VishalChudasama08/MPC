import java.awt.*;
import java.awt.event.*;

// source: chatGPT
public class AWT_006_All_Event_and_it_Listener_interfaces extends Frame {
    TextArea textArea;
    AWT_006_All_Event_and_it_Listener_interfaces(){
        setTitle("Java Event Handling Example");
        setSize(800, 900);
        setLayout(new FlowLayout());
    }

    public static void main(String[] args) {
        new AWT_006_All_Event_and_it_Listener_interfaces();
    }
}
