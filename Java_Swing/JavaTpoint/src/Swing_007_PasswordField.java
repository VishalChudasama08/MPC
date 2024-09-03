import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Swing_007_PasswordField {
    // It allows the editing of a single line of text.
    // It inherits JTextField class.
    JFrame frame;

    Swing_007_PasswordField(){
        frame = new JFrame("PasswordField Example");
        frame.setSize(1000, 600);
        frame.setLayout(null);

        simple_passwordField_example(); // simple password Field (Source: javaTpoint)
        passwordField_with_ActionListener(); // (Source: javaTpoint)
        jPasswordField_with_it_methods(); // (Source: chtGPT)

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void simple_passwordField_example(){
        JLabel label = new JLabel("Password: ");
        label.setBounds(50,50,80,30);

        JPasswordField pass = new JPasswordField("Password Field Example");
        pass.setBounds(130,50,200,30);
        pass.setToolTipText("This is Password Field Example");

        frame.add(pass);
        frame.add(label);
    }

    private void passwordField_with_ActionListener(){
        JLabel username_label = new JLabel("Enter Username: ");
        username_label.setBounds(50,120,100,30);

        JTextField username = new JTextField();
        username.setBounds(170, 120, 180, 30);

        JLabel pass_label = new JLabel("Enter Password: ");
        pass_label.setBounds(50,160,100,30);

        JPasswordField password = new JPasswordField();
        password.setBounds(170, 160, 180, 30);

        JLabel result = new JLabel();
        result.setBounds(50, 240, 300, 30);

        JButton submit = new JButton("Login");
        submit.setBounds(150, 200, 50, 30);
        submit.setMargin(new Insets(0,0,0,0));
        submit.setFont(new Font("Serif", Font.BOLD, 16));
        submit.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String data = "Username " + username.getText() + ", Password " + new String(password.getPassword());
                result.setText(data);
            }
        });

        frame.add(submit);
        frame.add(result);
        frame.add(password);
        frame.add(pass_label);
        frame.add(username);
        frame.add(username_label);
    }

    private void jPasswordField_with_it_methods(){
        JPasswordField passwordField1 = new JPasswordField();
        passwordField1.setBounds(600,80,200,30);
//        Sets the text of the text field (including passwords, though not recommended for passwords).
        passwordField1.setText("Vishal8320");
        // Set the echo character to an asterisk (*) to mask the password input
        passwordField1.setEchoChar('#');
        passwordField1.setEditable(true); // Sets whether the text field is editable.

        char a = passwordField1.getEchoChar(); // Returns the echo character used to mask input.
        System.out.println(a);
        boolean b = passwordField1.echoCharIsSet(); // Returns true if an echo character is set.
        System.out.println(b);

        JLabel label = new JLabel("Enter Password: ");
        label.setBounds(500, 80, 100, 30);

        JButton button = new JButton("Submit");
        button.setBounds(555, 120, 80, 30);
        button.setMargin(new Insets(0,0,0,0));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the password from the password field as a char array
                char [] password = passwordField1.getPassword();
                // Convert the password char array to a String for display (for demonstration purposes)
                String passwordText = new String(password);

                // Show a message dialog displaying the entered password
                JOptionPane.showMessageDialog(frame, "Password Entered: " + passwordText);

                // Clear the password array after use for security
                java.util.Arrays.fill(password, ' ');
            }
        });

        frame.add(button);
        frame.add(label);
        frame.add(passwordField1);
    }

    public static void main(String[] args) {
        new Swing_007_PasswordField();
    }
}
