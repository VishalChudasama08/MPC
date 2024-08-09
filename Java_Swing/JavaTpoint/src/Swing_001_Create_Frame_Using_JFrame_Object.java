import javax.swing.*;

public class Swing_001_Create_Frame_Using_JFrame_Object {
    public static void main(String[] args){
        // Create Frame(Window) Using Create JFrame object
        // for create frame using JFrame object this is not oop concept

        JFrame frame = new JFrame("This is Frame Title"); // argument it's title
        frame.setSize(400, 300); // Set size of the frame. first is width and seconds is height

        // jyare window close karvama aave tyare frame ne exit karva
        // difault DISPOSE_ON_CLOSE hoy chhe
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit on close

        // window ne visible karva
        frame.setVisible(true); // make the frame visible
    }
}
