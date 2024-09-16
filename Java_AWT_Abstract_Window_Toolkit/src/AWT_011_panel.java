import java.awt.*;

public class AWT_011_panel {
    Frame frame;
    AWT_011_panel(){
        frame = new Frame("Panel example");
        frame.setSize(800, 600);
        frame.setLayout(null);

        // Panel is a container that groups a set of components, such as buttons, text fields, and other panels.
        // A Panel doesn't have a title bar or borders, unlike Frame.
        // Panels are used to organize components within another container to better structure and layout management in Frame.
        panel_example(); // source: javatpoint
        PanelMethodsExample(); // source: chatGPT


        frame.setVisible(true);
    }
    void panel_example(){
        Panel panel = new Panel();
        panel.setBounds(400, 80, 200, 200);
        panel.setBackground(Color.gray);

        Button button1 = new Button("Button 1");
        button1.setBounds(50,100,80,30);
        button1.setBackground(Color.yellow);
        Button button2 =new Button("Button 2");
        button2.setBounds(100,100,80,30);
        button2.setBackground(Color.green);

        // Add components to the Panel
        panel.add(button1);
        panel.add(button2);

        frame.add(panel); // Add Panel to the Frame
    }

    void PanelMethodsExample() {
        // Create Panel
        Panel panel = new Panel();
        panel.setBackground(Color.lightGray);
        panel.setLayout(new FlowLayout());

        // Create and add components
        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");
        panel.add(button1);
        panel.add(button2);

        // Manipulate Panel
//        panel.setSize(300, 300);  // Setting size, in frame use layout null than not need it than need setBounds
        panel.setVisible(true);   // Setting visibility

        // Manually set the size and location of the Panel in the Frame
        panel.setBounds(50, 50, 300, 200);  // Must set bounds because Frame uses null layout

        // Access component properties
        System.out.println("Panel size: " + panel.getSize());
        System.out.println("Panel background color: " + panel.getBackground());

        // Add Panel to Frame
        frame.add(panel);
    }

    public static void main(String[] args) {
        new AWT_011_panel();
    }
}

/*

From Component:
    add(Component comp): Adds the specified component to this panel.
    remove(Component comp): Removes the specified component from this panel.
    setLayout(LayoutManager mgr): Sets the layout manager for arranging components.
    getLayout(): Returns the layout manager used by this panel.
    paint(Graphics g): Paints this component. Typically overridden to perform custom painting.
    repaint(): Requests that the component be repainted.
    setSize(int width, int height): Sets the size of this component.
    getSize(): Returns the size of this component.
    setVisible(boolean b): Sets the visibility of this component.
    isVisible(): Returns whether this component is visible.

From Container:
    add(Component comp, Object constraints): Adds the specified component to this container with constraints.
    remove(int index): Removes the component at the specified index.
    removeAll(): Removes all components from this container.
    getComponents(): Returns an array of all the components in this container.
    setComponentZOrder(Component comp, int index): Sets the Z-order of the specified component.
    getComponentZOrder(Component comp): Returns the Z-order of the specified component.

From Panel:
    getBackground(): Returns the background color of the panel.
    setBackground(Color c): Sets the background color of the panel.
    getForeground(): Returns the foreground color of the panel.
    setForeground(Color c): Sets the foreground color of the panel.
    getFont(): Returns the font used by the panel.
    setFont(Font font): Sets the font used by the panel.
    getInsets(): Returns the insets of this panel.
    getPeer(): Returns the peer of this component (used internally, not commonly used).

 */