import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.concurrent.atomic.AtomicBoolean;

public class Swing_009_RadioButton {
    JFrame frame;
    Swing_009_RadioButton(){
        frame = new JFrame("Radio Button Example");
        frame.setSize(400, 500);
        frame.setLayout(null);

        radioButtonExample(); // javaTPoint
        radioButtonExample_toggle();
        radioButtonExample_all();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    void radioButtonExample(){
        JRadioButton radioButton1 = new JRadioButton("A) Male");
        JRadioButton radioButton2 = new JRadioButton("B) Female");

        radioButton1.setBounds(10, 10,100,30);
        radioButton2.setBounds(10, 40,100,30);

        // ButtonGroup is used to ensure that only one radio button in a group can be selected at a time.
        // When you add radio buttons to a ButtonGroup, selecting one automatically deselects any previously selected button within the same group.
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);

        JButton button = new JButton("Click");
        button.setBounds(120, 25, 60, 30);
        button.setMargin(new Insets(0,0,0,0));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radioButton1.isSelected()){
                    JOptionPane.showMessageDialog(button, "You are Male");
                }
                if (radioButton2.isSelected()){
                    JOptionPane.showMessageDialog(button,"You are Female");
                }
            }
        });

        frame.add(radioButton1);
        frame.add(radioButton2);
        frame.add(button);
    }

    void radioButtonExample_toggle(){
        JRadioButton radioButton1 = new JRadioButton("A) Male");
        JRadioButton radioButton2 = new JRadioButton("B) Female");
        JRadioButton radioButton3 = new JRadioButton("C) Another");
        JRadioButton radioButton4 = new JRadioButton("D) None");

        radioButton1.setBounds(10, 100,80,30);
        radioButton2.setBounds(100, 100,100,30);
        radioButton3.setBounds(200, 100,100,30);
        radioButton4.setBounds(300, 100,80,30);

        radioButton4.setEnabled(false); // Disables the button
        radioButton1.setMnemonic(KeyEvent.VK_A); // Pressing 'Alt + A' keyboard key will select this button
        radioButton2.setMnemonic(KeyEvent.VK_B); // Pressing 'Alt + B' keyboard key will select this button
        radioButton3.setMnemonic(KeyEvent.VK_C); // Pressing 'Alt + C' keyboard key will select this button

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
        buttonGroup.add(radioButton3);

        AtomicBoolean toggleSelectionMale = new AtomicBoolean(false);
        AtomicBoolean toggleSelectionFemale = new AtomicBoolean(false);
        radioButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(toggleSelectionMale.get()){
                    buttonGroup.clearSelection(); // Deselect the radio button
                    toggleSelectionMale.set(false);
                } else {
                    radioButton1.setSelected(true); // select the radio button
                    toggleSelectionMale.set(true);
                    toggleSelectionFemale.set(false);
                }
            }
        });
        radioButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(toggleSelectionFemale.get()){
                    buttonGroup.clearSelection(); // Deselect the radio button
                    toggleSelectionFemale.set(false);
                } else {
                    radioButton2.setSelected(true); // select the radio button
                    toggleSelectionFemale.set(true);
                    toggleSelectionMale.set(false);
                }
            }
        });

        frame.add(radioButton1);
        frame.add(radioButton2);
        frame.add(radioButton3);
        frame.add(radioButton4);
    }

    void radioButtonExample_all(){
        // Creating radio buttons
        JRadioButton radioButton1 = new JRadioButton("Male");
        JRadioButton radioButton2 = new JRadioButton("Female");

        radioButton1.setBounds(50, 200, 100,30);
        radioButton2.setBounds(150, 200, 100,30);

        // Setting a tooltip text
        radioButton1.setToolTipText("Select if you are male");
        radioButton2.setToolTipText("Select if you are female");

        // Adding an action command
        // Sets a command string for the radio button.
        // This can be useful for handling ActionEvents.
        // for many radio button than this best way for Action event listener
        radioButton1.setActionCommand("male");
        radioButton2.setActionCommand("female");

        // Creating a button group
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);

        // Adding an ActionListener to the radio buttons
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieving the action command when a button is selected
                String selection = e.getActionCommand();
                JOptionPane.showMessageDialog(frame, "You selected: " + selection);
            }
        };

        // Attaching the ActionListener
        // Adds an ActionListener to handle events when the radio button is clicked.
        radioButton1.addActionListener(actionListener);
        radioButton2.addActionListener(actionListener);

        // Add radio buttons to frame
        frame.add(radioButton1);
        frame.add(radioButton2);

        // Set one of the radio buttons as selected by default
        radioButton1.setSelected(true);
    }

    public static void main(String[] args) {
        new Swing_009_RadioButton();
    }
}
