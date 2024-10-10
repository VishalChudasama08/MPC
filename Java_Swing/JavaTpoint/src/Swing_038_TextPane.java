import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;

public class Swing_038_TextPane {
    public static void main(String[] args) throws BadLocationException { // javatpoint
        JFrame frame = new JFrame("Swing TextPane Example");
        frame.setSize(400,300);

        Container container = frame.getContentPane();
        JTextPane pane = new JTextPane();
        SimpleAttributeSet attributeSet = new SimpleAttributeSet();
        StyleConstants.setBold(attributeSet, true);

        // set the attributes before adding text
        pane.setCharacterAttributes(attributeSet, true);
        pane.setText("Welcome");

        attributeSet = new SimpleAttributeSet();
        StyleConstants.setItalic(attributeSet, true);
        StyleConstants.setForeground(attributeSet,Color.red);
        StyleConstants.setBackground(attributeSet, Color.CYAN);

        Document document = pane.getStyledDocument();
        document.insertString(document.getLength(), "To Java ", attributeSet);

        attributeSet = new SimpleAttributeSet();
        document.insertString(document.getLength(), "World", attributeSet);

        JScrollPane scrollPane = new JScrollPane(pane);
        container.add(scrollPane, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
