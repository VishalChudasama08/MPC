import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AWT_013_Toolkit {
    Frame frame = new Frame("Toolkit Example");
    AWT_013_Toolkit(){
        frame.setSize(600,600);
        frame.setLayout(null);
        frame.setVisible(true);

        toolkit_example(); // Beep example, source: javatpoint
        toolkit_example1(); // Icon example, source: javatpoint
        toolkit_example2(); // Image on Canvas, source: chatGPT
    }
    void toolkit_example(){
        Button button = new Button("Push");
        button.setBounds(50,50,60,30);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Toolkit.getDefaultToolkit().beep();
            }
        });

        frame.add(button);
    }
    void toolkit_example1(){
        Image icon = Toolkit.getDefaultToolkit().getImage("D:\\Happy_Coding\\My_Code_In_Github\\MPC\\Java_AWT_Abstract_Window_Toolkit\\src\\awt(Abstract Window Toolkit.)hierarchy.png");
        frame.setIconImage(icon);
    }
    void toolkit_example2(){
        // Get the default Toolkit instance
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        Image img = toolkit.getImage("D:\\Happy_Coding\\My_Code_In_Github\\MPC\\Java_AWT_Abstract_Window_Toolkit\\src\\awt(Abstract Window Toolkit.)hierarchy.png");

        // Use MediaTracker to ensure the image is fully loaded
        MediaTracker tracker = new MediaTracker(frame);
        tracker.addImage(img, 0);
        try {
            tracker.waitForID(0);  // Wait until the image is fully loaded
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Create a Canvas to draw the image
        Canvas canvas = new Canvas() {
            @Override
            public void paint(Graphics g) {
                // Draw the image on the Canvas only if it's fully loaded
                if (img != null) {
                    g.drawImage(img, 50, 100, this);
                }
            }
        };

        canvas.setBounds(0, 0, 500, 500); // Set the bounds of the canvas
        frame.add(canvas);

        // Add the Canvas to the frame
        frame.add(canvas);

        // Adding a window listener to close the frame properly
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }
    public static void main(String[] args) {
        new AWT_013_Toolkit();
        Toolkit t = Toolkit.getDefaultToolkit();
        System.out.println("Screen resolution = " + t.getScreenResolution()); // monitor resolution

        Dimension d = t.getScreenSize();
        System.out.println("Screen width = " + d.width); // monitor width
        System.out.println("Screen height = " + d.height); // monitor height
    }
}
