import javax.swing.*;
import java.awt.*;

/*
The JComponent class is the base class of all Swing components except top-level containers.
Swing components whose names begin with "J" are descendants of the JComponent class.
For example, JButton, JScrollPane, JPanel, JTable etc.
But, JFrame and JDialog don't inherit JComponent class because they are the child of top-level containers.
 */

class MyJComponent extends JComponent {
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(30,30,100,100);
    }
}
public class Swing_031_Component {
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("JComponent Example");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyJComponent componentObj = new MyJComponent();

        frame.add(componentObj);
        frame.setVisible(true);
    }
}

