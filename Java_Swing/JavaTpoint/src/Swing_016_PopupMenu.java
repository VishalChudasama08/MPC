import javax.swing.*;

public class Swing_016_PopupMenu {
    JFrame frame;
    Swing_016_PopupMenu(){
        frame = new JFrame("Swing PopupMenu Example");
        frame.setSize(500, 400);
        frame.setLayout(null);

        popupMenuExample(); // javatpoint

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    void popupMenuExample(){

    }

    public static void main(String[] args) {
        new Swing_013_OptionPane();
    }
}
