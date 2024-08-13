import javax.swing.*;
import java.awt.*;

public class Swing_HTMLSupport {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Full HTML Example");
        frame.setLayout(new FlowLayout());
        frame.setSize(700, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // JLabel with various HTML tags and inline styles
        JLabel label = new JLabel("<html>" +
                "<h1>h1 Header</h1>" + "<h2>h2 Header</h2>" + "<h3>h3 Header</h3>" + "<h4>h4 Header</h4>" + "<h5>h5 Header</h5>" + "<h6>h6 Header</h6>" +
                "<p>This is a <b>bold</b> paragraph with <i>italic</i> and <u>underlined</u> text.</p>" +
                "<p style='color: green; font-size: 16px;'>This text is <span style='color: blue;'>blue</span> and has custom font size.</p>" +
                "<ul>" +
                "<li>First item</li>" +
                "<li>Second item with <b>bold</b> text</li>" +
                "</ul>" +
                "<ol>" +
                "<li>Ordered item 1</li>" +
                "<li>Ordered item 2 with <i>italic</i> text</li>" +
                "</ol>" +
                "</html>");

        // JButton with HTML content and inline styles
        JButton button = new JButton("<html><br><font color='white' face='Arial' size='5'>Styled <b>Button</b></font><br></html>");
        button.setBackground(Color.BLUE);
        button.setOpaque(true);
        button.setBorderPainted(false);

        JLabel labelBr = new JLabel("<html><br><br><br><br></html>");

        // JCheckBox with HTML content and inline styles
        JCheckBox checkBox = new JCheckBox("<html><font color='purple'>Check this <b>option</b></font></html>");

        // JRadioButton with HTML content and inline styles
        JRadioButton radioButton = new JRadioButton("<html><font color='orange'>Select <i>this</i> option</font></html>");

        // JTextPane with complex HTML content and inline styles
        JTextPane textPane = new JTextPane();
        textPane.setContentType("text/html");
        textPane.setText("<html>" +
                "<h2>Styled JTextPane</h2>" +
                "<p style='font-family: Verdana; font-size: 14px;'>This is a <b>JTextPane</b> with <i>HTML</i> content and inline styles.</p>" +
                "<p style='background-color: yellow;'>This paragraph has a yellow background.</p>" +
                "</html>");

        // JEditorPane with complex HTML content and inline styles
        JEditorPane editorPane = new JEditorPane();
        editorPane.setContentType("text/html");
        editorPane.setText("<html>" +
                "<h3>Styled JEditorPane</h3>" +
                "<p style='color: red; font-size: 18px;'>Text with <u>underline</u> and <b>bold</b> styles.</p>" +
                "<p style='text-align: center;'>This paragraph is centered.</p>" +
                "</html>");

        // Add components to the frame
        frame.add(label);
        frame.add(labelBr);
        frame.add(button);
        frame.add(checkBox);
        frame.add(radioButton);
        frame.add(new JScrollPane(textPane)); // Use JScrollPane to handle text pane overflow
        frame.add(new JScrollPane(editorPane)); // Use JScrollPane to handle editor pane overflow

        // Make the frame visible
        frame.setVisible(true);
    }
}
