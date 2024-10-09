import javax.swing.*;

public class Swing_034_EditorPane {
    JFrame frame;
    Swing_034_EditorPane(){
        frame = new JFrame("Swing EditorPane Example");
        frame.setSize(400, 300);

        /*
        JEditorPane is a class in Java Swing that provides a text component that can display rich text.
        It supports various types of content, including plain text, HTML, and RTF (Rich Text Format).
        It is used to create text editors, web browsers, and other applications that need to display and possibly edit formatted text.
        It inherits from javax.swing.text.JTextComponent, making it a versatile choice for handling text with different formatting requirements in Java applications.
         */

        JEditorPane editorPane = new JEditorPane();
        editorPane.setContentType("text/html");
        editorPane.setText("<h1>Sleeping</h1><p> is necessary for a healthy body." +
            " But sleeping in unnecessary times may spoil our he alt, wealth and studies." +
            " Doctors advise that the sleeping at improper timings may lead for obesity during the students days.</p>");

        frame.setContentPane(editorPane);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Swing_034_EditorPane();
    }
}
