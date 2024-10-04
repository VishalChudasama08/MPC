import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Swing_028_ToggleButton {
    JFrame frame;
    Swing_028_ToggleButton(){
        frame = new JFrame("Swing Toggle Button example");
        frame.setSize(400,300);
        frame.setLayout(new FlowLayout());

        // JToggleButton is used to create toggle button, it is two-states button to switch on or off.
        toggleButtonExample(); // javatpoint

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    void toggleButtonExample(){
        JToggleButton toggleButton = new JToggleButton("On");
        toggleButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(toggleButton.isSelected()){
                    toggleButton.setText("Off");
                } else {
                    toggleButton.setText("On");
                }
            }
        });
        frame.add(toggleButton);
    }

    public static void main(String[] args) {
        new Swing_028_ToggleButton();
    }
}
