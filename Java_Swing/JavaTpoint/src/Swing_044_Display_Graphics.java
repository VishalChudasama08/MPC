import javax.swing.*;
import java.awt.*;
import java.util.Random;

// Class that extends Canvas to draw custom graphics
public class Swing_044_Display_Graphics extends Canvas implements Runnable {
    // Overriding the paint method to perform custom drawing
    @Override
    public void paint(Graphics g) {

//        drawShapes(g); // javatpoint

        // Call the new method to draw random shapes
        drawRandomShapes(g); // ChatGPT
    }

    private void drawShapes(Graphics g){
        g.drawString("Hello", 40,40); // Draw a string at coordinates (40, 40) on the canvas

        setBackground(Color.WHITE); // Set the background color of the canvas to white

        g.fillRect(130,30,100,80); // Draw a filled rectangle at (130, 30) with width 100 and height 80

        g.drawOval(30,130,50,60); // Draw an unfilled (outlined) oval at (30, 130) with width 50 and height 60

        // Draw a filled arc at (30, 130) with width 40 and height 50,
        // starting at 180 degrees and covering 40 degrees
        g.fillArc(30,130,40,50,180,40);

        setForeground(Color.RED);// Set the foreground color (drawing color) to red

        g.fillOval(130,130,50,60); // Draw a filled oval at (130, 130) with width 50 and height 60

        // Draw an arc at (30, 200) with width 40 and height 50,
        // starting at 90 degrees and covering 60 degrees
        g.drawArc(30,200,40,50,90,60);
    }

    private Random random = new Random();
    private boolean running = true;  // Control the thread execution

    // Method to draw random shapes on the existing canvas
    private void drawRandomShapes(Graphics g) {
        // Draw 30 random shapes
        for (int i = 0; i < 30; i++) {
            drawRandomShape(g);
        }
    }

    // Helper method to draw a random shape
    private void drawRandomShape(Graphics g) {
        int shapeType = random.nextInt(3);  // Randomly choose between rectangle, oval, or line
        int x = random.nextInt(getWidth());
        int y = random.nextInt(getHeight());
        int width = random.nextInt(100) + 20;
        int height = random.nextInt(100) + 20;

        // Random color for each shape
        g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));

        switch (shapeType) {
            case 0: // Draw rectangle
                g.fillRect(x, y, width, height);
                break;
            case 1: // Draw oval
                g.fillOval(x, y, width, height);
                break;
            case 2: // Draw line
                g.drawLine(x, y, x + width, y + height);
                break;
        }
    }

    // Runnable method for the thread
    @Override
    public void run() {
        while (running) {
            try {
                // Sleep for 2-3 seconds (random time between 2000 and 3000 milliseconds)(here 1.5 seconds 1500)
                Thread.sleep(1500 + random.nextInt(1000));

                // Repaint the canvas (this will call the paint method)
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        Swing_044_Display_Graphics displayGraphics = new Swing_044_Display_Graphics();

        JFrame frame = new JFrame("Swing Display Graphics with Random Shapes and Thread");
        frame.setSize(1500, 800);  // Adjust frame size to fit the random shapes
        frame.setLocationRelativeTo(null); // Center the frame on the screen

        frame.add(displayGraphics);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Start a new thread to refresh the random shapes every 2-3 seconds
        Thread refreshThread = new Thread(displayGraphics);
        refreshThread.start();
    }
}
