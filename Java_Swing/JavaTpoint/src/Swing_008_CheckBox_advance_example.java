import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;

import static java.lang.Integer.parseInt;

public class Swing_008_CheckBox_advance_example extends JFrame implements ActionListener {

    JLabel label;
    JCheckBox [] checkBoxes;
    JButton button;
    Swing_008_CheckBox_advance_example(){
        setSize(500, 500);
        setLayout(null);

        using_checkBox_Food_Ordering_System(); // source: javatpoint

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    private void using_checkBox_Food_Ordering_System(){
        label = new JLabel("Food Ordering System");
//        label.setBounds(50, 50, 300, 20);
        label.setHorizontalAlignment(JLabel.CENTER);

        checkBoxes  = new JCheckBox[3]; // Array of checkboxes for dynamic handling

        checkBoxes[0] = new JCheckBox("Pizza @ 100");
        checkBoxes[0].setBounds(100, 100, 150, 20);

        checkBoxes[1] = new JCheckBox("Burger @ 30");
        checkBoxes[1].setBounds(100, 150,150,20);

        checkBoxes[2] = new JCheckBox("Tea @ 10");
        checkBoxes[2].setBounds(100, 200, 150, 20);

        button = new JButton("Order");
        button.setBounds(100, 250, 80, 30);
        button.setMargin(new Insets(0,0,0,0));
        button.addActionListener( this);

        add(button);
        for(JCheckBox checkBox : checkBoxes){
            add(checkBox);
        }
        add(label);
    }

    public void actionPerformed(ActionEvent e){
        float amount = 0;
        String msg = "";
        for(JCheckBox checkBox: checkBoxes){
            if (checkBox.isSelected()){
                String[] v = checkBox.getText().split(" ");
                amount += parseInt(v[v.length-1]); // String to integer
                msg += v[0]+": "+v[v.length-1]+"\n";
            }
        }
        msg += "-----------------\n";
        JOptionPane.showMessageDialog(this, msg+" Total:"+amount);
    }

    public static void main(String[] args) {
        new Swing_008_CheckBox_advance_example();
    }
}
