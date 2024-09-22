import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Swing_012_List {
    JFrame frame;
    Swing_012_List(){
        frame = new JFrame("Swing List Example");
        frame.setSize(1000, 400);
        frame.setLayout(null);

        listExample(); //javatpoint
        listExampleWithActionListener(); //javatpoint
        listExample_all();
        listExample_all_advances();

        // Create a horizontal separator
        JSeparator horizontalLine1 = new JSeparator(SwingConstants.VERTICAL);
        horizontalLine1.setBounds(230, 10, 1, 340);
        frame.add(horizontalLine1);

        JSeparator horizontalLine2 = new JSeparator(SwingConstants.VERTICAL);
        horizontalLine2.setBounds(780,10,1,340);
        frame.add(horizontalLine2);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    void listExample(){
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("Item1");
        listModel.addElement("Item2");
        listModel.addElement("Item3");
        listModel.addElement("Item4");

        JList<String> list = new JList<>(listModel);
        list.setBounds(10, 10, 75, 75);

        frame.add(list);
    }
    void listExampleWithActionListener(){
        JTextArea textArea = new JTextArea();
        textArea.setBounds(1, 100, 210, 40);
        textArea.setEditable(false);

        JButton button = new JButton("show");
        button.setMargin(new Insets(0,0,0,0));
        button.setBounds(50, 250, 50,30);

        DefaultListModel<String> listModel1 = new DefaultListModel<>();
        listModel1.addElement("C");
        listModel1.addElement("C++");
        listModel1.addElement("Java");
        listModel1.addElement("PHP");

        JList<String> list1 = new JList<>(listModel1);
        list1.setBounds(20, 150, 60, 80);

        DefaultListModel<String> listModel2 = new DefaultListModel<>();
        listModel2.addElement("Turbo C++");
        listModel2.addElement("Struts");
        listModel2.addElement("Spring");
        listModel2.addElement("YLL");

        JList<String> list2 = new JList<>(listModel2);
        list2.setBounds(100,150,100,80);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String data = null;
                if (list1.getSelectedIndex() != -1){
                    data = "Programming language Selected: " + list1.getSelectedValue();
                    textArea.setText(data);
                }
                if (list2.getSelectedIndex() != -1){
                    data += ",\nFrameWork Selected: ";
                    for (Object value : list2.getSelectedValues()){
                        data += value+" ";
                    }
                }
                textArea.setText(data);
            }
        });

        frame.add(textArea);
        frame.add(button);
        frame.add(list1);
        frame.add(list2);
    }

    void listExample_all(){
        // Sample data for JList
        String[] data = {
                "Amit", "Jai", "Sachin", "Raj", "Vijay", "Akash", "Ajay", "Vishal"
        };

        // Create the JList with data
        JList<String> list = new JList<>(data);
        list.setBounds(800, 100, 150, 150);
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        list.setVisibleRowCount(5);
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBounds(800, 100, 150, 150);

        frame.add(scrollPane);

        // 1. Get Selected Index
        list.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                System.out.println("Selected Indices: " + list.getSelectedIndices());
                System.out.println("Selected Values: " + list.getSelectedValuesList());
            }
        });

        // 2. Clear Selection
        JButton clearButton = new JButton("Clear Selection");
        clearButton.setBounds(800, 270, 150, 30);
        clearButton.addActionListener(e -> list.clearSelection());
        frame.add(clearButton);

        // 3. Set a Custom Renderer
        list.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                label.setForeground(Color.BLUE);
                if (isSelected) {
                    label.setBackground(Color.LIGHT_GRAY);
                }
                return label;
            }
        });

        // 4. Ensure a specific index is visible
        list.ensureIndexIsVisible(7);

        // 5. Set fixed cell size
        list.setFixedCellHeight(30);
        list.setFixedCellWidth(200);
    }

    void listExample_all_advances(){
        // 1. Create Text Area to display all action and method results
        JTextArea textArea = new JTextArea("List Action Results: ");

        JScrollPane scrollPaneTextArea = new JScrollPane(textArea);
        scrollPaneTextArea.setBounds(250, 110, 300, 200);

        // Data for the JList
        String[] data = {
                "Amit", "Jai", "Sachin", "Raj", "Vijay", "Akash", "Ajay", "Vishal"
        };

        // Create the JList with the data array
        JList<String> list = new JList<>(data);

        // Add JScrollPane for scrolling functionality
        JScrollPane scrollPaneList = new JScrollPane(list);
        scrollPaneList.setBounds(250, 10, 100, 80);

        frame.add(scrollPaneList);
        frame.add(scrollPaneTextArea);

        int selectedIndex = list.getSelectedIndex(); // Returns the index of the first selected item in the list.
        int[] selectedIndices = list.getSelectedIndices(); // Returns an array of all selected indices in the list.

        String selectedValue = list.getSelectedValue(); // Returns the value of the first selected item in the list.
//        List<String> selectedValues = list.getSelectedValuesList(); // Returns a list of all selected values.

        ListModel<String> model = list.getModel(); // Returns the ListModel that holds the items in the list.
//        list.setModel(new DefaultListModel<>()); // Sets the data model for the list.

        // Selects the item at the specified index.
        list.setSelectedIndex(2);  // Selects the third item
        // Selects the items at the specified indices.
        list.setSelectedIndices(new int[]{1, 3, 5});

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String item : data){
            listModel.addElement(item); // add all list item in DefaultListModel
        }

        JLabel addItemSuccessLabel = new JLabel(); // set for last action status

        // 2. Get Selected Index and Value
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // getValueIsAdjusting() return boolean ->
                // true: The event is still adjusting (i.e., the user is still in the process of selecting, such as clicking or dragging across multiple items).
                // false: The event is complete (i.e., the user has finished the selection process).
                if (!e.getValueIsAdjusting()){ // !true == false (selection finished than this if block run)
                    int selectedIndex = list.getSelectedIndex();  // Get the selected index
                    String selectedValue = list.getSelectedValue();  // Get the selected value
                    textArea.append("\nSelected Index: [" + selectedIndex + "] Value: " + selectedValue);
                }
            }
        });

        // 3. Adding Items (Dynamically)
        JTextField textField = new JTextField();
        frame.add(textField);

        JButton addListItemButton = new JButton("Add New Item");
        addListItemButton.setBounds(360, 20,100, 20);
        addListItemButton.setMargin(new Insets(0,0,0,0));
        addListItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setBounds(360, 60, 200, 20);
                textField.setText("");
                textField.setToolTipText("Enter the new item name and Press \"Enter\" Key on keyboard");
                textField.setEditable(true);
                textField.requestFocus(); // Set focus on the text field when the button is pressed
            }
        });
        frame.add(addListItemButton);

        // Add an ActionListener to the JTextField to add items when "Enter" is pressed
        textField.addActionListener(new ActionListener() { // Press "Enter" on keyboard than run
            @Override
            public void actionPerformed(ActionEvent e) {
                String newItem = textField.getText();
                listModel.addElement(newItem); // add new item in DefaultListModel
                list.setModel(listModel); // add DefaultListModel in list
                textField.setEditable(false);

                frame.remove(textField);

                frame.add(addItemSuccessLabel);
                addItemSuccessLabel.setBounds(360, 60, 400, 20);
                addItemSuccessLabel.setText("\"" + newItem + "\" Add Successfully. see in List");
                textArea.append("\n"+addItemSuccessLabel.getText());
            }
        });

        // 4. Removing Item
        JButton removeItem = new JButton("Remove 1st Item");
        removeItem.setBounds(470, 20,110, 20);
        removeItem.setMargin(new Insets(0,0,0,0));
        frame.add(removeItem);
        removeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstItem = listModel.getElementAt(0);
                if (listModel.getSize() > 1) {  // Ensure there is more than 1 element to remove
                    listModel.removeElementAt(0); // Remove the first element from the list (index 0 for first item)
                    list.setModel(listModel); // for Update list Set the list model for the JList

                    // Update the label
                    frame.add(addItemSuccessLabel);
                    addItemSuccessLabel.setBounds(360, 60, 400, 20);
                    addItemSuccessLabel.setText("First Item \'"+firstItem+"\' Removed Successfully. Check the List.");

                    // Append the success message to the text area
                    textArea.append("\n" + addItemSuccessLabel.getText());

                } else {
                    // In case the list has fewer than 1 element
                    addItemSuccessLabel.setText("No item to remove!");
                    textArea.append("\n" + addItemSuccessLabel.getText());
                }
            }
        });

        // 5. Edit / Replace Item
        JTextField textFieldEditReplace = new JTextField();
        textFieldEditReplace.setVisible(true);
        frame.add(textFieldEditReplace);

        JButton editReplaceItemButton = new JButton("Edit/Replace an Item");
        editReplaceItemButton.setBounds(590, 20, 160, 20);
        editReplaceItemButton.setVisible(false); // Initially hidden
        frame.add(editReplaceItemButton);
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) { // Check if the selection is final
                    if (list.getSelectedValue() != null) {
                        editReplaceItemButton.setVisible(true); // Show the button when an item is selected
                    } else {
                        editReplaceItemButton.setVisible(false); // Hide if no selection
                    }
                } else {
                    // Hide the button when the selection changes
                    editReplaceItemButton.setVisible(false);
                }
            }
        });

        editReplaceItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldEditReplace.setVisible(true);
                String selectedValue = list.getSelectedValue();  // Get the selected value
                textFieldEditReplace.setBounds(360, 60, 200, 20);
                textFieldEditReplace.setText(selectedValue);
                textFieldEditReplace.setEditable(true);
                textFieldEditReplace.setToolTipText("Edit Item name and press \"Enter\" Key on keyboard");
                textFieldEditReplace.requestFocus(); // Set focus on the text field when the button is pressed
            }
        });

        // Add an ActionListener to the JTextField to add items when "Enter" is pressed
        textFieldEditReplace.addActionListener(new ActionListener() { // Press "Enter" on keyboard than run
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list.getSelectedIndex();  // Get the selected index
                String updatedItem = textFieldEditReplace.getText();
                listModel.setElementAt(updatedItem, selectedIndex); // Update item
                list.setModel(listModel); // add DefaultListModel in list

                textFieldEditReplace.setEditable(false);
                textFieldEditReplace.setVisible(false); // hide text field

                frame.add(addItemSuccessLabel);
                addItemSuccessLabel.setBounds(360, 60, 400, 20);
                addItemSuccessLabel.setText("\"" + updatedItem + "\" Updated Successfully. see in List");
                textArea.append("\n"+addItemSuccessLabel.getText());
            }
        });

        // 5. Get All Data
        for (int i = 0; i < listModel.getSize(); i++) {
            textArea.append("\nValue at index " + i + ": " + listModel.getElementAt(i));
        }

        // 6. Selection Methods:
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  // Allow single selection

        // 7. tooltips for JList
        list.setToolTipText("Select an item from the list");

        // 8. Custom Cell Rendering (Change how items are displayed)
        list.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public java.awt.Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (index % 2 == 0) {
                    label.setBackground(java.awt.Color.LIGHT_GRAY);
                } else {
                    label.setBackground(java.awt.Color.WHITE);
                }
                return label;
            }
        });

        // 9. Set Visible Row Count
        list.setVisibleRowCount(4);  // Show only 4 rows in the viewable area

        // 10. Enable/Disable Selections
        list.setEnabled(true);  // Enable selection (disable if set to false)
    }

    public static void main(String[] args) {
        new Swing_012_List();
    }
}
