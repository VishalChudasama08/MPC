import javax.swing.*;
import java.awt.*;

public class Swing_005_TextField {
    public static void main(String[] args) {
        JFrame frame = new JFrame("TextField example");
        frame.setLayout(null);
        frame.setSize(800, 800);

        JTextField textField1, textField2, textField3_1, textField3_2, textField3_3, textField4, textField5;

        // textField1 : simple JTextField with default configuration
        textField1 = new JTextField("Welcome Java Swing Text Field. textField1 - this is simple text filed ");
        textField1.setBounds(50, 50, 200, 30); // Set position and size

        // textField2 : setFont to set Font type, make bold font, font size and tooltip
        textField2 = new JTextField("textField2 - setFont");
        textField2.setBounds(50, 100, 200, 30);  // Set position and size
        textField2.setFont(new Font("Arial",Font.BOLD, 14));
        // Font Constructors => arguments -> first - font name, second - font style, third font size (this all three argument is not optional it is required)
        // Font.BOLD (Bold text.), Font.PLAIN (Regular text (no emphasis).), Font.ITALIC (Italicized text.)
        textField2.setToolTipText("This is a tooltip for TextField 2"); // Set a tooltip that appears when hovering over the text field

        // textField3 : JTextField with text alignment and column size
        textField3_1 = new JTextField("text Center Aligned.", 20); // Create a JTextField with initial text and column size 20 (in frame setLayout use FlowLayout than working column -> frame.setLayout(new FlowLayout());)
        textField3_2 = new JTextField("text LEFT Aligned (default).");
        textField3_3 = new JTextField("text RIGHT Aligned.");
        textField3_1.setHorizontalAlignment(JTextField.CENTER); // in text field Set text alignment to center (other options: LEFT, RIGHT)
        textField3_2.setHorizontalAlignment(JTextField.LEFT);
        textField3_3.setHorizontalAlignment(JTextField.RIGHT);
        textField3_1.setBounds(50, 150, 200, 30);  // Set position and size
        textField3_2.setBounds(300, 150, 200, 30);
        textField3_3.setBounds(550, 150, 200, 30);

        // textField4 : JTextField in a disabled state (not interactive)
        textField4 = new JTextField("textField4 - Disabled TextField");
        textField4.setBounds(50, 200, 200, 30); // Set position and size
        textField4.setEnabled(false); // Disable the text field, making it non-interactive

        // textField5 : JTextField that is non-editable (user cannot change text)
        textField5 = new JTextField("textField5 - Non-editable TextField");
        textField5.setBounds(50, 250, 200, 30); // Set position and size
        textField5.setEditable(false); // Make the text field non-editable (user can't modify the text)

        // TextField 6: JTextField with input constraints (maximum number of characters allowed)
        JTextField textField6 = getJTextField6();

        // TextField 7: JTextField with custom background and text (foreground) color
        JTextField textField7 = new JTextField("Colored and bordered TextField");
        textField7.setBounds(50, 350, 200, 30); // Set position and size
        textField7.setBackground(Color.YELLOW); // Set background color to yellow
        textField7.setForeground(Color.RED); // Set text color to red
        textField7.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2)); // Set a blue border with thickness 2

        // Example of retrieving and using the text from a JTextField
        String textFromField1 = textField1.getText(); // Get the text from textField1
        System.out.println("Text from Field 1: " + textFromField1); // Print the text to the console
        // TextField 8: JTextField with showing text field 1 text
        JTextField textField8 = new JTextField();
        textField8.setBounds(50, 400, 400, 30); // Set position and size
        textField8.setText(textFromField1);

        frame.add(textField8);
        frame.add(textField7);
        frame.add(textField6);
        frame.add(textField5);
        frame.add(textField4);
        frame.add(textField3_3);
        frame.add(textField3_2);
        frame.add(textField3_1);
        frame.add(textField2);
        frame.add(textField1);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    private static JTextField getJTextField6() {
        // TextField 6: JTextField with input constraints (maximum number of characters allowed)
        JTextField textField6 = new JTextField();
        textField6.setBounds(50, 300, 200, 30); // Set position and size
        // Limit the number of characters to 20 by overriding the insertString() method of the PlainDocument class
        textField6.setDocument(new javax.swing.text.PlainDocument(){
            @Override
            public void insertString(int offs, String str, javax.swing.text.AttributeSet a)
                throws javax.swing.text.BadLocationException {
                if (getLength() + str.length() <= 20) { // Check if the total length of text is less than or equal to 10
                    super.insertString(offs, str, a); // If yes, insert the string
                }
            }
        });
        textField6.setText("20 chars only"); // set limit than set Text otherwise not working.
        return textField6;
    }
}
