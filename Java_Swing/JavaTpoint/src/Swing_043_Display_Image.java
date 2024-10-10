import javax.swing.*;
import java.awt.*;

public class Swing_043_Display_Image extends Canvas {
    @Override
    public void paint(Graphics g) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("src/loading.gif");
        g.drawImage(image,120,100, this);
    }
    public static void main (String [] args){
        Swing_043_Display_Image displayImage = new Swing_043_Display_Image();
        JFrame frame = new JFrame("Swing Display Image");
        frame.add(displayImage);
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
