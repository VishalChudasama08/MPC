import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DynamicPanelExample extends Frame {

    // Define the main content panel as a class-level variable so it can be updated
    Panel mainContent;

    public DynamicPanelExample() {
        // Set layout for the Frame (BorderLayout for dividing sections)
        setLayout(new BorderLayout());

        // Navbar (Header)
        Panel navbar = new Panel();
        navbar.setLayout(new FlowLayout());
        navbar.setBackground(Color.LIGHT_GRAY);
        navbar.add(new Label("Navbar - Header"));

        // Sidebar
        Panel sidebar = new Panel();
        sidebar.setLayout(new GridLayout(5, 1)); // Create a grid with 5 buttons for the menu
        sidebar.setBackground(Color.GRAY);

        // Create buttons for the sidebar
        Button menu1 = new Button("Menu 1");
        Button menu2 = new Button("Menu 2");
        Button menu3 = new Button("Menu 3");
        Button menu4 = new Button("Menu 4");
        Button menu5 = new Button("Menu 5");

        // Add buttons to the sidebar
        sidebar.add(menu1);
        sidebar.add(menu2);
        sidebar.add(menu3);
        sidebar.add(menu4);
        sidebar.add(menu5);

        // Main Content Area (where the content will change)
        mainContent = new Panel();
        mainContent.setLayout(new FlowLayout()); // Use any layout
        mainContent.setBackground(Color.WHITE);
        mainContent.add(new Label("Main Content Area")); // Default content

        // Footer
        Panel footer = new Panel();
        footer.setLayout(new FlowLayout());
        footer.setBackground(Color.DARK_GRAY);
        footer.add(new Label("Footer © 2024"));

        // Add Panels to the Frame using BorderLayout
        add(navbar, BorderLayout.NORTH);   // Navbar at the top
        add(sidebar, BorderLayout.WEST);   // Sidebar on the left
        add(mainContent, BorderLayout.CENTER); // Main content in the center
        add(footer, BorderLayout.SOUTH);   // Footer at the bottom

        // Add ActionListeners to sidebar buttons to change content dynamically
        menu1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateMainContent("Content for Menu 1");
            }
        });

        menu2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateMainContent("Content for Menu 2");
            }
        });

        menu3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateMainContent("Content for Menu 3");
            }
        });

        menu4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateMainContent("Content for Menu 4");
            }
        });

        menu5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateMainContent("Content for Menu 5");
            }
        });

        // Frame settings
        setSize(600, 400); // Set frame size
        setVisible(true);  // Make frame visible
    }

    // Method to update the main content panel
    private void updateMainContent(String content) {
        // Remove all existing components from the main content area
        mainContent.removeAll();

        // Add new content based on the button clicked
        mainContent.add(new Label(content));

        // Refresh the main content area to show the new content
        mainContent.revalidate();
        mainContent.repaint();
    }

    public static void main(String[] args) {
        new DynamicPanelExample(); // Run the example
    }
}
