import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// event handling by implementing ActionListener
public class AWT_003_Event_handling_by_implementing_ActionListener extends Frame implements ActionListener {
    TextField textField;
    AWT_003_Event_handling_by_implementing_ActionListener(){
        setSize(300,300);
        setLayout(null);

        textField = new TextField();
        textField.setBounds(60,50,170,30);

        Button button = new Button("Click Me");
        button.setBounds(100, 120, 80, 30);
        button.addActionListener(this); // passing current instance

        add(button);
        add(textField);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        textField.setText("Welcome");
    }

    public static void main(String[] args) {
        new AWT_003_Event_handling_by_implementing_ActionListener();
    }
}

