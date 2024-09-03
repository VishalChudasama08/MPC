import java.awt.*;

public class AWT_002_Frame_Class {
    AWT_002_Frame_Class(){
        Frame frame = new Frame("Create Frame Class Example");
        frame.setSize(400, 600);
        frame.setLayout(null);

        Label label = new Label("Employee id: ");
        label.setBounds(20,80,80,30);

        TextField textField = new TextField();
        textField.setBounds(100,80,80,30);

        Button button = new Button("Submit");
        button.setBounds(50,120,80,30);

        frame.add(button);
        frame.add(textField);
        frame.add(label);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
//        AWT_002_Frame_Class object = new AWT_002_Frame_Class();
        new AWT_002_Frame_Class(); // this two line is sem mining's
    }
}
