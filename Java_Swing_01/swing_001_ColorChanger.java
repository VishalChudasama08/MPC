import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class swing_001_ColorChanger {
    private JFrame frame;
    private String[] colors = {"Red", "Blue", "Green", "Yellow", "Black"};

    public ColorChanger() {
        frame = new JFrame("Color Changer");
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (String color : colors) {
            JButton colorButton = new JButton(color);
            colorButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    changeColor(color);
                }
            });
            frame.add(colorButton);
        }

        frame.setVisible(true);
    }

    private void changeColor(String color) {
        switch (color) {
            case "Red":
                frame.getContentPane().setBackground(Color.RED);
                break;
            case "Blue":
                frame.getContentPane().setBackground(Color.BLUE);
                break;
            case "Green":
                frame.getContentPane().setBackground(Color.GREEN);
                break;
            case "Yellow":
                frame.getContentPane().setBackground(Color.YELLOW);
                break;
            case "Black":
                frame.getContentPane().setBackground(Color.BLACK);
                break;
        }
    }

    public static void main(String[] args) {
        new ColorChanger();
    }
}
