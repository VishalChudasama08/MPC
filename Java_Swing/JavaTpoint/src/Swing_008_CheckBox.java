import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Swing_008_CheckBox implements ActionListener {
    JFrame frame;
    JCheckBox [] checkBoxes; // create array of CheckBox
    JLabel label;

    Swing_008_CheckBox(){
        frame = new JFrame("CheckBox Example");
        frame.setSize(600, 600);
        frame.setLayout(null);

        checkBox_example(); // source: javatpoint

        checkBox_array_with_dynamic_ActionListener(); // source: chatGPT

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void checkBox_example(){
        JCheckBox checkBox = new JCheckBox("I Am Check Box", true); // 2nd argument than represent checkBox checked
        checkBox.setBounds(300, 10, 200, 50);

        JLabel label1 = new JLabel();
        label1.setBounds(300, 80, 400, 100);

        checkBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                label1.setText("\"I Am Check Box\" CheckBox is: " + (e.getStateChange()==1?"Checked":"Unchecked"));
            }
        });

        frame.add(label1);
        frame.add(checkBox);
    }

    private void checkBox_array_with_dynamic_ActionListener(){
        checkBoxes = new JCheckBox[6]; // Array of checkboxes for dynamic handling

        checkBoxes[0] = new JCheckBox("Java");
        checkBoxes[0].setBounds(10,10,80,30);

        checkBoxes[1] = new JCheckBox("C++");
        checkBoxes[1].setBounds(10,50,80,30);

        checkBoxes[2] = new JCheckBox("Python");
        checkBoxes[2].setBounds(10,90,80,30);

        checkBoxes[3] = new JCheckBox("JavaScript");
        checkBoxes[3].setBounds(100,10,100,30);

        checkBoxes[4] = new JCheckBox("PHP");
        checkBoxes[4].setBounds(100,50,80,30);

        checkBoxes[5] = new JCheckBox("CSS");
        checkBoxes[5].setBounds(100,90,80,30);

        label = new JLabel();
        label.setBounds(50,150, 300, 180);

        frame.add(label);
        // Add all checkboxes to the frame
        for(JCheckBox checkBox: checkBoxes){
            checkBox.addActionListener(this); // Add ActionListener for each checkbox
            frame.add(checkBox);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Iterate through all checkboxes to find which one is selected
        StringBuffer selectedText = new StringBuffer();
        selectedText.append("Checked CheckBox's:");
        for (JCheckBox checkBox: checkBoxes) {
            if(checkBox.isSelected()) {
                selectedText.append(" ").append(checkBox.getText());
            }
        }
        // Update label with the selected checkboxes
        if (!selectedText.isEmpty()){
            label.setText("<html>" + selectedText.toString() + "</html>");
        } else {
            label.setText("No CheckBox is Checked");
        }
    }

    public static void main(String[] args) {
        new Swing_008_CheckBox();
        new Swing_008_CheckBox_advance_example();
//        new Swing_007_PasswordField(); // yes, this class run, you see both class windows
    }
}
