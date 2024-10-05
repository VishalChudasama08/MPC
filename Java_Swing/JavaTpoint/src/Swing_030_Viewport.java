import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Swing_030_Viewport {
    JFrame frame1, frame2, frame;
    Swing_030_Viewport(){
        viewportExample(); // javatpoint

        viewportExample2(); // chatGPT
        viewportExample3(); // chatGPT
    }
    void viewportExample(){
        frame1 = new JFrame("Swing Viewport example");
        frame1.setSize(500,400);

        JLabel label = new JLabel("Label");
        label.setPreferredSize(new Dimension(1000, 1000));
        JScrollPane scrollPane = new JScrollPane(label);

        JButton button1 = new JButton();

        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setViewportBorder(new LineBorder(Color.BLUE));
        scrollPane.getViewport().add(button1,null);

        frame1.add(scrollPane, BorderLayout.CENTER);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(true);
    }
    void viewportExample2(){
        frame2 = new JFrame("JViewport Example");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(500, 400);

        // Create a panel with a large grid of buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(40, 60));  // 10 rows, 5 columns

        // Add many buttons to the panel
        for (int i = 1; i <= 500; i++) {
            panel.add(new JButton("Button " + i));
        }

        // Create a JViewport
        JViewport viewport = new JViewport();
        viewport.setView(panel);  // Set the panel as the view for the viewport

        // Create a JScrollPane with the viewport inside
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewport(viewport);

        // Add the JScrollPane to the frame
        frame2.add(scrollPane);
        frame2.setVisible(true);
        frame2.setLocation(frame1.getWidth()+5, frame1.getY());
    }
    void viewportExample3(){
        frame = new JFrame("Advanced JViewport Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        // Create a JPanel with a large grid layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(20, 10));  // Large grid, 20 rows and 10 columns

        // Add buttons to the panel
        for (int i = 1; i <= 500; i++) {
            panel.add(new JButton("Button " + i));
        }

        // Create a JViewport
        JViewport viewport = new JViewport();
        viewport.setView(panel);  // Set the panel as the view for the viewport

        // Create a JScrollPane with the viewport
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewport(viewport);

        // Create control buttons to manipulate the viewport
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        JButton scrollToTopButton = new JButton("Scroll to Top");
        JButton scrollToBottomButton = new JButton("Scroll to Bottom");
        JButton scrollToCenterButton = new JButton("Scroll to Center");

        JButton scrollToHorizontalCenter = new JButton("Scroll To Horizontal Center");
        JButton scrollToVerticalCenter = new JButton("Scroll To Vertical Center");

        // Add actions to buttons
        scrollToTopButton.addActionListener(e -> viewport.setViewPosition(new Point(0, 0)));
        scrollToBottomButton.addActionListener(e -> viewport.setViewPosition(new Point(0, panel.getHeight() - viewport.getHeight())));
        scrollToCenterButton.addActionListener(e -> viewport.setViewPosition(new Point((panel.getWidth() - viewport.getWidth()) / 2, (panel.getHeight() - viewport.getHeight()) / 2)));
        // x - center, y - not change (as it is)
        scrollToHorizontalCenter.addActionListener(e -> viewport.setViewPosition(new Point((panel.getWidth() - viewport.getWidth()) / 2, viewport.getViewPosition().y)));
        // x - not change (as it is), y - center
        scrollToVerticalCenter.addActionListener(e -> {
            int currentX = viewport.getViewPosition().x; // Get the current x position
            viewport.setViewPosition(new Point(currentX, (panel.getHeight() - viewport.getHeight()) / 2));
        });

        // Add buttons to controlPanel
        controlPanel.add(scrollToTopButton);
        controlPanel.add(scrollToBottomButton);
        controlPanel.add(scrollToCenterButton);
        controlPanel.add(scrollToHorizontalCenter);
        controlPanel.add(scrollToVerticalCenter);

        // Set a preferred size for the control panel to make sure it fits inside the scroll pane
        controlPanel.setPreferredSize(new Dimension(500, 70)); // Adjust height as needed

//        // Add controlPanel to JScrollPane
//        JScrollPane controlPanelScrollPane = new JScrollPane(controlPanel);
//        controlPanelScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//        controlPanelScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Create a ChangeListener to monitor the viewport changes
        viewport.addChangeListener(e -> {
            Point viewPosition = viewport.getViewPosition();
            System.out.println("Viewport position changed to: " + viewPosition);
        });

        // Add the scroll pane and control panel to the frame
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(controlPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
        frame.setLocation(frame2.getX()+frame2.getWidth()+5, frame2.getY());
    }
    public static void main(String[] args) {
        new Swing_030_Viewport();
    }
}
