import javax.swing.*;
import java.awt.*;

public class Swing_033_DesktopPane {
    JFrame frame;
    Swing_033_DesktopPane(){
        frame = new JFrame("Swing DesktopPane Example");
        frame.setSize(350, 400);

        desktopPaneExample(); // javatpoint

        desktopPaneExample1(); // ChatGPT

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    void desktopPaneExample(){
        CustomDesktopPane desktopPane = new CustomDesktopPane();
        Container contentPane = frame.getContentPane();
        contentPane.add(desktopPane, BorderLayout.CENTER);
        desktopPane.display(desktopPane);
    }
    void desktopPaneExample1(){
        JFrame frame2 = new JFrame("JDesktopPane Example");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(400, 400);
        // Create a JDesktopPane
        JDesktopPane desktopPane = new JDesktopPane();

        // Create two JInternalFrame objects (mini-windows)
        JInternalFrame internalFrame1 = new JInternalFrame("Internal Frame 1", true, true, true, true);
        JInternalFrame internalFrame2 = new JInternalFrame("Internal Frame 2", true, true, true, true);

        // Set size and position for internal frames
        internalFrame1.setBounds(50, 50, 300, 100);
        internalFrame2.setBounds(50, 200, 300, 100);

        // Add internal frames to the desktop pane
        desktopPane.add(internalFrame1);
        desktopPane.add(internalFrame2);

        // Make internal frames visible
        internalFrame1.setVisible(true);
        internalFrame2.setVisible(true);

        // Add the desktop pane to the frame
        frame2.add(desktopPane);

        // Display the frame
        frame2.setVisible(true);
        frame2.setLocation(frame.getWidth()+10, frame.getY());
    }

    public static void main(String[] args) {
        new Swing_033_DesktopPane();
    }
}

class CustomDesktopPane extends JDesktopPane {
    int numFrames = 3, x = 30 , y = 30;
    public void display(CustomDesktopPane desktopPane){
        for (int i = 0; i <numFrames; i++) {
            JInternalFrame internalFrame = new JInternalFrame("Internal Frame "+ i , true,true, true,true);

            internalFrame.setBounds(x,y,250,85);
            Container container = internalFrame.getContentPane();
            container.add(new JLabel("I Love my country"));
            desktopPane.add(internalFrame);
            internalFrame.setVisible(true);
            y += 100;
        }
    }
}
