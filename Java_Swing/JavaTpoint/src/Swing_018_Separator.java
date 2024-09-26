import javax.swing.*;
import javax.swing.plaf.basic.BasicSeparatorUI;
import java.awt.*;

public class Swing_018_Separator {
    // used to provide a general purpose component for implementing divider lines.
    // It is used to draw a line to separate widgets in a Layout
    JFrame frame;
    Swing_018_Separator(){
        frame = new JFrame("Swing Separator Example");
        frame.setSize(800, 600);
        frame.setLayout(new GridLayout(0,1));

        separatorExample(); //javatpoint
        separatorExample2(); //javatpoint
        separatorExample1All(); // chatGPT

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    void separatorExample(){
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem menuItem1 = new JMenuItem("Item 1");
        JMenuItem menuItem2 = new JMenuItem("Item 2");
        JMenuItem menuItem3 = new JMenuItem("Item 3");

        menu.add(menuItem1);
        menu.addSeparator();
        menu.add(menuItem2);
        menu.addSeparator();
        menu.add(menuItem3);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);
    }
    void separatorExample2(){
        JLabel label1 = new JLabel("Above Separator");
        JLabel label2 = new JLabel("Below Separator");
        JLabel label3 = new JLabel("Below Separator");
        JLabel label4 = new JLabel("Below Separator");
        JSeparator separator1 = new JSeparator();
        JSeparator separator2 = new JSeparator();
        JSeparator separator3 = new JSeparator();

        frame.add(label1);
        frame.add(separator1);
        frame.add(label2);
        frame.add(separator2);
        frame.add(label3);
        frame.add(separator3);
        frame.add(label4);
    }

    void separatorExample1All(){
        JFrame frame2 = new JFrame("JSeparator Example");
        frame2.setSize(300, 300);
        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame2.setLayout(null);

        // Horizontal Separator with Line style
        JSeparator horizontalLine = new JSeparator(SwingConstants.HORIZONTAL);
        horizontalLine.setBounds(10, 40, 260, 2);
        horizontalLine.setForeground(Color.RED); // Set foreground color
        frame2.add(horizontalLine);

        // Vertical Separator with Line style
        JSeparator verticalLine = new JSeparator(SwingConstants.VERTICAL);
        verticalLine.setBounds(150, 50, 2, 100);
        verticalLine.setForeground(Color.BLUE); // Set foreground color
        frame2.add(verticalLine);

        // Horizontal Separator with Dashed style
        JSeparator dashedSeparator = new JSeparator(SwingConstants.HORIZONTAL);
        dashedSeparator.setBounds(10, 160, 260, 2);
        dashedSeparator.setForeground(Color.GREEN); // Set foreground color
        dashedSeparator.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Border for visibility
        dashedSeparator.setUI(new BasicSeparatorUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(c.getForeground());
                int y = ((JSeparator) c).getHeight() / 2;
                g2.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{5}, 0));
                g2.drawLine(0, y, c.getWidth(), y);
            }
        });
        frame2.add(dashedSeparator);

        frame2.setVisible(true);
        frame2.setLocation(frame.getX()+800, frame.getY());
    }

    public static void main(String[] args) {
        new Swing_018_Separator();
    }
}
