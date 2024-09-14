import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLOutput;
import java.util.Arrays;

public class AWT_008_Label {
    Frame frame;

    AWT_008_Label(){
        frame = new Frame("Button Examples");
        frame.setSize(800, 600);
        frame.setLayout(null);

        label_example(); // source: JavaTPoint
        label_example1(); // source: ChatGPT
        label_example2(); // source: ChatGPT
        label_example3(); // source: ChatGPT

        frame.setVisible(true);
    }

    void label_example() {
        // It is used to display a single line of read only text.
        Label label1 = new Label("Write any website url:-");
        label1.setBounds(30,30,120,30);
//        label1.setBackground(Color.BLUE);

        TextField textField = new TextField();
        textField.setBounds(150,35,250,20);

        Label label2 = new Label();
        label2.setBounds(150,70,350,30);

        Button button = new Button("Find IP Address");
        button.setBounds(30,70,100,30);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String host = textField.getText();
                    String ip_Address = Arrays.toString(java.net.InetAddress.getByName(host).getAddress());
                    label2.setText("IP of " + host + " is " +ip_Address);
                } catch (Exception ex){
                    System.out.println(ex);
                }
            }
        });

        frame.add(label2);
        frame.add(button);
        frame.add(textField);
        frame.add(label1);
    }

    void label_example1(){
        Label label = new Label();
        label.setText("Hello, World!");
        label.setBounds(100, 130, 200, 30);

        // Set font of the label
        label.setFont(new Font("Arial", Font.BOLD, 14));

        // Set text alignment to center
        label.setAlignment(Label.CENTER); // option: LEFT, CENTER, RIGHT

        // Set background and foreground colors
        label.setBackground(Color.LIGHT_GRAY);
        label.setForeground(Color.BLUE);

        System.out.println("Label Text: "+label.getText());
        System.out.println("Label Alignment: "+label.getAlignment());

        // Create Labels
        Label label1 = new Label("Label 1: Left Aligned");
        label1.setBounds(350, 130, 150, 30); // Manually positioned
        label1.setAlignment(Label.LEFT);
        label1.setBackground(Color.YELLOW);
        label1.setForeground(Color.MAGENTA);

        Label label2 = new Label("Label 2: Center Aligned");
        label2.setBounds(510, 130, 200, 30); // Manually positioned
        label2.setAlignment(Label.CENTER);
        label2.setBackground(Color.YELLOW);
        label2.setForeground(Color.BLUE);

        Label label3 = new Label("Label 3: setEnabled :- false(disable), setVisible:- true ");
        label3.setBounds(0, 170, 400, 30);
        label3.setAlignment(Label.CENTER);
        label3.setBackground(Color.YELLOW);
        label3.setEnabled(false); // Enable or disable the button (useful for controlling UI flow).
        label3.setVisible(true); // Show or hide the component.
        Font currentFont = label.getFont(); // get label font object
        label3.setFont(new Font(currentFont.getName(), Font.BOLD, currentFont.getSize())); // change only Font BOLD other all ase-tis

        Label label4 = new Label("Label 4: in label 3 Set Font bold only, font name and size not change");

        // Add labels to frame
        frame.add(label3);
        frame.add(label1);
        frame.add(label2);

        frame.add(label);
    }
    void label_example2(){
        // Layout => FlowLayout
//        frame.setLayout(new FlowLayout()); // Layout manager for automatic positioning
//
//        Label label = new Label("Flow Layout Label");
//        label.setFont(new Font("Arial", Font.PLAIN, 12));
//        label.setForeground(Color.MAGENTA);
//        frame.add(label);


        // Layout => GridLayout
//        frame.setLayout(new GridLayout(2, 1)); // GridLayout with 2 rows and 1 column
//
//        Label label1 = new Label("First Label");
//        Label label2 = new Label("Second Label");
//        frame.add(label1);
//        frame.add(label2);
    }

    void label_example3(){
        // Array of supported cursor types
        int[] cursorTypes = {
                Cursor.DEFAULT_CURSOR, Cursor.HAND_CURSOR, Cursor.CROSSHAIR_CURSOR,
                Cursor.WAIT_CURSOR, Cursor.TEXT_CURSOR, Cursor.MOVE_CURSOR,
                Cursor.N_RESIZE_CURSOR, Cursor.E_RESIZE_CURSOR,
                Cursor.NW_RESIZE_CURSOR, Cursor.NE_RESIZE_CURSOR
        };

        // Loop to create and configure Labels dynamically
        for (int i = 0; i < cursorTypes.length; i++) {
            // Create a label with text "L" followed by its number (e.g., L1, L2...)
            Label label = new Label("L" + (i + 1));

            // Set position dynamically (e.g., 3 labels per row)
            int x = 50 + (i % 3) * 60;  // Adjust x-coordinate
            int y = 220 + (i / 3) * 60;  // Adjust y-coordinate
            label.setBounds(x, y, 30, 30);  // Set size 20x20
            System.out.println(i + " " + label.getBounds());
            label.setAlignment(Label.CENTER);
            label.setBackground(Color.GREEN);
            label.setForeground(Color.RED);

            // Set the corresponding cursor for each label
            label.setCursor(new Cursor(cursorTypes[i]));

            // Add the label to the frame
            frame.add(label);
        }
    }

    public static void main(String[] args) {
        new AWT_008_Label();
    }
}
