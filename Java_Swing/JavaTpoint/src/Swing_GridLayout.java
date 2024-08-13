import javax.swing.*;
import java.awt.*;

public class Swing_GridLayout {
    public static void main(String[] args) {
        // Create a JFrame to hold the buttons
        JFrame frame = new JFrame("GridLayout Example");

        // Set the GridLayout manager with 3 rows and 2 columns
        frame.setLayout(new GridLayout(3, 2)); // 3 rows, 2 columns

        // Create buttons to be added to the grid
        JButton b1 = new JButton("Button 1");
        JButton b2 = new JButton("Button 2");
        JButton b3 = new JButton("Button 3");
        JButton b4 = new JButton("Button 4");
        JButton b5 = new JButton("Button 5");
        JButton b6 = new JButton("Button 6");

        // Add buttons to the frame
        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(b4);
        frame.add(b5);
        frame.add(b6);

        // Set the size of the frame
        frame.setSize(400, 300);

        // Specify the default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make the frame visible
        frame.setVisible(true);
    }
}
