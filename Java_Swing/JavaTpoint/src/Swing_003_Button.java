import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Swing_003_Button {
    public static
    void main(String[] args) {
        JFrame f = new JFrame("Button Example");

        JTextField tf = new JTextField(); // text input box
        tf.setBounds(50, 50, 200, 25);

        JButton b1 = new JButton("Button 1"); // create button and set title (button text)
        b1.setBounds(50, 100, 100,30);
//        b1.setBorderPainted(true);
        // Remove default border
//        b1.setBorder(BorderFactory.createEmptyBorder());

        b1.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        b1.setFocusPainted(false);  // Remove focus indication (outline) when the button is pressed

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf.setText("कृष्णम सदा सहायते it's Button");
            }
        });



        JButton b2 = new JButton("<html><b>Button 2 With b (bold) tag </b></html>");
        // Set the position and size of the button
        b2.setBounds(100, 100, 222, 50);
        // Set the tooltip text that appears when hovering over the button
        b2.setToolTipText("Click this button to perform an action");
        // Change the button's background color
        b2.setBackground(java.awt.Color.CYAN);
        // Change the button's foreground color (text color)
        b2.setForeground(java.awt.Color.RED);
        // Set the button's font and size
        b2.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 16));
        // Set the button's enabled/disabled state
        b2.setEnabled(true); // Set to false to disable the button

        // Add an ActionListener to handle button clicks
        b2.addActionListener(e -> {
            // Action to be performed when the button is clicked
            JOptionPane.showMessageDialog(f, "Button was clicked!");
        });

        JButton b3 = new JButton(new ImageIcon("src/img.png"));
        b3.setBounds(100,200,273, 110);
        b3.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
        b3.setToolTipText("I Am Button");
        f.add(b3);

        f.add(b2);

        f.add(b1);
        f.add(tf);
        f.setSize(400, 400);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

}
