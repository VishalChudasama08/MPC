import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Swing_010_ComboBox {
    JFrame frame;
    Swing_010_ComboBox(){
        frame = new JFrame("JComboBox example");
        frame.setSize(400, 700);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        comboBoxExample(); //javatpoint
        comboBoxExample_all();

        frame.setVisible(true);
    }
    void comboBoxExample(){
        String [] country = {"India", "Australia", "America", "England", "Newzealand", "South Korea", "Japan"};
        String [] capital = {"New Delhi", "Canberra", "Washington, D.C.", "London", "Wellington", "Seoul", "Tokyo"};
        JComboBox<String> comboBox = new JComboBox<>(country);
        comboBox.setBounds(50,50,100,25);

        JLabel label = new JLabel("Select Country Than I showing it's capital");
        label.setBounds(10,10,400,20);

        JLabel labelR = new JLabel();
        labelR.setBounds(10,90,400,20);

        JButton button = new JButton("Find");
        button.setBounds(160,50,50,25);
        button.setMargin(new Insets(0,0,0,0));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result = "Country: " + comboBox.getItemAt(comboBox.getSelectedIndex()) + "\t Capital: " + capital[comboBox.getSelectedIndex()];
                labelR.setText(result);
            }
        });

        frame.add(label);
        frame.add(comboBox);
        frame.add(button);
        frame.add(labelR);
    }
    void comboBoxExample_all(){
        // Create JComboBox and add initial items
        JComboBox<String> comboBox = new JComboBox<>(new String[] {"Item 1", "Item 2", "Item 3"});
        comboBox.setBounds(50, 150, 150, 30);

        // Button to add an item to the JComboBox
        JButton addButton = new JButton("Add Item");
        addButton.setBounds(50, 200, 120, 30);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comboBox.addItem("New Item");
            }
        });

        // Button to insert an item at a specific index
        JButton insertButton = new JButton("Insert at Index 1");
        insertButton.setBounds(50, 250, 150, 30);
        insertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comboBox.insertItemAt("Inserted Item", 1);
            }
        });

        // Button to remove the selected item
        JButton removeButton = new JButton("Remove Selected");
        removeButton.setBounds(50, 300, 150, 30);
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comboBox.removeItem(comboBox.getSelectedItem());
            }
        });

        // Button to remove an item at index 0
        JButton removeAtButton = new JButton("Remove At Index 0");
        removeAtButton.setBounds(50, 350, 150, 30);
        removeAtButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (comboBox.getItemCount() > 0) {
                    comboBox.removeItemAt(0);
                }
            }
        });

        // Button to remove all items from JComboBox
        JButton removeAllButton = new JButton("Remove All Items");
        removeAllButton.setBounds(50, 400, 150, 30);
        removeAllButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comboBox.removeAllItems();
            }
        });

        // Display the selected item
        JButton getSelectedButton = new JButton("Get Selected Item");
        getSelectedButton.setBounds(50, 450, 150, 30);
        getSelectedButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Selected Item: " + comboBox.getSelectedItem());
            }
        });

        // Set selected index to 2
        JButton setSelectedButton = new JButton("Select Index 2");
        setSelectedButton.setBounds(50, 500, 150, 30);
        setSelectedButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (comboBox.getItemCount() > 2) {
                    comboBox.setSelectedIndex(2);
                }
            }
        });

        // Get item count
        JButton getItemCountButton = new JButton("Item Count");
        getItemCountButton.setBounds(50, 550, 150, 30);
        getItemCountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Item Count: " + comboBox.getItemCount());
            }
        });

        // Get item at index 1
        JButton getItemAtButton = new JButton("Get Item at Index 1");
        getItemAtButton.setBounds(50, 550, 150, 30);
        getItemAtButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (comboBox.getItemCount() > 1) {
                    JOptionPane.showMessageDialog(frame, "Item at Index 1: " + comboBox.getItemAt(1));
                }
            }
        });

        // Add components to JFrame
        frame.add(comboBox);
        frame.add(addButton);
        frame.add(insertButton);
        frame.add(removeButton);
        frame.add(removeAtButton);
        frame.add(removeAllButton);
        frame.add(getSelectedButton);
        frame.add(setSelectedButton);
        frame.add(getItemCountButton);
        frame.add(getItemAtButton);
    }

    public static void main(String[] args) {
        new Swing_010_ComboBox();
    }
}
