import javax.swing.*;
import java.awt.*;

public class Swing_004_Label {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Lable Example");

        JLabel label1 = new JLabel("I Am simple Label1.");
        label1.setBounds(50, 0, 100, 30);

        JLabel label2 = new JLabel("I am label2");
        label2.setBounds(50, 150, 200, 30); // x, y, width, height
        label2.setText("I am label2:- setText, setFont"); // Update text
        String label2text = label2.getText(); // get label text
        label2.setFont(new Font("Serif", Font.BOLD, 16)); // font name, style, size

        JLabel label3 = new JLabel("I am Label3");
        ImageIcon icon = new ImageIcon("src/swinghierarchy.jpg");
        label3.setBounds(50, 200, 644, 520); // x, y, width, height
        label3.setToolTipText("I am Label3:- ImageIcon");
        label3.setIcon(icon);

        JLabel label4 = getLabel4(); // if many contect than cover in method it is best way

        frame.add(label4);
        frame.add(label3);
        frame.add(label2);
        frame.add(label1);

        frame.setSize(800, 800);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true); // Show the frame
    }

    private static JLabel getLabel4() {
        JLabel label4 = new JLabel();
        label4.setText("<html>I am Label4:- setOpaque, setBackground, setForeground, setBorder, setToolTipText, setHorizontalAlignment, setVerticalAlignment</html>");
        // Yes HTML Support 😃😃
        // inner <html></html> tag supported tag is ->
        // Basic Formatting: Tags like <b>, <i>, <u>, and <font> for bold, italic, underline, and font changes.
        // Paragraphs and Line Breaks: Tags like <p> and <br> for paragraphs and line breaks.
        // Lists: Tags like <ul>, <ol>, and <li> for unordered and ordered lists.
        label4.setBounds(50, 50, 700, 80); // not needed because setHorizontalAlignment and setVerticalAlignment is set
        label4.setOpaque(true); // By default, JLabel is not render its background color. You need to make it opaque to see the background color.
        label4.setBackground(Color.GREEN); // background color
        label4.setForeground(Color.BLUE); // text color
        label4.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        label4.setToolTipText("This is Label 4");

        // set -> frame.setLayout(new FlowLayout()); than set setHorizontalAlignment and setVerticalAlignment
//        label4.setHorizontalAlignment(JLabel.CENTER); // Set Horizontal Alignment: options: CENTER, LEFT, RIGHT
//        label4.setVerticalAlignment(JLabel.CENTER);  // Set Vertical Alignment: options: CENTER, TOP, BOTTOM
        return label4;
    }
}
