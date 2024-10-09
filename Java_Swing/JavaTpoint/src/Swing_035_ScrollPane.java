import javax.swing.*;
import java.awt.*;

public class Swing_035_ScrollPane {

    private static final long serialVersionUID = 1L;
    JFrame frame;
    Swing_035_ScrollPane(){
        frame = new JFrame("Swing ScrollPane Example ");
        frame.setLayout(new FlowLayout());
        frame.setSize(400, 300);

        scrollPaneExample(); // javatpoint

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    void scrollPaneExample(){
        JTextArea textArea = new JTextArea(10,20);
        JScrollPane scrollableTextArea = new JScrollPane(textArea);

//        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        frame.add(scrollableTextArea);
    }

    public static void main(String[] args) {
        new Swing_035_ScrollPane();
    }
}
