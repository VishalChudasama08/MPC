import javax.swing.*;
import java.awt.*;

public class Swing_LayoutManager_BorderLayout {
    static JFrame frame1, frame2, frame3;

    Swing_LayoutManager_BorderLayout(){
        frame1 = getFrame("Swing BorderLayout", new BorderLayout());

        frame2 = getFrame("Swing BorderLayout with component gap", new BorderLayout(12, 18));
        frame2.setLocation(frame1.getWidth() + 10, frame1.getY());
        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame3 = new JFrame("Swing BorderLayout without set Region");
        frame3.setSize(500, 400);
        frame3.setLayout(new BorderLayout()); // default layout is BorderLayout
        frame3.setLocation(frame2.getX() + frame2.getWidth() + 10, frame2.getY());

        borderLayoutExampleForFrame3();

        frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame3.setVisible(true);
    }

    static JFrame getFrame(String title, LayoutManager layoutStyle){
        JFrame frame = new JFrame(title);
        frame.setSize(500, 400);
        frame.setLayout(layoutStyle); // default layout is BorderLayout

        borderLayoutExample(frame);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        return frame;
    }

    static void borderLayoutExample(JFrame frame){
        frame.add(new JButton("I Am North"), BorderLayout.NORTH);
        frame.add(new JButton("I Am South"), BorderLayout.SOUTH);
        frame.add(new JButton("I Am East"), BorderLayout.EAST);
        frame.add(new JButton("I Am West"), BorderLayout.WEST);
        frame.add(new JButton("I Am Center"), BorderLayout.CENTER);
    }

    static void borderLayoutExampleForFrame3(){
        frame3.add(new JButton("I Am North and Button 1"));
        frame3.add(new JButton("I Am South and Button 2"));
        frame3.add(new JButton("I Am East and Button 3"));
        frame3.add(new JButton("I Am West and Button 4"));
        frame3.add(new JButton("I Am Center and Button 5"));
    }

    public static void main(String[] args) {
        new Swing_LayoutManager_BorderLayout();
    }
}
