import java.awt.*;

public class LayoutExample extends Frame {

    public LayoutExample() {
        // Set layout for the main Frame (BorderLayout allows positioning of components like Header, Footer, etc.)
        setLayout(new BorderLayout());

        // Navbar (Header)
        Panel navbar = new Panel();
        navbar.setLayout(new FlowLayout()); // You can change this layout as per requirement
        navbar.setBackground(Color.LIGHT_GRAY);
        navbar.add(new Label("Navbar - Header"));
        navbar.add(new Button("Home"));
        navbar.add(new Button("About"));

        // Sidebar
        Panel sidebar = new Panel();
        sidebar.setLayout(new GridLayout(5, 1)); // Create a grid with 5 rows and 1 column
        sidebar.setBackground(Color.GRAY);
        sidebar.add(new Button("Menu 1"));
        sidebar.add(new Button("Menu 2"));
        sidebar.add(new Button("Menu 3"));
        sidebar.add(new Button("Menu 4"));
        sidebar.add(new Button("Menu 5"));

        // Main Content Area (Main Container)
        Panel mainContent = new Panel();
        mainContent.setLayout(new FlowLayout());
        mainContent.setBackground(Color.WHITE);
        mainContent.add(new Label("Main Content Area"));
        mainContent.add(new TextField("Enter something...", 20));

        // Footer
        Panel footer = new Panel();
        footer.setLayout(new FlowLayout());
        footer.setBackground(Color.DARK_GRAY);
        footer.add(new Label("Footer © 2024"));

        // Add Panels to the Frame using BorderLayout positions
        add(navbar, BorderLayout.NORTH);   // Navbar at the top
        add(sidebar, BorderLayout.WEST);   // Sidebar on the left
        add(mainContent, BorderLayout.CENTER); // Main content in the center
        add(footer, BorderLayout.SOUTH);   // Footer at the bottom

        // Frame settings
        setSize(600, 400); // Set frame size
        setVisible(true);  // Make frame visible
    }

    public static void main(String[] args) {
        new LayoutExample(); // Run the example
    }
}
