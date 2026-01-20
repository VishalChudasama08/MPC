package com.security.locker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;

public class SecureLockerUI extends JFrame {

    JTextField txtName = new JTextField();
    JTextField txtEmail = new JTextField();
    JLabel lblFile = new JLabel("No file selected");
    File selectedFile;

    public SecureLockerUI() {
        setTitle("Secure Digital Locker (AES + JDBC)");
        setSize(500, 350);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel l1 = new JLabel("Name:");
        l1.setBounds(30, 30, 100, 25);
        add(l1);

        txtName.setBounds(150, 30, 250, 25);
        add(txtName);

        JLabel l2 = new JLabel("Email:");
        l2.setBounds(30, 70, 100, 25);
        add(l2);

        txtEmail.setBounds(150, 70, 250, 25);
        add(txtEmail);

        JButton btnChoose = new JButton("Choose File");
        btnChoose.setBounds(30, 120, 150, 30);
        add(btnChoose);

        lblFile.setBounds(200, 120, 250, 30);
        add(lblFile);

        JButton btnUpload = new JButton("Encrypt & Upload");
        btnUpload.setBounds(150, 180, 200, 40);
        add(btnUpload);

        // File chooser action
        btnChoose.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            int result = chooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                lblFile.setText(selectedFile.getName());
            }
        });

        // Upload action
        btnUpload.addActionListener(e -> {
            if (selectedFile == null) {
                JOptionPane.showMessageDialog(this, "Select a file first!");
                return;
            }
            uploadFile();
        });
    }

    private void uploadFile() {
        try {
            byte[] fileBytes = readFileToBytes(selectedFile);

            // Encrypt file
            byte[] encryptedBytes = AESCrypto.encrypt(fileBytes);

            // Save to DB
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/AES_encryption?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",
                "root",
                "vishal08"
            );

            String sql = "INSERT INTO secure_locker(name, email, file_name, file_type, encrypted_data) "
                + "VALUES(?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, txtName.getText());
            ps.setString(2, txtEmail.getText());
            ps.setString(3, selectedFile.getName());
            ps.setString(4, getFileExtension(selectedFile.getName()));
            ps.setBytes(5, encryptedBytes);

            ps.executeUpdate();
            conn.close();

            JOptionPane.showMessageDialog(this,
                "File encrypted and stored securely!");

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,
                "Error: " + ex.getMessage());
        }
    }

    private byte[] readFileToBytes(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fis.read(data);
        fis.close();
        return data;
    }

    private String getFileExtension(String name) {
        int i = name.lastIndexOf('.');
        return (i > 0) ? name.substring(i + 1) : "";
    }

    public static void main(String[] args) {
        new SecureLockerUI().setVisible(true);
    }
}
