import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AWT_010_TextArea implements ActionListener {
    Frame frame;
    TextArea textArea;
    Label label1,label2;
    Button button;
    AWT_010_TextArea(){
        frame = new Frame("TextArea Example");
        frame.setLayout(null);
        frame.setSize(800, 600);

        // The text area allows us to type as much text as we want.
        // When the text in the text area becomes larger than the viewable area,
        // the scroll bar appears automatically which helps us to scroll the text up and down,
        // or right and left.
        textArea_example(); // source: javaTPoint
        textArea_example1(); // source: chatGPT

        frame.setVisible(true);
    }

    void textArea_example(){
        textArea = new TextArea("Welcome to Text Area");
        textArea.setBounds(50,50,300,100);

        label1 = new Label();
        label1.setBounds(400,75, 150, 30);
        label2 = new Label();
        label2.setBounds(400, 100, 150, 30);

        button = new Button("Count");
        button.setBounds(400, 50, 50,20);
        button.addActionListener(this);

        frame.add(button);
        frame.add(label2);
        frame.add(label1);
        frame.add(textArea);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = textArea.getText();
        String [] words = text.split("\\s");
        label1.setText("Words: "+words.length);
        label2.setText("Characters: "+text.length());
    }
    void textArea_example1(){
        // Set the layout to FlowLayout (organizes components in a row, left to right)
        frame.setLayout(new FlowLayout());

        TextArea textArea1 = new TextArea(5, 30);
        textArea1.setText("This is a default text in the TextArea.\nYou can modify it.");

        // Enable or disable text editing (set to true by default)
        textArea1.setEditable(true); // false will make it read-only

        // Set the maximum number of characters visible in the text area (rows and columns)
        textArea1.setRows(5);    // 5 visible rows
        textArea1.setColumns(30); // 30 characters visible in a row

        // Create a Label to show the text from the TextArea
        Label resultLabel = new Label("Result: ");

        // Add a button to get the current text from the TextArea
        Button getTextButton = new Button("Get Text");
        // Add ActionListener to get the text from the TextArea and display it in the Label
        getTextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the text from the TextArea
                String text = textArea1.getText();
                // Display the text in the resultLabel
                resultLabel.setText("Result: " + text);
            }
        });

        // Add a button to clear the text in the TextArea
        Button clearTextButton = new Button("Clear Text");

        // Add ActionListener to clear the text in the TextArea
        clearTextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Clear the text inside the TextArea
                textArea1.setText("");
            }
        });

        // Add components to the frame
        frame.add(textArea1);       // Add the TextArea to the frame
        frame.add(getTextButton);  // Add the button to get text
        frame.add(clearTextButton); // Add the button to clear text
        frame.add(resultLabel);    // Add the Label to display the result

        // Close the frame when the window is closed
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0); // Exit the application
            }
        });

    }

    public static void main(String[] args) {
        new AWT_010_TextArea();
    }
}
