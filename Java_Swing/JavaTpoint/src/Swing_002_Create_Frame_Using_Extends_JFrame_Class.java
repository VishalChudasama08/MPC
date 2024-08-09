import javax.swing.*;
// Create frame (window) using extends JFrame class
// this is oop concept to make frame
public class Swing_002_Create_Frame_Using_Extends_JFrame_Class extends JFrame {
    // for use JFrame class functionality create constructor
    public Swing_002_Create_Frame_Using_Extends_JFrame_Class() { // this is Constructor
        // for calling JFrame class constructor and given argument to set frame title
        super("Extends Frame Class");

        setSize(400, 300); // call setSize JFrame class method with argument, and that is width and height

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // calling JFrame method to close frame when exit application

        setVisible(true); // calling setVisible() JFrame Class method with true argument to visible frame (Window)
    }

    public static void main (String[] args){
        // create instances (self class object)
        new Swing_002_Create_Frame_Using_Extends_JFrame_Class();
    }
}
