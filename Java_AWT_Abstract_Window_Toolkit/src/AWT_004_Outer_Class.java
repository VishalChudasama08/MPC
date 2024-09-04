import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AWT_004_Outer_Class implements ActionListener {
    AWT_004_Event_handling_by_outer_class object_004_class;

    AWT_004_Outer_Class(AWT_004_Event_handling_by_outer_class object_004){
        this.object_004_class = object_004;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        object_004_class.textField.setText("Welcome");
    }
}
