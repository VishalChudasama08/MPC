import javax.swing.*;

public class Swing_001_Create_Frame_Using_JFrame_Object {
    public static void main(String[] args){
        // Create Frame(Window) Using Create JFrame object
        // for create frame using JFrame object this is not oop concept

        JFrame frame = new JFrame("This is Frame Title"); // argument it's title
        frame.setLayout(null); // In frame content (label, button, text field,...) set its Layout
        frame.setSize(400, 300); // Set size of the frame. first is width and seconds is height


        // write here swing component
        // and add its in frame using add method


        // jyare window close karvama aave tyare frame ne exit karva
        // difault DISPOSE_ON_CLOSE hoy chhe
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit on close, motabhage/kyarek kyarek output window close karta program close thato nathi te this output window close thay tyare program close thay tena mate vaparay

        // window ne visible karva
        frame.setVisible(true); // make the frame visible
    }
}
