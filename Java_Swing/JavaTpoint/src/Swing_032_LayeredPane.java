import javax.swing.*;
import java.awt.*;

public class Swing_032_LayeredPane {
    JFrame frame;
    Swing_032_LayeredPane(){
        frame = new JFrame("Swing LayeredPane Example");
        frame.setSize(400, 300);

        layeredPaneExample(); // javatpoint

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        layeredPaneExample1(); // ChatGPT
    }
    void layeredPaneExample(){
        JButton top = new JButton();
        top.setBackground(Color.WHITE);
        top.setBounds(20, 20, 50, 50);

        JButton middle = new JButton();
        middle.setBackground(Color.CYAN);
        middle.setBounds(40,40,50,50);

        JButton bottom = new JButton();
        bottom.setBackground(Color.BLUE);
        bottom.setBounds(60,60,50,50);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.add(bottom, new int[3]);
        layeredPane.add(middle, new int[2]);
        layeredPane.add(top, new int[1]);

        frame.add(layeredPane);
    }

    void layeredPaneExample1(){
        // Create a JFrame to hold everything
        JFrame frame2 = new JFrame("LayeredPane Example");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(400, 400);

        // Create a JLayeredPane to manage components
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(400, 400));

        // Create some JLabels with different content and colors
        JLabel label1 = new JLabel("Label 1");
        label1.setOpaque(true);
        label1.setBackground(Color.RED);
        label1.setBounds(50, 50, 100, 50);

        JLabel label2 = new JLabel("Label 2");
        label2.setOpaque(true);
        label2.setBackground(Color.BLUE);
        label2.setBounds(100, 100, 100, 50);

        JLabel label3 = new JLabel("Label 3");
        label3.setOpaque(true);
        label3.setBackground(Color.GREEN);
        label3.setBounds(150, 150, 100, 50);

        // Add labels to the layered pane with different layers
        layeredPane.add(label1, JLayeredPane.DEFAULT_LAYER); // layer 0
        layeredPane.add(label2, JLayeredPane.PALETTE_LAYER); // layer 100
        layeredPane.add(label3, JLayeredPane.MODAL_LAYER); // layer 200

        // Set positions of the layered pane and add it to the frame
        layeredPane.setBounds(0, 0, 400, 400);
        frame2.add(layeredPane);

        // Display the frame2
        frame2.setVisible(true);
        frame2.setLocation(frame.getWidth()+10, frame.getY());
    }

    public static void main(String[] args) {
        new Swing_032_LayeredPane();
    }
}
