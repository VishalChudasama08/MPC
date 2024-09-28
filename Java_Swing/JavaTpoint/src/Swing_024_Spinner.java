import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Swing_024_Spinner {
    static JFrame frame;
    Swing_024_Spinner(){
        frame = new JFrame("Swing Spinner Example");
        frame.setSize(400, 300);
        frame.setLayout(null);

        spinnerExample(); // javatpoint
        spinnerExampleWithChangeListener(); // javatpoint

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    void spinnerExample(){
        SpinnerModel value = new SpinnerNumberModel(5,0,10,1);
        JSpinner spinner = new JSpinner(value);
        spinner.setBounds(10,10,40,30);
        frame.add(spinner);
    }
    void spinnerExampleWithChangeListener(){
        JLabel label = new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setSize(250, 100);
        SpinnerModel value = new SpinnerNumberModel(5,1,10,1);
        JSpinner spinner = new JSpinner(value);
        spinner.setBounds(10,60,50,30);
        spinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                label.setText("Value: "+((JSpinner)e.getSource()).getValue());
            }
        });

        frame.add(spinner);
        frame.add(label);
    }
    public static void main(String[] args) {
        new Swing_024_Spinner();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SpinnerExampleAdvanced example = new SpinnerExampleAdvanced();
                example.setLocation(frame.getWidth(), frame.getY());
                example.setVisible(true);
            }
        });
    }
}

class SpinnerExampleAdvanced extends JFrame {
    private JSpinner spinner;
    private JLabel valueLabel;

    public SpinnerExampleAdvanced() {
        setTitle("JSpinner Example");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create a SpinnerNumberModel with initial value 10, minimum 0, maximum 50, and step size 1
        SpinnerNumberModel model = new SpinnerNumberModel(10, 0, 50, 1);

        // Creating the JSpinner
        spinner = new JSpinner(model);

        // Customize the editor format
        JSpinner.NumberEditor editor = new JSpinner.NumberEditor(spinner, "#");  // No decimal places
        spinner.setEditor(editor);

        // Set the preferred size of the spinner
        spinner.setPreferredSize(new Dimension(100, 30));

        // JLabel to display the spinner value
        valueLabel = new JLabel("Value: " + spinner.getValue());

        // Add a ChangeListener to handle value changes in the spinner
        spinner.addChangeListener(e -> {
            // Get the current value of the spinner
            int value = (int) spinner.getValue();
            valueLabel.setText("Value: " + value);
        });

        // You can also add an action listener for manual updates using a button
        JButton updateButton = new JButton("Update Value");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get value from spinner and perform an action
                int spinnerValue = (int) spinner.getValue();
                JOptionPane.showMessageDialog(null, "You selected: " + spinnerValue);
            }
        });

        // Disable editing manually (make it non-editable)
        JComponent editorComponent = spinner.getEditor();
        if (editorComponent instanceof JSpinner.DefaultEditor) {
            ((JSpinner.DefaultEditor) editorComponent).getTextField().setEditable(false);
        }

        add(valueLabel);
        add(spinner);
        add(updateButton);
    }
}