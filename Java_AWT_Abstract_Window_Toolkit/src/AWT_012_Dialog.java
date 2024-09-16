import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AWT_012_Dialog {
    static Dialog d;
    AWT_012_Dialog() {
        Frame f = new Frame();
        d = new Dialog(f, "I Am Dialog", true);
        d.setLayout(new FlowLayout());
        Button b = new Button("OK");
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AWT_012_Dialog.d.setVisible(false);
            }
        });
        d.add(new Label("Click button to continue."));
        d.add(b);
        d.setSize(300, 300);
        d.setVisible(true);
    }

    public static void main(String[] args) {
        new AWT_012_Dialog(); // source: javatpoint
        new AWTDialogExample();  // source: chatGPT
    }
}

class AWTDialogExample {
    Frame frame;
    Dialog dialog;

    AWTDialogExample() {
        // Create Frame
        frame = new Frame();
        frame.setTitle("AWT Dialog Example");
        frame.setSize(400, 400);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);

        // Create a Button to trigger the Dialog
        Button openDialogButton = new Button("Open Dialog");
        frame.add(openDialogButton);

        // Create Dialog associated with this Frame
        dialog = new Dialog(frame, "Simple Dialog", true);  // 'true' makes it modal
        // Modal Dialog: Blocks the input to other windows until it is closed. (true)
        // Non-Modal Dialog: Allows interaction with other windows even when the dialog is open. (false)
        dialog.setSize(300, 200);
        dialog.setLayout(new FlowLayout());

        // Add content to Dialog
        Label dialogLabel = new Label("This is a simple dialog");
        Button closeButton = new Button("Close");

        // add components in dialog
        dialog.add(dialogLabel);
        dialog.add(closeButton);

        // Close the dialog when the close button is clicked
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);  // Hide the dialog
            }
        });

        // Open the dialog when the button is clicked
        openDialogButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(true);  // Show the dialog
            }
        });

        // Close the Frame and exit when the close button is clicked
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);  // Close the application
            }
        });
    }
}
