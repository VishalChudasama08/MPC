import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

public class Swing_027_FileChooser implements ActionListener {
    static JFrame frame;
    static JLabel label; // Label to show selected file path

        Swing_027_FileChooser(){
        frame = new JFrame("Swing FileChooser example");
        frame.setSize(400, 300);
//        frame.setLayout(null);

        fileChooserExample(); // javatpoint

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    void fileChooserExample(){
        JButton button1 = new JButton("save dialog");
        JButton button2 = new JButton("open dialog");

        button1.addActionListener(this);
        button2.addActionListener(this);

        JPanel panel = new JPanel();
        panel.add(button1);
        panel.add(button2);

        label = new JLabel();
        panel.add(label);

        frame.add(panel);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand(); // get the action command of the clicked button
        if(command.equals("save dialog")){
            JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView());
            if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
                label.setText(fileChooser.getSelectedFile().getAbsolutePath());
            } else {
                label.setText("The user cancelled the operation");
            }
        } else if (command.equals("open dialog")){
            JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView());
            if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
                label.setText(fileChooser.getSelectedFile().getAbsolutePath());
            } else {
                label.setText("The user cancelled the operation");
            }
        }
    }

    public static void main(String[] args) {
        // creating object to the JFileChooser class

        // default constructor JFileChooser is called.
//        JFileChooser fileChooser = new JFileChooser();

        // parameterised constructor JFileChooser (File currentDirectory) is called.
//        JFileChooser fileChooser = new JFileChooser("c:");

        // parameterised constructor JFileChooser(File currentDirectory, FIleSystemView(FSV)) is called.
//        JFileChooser fileChooser = new JFileChooser("c:", FileSystemView.getFileSystemView());

        // parameterised constructor JFileChooser(FileSystemViewfsv) is called.
//        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView());

        // parameterised constructor JFileChooser(string current DirectoryPath) is called.
//        JFileChooser fileChooser = new JFileChooser("C:\\Users\\visha\\Pictures\\Screenshots");

        // opening the saved dialogue
//        fileChooser.showSaveDialog(null);

        // opening the opened dialogue
//        fileChooser.showOpenDialog(null);

        new Swing_027_FileChooser();
        // Creating and displaying the file chooser example
        AdvancedFileChooserExample chatGPT = new AdvancedFileChooserExample(); // chatGPT
        chatGPT.setLocation(frame.getWidth()+10, frame.getY());
    }
}


class AdvancedFileChooserExample extends JFrame implements ActionListener { // chatGPT
    // Declaring components
    private JButton openButton, saveButton;
    private JLabel label;

    public AdvancedFileChooserExample() {
        // Frame settings
        setTitle("Advanced JFileChooser Example");
        setSize(600, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Creating the buttons and label
        openButton = new JButton("Open File");
        saveButton = new JButton("Save File");
        label = new JLabel("No file selected");

        // Adding action listeners
        openButton.addActionListener(this);
        saveButton.addActionListener(this);

        // Adding components to the panel
        JPanel panel = new JPanel();
        panel.add(openButton);
        panel.add(saveButton);
        panel.add(label);

        // Adding panel to the frame
        add(panel);

        // Setting the frame visibility
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Creating an instance of JFileChooser
        JFileChooser fileChooser = new JFileChooser();

        // Set the current directory to user's home
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

        // Set a title for the dialog
        fileChooser.setDialogTitle("Select a file");

        // Restrict file types using FileNameExtensionFilter
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text and Image Files", "txt", "jpg", "png");
        fileChooser.setFileFilter(filter);

        // Show Open dialog when Open button is clicked
        if (e.getSource() == openButton) {
            // Allow only files to be selected (not directories)
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

            // Show the open dialog and capture the user's response
            int response = fileChooser.showOpenDialog(null);

            // If the user approves file selection, display the file path
            if (response == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                label.setText("Opened: " + selectedFile.getAbsolutePath());
            } else {
                label.setText("Open command canceled");
            }
        }

        // Show Save dialog when Save button is clicked
        if (e.getSource() == saveButton) {
            // Allow the user to choose a file location for saving
            fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

            // Show the save dialog and capture the user's response
            int response = fileChooser.showSaveDialog(null);

            // If the user approves file selection, display the file path
            if (response == JFileChooser.APPROVE_OPTION) {
                File savedFile = fileChooser.getSelectedFile();

                // If no extension is provided, add ".txt" as the default extension
                if (!savedFile.getName().endsWith(".txt")) {
                    savedFile = new File(savedFile.getAbsolutePath() + ".txt");
                }

                label.setText("Saved: " + savedFile.getAbsolutePath());
            } else {
                label.setText("Save command canceled");
            }
        }
    }
}