import java.awt.*;

public class AWT_Dimension {
    // used to represent the size (width and height) of a two-dimensional object, such as a GUI component or a window.
    AWT_Dimension(){// Create a new Frame (window)
        Frame frame = new Frame("Dimension Example");

        // Set the size of the frame using Dimension
        Dimension frameSize = new Dimension(600, 300); // Width: 400, Height: 300
        frame.setSize(frameSize);
        frame.setLayout(new FlowLayout());

        // Create a new Button
        Button button = new Button("Click Me!");

        // Set a preferred size for the button using Dimension
        Dimension buttonSize = new Dimension(100, 50); // Width: 200, Height: 50
        button.setPreferredSize(buttonSize);

        // Add the button to the frame's content pane
        frame.add(button);

        TextArea textArea = new TextArea("This is Text Area");
        Dimension textAreaSize = new Dimension(250, 150);
        textArea.setSize(textAreaSize);
        frame.add(textArea);

        // The pack() method sizes the frame according to the preferred sizes of its components.
        // Pack the frame to arrange the components as per their preferred sizes
//        frame.pack();

        // Set the frame's location to the center of the screen
        frame.setLocationRelativeTo(null);

        // Make the frame visible
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new AWT_Dimension();

        // 1. Creating a Dimension object using width and height
        Dimension dim1 = new Dimension(100, 200);  // Width = 100, Height = 200
        System.out.println("Dimension 1: " + dim1);  // toString() will print width and height

        // 2. Creating a default Dimension object (width and height default to 0)
        Dimension dim2 = new Dimension();
        System.out.println("Dimension 2 (default): " + dim2);  // Defaults to width=0, height=0

        // 3. Modifying the size of an existing Dimension object
        dim2.setSize(300, 400);  // Set the width to 300 and the height to 400
        System.out.println("Dimension 2 (modified): " + dim2);

        // 4. Getting the size of a Dimension object
        Dimension dim3 = dim1.getSize();  // This creates a copy of dim1's size
        System.out.println("Dimension 3 (copy of Dimension 1): " + dim3);

        // 5. Changing the size of a Dimension using another Dimension object
        dim3.setSize(dim2);  // Set dim3's size to the size of dim2 (300, 400)
        System.out.println("Dimension 3 (after setSize from Dimension 2): " + dim3);

        // 6. Accessing and modifying the width and height directly
        System.out.println("Dimension 3 width: " + dim3.width);  // Access width directly
        System.out.println("Dimension 3 height: " + dim3.height);  // Access height directly

        // You can also modify width and height directly
        dim3.width = 150;
        dim3.height = 250;
        System.out.println("Dimension 3 (after direct modification): " + dim3);
    }
}
