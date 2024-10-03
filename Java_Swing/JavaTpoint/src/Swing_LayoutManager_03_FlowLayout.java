import javax.swing.*;
import java.awt.*;

public class Swing_LayoutManager_03_FlowLayout {
    JFrame frame1,frame2,frame3,frame4,frame5;
    Swing_LayoutManager_03_FlowLayout(){
        // The Java FlowLayout class is used to arrange the components in a line, one after another (in a flow).
        // It is the default layout of the applet or panel.
        // horizontal as well as the vertical gap is 5 units by default in flowlayouts components

        flowLayoutExample(); // javatpoint
        flowLayoutExampleAlign(); // javatpoint
        flowLayoutExampleAlignVGapHGap(); // javatpoint

        flowLayoutExample2();
        flowLayoutExample3();
    }
    void flowLayoutExample(){
        frame1 = new JFrame("LayoutManager FlowLayout Example");
        frame1.setLayout(new FlowLayout());

        buttons(frame1);

        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(true);
    }
    void flowLayoutExampleAlign(){
        frame2 = new JFrame("FlowLayout.RIGHT");

        // in one row set three components. this type total three rows
        frame2.setLayout(new FlowLayout(FlowLayout.RIGHT));

        buttons(frame2);

        frame2.setLocation(frame1.getWidth()+5, frame1.getY());
    }
    void flowLayoutExampleAlignVGapHGap(){
        frame3 = new JFrame("FlowLayout.LEFT, 12, 18");

        // where alignment is left
        // horizontal gap is 12 units and vertical gap is 18 units.
        frame3.setLayout(new FlowLayout(FlowLayout.LEFT, 12, 18));

        buttons(frame3);

        frame3.setLocation(frame2.getX()+frame2.getWidth()+5, frame1.getY());
    }
    void flowLayoutExample2(){
        frame4 = new JFrame("FlowLayout.LEADING");
        frame4.setLayout(new FlowLayout(FlowLayout.LEADING));

        buttons(frame4);

        frame4.setLocation(frame3.getX()+frame3.getWidth()+5, frame3.getY());
    }
    void flowLayoutExample3(){
        frame5 = new JFrame("FlowLayout.LEFT");
        frame5.setLayout(new FlowLayout(FlowLayout.LEFT));

        buttons(frame5);

        frame5.setLocation(frame4.getX()+frame4.getWidth()+5, frame4.getY());
    }
    public static void main(String[] args) {
        new Swing_LayoutManager_03_FlowLayout();
    }

    static void buttons(JFrame frame){
        frame.setSize(300,200);

        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");
        JButton button6 = new JButton("6");
        JButton button7 = new JButton("7");
        JButton button8 = new JButton("8");
        JButton button9 = new JButton("9");

        frame.add(button1);frame.add(button2);frame.add(button3);
        frame.add(button4);frame.add(button5);frame.add(button6);
        frame.add(button7);frame.add(button8);frame.add(button9);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}
