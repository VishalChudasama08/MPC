import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;

public class Swing_020_Tree {
    JFrame frame;
    Swing_020_Tree(){
        frame = new JFrame("Swing Tree Example");
        frame.setSize(700, 600);
        frame.setLayout(null);

        // The JTree class is used to display the tree structured data or hierarchical data.
        // JTree is a complex component. It has a 'root node' at the top most which is a parent for all nodes in the tree.
        // It inherits JComponent class.
        treeExample(); // javatpoint

        treeExample_all(); // chatGPT

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    void treeExample(){
        DefaultMutableTreeNode style = new DefaultMutableTreeNode("Style");
        DefaultMutableTreeNode color = new DefaultMutableTreeNode("Color");
        DefaultMutableTreeNode font = new DefaultMutableTreeNode("Font");

        style.add(color);
        style.add(font);

        DefaultMutableTreeNode red = new DefaultMutableTreeNode("Red");
        DefaultMutableTreeNode blue = new DefaultMutableTreeNode("Blue");
        DefaultMutableTreeNode black = new DefaultMutableTreeNode("Black");
        DefaultMutableTreeNode green = new DefaultMutableTreeNode("Green");

        color.add(red);
        color.add(blue);
        color.add(black);
        color.add(green);

        JTree tree = new JTree(style);
        tree.setBounds(10, 10, 100, 150);
        frame.add(tree);
    }
    void treeExample_all(){
        // Create the root node for the tree
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");

        // Create child nodes and add them to the root
        DefaultMutableTreeNode parent1 = new DefaultMutableTreeNode("Parent 1");
        DefaultMutableTreeNode parent2 = new DefaultMutableTreeNode("Parent 2");

        // Adding children to Parent 1
        parent1.add(new DefaultMutableTreeNode("Child 1.1"));
        parent1.add(new DefaultMutableTreeNode("Child 1.2"));

        // Adding children to Parent 2
        parent2.add(new DefaultMutableTreeNode("Child 2.1"));
        parent2.add(new DefaultMutableTreeNode("Child 2.2"));

        // Add parent nodes to the root node
        root.add(parent1);
        root.add(parent2);

        // Create the JTree using the root node
        JTree tree = new JTree(root);

        // Enable root node visibility toggle
        tree.setRootVisible(true); // Change to false if root shouldn't be shown

        // Expand all rows to display the tree structure fully
        for (int i = 0; i < tree.getRowCount(); i++) {
            tree.expandRow(i); // Expands each row
            // Expands the tree structure to show all nodes within the row.
        }

        // Set the selection mode for the tree
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION); // Single node selection
        // getSelectionModel(): allowing configuration of node selection behavior (like single/multiple node selection).
        // setSelectionMode(int mode): Sets the selection mode for the tree. here, set to single node selection.

        // Retrieve selected node
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                // Gets the most recently selected node in the tree.
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                if(selectedNode != null){
                    System.out.println("Selected Node : " + selectedNode.getUserObject());
                    // getUserObject() : get node name (here than is selected node)
                }
            }
        });

        // Add the tree to a JScrollPane to allow scrolling
        JScrollPane treeScrollPane = new JScrollPane(tree);
        treeScrollPane.setBounds(200, 10, 300, 300); // Set position and size of the scroll pane

        // Add the scroll pane to the frame
        frame.add(treeScrollPane);
    }

    public static void main(String[] args) {
        new Swing_020_Tree();
    }
}
