import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// java event handling by anonymous class
public class AWT_005_Event_handling_by_anonymous_class extends Frame {
    TextField textField;
    AWT_005_Event_handling_by_anonymous_class(){
        setSize(600, 500);
        setLayout(null);

        textField = new TextField();
        textField.setBounds(60,50,450,20);

        Button button = new Button("Click Me");
        button.setBounds(50,120,80,30);

        // In this code, the anonymous class is created by directly implementing the ActionListener interface and
        // overriding its actionPerformed method, all in one step, without explicitly naming the class.
        // This is why it's called an anonymous class.
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("Hello, This Program is Java event handling by anonymous class");
            }
        });

        add(button);
        add(textField);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AWT_005_Event_handling_by_anonymous_class();
    }
}