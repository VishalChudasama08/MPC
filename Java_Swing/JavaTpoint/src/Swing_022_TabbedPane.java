import javax.swing.*;

public class Swing_022_TabbedPane {
    JFrame frame;
    Swing_022_TabbedPane(){
        frame = new JFrame("Swing Tabbed Pane Example");
        frame.setLayout(null);
        frame.setSize(800,600);


        tabbedPaneExample(); // javatpoint

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    void tabbedPaneExample(){
        JTextArea textArea = new JTextArea(200,200);
        JPanel pane1= new JPanel();
        pane1.add(textArea);

        JPanel pane2 = new JPanel();
        JPanel pane3 = new JPanel();

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(50,50,200,200);
        tabbedPane.add("main", pane1);
        tabbedPane.add("visit", pane2);
        tabbedPane.add("help", pane3);

        frame.add(tabbedPane);
    }

    public static void main(String[] args) {
        new Swing_022_TabbedPane();
    }
}
