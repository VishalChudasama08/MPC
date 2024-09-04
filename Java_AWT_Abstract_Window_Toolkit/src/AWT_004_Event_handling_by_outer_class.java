import java.awt.*;

// event handling by outer class
class AWT_004_Event_handling_by_outer_class extends Frame {
    TextField textField;

    AWT_004_Event_handling_by_outer_class() {
        setSize(300, 300);
        setLayout(null);

        textField = new TextField();
        textField.setBounds(60, 50, 170, 30);

        Button button = new Button("Click Me");
        button.setBounds(100, 120, 80,30);

        // create outer class Object
        AWT_004_Outer_Class outer_class = new AWT_004_Outer_Class(this); // argument is it self object, send AWT_004_Event_handling_by_outer_class class object

        // passing outer class instance
        button.addActionListener(outer_class);

        add(button);
        add(textField);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AWT_004_Event_handling_by_outer_class();
    }
}
