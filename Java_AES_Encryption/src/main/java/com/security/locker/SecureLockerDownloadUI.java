package com.security.locker;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.FileOutputStream;
import java.sql.*;

public class SecureLockerDownloadUI extends JFrame {

    JTable table;
    DefaultTableModel model;

    public SecureLockerDownloadUI() {

        setTitle("Secure Locker - Download & Decrypt");
        setSize(700, 400);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Table columns
        String[] columns = {"ID", "Name", "Email", "File Name", "Type"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JButton btnLoad = new JButton("Load Files");
        JButton btnDownload = new JButton("Download & Decrypt");

        JPanel panel = new JPanel();
        panel.add(btnLoad);
        panel.add(btnDownload);
        add(panel, BorderLayout.SOUTH);

        // Load button action
        btnLoad.addActionListener(e -> loadDataFromDB());

        // Download button action
        btnDownload.addActionListener(e -> downloadSelectedFile());
    }

    private void loadDataFromDB() {
        model.setRowCount(0); // clear table

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // MySQL 8 uses a secure authentication mechanism that requires explicit permission to retrieve the public key, so I enabled it in the JDBC URL.
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/AES_encryption?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",
                "root",
                "vishal08"
            );

            String sql = "SELECT id, name, email, file_name, file_type FROM secure_locker";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("file_name"),
                    rs.getString("file_type")
                });
            }

            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void downloadSelectedFile() {
        int row = table.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Select a file first!");
            return;
        }

        int fileId = (int) model.getValueAt(row, 0);
        String fileName = (String) model.getValueAt(row, 3);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // MySQL 8 uses a secure authentication mechanism that requires explicit permission to retrieve the public key, so I enabled it in the JDBC URL.
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/AES_encryption?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",
                "root",
                "vishal08"
            );

            String sql = "SELECT encrypted_data FROM secure_locker WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, fileId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                byte[] encryptedBytes = rs.getBytes("encrypted_data");

                // Decrypt bytes
                byte[] originalBytes = AESCrypto.decrypt(encryptedBytes);

                // Ask user where to save file
                JFileChooser chooser = new JFileChooser();
                chooser.setSelectedFile(new java.io.File(fileName));

                int result = chooser.showSaveDialog(this);

                if (result == JFileChooser.APPROVE_OPTION) {
                    FileOutputStream fos =
                        new FileOutputStream(chooser.getSelectedFile());
                    fos.write(originalBytes);
                    fos.close();

                    JOptionPane.showMessageDialog(this,
                        "File decrypted and downloaded successfully!");
                }
            }

            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new SecureLockerDownloadUI().setVisible(true);
    }
}

