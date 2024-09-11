import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AWT_007_Button {
    Frame frame;
    AWT_007_Button(){
        frame = new Frame("Button Examples");
        frame.setSize(600, 400);
        frame.setLayout(null);

        buttons_example(); // source: JavaTPoint
        buttons_example1(); // source: ChatGPT

        frame.setVisible(true);
    }

    void buttons_example(){
        Button button = new Button(); // AWT button is like clickable label
        button.setLabel("AWT Button"); // like set title but in Button that called setLabel
        button.setBounds(30,60,100,30); // set the position for the button in frame

        TextField textField = new TextField();
        textField.setBounds(160,65,200,20);
        textField.setText("Click 'AWT Button'");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("Button Clicked.");
            }
        });

        frame.add(textField);
        frame.add(button); // add button to the frame
    }

    void buttons_example1(){
        Button button1 = new Button();
        button1.setLabel("Button1"); // Change the button’s label using: like set title but in Button that called setLabel
        button1.setBounds(30,200,100,30); // set the position for the button in frame
        button1.setBackground(Color.ORANGE); // Set the button background to light gray
        button1.setForeground(Color.BLUE);       // Set the text color to blue
        button1.setFont(new Font("Arial", Font.BOLD, 16)); // style font. 1st font name, 2nd (BOLD,ITALIC,PLAIN,...), 3rd font size
        button1.setEnabled(false); // Disable the button, "true" than Enable

        // Layout => FlowLayout than
        /*
        frame.setLayout(new FlowLayout());
        button.setFont(new Font("Serif", Font.PLAIN, 12));
        button.setBackground(Color.ORANGE);
        frame.add(button);
         */

        // Layout => BorderLayout than
        /*
        frame.setLayout(new BorderLayout());
        button.setFont(new Font("Helvetica", Font.BOLD, 16));
        frame.add(button, BorderLayout.NORTH); // Button placed at the top
         */

        // Layout => GridLayout than
        /*
        frame.setLayout(new GridLayout(2, 2)); // 2x2 grid
        button.setFont(new Font("Courier", Font.BOLD, 18));
        button.setBackground(Color.GREEN);
        frame.add(button); // Button will be placed in the first grid cell
         */

        // Create a button2
        Button button2 = new Button("Click Me");

        // Manual positioning using setBounds (when no layout manager is used)
        button2.setBounds(150,200,100,30);  // x, y, width, height

        // Styling: background, foreground, and font
        button2.setBackground(Color.CYAN);
        button2.setForeground(Color.BLUE);
        button2.setFont(new Font("Arial", Font.BOLD, 16));

        // Add action listener
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button 2 Clicked");
            }
        });

        // Add the button to the frame
        frame.add(button2);
        frame.add(button1);
    }

    public static void main(String[] args) {
        new AWT_007_Button();
    }
}
