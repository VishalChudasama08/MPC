import javax.swing.*;
import java.awt.*;

public class Swing_LayoutManager_04_BoxLayout {
    JFrame frame1, frame2, frame3, frame4;

    public static void main(String[] args) {
        new Swing_LayoutManager_04_BoxLayout();
    }

    public Swing_LayoutManager_04_BoxLayout() {
        boxlayoutX_AXISExample();     // Frame for X_AXIS layout
        boxlayoutY_AXISExample();     // Frame for Y_AXIS layout
        boxlayoutLINE_AXISExample();  // Frame for LINE_AXIS with different orientations
        boxlayoutPAGE_AXISExample();  // Frame for PAGE_AXIS with different orientations
    }

    // 1. BoxLayout.X_AXIS Example: Components laid out horizontally from left to right
    void boxlayoutX_AXISExample() {
        frame1 = new JFrame("BoxLayout X_AXIS Example");
        frame1.setLayout(new BoxLayout(frame1.getContentPane(), BoxLayout.X_AXIS));

        addButtons(frame1, "X_AXIS Button");

        frame1.setSize(500, 400);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(true);
    }

    // 2. BoxLayout.Y_AXIS Example: Components laid out vertically from top to bottom
    void boxlayoutY_AXISExample() {
        frame2 = new JFrame("BoxLayout Y_AXIS Example");
        frame2.setLayout(new BoxLayout(frame2.getContentPane(), BoxLayout.Y_AXIS));

        addButtons(frame2, "Y_AXIS Button");

        frame2.setSize(500, 400);
        frame2.setLocation(frame1.getWidth()+5, frame1.getY());
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setVisible(true);
    }

    // 3. BoxLayout.LINE_AXIS Example: Orientation-based alignment (horizontal or vertical based on ComponentOrientation)
    void boxlayoutLINE_AXISExample() {
        frame3 = new JFrame("BoxLayout LINE_AXIS Example");

        // First container: LEFT_TO_RIGHT
        JPanel leftToRightPanel = new JPanel();
        leftToRightPanel.setLayout(new BoxLayout(leftToRightPanel, BoxLayout.LINE_AXIS));
        leftToRightPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        addButtons(leftToRightPanel, "LTR LINE_AXIS Button");

        // Second container: RIGHT_TO_LEFT
        JPanel rightToLeftPanel = new JPanel();
        rightToLeftPanel.setLayout(new BoxLayout(rightToLeftPanel, BoxLayout.LINE_AXIS));
        rightToLeftPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        addButtons(rightToLeftPanel, "RTL LINE_AXIS Button");

        frame3.setLayout(new BoxLayout(frame3.getContentPane(), BoxLayout.Y_AXIS)); // Stack containers vertically
        frame3.add(leftToRightPanel);
        frame3.add(Box.createVerticalStrut(20));  // Add space between panels
        frame3.add(rightToLeftPanel);

        frame3.setSize(500, 400);
        frame3.setLocation(frame2.getX()+frame2.getWidth()+5, frame2.getY());
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setVisible(true);
    }

    // 4. BoxLayout.PAGE_AXIS Example: Orientation-based alignment similar to text flow on a page
    void boxlayoutPAGE_AXISExample() {
        frame4 = new JFrame("BoxLayout PAGE_AXIS Example");

        // First container: LEFT_TO_RIGHT (behaves like Y_AXIS)
        JPanel leftToRightPanel = new JPanel();
        leftToRightPanel.setLayout(new BoxLayout(leftToRightPanel, BoxLayout.PAGE_AXIS));
        leftToRightPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        addButtons(leftToRightPanel, "LTR PAGE_AXIS Button");

        // Second container: RIGHT_TO_LEFT (behaves like Y_AXIS)
        JPanel rightToLeftPanel = new JPanel();
        rightToLeftPanel.setLayout(new BoxLayout(rightToLeftPanel, BoxLayout.PAGE_AXIS));
        rightToLeftPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        addButtons(rightToLeftPanel, "RTL PAGE_AXIS Button");

        frame4.setLayout(new BoxLayout(frame4.getContentPane(), BoxLayout.X_AXIS)); // Stack containers horizontally
        frame4.add(leftToRightPanel);
        frame4.add(Box.createHorizontalStrut(20));  // Add space between panels
        frame4.add(rightToLeftPanel);

        frame4.setSize(500, 400);
        frame4.setLocation(frame1.getX(), frame1.getHeight()+5);
        frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame4.setVisible(true);
    }

    // Helper method to add buttons to a container
    void addButtons(Container container, String buttonPrefix) {
        for (int i = 1; i <= 8; i++) {
            container.add(new JButton(buttonPrefix + " " + i));
        }
    }
}
