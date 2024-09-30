import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Swing_025_Dialog {
    static JFrame frame;
    Swing_025_Dialog(){
        frame = new JFrame("Swing Dialog Example");
        frame.setSize(400, 300);
        frame.setLayout(null);

        dialogExample(); // javatpoint
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    void dialogExample(){
        JDialog dialog = new JDialog(frame,"This is Dialog");
        dialog.setLayout(new FlowLayout());
        JButton button = new JButton("ok");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
            }
        });

        dialog.add(new JLabel("Click button to continue."));
        dialog.add(button);
        dialog.setSize(200, 100);
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        /*
        Why use the Event Dispatch Thread?
        --> Thread safety: Swing components are not thread-safe, meaning they should only be created or modified on the EDT.
                If GUI updates are made from other threads, it could lead to unexpected behavior, such as UI glitches or freezing.
        --> Ensuring smooth UI operations: By running the code on the EDT, you make sure that the application's user interface remains responsive.
                Long-running tasks should not block the EDT, otherwise the UI would freeze.

         What does SwingUtilities.invokeLater() do?
         --> Purpose: SwingUtilities.invokeLater() schedules the creation or update of Swing components to be executed on the Event Dispatch Thread.

         --> Usage: It's commonly used when initializing a Swing application or when performing UI updates after a background task.
                It ensures that any GUI-related actions are safely handled by the EDT.
         */
        // Run the JDialog example in the event dispatch thread
        SwingUtilities.invokeLater(() -> {
            // javatpoint
            new Swing_025_Dialog();

            // chatGPT
            JDialogExample example = new JDialogExample();
            example.setVisible(true);
            example.setLocation(frame.getWidth(), frame.getY());
        });
    }
}


// The example covers modal dialogs, custom dialogs, confirmation dialogs, and input dialogs, along with the usage of key methods.
class JDialogExample extends JFrame {
    // hare inherit JFrame class
    public JDialogExample() {
        setTitle("JDialog Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());

        // Button to open modal dialog
        JButton modalDialogButton = new JButton("Open Modal Dialog");
        modalDialogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openModalDialog(); // Call method to open modal dialog
            }
        });

        // Button to open custom dialog
        JButton customDialogButton = new JButton("Open Custom Dialog");
        customDialogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openCustomDialog(); // Call method to open custom dialog
            }
        });

        // Button to open confirmation dialog
        JButton confirmDialogButton = new JButton("Open Confirmation Dialog");
        confirmDialogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openConfirmationDialog(); // Call method to open confirmation dialog
            }
        });

        // Button to open input dialog
        JButton inputDialogButton = new JButton("Open Input Dialog");
        inputDialogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openInputDialog(); // Call method to open input dialog
            }
        });

        // Add buttons to the frame
        add(modalDialogButton);
        add(customDialogButton);
        add(confirmDialogButton);
        add(inputDialogButton);
    }

    // Method to open a modal dialog
    private void openModalDialog() {
        // Creates a modal dialog that blocks interaction with the parent frame until it’s closed.
        JDialog modalDialog = new JDialog(this, "Modal Dialog", true); // 'true' makes it modal
        modalDialog.setSize(230, 150); // Set size of the dialog
        modalDialog.setLayout(new FlowLayout()); // Set layout for the dialog

        JLabel label = new JLabel("This is a modal dialog.");
        modalDialog.add(label); // Add a label to the dialog

        JLabel label1 = new JLabel("Blocks user interact to other windows");
        JLabel label2 = new JLabel("because that is model dialog");
        modalDialog.add(label1);
        modalDialog.add(label2);

        // Add a close button to the dialog
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> modalDialog.dispose()); // Close dialog on button click
        modalDialog.add(closeButton);

        // Center the dialog relative to the parent frame
        modalDialog.setLocationRelativeTo(this); // Center the dialog
        modalDialog.setVisible(true); // Makes the dialog visible, blocking the rest of the UI.
        // if is visible than Blocks user input to other windows because that is model dialog
    }

    // Method to open a custom JDialog
    private void openCustomDialog() {
        // Creates a non-modal dialog that allows interaction with other windows.
        JDialog customDialog = new JDialog(this, "Custom Dialog", false); // Non-modal dialog, (false for non-modal)
        customDialog.setSize(300, 200);
        customDialog.setLayout(new BorderLayout());

        // Add a message in the center
        JLabel message = new JLabel("Custom dialog with BorderLayout.");
        message.setHorizontalAlignment(SwingConstants.CENTER); // Center the text
        customDialog.add(message, BorderLayout.CENTER); // Add label to center of the dialog

        // Add a close button at the bottom
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> customDialog.dispose()); // Close dialog on button click
        customDialog.add(closeButton, BorderLayout.SOUTH); // Add button to the bottom of the dialog

        // Center the dialog relative to the parent frame
        customDialog.setLocationRelativeTo(this); // Center the dialog
        customDialog.setVisible(true); // Show the custom dialog ( Non-modal, doesn't block other windows)
    }

    // Method to open a confirmation dialog
    private void openConfirmationDialog() {
        // Open a confirmation dialog with Yes/No options
        int result = JOptionPane.showConfirmDialog(this, "Do you want to continue?",
                "Confirmation Dialog", JOptionPane.YES_NO_OPTION); // Shows a dialog with Yes/No options.

        // Show response based on user's choice
        if (result == JOptionPane.YES_OPTION) { // Checks if the user clicked "Yes."
            JOptionPane.showMessageDialog(this, "You clicked Yes.");
        } else {
            JOptionPane.showMessageDialog(this, "You clicked No.");
        }
    }

    // Method to open an input dialog
    private void openInputDialog() {
        // Open an input dialog where user can enter text
        String input = JOptionPane.showInputDialog(this, "Enter your name:", "Input Dialog",
                JOptionPane.PLAIN_MESSAGE); // that dialog showing Prompts, Prompts the user to enter a value.

        // Show a message with the entered input or notify if no input
        if (input != null && !input.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Hello, " + input + "!");
        } else {
            JOptionPane.showMessageDialog(this, "You didn't enter anything.");
        }
    }
}