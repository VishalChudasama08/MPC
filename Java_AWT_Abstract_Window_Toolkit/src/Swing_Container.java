import javax.swing.*;
import java.awt.*;

public class Swing_Container {
    /*
     * Container:  is a general class that provides the ability to hold components and manage their layout but is not used directly.
     *             It is inherited by concrete classes like JPanel, JFrame, etc., which you use to build your GUI.

     * Panel:      is a concrete subclass of Container that you can use to group and organize components inside a GUI.
     *             In AWT, it's common to use Panel, but in Swing, you would typically use JPanel.
     */

    public static void main(String[] args) {
        // Create a new JFrame (window)
        JFrame frame = new JFrame("Container Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Get the content pane of the frame (which is a Container)
        Container container = frame.getContentPane();

        // Set a layout for the container
        container.setLayout(new BorderLayout());

        // Create components to add to the container
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JLabel label = new JLabel("This is a label");

        // Add components to the container with layout constraints
        container.add(button1, BorderLayout.NORTH);
        container.add(button2, BorderLayout.SOUTH);
        container.add(label, BorderLayout.CENTER);

        // Make the frame visible
        frame.setVisible(true);
    }
}
