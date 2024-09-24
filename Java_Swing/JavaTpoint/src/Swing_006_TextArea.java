import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Swing_006_TextArea implements ActionListener {
    JFrame frame; // for access in any method declare global
    JTextArea textArea;
    JLabel l1,l2,l3;
    JButton button;
    public Swing_006_TextArea(){
        frame = new JFrame("Text Area Example");
        frame.setLayout(null);
        frame.setSize(1000, 600);

        textArea(); // calling method (method inner data source:- javaTpoint)
        textAreaChatGPT(); // (method inner data source:- chatGPT)

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void textArea(){
        // A JTextArea is a component in Java Swing that allows you to display and edit multiple lines of text.
        // It's like a big text box where you can write and read lots of text, and it supports features like scrolling
        // if the text is too long to fit in the visible area.
        // It doesn't have a scroll bar by default
        JTextArea area = new JTextArea("javax.swing.JTextArea \nI Am Simple Writable Text Area");
        area.setBounds(10, 10, 200, 200);
        area.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        textArea = new JTextArea();
        textArea.setBounds(10, 220, 300, 200);
        textArea.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        button = new JButton("Count Words");
        button.setBounds(320, 260, 100, 30);
        button.setMargin(new Insets(0,0,0,0));
        button.addActionListener(this);

        l1 = new JLabel("0");
        l1.setBounds(320, 310, 150, 30);

        l2 = new JLabel("0");
        l2.setBounds(320, 350, 150, 30);

        l3 = new JLabel("0");
        l3.setBounds(320, 390, 150, 30);

        frame.add(l3);
        frame.add(l2);
        frame.add(l1);
        frame.add(button);
        frame.add(textArea);
        frame.add(area);
    }

    private void textAreaChatGPT(){
        // Create a JTextArea object
        JTextArea textArea = new JTextArea();
        textArea.setText("This is a JTextArea example with this future :- \n" +
                "1. For Scroll bar enabled Create a JScrollPane and add the JTextArea to it \n" +
                "2. Lines will be wrapped at word boundaries. \n" +
                "3. Words will wrap instead of splitting. \n" +
                "4. Create a JButton that clears the JTextArea when clicked.");

        // Set line wrap and word wrap
        textArea.setLineWrap(true); // Lines will be wrapped at word boundaries
        textArea.setWrapStyleWord(true); // Words will wrap instead of splitting

        // Create a JScrollPane and add the JTextArea to it
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(500, 20, 300, 200); // Set position and size manually

        // Add the JScrollPane (which contains the JTextArea) to the frame
        frame.add(scrollPane);

        // Create a JButton that clears the JTextArea when clicked
        JButton clearButton = new JButton("Clear Text");
        clearButton.setBounds(500, 240, 120, 30); // Set position and size manually
        frame.add(clearButton);

        // Add an action listener to the button to clear the text when clicked
        clearButton.addActionListener(e -> textArea.setText("")); // Clear text on button click



        // Add FocusListener to simulate placeholder behavior
        JTextArea textArea1 = new JTextArea();
        textArea1.setBounds(500, 300, 320, 200);

        String placeholder = "Enter your text here...";
        textArea1.setText(placeholder);
        textArea1.setForeground(Color.GRAY); // Placeholder text in gray
        textArea1.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (textArea1.getText().equals(placeholder)) {
                    textArea1.setText("");  // Remove placeholder when focused
                    textArea1.setForeground(Color.BLACK); // Set text color to black
                }
            }
            public void focusLost(FocusEvent e) {
                if (textArea1.getText().isEmpty()) {
                    textArea1.setText(placeholder); // Show placeholder again when focus is lost and the text area is empty
                    textArea1.setForeground(Color.GRAY); // Set placeholder text color to gray
                }
            }
        });
        frame.add(textArea1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = textArea.getText();
        String[] words = text.isEmpty() ? new String[0] : text.split("\\s");
        String[] newLine = text.isEmpty() ? new String[0] : text.split("\\n");

        l1.setText("Words: " + words.length);
        l2.setText("Characters: " + text.length());
        l3.setText("Total line : " + newLine.length);
    }

    public static void main(String[] args) {
        new Swing_006_TextArea(); // main method calling self class
    }
}
