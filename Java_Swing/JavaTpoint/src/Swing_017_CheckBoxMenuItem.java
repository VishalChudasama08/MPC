import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Swing_017_CheckBoxMenuItem {
    JFrame frame;
    Swing_017_CheckBoxMenuItem(){
        frame = new JFrame("CheckBoxMenuItem example");
        frame.setSize(400,400);
        frame.setLayout(null);

//        CheckBoxMenuItemExample(); //javatpoint
        // One Time only one menuBar showing
        CheckBoxMenuItemExample2(); // charGPT

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    void CheckBoxMenuItemExample(){
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        JMenuItem openMenuItem = new JMenuItem("Open", KeyEvent.VK_N);

        JCheckBoxMenuItem caseMenuItem = new JCheckBoxMenuItem("Option_1");
        caseMenuItem.setMnemonic(KeyEvent.VK_C);

        ActionListener listenerObj = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AbstractButton abstractButtonObj = (AbstractButton) e.getSource();
                boolean selected = abstractButtonObj.getModel().isSelected();
                String newLabel;
                Icon newIcon;
                if(selected){
                    newLabel = "Value-1";
                } else {
                    newLabel = "value-2";
                }
                abstractButtonObj.setText(newLabel);
            }
        };

        fileMenu.add(caseMenuItem);
        fileMenu.add(openMenuItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
    }

    void CheckBoxMenuItemExample2(){
        JMenuBar menuBar = new JMenuBar(); // Create a menu bar

        JMenu fileMenu = new JMenu("File"); // Create a menu "File"
        JCheckBoxMenuItem checkBoxMenuItem = new JCheckBoxMenuItem("Check Me"); // Create a checkbox menu item

        checkBoxMenuItem.setState(true); // Set the initial state of the checkbox (checked)

        // Add ActionListener to respond to state changes
        checkBoxMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem)e.getSource();
                if (menuItem.isSelected()) {
                    System.out.println("Checkbox selected"); // Print message when checkbox is selected
                } else {
                    System.out.println("Checkbox deselected"); // Print message when checkbox is deselected
                }
            }
        });

        fileMenu.add(checkBoxMenuItem); // Add the checkbox menu item to the "File" menu
        menuBar.add(fileMenu); // Add the "File" menu to the menu bar

        frame.setJMenuBar(menuBar); // Set the menu bar to the JFrame
    }

    public static void main(String[] args) {
        new Swing_017_CheckBoxMenuItem();
    }
}
