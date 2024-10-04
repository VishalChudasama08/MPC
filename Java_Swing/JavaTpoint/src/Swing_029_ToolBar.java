import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Swing_029_ToolBar {
    JFrame frame;
    JTextArea textArea;
    Swing_029_ToolBar(){
        frame = new JFrame("swing Tool Bar Example");
        frame.setSize(500, 300);

        toolBarExample(); // javatpoint

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    void toolBarExample(){
        JToolBar toolBar = new JToolBar();
        toolBar.setRollover(true);

        JButton fileButton = new JButton("File");
        fileButton.addActionListener(e -> {
            textArea.append("File button clicked!\n");
        });
        toolBar.add(fileButton);
        toolBar.addSeparator();

        JButton editButton = new JButton("Edit");
        editButton.addActionListener(e -> {
            textArea.append("Edit button clicked!\n");
        });
        toolBar.add(editButton);
        toolBar.addSeparator();

        JComboBox<String> comboBox = new JComboBox<>(new String[]{
            "option-1", "option-2", "option-3", "option-4"
        });
        comboBox.addActionListener(e -> {
            String selectedoption = (String) comboBox.getSelectedItem();
            textArea.append("Selected option: " + selectedoption + "\n");
        });
        toolBar.add(comboBox);

        Container containerPane = frame.getContentPane();
        containerPane.add(toolBar, BorderLayout.NORTH);

        textArea = new JTextArea();

        JScrollPane scrollPane = new JScrollPane(textArea);
        containerPane.add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new Swing_029_ToolBar();
    }
}
