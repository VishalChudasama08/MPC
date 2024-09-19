import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AWT_016_Choice {
    Frame f;
    AWT_016_Choice(){
        f = new Frame();

        choice_example(); // javatpoint
        choice_example_ActionListener(); // javatpoint

        // setting size, layout and visibility of frame
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
    }
    void choice_example(){
        // creating a choice component
        Choice c = new Choice();

        // setting the bounds of choice menu
        c.setBounds(100, 100, 75, 75);

        // adding items to the choice menu
        c.add("Item 1");
        c.add("Item 2");
        c.add("Item 3");
        c.add("Item 4");
        c.add("Item 5");

        // adding choice menu to frame
        f.add(c);
    }
    void choice_example_ActionListener(){
        final Label label = new Label();

        // setting alignment and size of label component
        label.setAlignment(Label.CENTER);
        label.setSize(400, 100);

        // creating a button
        Button b = new Button("Show");
        // setting the bounds of button
        b.setBounds(300, 100, 50, 20);

        // creating final object of Choice class
        final Choice c = new Choice();

        // setting bounds of choice menu
        c.setBounds(200, 100, 75, 75);

        // adding 5 items to choice menu
        c.add("C");
        c.add("C++");
        c.add("Java");
        c.add("PHP");
        c.add("Android");

        // adding event to the button
        // which displays the selected item from the list when button is clicked
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = "Programming language Selected: "+ c.getItem(c.getSelectedIndex());
                label.setText(data);
            }
        });

        // adding above components into the frame
        f.add(c);
        f.add(label);
        f.add(b);
    }

    public static void main(String[] args) {
        new AWT_016_Choice();
    }
}
