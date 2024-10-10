import javax.swing.*;

public class Swing_040_RootPane {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing RootPane Example");
//        frame.setSize(400,300);

        JRootPane rootPane = frame.getRootPane();

        // create menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");

        menu.add("Open");
        menu.add("Close");

        menuBar.add(menu);
        rootPane.setJMenuBar(menuBar);

        // Add a button to the content pane
        rootPane.getContentPane().add(new JButton("Press Me"));


        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
