import java.awt.*;

public class AWT_001_Create_Frame_by_inheriting extends Frame { // for creating frame inherit Frame class
    AWT_001_Create_Frame_by_inheriting(){
        setTitle("This is our basic AWT example"); // setting the title of Frame
        setLayout(null); // set layout manager, here no layout manager set

        Button button = new Button("Click Me!!"); // creating Button
        button.setBounds(30,100,80,30); // setting button position on screen

        add(button); // adding button into frame
        setSize(300,300); // frame size 300 width and 300 height
        setVisible(true);
    }

    public static void main(String[] args) {
        AWT_001_Create_Frame_by_inheriting f  = new AWT_001_Create_Frame_by_inheriting();
    }
}



