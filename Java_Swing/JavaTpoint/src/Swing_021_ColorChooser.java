import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Swing_021_ColorChooser {
    JFrame frame, frame2;
    Swing_021_ColorChooser(){
        frame = new JFrame("Swing ColorChooser Example");
        frame.setSize(400, 300);
        frame.setLayout(null);
//        frame2 = frame;

        // The JColorChooser class is used to create a color chooser dialog box so that user can select any color
        colorChooserExample(); // javatpoint
        colorChooserExample2(); // javatpoint

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    void colorChooserExample(){
        Container container = frame.getContentPane();
        container.setLayout(new FlowLayout());
        JButton button = new JButton("color");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color initialcolor = Color.RED;
                Color color = JColorChooser.showDialog(frame, "Select a color ", initialcolor);
                container.setBackground(color);
            }
        });
        container.add(button);
    }

    void colorChooserExample2(){
        frame2 = new JFrame("Swing ColorChooser Example");
        frame2.setSize(400, 300);
        frame2.setLayout(null);

        JButton button = new JButton("Pad Color");
        button.setBounds(10, 220, 100, 30);

        JTextArea textAre = new JTextArea();
        textAre.setBounds(10,10,300,200);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = JColorChooser.showDialog(frame2, "Choose", Color.CYAN);
                textAre.setBackground(color);
            }
        });

        frame2.add(textAre);
        frame2.add(button);

        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame2.setVisible(true);
        frame2.setLocation(frame.getX()+410, frame.getY());
    }

    public static void main(String[] args) {
        new Swing_021_ColorChooser();
    }
}
