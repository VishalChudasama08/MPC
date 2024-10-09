import javax.swing.*;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.awt.*;

public class Swing_036_SplitPane {
    JFrame frame, frame2, frame3;
    Swing_036_SplitPane(){
        frame = new JFrame("Swing SplitPane Example");
//        frame.setLayout(new FlowLayout());
        frame.setSize(400, 300);

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                splitPaneExample(); // javatpoint

                splitPaneExample1(); // ChatGPT
                splitPaneExample2(); // ChatGPT
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    void splitPaneExample(){
        String [] option1 = {"A", "B", "C", "D", "E"};
        JComboBox<String> box1 = new JComboBox<>(option1);

        String [] option2 = {"1", "2", "3", "4", "5"};
        JComboBox<String> box2 = new JComboBox<>(option2);

        JPanel panel1 = new JPanel();
        panel1.add(box1);

        JPanel panel2 = new JPanel();
        panel2.add(box2);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panel1, panel2);
//        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panel1, panel2);

        frame.add(splitPane);
    }
    void splitPaneExample1(){
        // Create a JFrame
        frame2 = new JFrame("JSplitPane Example");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame2.setSize(400, 300);

        // Create two panels with different background colors
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.CYAN);
        panel1.add(new JLabel("Panel 1"));

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.ORANGE);
        panel2.add(new JLabel("Panel 2"));

        // Create a JSplitPane
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panel1, panel2);

        // Set the divider location (in pixels from the left/top)
        splitPane.setDividerLocation(150);

        // Allow the user to continuously resize the panes
        splitPane.setContinuousLayout(true);

        // Add the split pane to the frame2
        frame2.getContentPane().add(splitPane);

        // Set the frame2 to be visible
        frame2.setVisible(true);
        frame2.setLocation(frame.getWidth()+frame.getX()+10, frame.getY());
    }
    void splitPaneExample2(){
        // Create the main frame
        frame3 = new JFrame("JSplitPane 5-Panel Example");
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setSize(600, 600);

        // Create individual panels with different background colors
        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.CYAN);
        topPanel.add(new JLabel("Top Panel"));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.LIGHT_GRAY);
        bottomPanel.add(new JLabel("Bottom Panel"));

        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.ORANGE);
        leftPanel.add(new JLabel("Left Panel"));

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.WHITE);
        centerPanel.add(new JLabel("Center Panel"));

        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.PINK);
        rightPanel.add(new JLabel("Right Panel"));

        // Split left and center panels (horizontal split)
        JSplitPane leftCenterSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, centerPanel);
        leftCenterSplit.setDividerLocation(100); // Set the initial divider position
        splitPaneStyle(leftCenterSplit);

        // Split leftCenterSplit and right panels (horizontal split)
        JSplitPane centerRightSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftCenterSplit, rightPanel);
        centerRightSplit.setDividerLocation(500); // Set the initial divider position
        splitPaneStyle(centerRightSplit);

        // Split top and the combined (left, center, right) bottom panels (vertical split)
        JSplitPane topBottomSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, topPanel, centerRightSplit);
        topBottomSplit.setDividerLocation(30); // Set the initial divider position for top splitPane
        splitPaneStyle(topBottomSplit);

        // Now split the combined top, left, center, right with the bottom panel
        JSplitPane finalSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, topBottomSplit, bottomPanel);
        finalSplit.setDividerLocation(530); // Set the initial divider position
        splitPaneStyle(finalSplit);

        // Add the final split pane to the frame3
        frame3.add(finalSplit);

        // Make the frame3 visible
        frame3.setVisible(true);
        frame3.setLocation(frame2.getWidth()+frame2.getX()+10,frame2.getY());
    }

    private static JSplitPane splitPaneStyle(JSplitPane splitPane){
        // Customize the divider to be 3px solid black
        splitPane.setUI(new BasicSplitPaneUI() {
            @Override
            public BasicSplitPaneDivider createDefaultDivider() {
                return new BasicSplitPaneDivider(this) {
                    @Override
                    public void paint(Graphics g) {
                        // Set the divider color and size
                        g.setColor(Color.BLACK);
                        g.fillRect(0, 0, getSize().width, getSize().height);
                    }
                };
            }
        });
        splitPane.setDividerSize(2);  // Set the thickness of the divider to 3px
        return splitPane;
    }

    public static void main(String[] args) {
        new Swing_036_SplitPane();
    }
}
