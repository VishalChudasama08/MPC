import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

public class AWT_MediaTracker extends Frame {
    Image image1;     // First image to load (local image)
    Image image2;     // Second image to load (remote URL image)
    MediaTracker tracker;  // MediaTracker object

    public AWT_MediaTracker() {
        // Create a new Frame
        super("AWT MediaTracker Example");
        setSize(600, 600);
        setLayout(null); // No layout manager, positioning done manually

        // Handle window closing event
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose(); // Close the window
            }
        });

        // Create a MediaTracker object
        tracker = new MediaTracker(this);

        // Load images using Toolkit
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        image1 = toolkit.getImage("src/image1.jpg");  // local image
        try {
            // Load image from URL
            URL url = new URL("https://picsum.photos/id/1/200/300");
            image2 = toolkit.getImage(url);  // Image from remote URL

            // Add images to the tracker, assigning unique IDs
            tracker.addImage(image1, 1);  // Local image
            tracker.addImage(image2, 2);  // Remote image
        } catch (Exception e) {
            System.out.println("Error loading image from URL: " + e.getMessage());
        }

        // Add images to the tracker, assigning unique IDs
        tracker.addImage(image1, 1);
        tracker.addImage(image2, 2);

        // Use the MediaTracker to wait for images to load
        try {
            // Wait for image1 to load completely (ID 1)
            tracker.waitForID(1);
            // Wait for image2 to load completely (ID 2)
            tracker.waitForID(2);
        } catch (InterruptedException e) {
            System.out.println("Image loading interrupted: " + e);
        }

        // Check for any errors
        if (tracker.isErrorAny()) {
            System.out.println("Error loading one or more images.");
        }
    }

    // Override paint method to draw images
    public void paint(Graphics g) {
        if (tracker.checkAll()) { // If all images have been loaded
            g.drawImage(image1, 50, 50, this);  // Draw image1 at (50, 50)
            g.drawImage(image2, 250, 50, this);  // Draw image2 at (250, 50)
        } else {
            g.drawString("Images are still loading...", 50, 50);
        }
    }

    public static void main(String[] args) {
        // Create an instance of the MediaTrackerExampleAWT
        AWT_MediaTracker frame = new AWT_MediaTracker();
        frame.setVisible(true);  // Show the frame
    }
}
