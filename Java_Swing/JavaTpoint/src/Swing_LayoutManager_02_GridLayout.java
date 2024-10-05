import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Swing_LayoutManager_02_GridLayout {
    JFrame frame1,frame2,frame3, frame;
    Swing_LayoutManager_02_GridLayout(){
        // The Java GridLayout class is used to arrange the components in a rectangular grid.
        // One component is displayed in each rectangle.
        gridLayoutExample(); // javatpoint
        gridLayoutExampleRowColumns(); // javatpoint
        gridLayoutExampleRowColumnsHgapVgap(); // javatpoint

        gridLayoutExample1();
    }
    void gridLayoutExample(){
        frame1 = new JFrame("LayoutManager Gridlayout Example");
        frame1.setSize(400,300);
        frame1.setLayout(new GridLayout());

        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");
        JButton button6 = new JButton("6");
        JButton button7 = new JButton("7");
        JButton button8 = new JButton("8");
        JButton button9 = new JButton("9");
        frame1.add(button1);frame1.add(button2);frame1.add(button3);
        frame1.add(button4);frame1.add(button5);frame1.add(button6);
        frame1.add(button7);frame1.add(button8);frame1.add(button9);

        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(true);
    }
    void gridLayoutExampleRowColumns(){
        frame2 = new JFrame("LayoutManager Gridlayout Example");
        frame2.setSize(400,300);

        // in one row set three components. this type total three rows
        frame2.setLayout(new GridLayout(3,3));

        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");
        JButton button6 = new JButton("6");
        JButton button7 = new JButton("7");
        JButton button8 = new JButton("8");
        JButton button9 = new JButton("9");

        frame2.add(button1);frame2.add(button2);frame2.add(button3);
        frame2.add(button4);frame2.add(button5);frame2.add(button6);
        frame2.add(button7);frame2.add(button8);frame2.add(button9);

        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame2.setVisible(true);
        frame2.setLocation(frame1.getWidth()+5, frame1.getY());
    }
    void gridLayoutExampleRowColumnsHgapVgap(){
        frame3 = new JFrame("LayoutManager Gridlayout Example   ");
        frame3.setSize(400,300);

        // in one row set three components. this type total three rows
        // 12 is horizontal gap and 18 is vertical gap
        frame3.setLayout(new GridLayout(3,3, 12, 18));

        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");
        JButton button6 = new JButton("6");
        JButton button7 = new JButton("7");
        JButton button8 = new JButton("8");
        JButton button9 = new JButton("9");

        frame3.add(button1);frame3.add(button2);frame3.add(button3);
        frame3.add(button4);frame3.add(button5);frame3.add(button6);
        frame3.add(button7);frame3.add(button8);frame3.add(button9);

        frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame3.setVisible(true);
        frame3.setLocation(frame2.getX()+frame2.getWidth()+5, frame1.getY());
    }
    void gridLayoutExample1(){
        // Create a JFrame
        frame = new JFrame("GridLayout Full Border Example");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 500);

        // Create a JPanel with GridLayout (5 rows, 4 columns)
        JPanel panel = new JPanel(new GridLayout(5, 4, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Border for the panel

        // Create a border to use for all components
        Border componentBorder = BorderFactory.createLineBorder(Color.BLACK, 2);

        // JTextArea
        JTextArea textArea = new JTextArea("JTextArea");
        textArea.setBorder(componentBorder);
        panel.add(textArea);

        // JCheckBox
        JCheckBox checkBox = new JCheckBox("JCheckBox");
        checkBox.setBorder(componentBorder);
        panel.add(checkBox);

        // JList
        String[] listData = {"Item 1", "Item 2", "Item 3"};
        JList<String> list = new JList<>(listData);
        list.setBorder(componentBorder);
        panel.add(new JScrollPane(list)); // Adding JScrollPane around JList

        // JScrollBar
        JScrollBar scrollBar = new JScrollBar();
        scrollBar.setBorder(componentBorder);
        panel.add(scrollBar);

        // JPopupMenu
        JPopupMenu popupMenu = new JPopupMenu("Options");
        popupMenu.setBorder(componentBorder);
        JMenuItem menuItem = new JMenuItem("Item 1");
        popupMenu.add(menuItem);
        panel.add(new JLabel("Right-click for Popup Menu")); // Component to show the popup

        // Add popup menu to the frame
        frame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });

        // JSeparator
        JSeparator separator = new JSeparator();
        separator.setBorder(componentBorder);
        panel.add(separator);

        // JButton
        JButton button = new JButton("JButton");
        button.setBorder(componentBorder);
        panel.add(button);

        // JLabel
        JLabel label = new JLabel("JLabel");
        label.setBorder(componentBorder);
        panel.add(label);

        // JTextField
        JTextField textField = new JTextField("JTextField");
        textField.setBorder(componentBorder);
        panel.add(textField);

        // JComboBox
        String[] comboBoxItems = {"Option 1", "Option 2", "Option 3"};
        JComboBox<String> comboBox = new JComboBox<>(comboBoxItems);
        comboBox.setBorder(componentBorder);
        panel.add(comboBox);

        // JPasswordField
        JPasswordField passwordField = new JPasswordField("JPasswordField");
        passwordField.setBorder(componentBorder);
        panel.add(passwordField);

        // JProgressBar
        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setValue(50);
        progressBar.setBorder(componentBorder);
        panel.add(progressBar);

        // JSlider
        JSlider slider = new JSlider(0, 100, 50);
        slider.setBorder(componentBorder);
        panel.add(slider);

        // JSpinner
        JSpinner spinner = new JSpinner(new SpinnerNumberModel(1, 0, 100, 1));
        spinner.setBorder(componentBorder);
        panel.add(spinner);

        // JTable
        String[][] tableData = {
            {"Row 1", "Data 1"},
            {"Row 2", "Data 2"}
        };
        String[] columnNames = {"Column 1", "Column 2"};
        JTable table = new JTable(tableData, columnNames);
        table.setBorder(componentBorder);
        panel.add(new JScrollPane(table)); // Adding JScrollPane around JTable

        // JTree
        JTree tree = new JTree();
        tree.setBorder(componentBorder);
        panel.add(new JScrollPane(tree)); // Adding JScrollPane around JTree

        // JTextPane
        JTextPane textPane = new JTextPane();
        textPane.setText("JTextPane");
        textPane.setBorder(componentBorder);
        panel.add(textPane);

        // JEditorPane
        JEditorPane editorPane = new JEditorPane();
        editorPane.setText("JEditorPane");
        editorPane.setBorder(componentBorder);
        panel.add(editorPane);

        // Add the panel to the frame
        frame.add(panel);

        // Display the frame
        frame.setVisible(true);
        frame.setLocation(frame1.getX(), frame1.getHeight()+5);
    }

    public static void main(String[] args) {
        new Swing_LayoutManager_02_GridLayout();
    }
}
