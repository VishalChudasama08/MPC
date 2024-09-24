import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Swing_016_PopupMenu {
    JFrame frame, frame2, frame3;
    Swing_016_PopupMenu(){
        frame = new JFrame();
        frame.setSize(500, 400);
        frame.setLayout(null);

        popupMenuExample(); // javatpoint

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame2 = new JFrame("PopupMenu with MouseListener");
        frame2.setSize(500, 400);
        frame2.setLayout(null);

        popupMenuExample_MouseListener(); // javatpoint

        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // only close this frame (windows)
        frame2.setVisible(true);
        frame2.setLocation(frame.getX() + 510, frame.getY());

        frame3 = new JFrame("PopupMenu all in");
        frame3.setSize(500,400);
        frame3.setLayout(null);

        popupMenuExample_all(); // chatGPT

        frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // only close this frame (windows)
        frame3.setVisible(true);
        frame3.setLocation(frame2.getX() + 510, frame2.getY());
    }

    void popupMenuExample(){
        JPopupMenu popupMenu = new JPopupMenu("Edit");
        JMenuItem cut = new JMenuItem("Cut");
        JMenuItem copy = new JMenuItem("Copy");
        JMenuItem paste = new JMenuItem("Paste");
        popupMenu.add(cut);
        popupMenu.add(copy);
        popupMenu.add(paste);
        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) { // click everywhere on frame in this point showing popupmenu
                popupMenu.show(frame, e.getX(), e.getY()); // call show() to show popupMenu
            }
        });
        frame.add(popupMenu);
    }

    void popupMenuExample_MouseListener(){
        JLabel label = new JLabel();
//        label.setBounds(0,0,300,30);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setSize(300, 100);

        JPopupMenu popupMenu = new JPopupMenu("Edit");
        JMenuItem cut = new JMenuItem("Cut");
        JMenuItem copy = new JMenuItem("Copy");
        JMenuItem paste = new JMenuItem("Paste");
        popupMenu.add(cut);
        popupMenu.add(copy);
        popupMenu.add(paste);

        frame2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                popupMenu.show(frame2, e.getX(), e.getY());
            }
        });

        cut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Cut MenuItem Clicked");
            }
        });
        copy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Copy MenuItem Clicked");
            }
        });
        paste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Paste MenuItem Clicked");
            }
        });

        frame2.add(popupMenu);
        frame2.add(label);
    }

    void popupMenuExample_all(){
        JLabel label = new JLabel("Right Click on Text Area to see Popup Menu");
        label.setBounds(30, 10, 400, 15);
        frame3.add(label);

        JLabel copyLabel = new JLabel();
        copyLabel.setBounds(333, 100, 130, 30);
        frame3.add(copyLabel);

        // Step 1: Create a JTextArea to display text
        JTextArea textArea = new JTextArea();
        textArea.setBounds(30, 40, 300, 200); // Set the position and size of the text area

        // Step 2: Create a JPopupMenu
        JPopupMenu popupMenu = new JPopupMenu(); // Popup menu component

        // Step 3: Create menu items to be added in the popup menu
        JMenuItem selectAllMenuItem = new JMenuItem("Select All");     // Menu item for "Select All"
        JMenuItem cutMenuItem = new JMenuItem("Cut");     // Menu item for "Cut"
        JMenuItem copyMenuItem = new JMenuItem("Copy");   // Menu item for "Copy"
        JMenuItem pasteMenuItem = new JMenuItem("Paste"); // Menu item for "Paste"

        // Step 4: Add menu items to the popup menu
        popupMenu.add(selectAllMenuItem);   // Add "Select All" option
        popupMenu.add(cutMenuItem);   // Add "Cut" option
        popupMenu.add(copyMenuItem);  // Add "Copy" option
        popupMenu.add(pasteMenuItem); // Add "Paste" option

        // Step 5: Add ActionListener to handle menu item actions
        selectAllMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.selectAll(); // select all text
            }
        });
        cutMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.cut(); // Cut the selected text
            }
        });

        copyMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.copy(); // Copy the selected text
                copyLabel.setText("Copy In Clipboard");

                // Timer to remove the text after 3 seconds (3000 ms)
                new Timer(3000, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        copyLabel.setText(""); // Clear the label text after 3 seconds
                    }
                }).start(); // Start the timer
            }
        });

        pasteMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.paste(); // Paste the copied text
            }
        });

        // Step 6: Set up a MouseListener to show the popup menu when the right mouse button is clicked
        textArea.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) { // Detect if it's the right-click button
                    popupMenu.show(e.getComponent(), e.getX(), e.getY()); // Show the popup menu at the cursor's location
                }
            }
        });

        // Step 7: Add the text area to the frame
        frame3.add(textArea);
    }

    public static void main(String[] args) {
        new Swing_016_PopupMenu();
    }
}
