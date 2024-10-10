import javax.swing.*;
import java.awt.*;

public class Swing_041_TitleBar_icon {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Image icon = Toolkit.getDefaultToolkit().getImage("src/krishna.jpg");
        frame.setIconImage(icon);

        frame.setLayout(null);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
