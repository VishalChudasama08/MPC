import java.awt.*;
import java.awt.event.*;

public class AWT_016_List {
    Frame frame;
    AWT_016_List(){
        frame = new Frame("List example");
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);

        list_example(); // source: javatpoint
        list_example_with_ActionListener(); // source: javatpoint
        list_example1(); // source: chatGPT
    }
    void list_example(){
        List list = new List(5);
        // 5 item visible in list another item in scroll

        list.setBounds(30,40,80,75);

        list.add("list item 1");
        list.add("list item 2");
        list.add("list item 3");
        list.add("list item 4");
        list.add("list item 5");
        list.add("list item 6");

        frame.add(list);
    }
    void list_example_with_ActionListener(){
        Label label = new Label();
        label.setBounds(20, 260,450, 20);
//        label.setAlignment(Label.LEFT);
//        label.setSize(500, 100);

        Button button = new Button("Show");
        button.setBounds(100,230,80,20);

        List list1 = new List(4, false);
        list1.setBounds(50, 150, 70,70);
        list1.add("C");
        list1.add("C++");
        list1.add("JAVA");
        list1.add("PHP");

        List list2 = new List(4, true);
        list2.setBounds(150, 150, 70,70);
        list2.add("Turbo C++");
        list2.add("Spring");
        list2.add("Hibernate");
        list2.add("Codelgniter");

        frame.add(list1);
        frame.add(list2);
        frame.add(label);
        frame.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String list1Data = list1.getSelectedItem();
                String [] list2Data = list2.getSelectedItems();
                if(list1Data != null && list2Data.length > 0){
//                    String data = "Programming Language Selected: "+list1.getItem(list1.getSelectedIndex());
//                    data += ", Framework Selected: ";
//                    for (String itemText:list2.getSelectedItems()){
//                        data += itemText + " ";
//                    }
                    String data = "Programming Language Selected: " + list1Data + ", Framework Selected: " + String.join(", ", list2Data);
                    label.setText(data);
                } else {
                    label.setText("Please select attlist one item on both list");
                }
            }
        });
    }
    void list_example1(){
        // Create a List component with 5 visible items and multiple selection allowed
        List itemList = new List(5, true);
        itemList.setBounds(20,300, 100, 100);

        // Add items to the List
        itemList.add("Item 1");
        itemList.add("Item 2");
        itemList.add("Item 3");
        itemList.add("Item 4");
        itemList.add("Item 5");

        // Add an item at a specific position (e.g., adding "Item 6" at the second position)
        itemList.add("Item 6", 1); // Indexing starts at 0, so this adds at the second place

        // Enable/disable multiple selections (in this case, we are allowing multiple selections)
        itemList.setMultipleMode(true); // If set to false, only one item can be selected at a time

        // Add an ActionListener to handle when an item is double-clicked
        itemList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Double-clicked on: " + itemList.getSelectedItem());
            }
        });

        // Create a Label to show the selected items
        Label selectedItemsLabel = new Label("Selected items will be shown here");
        selectedItemsLabel.setBounds(150, 320,300,30);

        // Add an ItemListener to handle item selection changes
        itemList.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                // Get the selected items and print them
                String[] selectedItems = itemList.getSelectedItems();
                System.out.println("Selected Items: ");
                StringBuilder items = new StringBuilder();
                items.append("Selected Items: ");
                for (String item : selectedItems) {
                    System.out.println(item);
                    items.append(" ").append(item);
                }
                selectedItemsLabel.setText(items.toString());
            }
        });


        // Add a Button to clear the selection
        Button clearSelectionButton = new Button("Clear Selection");
        clearSelectionButton.setBounds(150,370,150,20);

        // Add ActionListener to the Button
        clearSelectionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Clear the selection of the list
                itemList.deselect(itemList.getSelectedIndex());
                selectedItemsLabel.setText("Selection Cleared!");
            }
        });

        // Add components to the frame
        frame.add(itemList, BorderLayout.NORTH);
        frame.add(selectedItemsLabel, BorderLayout.CENTER);
        frame.add(clearSelectionButton, BorderLayout.SOUTH);

        // Add a window listener to close the frame when the close button is clicked
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new AWT_016_List();
    }
}
