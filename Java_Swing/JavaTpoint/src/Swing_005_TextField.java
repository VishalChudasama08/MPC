import javax.swing.*;
import java.awt.*;

public class Swing_005_TextField {
    public static void main(String[] args) {
        JFrame frame = new JFrame("TextField example");
        frame.setLayout(null);
        frame.setSize(800, 800);

        JTextField textField1, textField2, textField3;

        // textField1 : simple JTextField with default configuration
        textField1 = new JTextField("Welcome Java Swing Text Field. textField1 - this is simple text filed ");
        textField1.setBounds(50, 50, 200, 30);

        //
        textField2 = new JTextField("textField2 - ");
        textField2.setBounds(50, 100, 200, 30);
        textField2.setFont(new Font("Arial", Font.BOLD, 14));

        frame.add(textField3);
        frame.add(textField2);
        frame.add(textField1);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
