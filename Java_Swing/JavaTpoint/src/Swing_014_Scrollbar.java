import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class Swing_014_Scrollbar {
    static JFrame f, frame2, frame3;

    // Constructor to run all examples
    Swing_014_Scrollbar() {
        ScrollbarExample();

        ScrollbarExampleChatGPT();
        ScrollbarExampleChatGPT2();
        // Run the GUI in the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public static void ScrollbarExample() {
        // creating a frame
        f = new JFrame("Scrollbar Example");
        // creating a scroll bar
        JScrollBar s = new JScrollBar(JScrollBar.VERTICAL);

        // setting the position of scroll bar
        s.setBounds(80, 100, 50, 100);

        // adding scroll bar to the frame
        f.add(s);

        ScrollbarExampleWthActionListener();

        // setting size, layout, and visibility of frame
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    static void ScrollbarExampleWthActionListener() {
        JLabel label = new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setSize(400, 100);
        JScrollBar s = new JScrollBar();
        s.setBounds(200, 100, 50, 100);
        f.add(s);
        f.add(label);
        s.addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                label.setText("Vertical Scrollbar value is:" + s.getValue());
            }
        });
    }
    public static void ScrollbarExampleChatGPT() {
        // Create a new JFrame
        frame2 = new JFrame("Swing Scrollbar Example");

        // Create a vertical JScrollBar
        JScrollBar verticalScrollbar = new JScrollBar(JScrollBar.VERTICAL, 0, 20, 0, 300);
        verticalScrollbar.setBounds(50, 50, 20, 200);  // Setting position and size

        // Create a horizontal JScrollBar
        JScrollBar horizontalScrollbar = new JScrollBar(JScrollBar.HORIZONTAL, 0, 50, 0, 300);
        horizontalScrollbar.setBounds(100, 300, 200, 20);  // Setting position and size

        // Label to display the vertical scrollbar value
        JLabel labelV = new JLabel("Vertical Scrollbar Value: 0");

        // Set the label position
        labelV.setBounds(150, 50, 200, 30);

        // Label to display the horizontal scrollbar value
        JLabel labelH = new JLabel("Horizontal Scrollbar Value: 0");

        // Set the label position
        labelH.setBounds(150, 250, 200, 30);

        // Add an adjustment listener to the vertical scrollbar
        verticalScrollbar.addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                int value = verticalScrollbar.getValue();
                labelV.setText("Vertical Scrollbar Value: " + value);
            }
        });

        // Add an adjustment listener to the horizontal scrollbar
        horizontalScrollbar.addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                int value = horizontalScrollbar.getValue();
                labelH.setText("Horizontal Scrollbar Value: " + value);
            }
        });

        // Set layout to null for manual positioning
        frame2.setLayout(null);

        // Add components to the frame
        frame2.add(verticalScrollbar);
        frame2.add(horizontalScrollbar);
        frame2.add(labelV);
        frame2.add(labelH);

        // Set frame size and visibility
        frame2.setSize(400, 400);
        frame2.setVisible(true);
        frame2.setLocation(f.getX() + 400, f.getY()); // set this frame location on screen

        // Close frame when user clicks on the close button
        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void ScrollbarExampleChatGPT2() {
        // Create a JFrame
        frame3 = new JFrame("Scrollbar Example - RGB Color Controller");

        // Create three scrollbars for Red, Green, and Blue
        JScrollBar redScrollbar = new JScrollBar(JScrollBar.HORIZONTAL, 0, 1, 0, 256);
        JScrollBar greenScrollbar = new JScrollBar(JScrollBar.HORIZONTAL, 0, 1, 0, 256);
        JScrollBar blueScrollbar = new JScrollBar(JScrollBar.HORIZONTAL, 0, 1, 0, 256);

        // Set scrollbar sizes and positions
        redScrollbar.setBounds(50, 100, 300, 20);
        greenScrollbar.setBounds(50, 150, 300, 20);
        blueScrollbar.setBounds(50, 200, 300, 20);

        // Create a label to show the RGB values
        JLabel rgbLabel = new JLabel("R: 0, G: 0, B: 0");
        rgbLabel.setBounds(50, 250, 300, 20);

        // Add adjustment listeners to the scrollbars
        redScrollbar.addAdjustmentListener(e -> updateBackgroundColor(frame3, redScrollbar, greenScrollbar, blueScrollbar, rgbLabel));
        greenScrollbar.addAdjustmentListener(e -> updateBackgroundColor(frame3, redScrollbar, greenScrollbar, blueScrollbar, rgbLabel));
        blueScrollbar.addAdjustmentListener(e -> updateBackgroundColor(frame3, redScrollbar, greenScrollbar, blueScrollbar, rgbLabel));

        // Set layout to null for manual component positioning
        frame3.setLayout(null);

        // Add components to the frame
        frame3.add(redScrollbar);
        frame3.add(greenScrollbar);
        frame3.add(blueScrollbar);
        frame3.add(rgbLabel);

        // Set frame size, visibility, and window listener to close the window
        frame3.setSize(400, 400);
        frame3.setLocation(frame2.getX() + 400, frame2.getY());
        frame3.setVisible(true);

        frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void createAndShowGUI() {
        // Create a JFrame
        JFrame frame = new JFrame("Swing Advanced JScrollBar Example");

        // Set layout to null for manual positioning
        frame.setLayout(null);

        // Create a JScrollBar
        JScrollBar verticalScrollBar = new JScrollBar(JScrollBar.VERTICAL, 50, 20, 0, 300);
        verticalScrollBar.setBounds(50, 50, 20, 200);  // Set position and size

        // Retrieve the BoundedRangeModel for advanced control
        BoundedRangeModel model = verticalScrollBar.getModel();

        // Add a ChangeListener for the model
        model.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                System.out.println("Model-based Vertical Scrollbar Value: " + model.getValue());
            }
        });

        // Modify unit and block increments
        verticalScrollBar.setUnitIncrement(5);  // Small step
        verticalScrollBar.setBlockIncrement(30); // Large step

        // Set custom UI (Swing's specific feature)
        verticalScrollBar.setUI(new javax.swing.plaf.metal.MetalScrollBarUI());

        // Add the JScrollBar to the frame
        frame.add(verticalScrollBar);

        // Set frame size and visibility
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocation(frame2.getX(), frame2.getY() + 400);
    }


    // Method to update the background color based on scrollbar values
    private static void updateBackgroundColor(JFrame frame, JScrollBar redScrollbar, JScrollBar greenScrollbar, JScrollBar blueScrollbar, JLabel rgbLabel) {
        int red = redScrollbar.getValue();
        int green = greenScrollbar.getValue();
        int blue = blueScrollbar.getValue();

        rgbLabel.setText("R: " + red + ", G: " + green + ", B: " + blue);
        frame.getContentPane().setBackground(new Color(red, green, blue));
    }

    // main method
    public static void main(String[] args) {
        new Swing_014_Scrollbar();
    }
}
