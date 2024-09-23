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
        JLabel label = new JLabel("Hello " + name);
        label.setBounds(20,20,200,30);
        frame.add(label);

        frame.addWindowListener(this);

        frame.setVisible(true);

        optionPane_example_all(); // chatGPT
    }
    void optionPane_example_all(){
        // 1. Show a simple message dialog
        JOptionPane.showMessageDialog(null, "This is a simple message", "Message", JOptionPane.INFORMATION_MESSAGE);

        // 2. Show a confirmation dialog (Yes/No)
        int confirm = JOptionPane.showConfirmDialog(null, "Do you want to proceed?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            System.out.println("User chose Yes");
        } else {
            System.out.println("User chose No");
        }

        // 3. Show an input dialog to get a string from the user
        String input = JOptionPane.showInputDialog(null, "Enter your name:", "Input", JOptionPane.QUESTION_MESSAGE);
        if (input != null && !input.isEmpty()) {
            System.out.println("User entered: " + input);
        } else {
            System.out.println("User cancelled input or entered nothing.");
        }

        // 4. Show an option dialog with custom options (e.g., Save, Don't Save, Cancel)
        String[] options = {"Save", "Don't Save", "Cancel"};
        int option = JOptionPane.showOptionDialog(null, "Do you want to save changes?", "Save Confirmation",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                null, options, options[0]);
        if (option == 0) {
            System.out.println("User chose Save");
        } else if (option == 1) {
            System.out.println("User chose Don't Save");
        } else {
            System.out.println("User chose Cancel or closed the dialog");
        }

        // 5. Show an error message dialog
        JOptionPane.showMessageDialog(null, "An error has occurred!", "Error", JOptionPane.ERROR_MESSAGE);

        // 6. Show a plain message dialog (no icon)
        JOptionPane.showMessageDialog(null, "This is a plain message", "Plain Message", JOptionPane.PLAIN_MESSAGE);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        int a = JOptionPane.showConfirmDialog(frame,"Are you sure?");
        if(a == JOptionPane.YES_OPTION){ // click "Yes" on dialog than true
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }

    public static void main(String[] args) {
        new Swing_013_OptionPane();
    }
}
