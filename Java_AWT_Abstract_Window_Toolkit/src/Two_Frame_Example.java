import java.awt.*;
import java.awt.event.*;

public class Two_Frame_Example {
    static Frame frame1 = new Frame("First Frame"); // Create the first frame
    static Frame frame2 = new Frame("Second Frame"); // Create the second frame
    public static void Frame1(){
        // Set size and layout for the first frame
        frame1.setSize(300, 200);
        frame1.setLayout(new FlowLayout());

        // Add a label to the first frame
        Label label1 = new Label("This is the First Frame");
        frame1.add(label1);

        // Add a window listener to close the first frame
        frame1.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);  // Close the application when the first frame is closed
            }
        });

        // set frame location on screen
        frame1.setLocationRelativeTo(null);

        // Make the first frame visible
        frame1.setVisible(true);
    }
    public static void Frame2(){
        // Set size and layout for the second frame
        frame2.setSize(300, 200);
        frame2.setLayout(new FlowLayout());

        // Add a label to the second frame
        Label label2 = new Label("This is the Second Frame");
        frame2.add(label2);

        // Add a window listener to close the second frame
        frame2.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                frame2.dispose();  // Only close the second frame
            }
        });

        // set frame location on screen
        frame2.setLocation(frame1.getX() + 310,frame1.getY());

        // Make the second frame visible
        frame2.setVisible(true);
    }
    public static void main(String[] args) {
        Frame1();
        Frame2();
    }
}
