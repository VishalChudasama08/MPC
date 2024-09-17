import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AWT_015_PopupMenu {

    // Constructor to set up the frame, button, and popup menu
    AWT_015_PopupMenu() {
        // Create a Frame (window) with the title "PopupMenu Example"
        Frame frame = new Frame("PopupMenu Example");

        // Create a PopupMenu titled "Edit"
        PopupMenu popupMenu = new PopupMenu("Edit");

        // Create menu items for "Cut", "Copy", and "Paste"
        MenuItem cut = new MenuItem("Cut");
        cut.setActionCommand("Cut");  // Set the action command for cut (used in future event handling)
        MenuItem copy = new MenuItem("Copy");
        copy.setActionCommand("Copy");
        MenuItem paste = new MenuItem("Paste");
        paste.setActionCommand("Paste");

        // Add the menu items to the popup menu
        popupMenu.add(cut);
        popupMenu.add(copy);
        popupMenu.add(paste);

        // Create a Button labeled "Edit" and position it at (180, 180) with width 100 and height 30
        Button button = new Button("Edit");
        button.setBounds(180, 180, 100, 30);  // Manually positioning the button (no layout manager)

        // Add a mouse listener to detect clicks on the button
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Show the popup menu when the button is clicked
                popupMenu.show(frame, e.getX(), e.getY()); // 1st: Frame, 2nd x-axis, 3rd y-axis
                // 2nd and 3rd argument is set Popupmenu position
                // e.getX(): x-axis value, e.getY(): y-axis value
            }
        });

        // Add the button and popup menu to the frame
        frame.add(button);
        frame.add(popupMenu);

        // Set frame layout to null to allow manual positioning of components
        frame.setLayout(null);

        // Set frame size to 400x400 pixels
        frame.setSize(400, 400);

        // Make the frame visible
        frame.setVisible(true);
    }

    // Main method - the entry point of the program
    public static void main(String[] args) {
        // Create an instance of AWT_015_PopupMenu, which will set up and display the UI
        new AWT_015_PopupMenu();
    }
}
