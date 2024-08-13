import javax.swing.*;
import java.awt.*;

public class Swing_GridLayout_With_Panels {

    public static void main(String[] args) {
        JFrame frame = new JFrame("GridLayout with Additional Content");

        // Set the layout manager for the frame
        frame.setLayout(new BorderLayout());

        // Add content above the grid
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("This is the top content"));
        frame.add(topPanel, BorderLayout.NORTH);

        // Create a panel for the button grid
        JPanel buttonPanel = new JPanel(new GridLayout(3, 2)); // 3 rows, 2 columns

        // Add buttons to the grid panel
        for (int i = 1; i <= 6; i++) {
            JButton button = new JButton("Button " + i);
            button.setPreferredSize(new Dimension(50, 20)); // Set width and height
            buttonPanel.add(button);
        }

        // Add the button grid panel to the center of the frame
        frame.add(buttonPanel, BorderLayout.CENTER);

        // Add content below the grid
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(new JLabel("This is the bottom content"));
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Set frame properties
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
