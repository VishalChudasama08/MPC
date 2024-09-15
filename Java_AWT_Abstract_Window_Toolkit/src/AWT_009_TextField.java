import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AWT_009_TextField implements ActionListener {
    Frame frame;
    Label label1,label2,label3;
    TextField textField1,textField2,textField3;
    Button button1,button2,button3,button4;
    AWT_009_TextField(){

        frame = new Frame("AWT TextField example");
        frame.setSize(600,500);
        frame.setLayout(null);

        // The TextField class in AWT is a text component that allows the user to enter and edit a single line of text.
        textField_example(); // source: javaTPoint
//        textField_example1(); // source: chatGPT

        frame.setVisible(true);
    }
    void textField_example(){
        TextField textField = new TextField("Enter text here...");
        textField.setBounds(50,50,180,20);

        label1 = new Label("Enter Number 1 :-");
        label1.setBounds(10,100,100,20);
        textField1 = new TextField();
        textField1.setBounds(110, 100, 100, 20);

        label2 = new Label("Enter Number 2 :-");
        label2.setBounds(10,120,100,20);
        textField2 = new TextField();
        textField2.setBounds(110, 120, 100, 20);

        label3 = new Label("Result :-");
        label3.setBounds(330,110,50,20);
        textField3 = new TextField();
        textField3.setBounds(380, 110, 100, 20);

        button1 = new Button("+");
        button1.setFont(new Font("Arial", Font.BOLD, 14));
        button1.setBounds(220,110,20,20);
        button1.addActionListener(this);

        button2 = new Button("-");
        button2.setFont(new Font("Arial", Font.BOLD, 14));
        button2.setBounds(245,110,20,20);
        button2.addActionListener(this);

        button3 = new Button("*");
        button3.setFont(new Font("Arial", Font.BOLD, 14));
        button3.setBounds(270,110,20,20);
        button3.addActionListener(this);

        button4 = new Button("/");
        button4.setFont(new Font("Arial", Font.BOLD, 14));
        button4.setBounds(295,110,20,20);
        button4.addActionListener(this);

        frame.add(button4);
        frame.add(button3);
        frame.add(button2);
        frame.add(button1);
        frame.add(textField3);
        frame.add(label3);
        frame.add(textField2);
        frame.add(label2);
        frame.add(textField1);
        frame.add(label1);
        frame.add(textField);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int value1 = Integer.parseInt(textField1.getText());
        int value2 = Integer.parseInt(textField2.getText());
        int result = 0;
        if(e.getSource() == button1){
            result = value1 + value2;
        } else if (e.getSource() == button2){
            result = value1 - value2;
        } else if (e.getSource() == button3){
            result = value1 * value2;
        } else if (e.getSource() == button4){
            result = value1 / value2;
        }
        textField3.setText(String.valueOf(result)); // convert in string and set
    }

    void textField_example1(){
        frame.setLayout(new FlowLayout());

        Label label = new Label("Enter Text :- ");

        // Create a TextField with 20 columns
        TextField textField = new TextField(20);

        // Create a Label to show the text from the TextField
        Label resultLabel = new Label("Result: ", Label.CENTER);
        resultLabel.setPreferredSize(new Dimension(350, 50)); // Set an initial width for the label

        // Set some default text in the TextField
        textField.setText("Hello World");

        // Add a button to get the current text from the TextField
        Button getTextButton = new Button("Get Text");

        // Add a button to select all text in the TextField
        Button selectAllButton = new Button("Select All");

        // Add a button to clear the text in the TextField
        Button clearTextButton = new Button("Clear Text");

        // Add ActionListener to get the text from the TextField and show it in the Label
        getTextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the text from the TextField
                String text = textField.getText();
                resultLabel.setText("Result: " + text);
            }
        });

        // Add ActionListener to select all text in the TextField
        selectAllButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Ensure the TextField has focus
//                textField.requestFocus();
                // Select all text in the TextField
                textField.selectAll();
            }
        });

        // Add ActionListener to clear the text in the TextField
        clearTextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Clear the text in the TextField
                textField.setText("");
            }
        });

        // Add components to the frame
        frame.add(label);
        frame.add(textField);
        frame.add(getTextButton);
        frame.add(selectAllButton);
        frame.add(clearTextButton);
        frame.add(resultLabel);

        // Close the frame when the window is closed
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new AWT_009_TextField();
    }
}
