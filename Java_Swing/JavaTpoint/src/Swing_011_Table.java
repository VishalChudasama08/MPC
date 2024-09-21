import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.Arrays;
import java.util.Vector;

public class Swing_011_Table {
    JFrame frame;
    Swing_011_Table(){
        frame = new JFrame("Swing Table Example");
        frame.setSize(600,600);
        frame.setLayout(null);

        table_example(); // javatpoint
        table_example_with_ListSelectionListener(); // javatpoint
        table_example_all();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    void table_example(){
        String[][] data = {{"101", "Amit", "670000"}, {"102", "Jai", "780000"}, {"103", "Sachin", "700000"}};
        String[] column = {"ID", "NAME", "SALARY"};
        JTable table = new JTable(data, column);
        JScrollPane sp = new JScrollPane(table); // Wrap the table in a JScrollPane

        // Set bounds for the scroll pane, not the table
        sp.setBounds(30, 10, 400, 100); // Adjusted bounds for better visibility

        frame.add(sp); // Add the scroll pane to the frame, not the table directly
    }
    void table_example_with_ListSelectionListener(){
        String[][] data = {{"101", "Amit", "670000"}, {"102", "Jai", "780000"}, {"103", "Sachin", "700000"}};
        String[] columns = {"ID", "NAME", "SALARY"};

        JTable table = new JTable(data, columns);
        JScrollPane sp = new JScrollPane(table); // Wrap the table in a JScrollPane

        // Set bounds for the scroll pane, not the table
        sp.setBounds(30, 120, 400, 100); // Adjusted bounds for better visibility

        frame.add(sp); // Add the scroll pane to the frame, not the table directly

        table.setCellSelectionEnabled(true); // true - than select single box. default false - select full row

        ListSelectionModel select = table.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        select.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // once when the row is selected and once when the column is selected.
                // In your case, both row and column selections are triggering the valueChanged() method, causing the data to be printed twice.
                // Prevent action from being performed twice
                if (!e.getValueIsAdjusting()) { // not use this condition than run this below code 2 time and print two time selected element
                    String selectedData = null;
                    int[] row = table.getSelectedRows();
                    int[] column = table.getSelectedColumns();
                    for (int i : row) {
                        System.out.println(i);
                        for (int j : column) {
                            System.out.println(j);
                            selectedData = (String) table.getValueAt(i, j);
                        }
                    }
                    System.out.println("Table element selected is: " + selectedData);
                }
            }
        });
    }

    void table_example_all(){
        // 1. Creating a Basic Table
        String[][] data = {
                {"101", "Amit", "670000"},
                {"102", "Jai", "780000"},
                {"103", "Sachin", "700000"},
                {"104", "Raj", "800000"},
                {"105", "Vijay", "850000"},
                {"106", "Akash", "900000"},
                {"107", "Ajay", "950000"},
                {"108", "Vishal", "980000"}
        };
        String[] column = {"ID", "NAME", "SALARY"};

        JTable table = new JTable(data, column);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(30, 240, 400, 200);

        frame.add(sp);

        // 2. Get Selected Row/Column
        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = table.getSelectedRow();
                int selectedColumn = table.getSelectedColumn();
                if (selectedRow != -1 && selectedColumn != -1) {
                    Object selectedValue = table.getValueAt(selectedRow, selectedColumn);
                    System.out.println("Selected Value: " + selectedValue);
                }
            }
        });

        // 3. Add and Remove Columns
//        TableColumn newColumn = new TableColumn(2);
//        newColumn.setHeaderValue("NEW COLUMN");
//        table.addColumn(newColumn);  // Add new empty column
//        table.removeColumn(table.getColumnModel().getColumn(0));  // Remove the first column (ID)

        // 4. Editing Data in a Cell
        table.setValueAt("1000000", 2, 2);  // Set new salary for "Sachin"

        // 5. Get/Set Table Data
        for (int i = 0; i < table.getRowCount(); i++) {
            for (int j = 0; j < table.getColumnCount(); j++) {
                System.out.println("Value at [" + i + "," + j + "] = " + table.getValueAt(i, j));
            }
        }

        // 6. Selection Methods
        table.setRowSelectionAllowed(true);  // Allow row selection
        table.setColumnSelectionAllowed(true);  // Allow column selection
        int[] selectedRows = table.getSelectedRows();
        int[] selectedColumns = table.getSelectedColumns();
        System.out.println("Selected Rows: " + selectedRows.length);
        System.out.println("Selected Columns: " + selectedColumns.length);

        // 7. Sorting and Filtering
        table.setAutoCreateRowSorter(true);  // Enables sorting by clicking column headers

        // 8. Column Customization
        table.getColumnModel().moveColumn(2, 0);  // Move the Salary column to position 0

        // 9. Editing Control
        System.out.println("Is cell editable at [1, 1]: " + table.isCellEditable(1, 1));

        // 10. Custom Cell Renderers
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                           boolean hasFocus, int row, int column) {
                Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (row % 2 == 0) {
                    cell.setBackground(Color.LIGHT_GRAY);
                } else {
                    cell.setBackground(Color.WHITE);
                }
                return cell;
            }
        });

        // 11. Column Resizing and Reordering
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);  // Automatically resize all columns

        // 12. Tooltips and Custom Header
        table.getTableHeader().setToolTipText("Table Header Tooltip");  // Tooltip for the table header

        // 13. Row Height and Clearing Selection
        table.setRowHeight(30);  // Set row height to 30
        table.clearSelection();  // Clear selection
    }

    public static void main(String[] args) {
        new Swing_011_Table();
    }
}
