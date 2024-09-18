import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AWT_019_Scrollbar {
    static Frame f, frame, frame3;

    public static void ScrollbarExample() {

        // creating a frame
        f = new Frame("Scrollbar Example");
        // creating a scroll bar
        Scrollbar s = new Scrollbar();

        // setting the position of scroll bar
        s.setBounds (100, 100, 50, 100);

        // adding scroll bar to the frame
        f.add(s);

        // setting size, layout and visibility of frame
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
    }

    public static void ScrollbarExampleChatGPT(){
        // Create a new Frame
        frame = new Frame("AWT Scrollbar Example");

        // Create a vertical Scrollbar (default orientation is vertical)
        Scrollbar verticalScrollbar = new Scrollbar(Scrollbar.VERTICAL, 0, 20, 0, 300);
        verticalScrollbar.setBounds(50, 50, 20, 200);  // Setting position and size

        // Create a horizontal Scrollbar
        Scrollbar horizontalScrollbar = new Scrollbar(Scrollbar.HORIZONTAL, 0, 50, 0, 300);
        horizontalScrollbar.setBounds(100, 300, 200, 20);  // Setting position and size

        // Label to display the VERTICAL scrollbar value
        Label labelV = new Label("Vertical Scrollbar Value: 0");

        // Set the label position
        labelV.setBounds(150, 50, 200, 30);

        // Label to display the scrollbar value
        Label labelH = new Label("Horizontal Scrollbar Value: 0");

        // Set the label position
        labelH.setBounds(150, 250, 200, 30);

        // Add an adjustment listener to the vertical scrollbar
        verticalScrollbar.addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                // Get the current value of the scrollbar
                int value = verticalScrollbar.getValue();
                labelV.setText("Vertical Scrollbar Value: " + value);
            }
        });

        // Add an adjustment listener to the horizontal scrollbar
        horizontalScrollbar.addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                // Get the current value of the scrollbar
                int value = horizontalScrollbar.getValue();
                labelH.setText("Horizontal Scrollbar Value: " + value);
            }
        });

        // Set layout to null for manual positioning
        frame.setLayout(null);

        // Add components to the frame
        frame.add(verticalScrollbar);
        frame.add(horizontalScrollbar);
        frame.add(labelV);
        frame.add(labelH);

        // Set frame size and visibility
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setLocation(f.getX()+400, f.getY());

        // Add a window listener to close the frame
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                frame.dispose();  // Only close this frame
            }
        });
    }

    public static void ScrollbarExampleChatGPT2(){
        // Create a Frame
        frame3 = new Frame("Scrollbar Example - RGB Color Controller");

        // Create three scrollbars for Red, Green, and Blue
        Scrollbar redScrollbar = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, 256);   // Red scrollbar (range 0-255)
        Scrollbar greenScrollbar = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, 256); // Green scrollbar (range 0-255)
        Scrollbar blueScrollbar = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, 256);  // Blue scrollbar (range 0-255)

        // Set scrollbar sizes and positions
        redScrollbar.setBounds(50, 100, 300, 20);    // Position and size for Red
        greenScrollbar.setBounds(50, 150, 300, 20);  // Position and size for Green
        blueScrollbar.setBounds(50, 200, 300, 20);   // Position and size for Blue

        // Create a label to show the RGB values
        Label rgbLabel = new Label("R: 0, G: 0, B: 0");

        // Set label size and position
        rgbLabel.setBounds(50, 250, 300, 20);

        // Add adjustment listeners to the scrollbars
        redScrollbar.addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                updateBackgroundColor(frame3, redScrollbar, greenScrollbar, blueScrollbar, rgbLabel);
            }
        });

        greenScrollbar.addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                updateBackgroundColor(frame3, redScrollbar, greenScrollbar, blueScrollbar, rgbLabel);
            }
        });

        blueScrollbar.addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                updateBackgroundColor(frame3, redScrollbar, greenScrollbar, blueScrollbar, rgbLabel);
            }
        });

        // Set layout to null for manual component positioning
        frame3.setLayout(null);

        // Add components to the frame
        frame3.add(redScrollbar);
        frame3.add(greenScrollbar);
        frame3.add(blueScrollbar);
        frame3.add(rgbLabel);

        // Set frame size, visibility, and window listener to close the window
        frame3.setSize(400, 400);
        frame3.setLocation(frame.getX()+400, frame.getY());
        frame3.setVisible(true);

        // Add a window listener to close the frame
        frame3.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
//                System.exit(0); // close application
                frame3.dispose(); // close this frame (frame3)
            }
        });
    }

    // Method to update the background color based on scrollbar values
    private static void updateBackgroundColor(Frame frame, Scrollbar redScrollbar, Scrollbar greenScrollbar, Scrollbar blueScrollbar, Label rgbLabel) {
        // Get RGB values from the scrollbars
        int red = redScrollbar.getValue();
        int green = greenScrollbar.getValue();
        int blue = blueScrollbar.getValue();

        // Update the label with the current RGB values
        rgbLabel.setText("R: " + red + ", G: " + green + ", B: " + blue);

        // Set the background color of the frame using the RGB values
        frame.setBackground(new Color(red, green, blue));
    }

    AWT_019_Scrollbar(){
        ScrollbarExample();
        ScrollbarExampleChatGPT();
        ScrollbarExampleChatGPT2();
    }

    // main method
    public static void main(String args[]) {
        new AWT_019_Scrollbar();
    }
}    