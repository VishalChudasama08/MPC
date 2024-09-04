import java.awt.*;
import java.awt.event.*;

// source: chatGPT
public class AWT_006_All_Event_and_it_Listener_interfaces extends Frame {
    TextArea textArea;
    AWT_006_All_Event_and_it_Listener_interfaces(){
        setTitle("Java Event Handling Example");
        setSize(700, 900);
        setLayout(new FlowLayout());

        // Create a TextArea to display events
        textArea = new TextArea(10, 50);
        add(textArea);

        // Adding a Button to demonstrate ActionEvent and ActionListener
        Button actionButton = new Button("Action Button");
        actionButton.addActionListener(new ActionListener() {  // ActionListener
            @Override
            public void actionPerformed(ActionEvent e) {
                // click button than this event run and showing in textArea
                textArea.append("Action button clicked\n");
            }
        });
        add(actionButton);

        // Captures mouse actions like clicks, and mouse movements.
        addMouseListener(new MouseAdapter() {  // MouseListener (and MouseMotionListener)
            @Override
            public void mouseClicked(MouseEvent e) {
                // click in window any space than this event run and showing in textArea
                textArea.append("Mouse clicked at (" + e.getX() + ", " + e.getY() + ")\n");
            }
        });

        // Handles mouse wheel movements.
        addMouseWheelListener(new MouseWheelListener() {  // MouseWheelListener
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                // swap two finger than this event run and showing in textArea 
                textArea.append("Mouse wheel moved by " + e.getWheelRotation() + " notches\n");
            }
        });

        // Listens for key presses on the keyboard.
        TextField keyField = new TextField(25);
        keyField.setText("KeyListener, presses key in this Field");
        keyField.requestFocus(); // the TextField gains focus initially
        keyField.addKeyListener(new KeyAdapter() { // KeyListener
            @Override
            public void keyPressed(KeyEvent e) {
                // type or write or presses any key on keyField than this event run and showing in textArea
                textArea.append("Key pressed: " + e.getKeyChar() + "\n");
            }
        });
        add(keyField);

        // Tracks changes in components like checkboxes and lists.
        Checkbox checkbox = new Checkbox("Checkbox Example");
        checkbox.addItemListener(new ItemListener() {  // ItemListener
            @Override
            public void itemStateChanged(ItemEvent e) {
                // click on checkbox than this event run and showing in textArea 
                textArea.append("Checkbox state changed: " + (e.getStateChange() == ItemEvent.SELECTED ? "Selected" : "Deselected") + "\n");
            }
        });
        add(checkbox);

        // Detects changes in text fields or text areas.
        TextField textField = new TextField(20);
        textField.addTextListener(new TextListener() {  // TextListener
            @Override
            public void textValueChanged(TextEvent e) {
                // write/enter text in textField than this event run and showing in textArea 
                textArea.append("Text changed in TextField\n");
            }
        });
        add(textField);

        // Handles changes in adjustable components like scrollbars.
        Scrollbar scrollbar = new Scrollbar();
        scrollbar.addAdjustmentListener(new AdjustmentListener() {  // AdjustmentListener
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                // click on Scrollbar than this event run and showing in textArea
                textArea.append("Scrollbar adjusted to " + e.getValue() + "\n");
            }
        });
        add(scrollbar);

        // ContainerListener - Dynamically add a component
        Button addComponentButton = new Button("Add Component");
        addComponentButton.addActionListener(new ActionListener() { // ComponentListener
            @Override
            public void actionPerformed(ActionEvent e) {
                Label newLabel = new Label("New Component");
                add(newLabel);
                textArea.append("Component added dynamically.\n");
                validate(); // Refresh the layout to show the new component
            }
        });
        add(addComponentButton);

        // Monitors when components are added or removed from a container.
        addContainerListener(new ContainerAdapter() {  // ContainerListener
            @Override
            public void componentAdded(ContainerEvent e) {
                // Click Add Component than this event run and showing in textArea
                textArea.append("Component added: " + e.getChild().getClass().getName() + "\n");
            }
        });

        // Detects when a component gains or loses focus.
        TextField focusField = new TextField(20);
        focusField.addFocusListener(new FocusAdapter() { // FocusListener
            @Override
            public void focusGained(FocusEvent e) {
                textArea.append("Focus gained by the focusField\n");
            }

            @Override
            public void focusLost(FocusEvent e) {
                textArea.append("Focus lost by the focusField\n");
            }
        });
        add(focusField);

        setVisible(true);
    }

    public static void main(String[] args) {
        new AWT_006_All_Event_and_it_Listener_interfaces();
    }
}
