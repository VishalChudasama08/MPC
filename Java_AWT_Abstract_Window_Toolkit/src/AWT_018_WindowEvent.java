/*
 * Window is Opened: windowOpened() is called.
 * Window is Closing: windowClosing() is triggered when the user clicks the close button (X).
 * Window is Closed: windowClosed() is triggered after the window has completely closed.
 * Window is Activated: windowActivated() is triggered when the window gains focus (is clicked or brought to the foreground).
 * Window is Deactivated: windowDeactivated() is triggered when the window loses focus (another window is selected).
 * Window is Minimized (Iconified): windowIconified() is triggered when the window is minimized.
 * Window is Restored (Deiconified): windowDeiconified() is triggered when the window is restored from its minimized state.
 */
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

// A class that inherits the AWT Frame class and implements WindowListener interface
public class AWT_018_WindowEvent extends Frame implements WindowListener {

    // Constructor of the class
    AWT_018_WindowEvent() {
        // Adding the current class (which implements WindowListener) to the Frame
        // This allows the class to listen to window events
        addWindowListener(this);

        // Setting the size of the Frame to 400x400 pixels
        setSize(400, 400);

        // Setting the layout manager to null (no layout manager)
        // This means components must be manually positioned
        setLayout(null);

        // Making the Frame visible to the user
        setVisible(true);
    }

    // main method - entry point of the program
    public static void main(String[] args) {
        // Creating an instance of AWT_WindowExample
        // This triggers the constructor and displays the window
        new AWT_018_WindowEvent();
    }

    // This method is called when the window becomes active (in focus)
    @Override
    public void windowActivated(WindowEvent arg0) {
        System.out.println("Window is activated");
    }

    // This method is called after the window has been closed
    // (Note: windowClosed() is called after the windowClosing() method has executed)
    @Override
    public void windowClosed(WindowEvent arg0) {
        System.out.println("Window is closed");
    }

    // This method is called when the user attempts to close the window
    // For example, when clicking the "X" button on the window's title bar
    @Override
    public void windowClosing(WindowEvent arg0) {
        System.out.println("Window is closing");

        // Dispose of the frame when it is being closed, releasing resources
        // This closes the window without exiting the application
        dispose();
    }

    // This method is called when the window loses focus (is deactivated)
    // For example, when another window is selected
    @Override
    public void windowDeactivated(WindowEvent arg0) {
        System.out.println("Window is deactivated");
    }

    // This method is called when the window is restored from minimized (iconified) state
    @Override
    public void windowDeiconified(WindowEvent arg0) {
        System.out.println("Window is deiconified");
    }

    // This method is called when the window is minimized (iconified)
    @Override
    public void windowIconified(WindowEvent arg0) {
        System.out.println("Window is iconified");
    }

    // This method is called when the window is first opened
    @Override
    public void windowOpened(WindowEvent arg0) {
        System.out.println("Window is opened");
    }
}
