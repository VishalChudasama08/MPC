import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Customizer;
import java.security.cert.TrustAnchor;

public class Swing_026_Panel {
    JFrame frame;
    Swing_026_Panel(){
        frame = new JFrame("Swing Panel Example");
        frame.setSize(800, 600);
        frame.setLayout(null);

        // Run everything on the Event Dispatch Thread (EDT) for thread safety
        SwingUtilities.invokeLater(() -> {
//            panelExample(); // javatpoint
            panelExample_all();  // chatGPT
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    void panelExample(){
        JPanel panel = new JPanel();
        panel.setBounds(10,80,200,200);
        panel.setBackground(Color.CYAN);

        JButton button1 = new JButton("Button 1");
        button1.setBounds(50,100,80,30);
        button1.setBackground(Color.GREEN);

        JButton button2 = new JButton("Button 2");
        button2.setBounds(100,100,80,30);
        button2.setBackground(Color.YELLOW);

        panel.add(button1);
        panel.add(button2);

        frame.add(panel);
    }

    void panelExample_all(){
        JLabel label = new JLabel("Swing JPanel Advance Example");
        label.setOpaque(true);
        label.setBackground(Color.GREEN);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        // Use a BorderLayout for the JFrame
        frame.setLayout(new BorderLayout(10,20));

        CustomPanel panel = new CustomPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        // Add the custom JPanel to the center of the frame
        frame.add(panel, BorderLayout.CENTER);

        // Create a button to add more components dynamically
        JButton addButton = new JButton("Add Label");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add a new label to the panel when the button is clicked
                panel.addNewLabel("Dynamic label " + (panel.getComponentCount() + 1));
                panel.revalidate(); // Revalidate the panel to adjust the layout
                panel.repaint();     // Repaint the panel to ensure proper rendering
            }
        });

        JButton removeButton = new JButton("Remove Label");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeComponent(panel.getComponentCount()-1);
            }
        });

        JButton clearButton = new JButton("Clear All Labels");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.clearPanel();
            }
        });

        // Add the button to the bottom of the frame
        frame.add(label, BorderLayout.NORTH);
        frame.add(addButton, BorderLayout.SOUTH);
        frame.add(removeButton, BorderLayout.EAST);
        frame.add(clearButton, BorderLayout.WEST);

        // Make the frame visible
        frame.setVisible(true);
    }
    // Custom JPanel class that demonstrates advanced panel features
    static class CustomPanel extends JPanel {

        // Constructor for the custom panel
        public CustomPanel() {
            // Set the layout to FlowLayout for this example
            this.setLayout(new FlowLayout());

            // Add initial components to the panel
            this.add(new JLabel("Label 1"));
            this.add(new JLabel("Label 2"));

            // Set preferred size for the panel
            this.setPreferredSize(new Dimension(400, 300));
        }

        // Method to add a new JLabel dynamically to the panel
        public void addNewLabel(String labelText) {
            JLabel label = new JLabel(labelText);
            this.add(label);  // Add the label to the panel
        }

        // Override paintComponent to custom draw on the panel
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);  // Always call the superclass method first

            // Custom drawing: Draw a rectangle border around the panel
            g.setColor(Color.BLACK);
            g.drawRect(10, 10, getWidth() - 20, getHeight() - 20);
        }

        // Method to remove a specific component by index
        public void removeComponent(int index) {
            if (index >= 0 && index < this.getComponentCount()) {
                this.remove(index);  // Remove the component at the specified index
                this.revalidate();   // Revalidate the panel to update the layout
                this.repaint();      // Repaint the panel to reflect the changes
            }
        }

        // Method to clear all components from the panel
        public void clearPanel() {
            this.removeAll();     // Remove all components from the panel
            this.revalidate();    // Revalidate the layout
            this.repaint();       // Repaint to reflect the empty panel
        }
    }

    public static void main(String[] args) {
        new Swing_026_Panel();
    }
}
