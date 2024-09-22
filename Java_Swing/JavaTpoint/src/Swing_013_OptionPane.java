import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Swing_013_OptionPane extends WindowAdapter {
    /*
    The JOptionPane class is used to provide standard dialog boxes such as message dialog box,
    confirm dialog box and input dialog box. These dialog boxes are used to display information or get input from the user.
     */
    JFrame frame;
    Swing_013_OptionPane(){
        frame = new JFrame("Swing OptionPane Example");
        frame.setSize(300, 300);
        frame.setLayout(null);

        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, "Hello, Welcome to Swing");
        JOptionPane.showMessageDialog(frame, "Successfully Updated.", "Alert", JOptionPane.WARNING_MESSAGE);
        String name = JOptionPane.showInputDialog(frame,"Enter Name");
        frame.addWindowListener(this);

        frame.setVisible(true);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        int a = JOptionPane.showConfirmDialog(frame,"Are you sure?");
        if(a == JOptionPane.YES_OPTION){
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }

    public static void main(String[] args) {
        new Swing_013_OptionPane();
    }
}
