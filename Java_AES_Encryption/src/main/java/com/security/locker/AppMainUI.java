package com.security.locker;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

// “My application has secure registration and login. After authentication, the user can upload encrypted documents to a digital locker or retrieve and decrypt them. All files are protected using AES encryption and stored securely in MySQL.”
public class AppMainUI extends JFrame {

    CardLayout card = new CardLayout();
    JPanel mainPanel = new JPanel(card);

    // Login fields
    JTextField loginEmail = new JTextField();
    JPasswordField loginPass = new JPasswordField();

    // Register fields
    JTextField regName = new JTextField();
    JTextField regEmail = new JTextField();
    JPasswordField regPass = new JPasswordField();

    int loggedInUserId = -1;

    public AppMainUI() {

        setTitle("Secure Digital Vault System");
        setSize(700, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        mainPanel.add(loginPanel(), "LOGIN");
        mainPanel.add(registerPanel(), "REGISTER");
        mainPanel.add(dashboardPanel(), "DASHBOARD");

        add(mainPanel);
        card.show(mainPanel, "LOGIN");
    }

    // ---------- LOGIN SCREEN ----------
    private JPanel loginPanel() {
        JPanel p = new JPanel(null);

        JLabel l1 = new JLabel("Email:");
        l1.setBounds(200, 100, 100, 25);
        p.add(l1);

        loginEmail.setBounds(300, 100, 200, 25);
        p.add(loginEmail);

        JLabel l2 = new JLabel("Password:");
        l2.setBounds(200, 140, 100, 25);
        p.add(l2);

        loginPass.setBounds(300, 140, 200, 25);
        p.add(loginPass);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(300, 180, 100, 30);
        p.add(btnLogin);

        JButton btnGoReg = new JButton("Register");
        btnGoReg.setBounds(410, 180, 100, 30);
        p.add(btnGoReg);

        btnGoReg.addActionListener(e -> card.show(mainPanel, "REGISTER"));

        btnLogin.addActionListener(e -> doLogin());

        return p;
    }

    // ---------- REGISTER SCREEN ----------
    private JPanel registerPanel() {
        JPanel p = new JPanel(null);

        JLabel l1 = new JLabel("Name:");
        l1.setBounds(200, 80, 100, 25);
        p.add(l1);

        regName.setBounds(300, 80, 200, 25);
        p.add(regName);

        JLabel l2 = new JLabel("Email:");
        l2.setBounds(200, 120, 100, 25);
        p.add(l2);

        regEmail.setBounds(300, 120, 200, 25);
        p.add(regEmail);

        JLabel l3 = new JLabel("Password:");
        l3.setBounds(200, 160, 100, 25);
        p.add(l3);

        regPass.setBounds(300, 160, 200, 25);
        p.add(regPass);

        JButton btnReg = new JButton("Create Account");
        btnReg.setBounds(300, 200, 150, 30);
        p.add(btnReg);

        JButton btnBack = new JButton("Back to Login");
        btnBack.setBounds(300, 240, 150, 30);
        p.add(btnBack);

        btnBack.addActionListener(e -> card.show(mainPanel, "LOGIN"));
        btnReg.addActionListener(e -> doRegister());

        return p;
    }

    // ---------- DASHBOARD SCREEN ----------
    private JPanel dashboardPanel() {
        JPanel p = new JPanel(new GridLayout(3, 1, 10, 10));

        JButton btnUpload = new JButton("Upload & Encrypt File");
        JButton btnView = new JButton("View & Download Files");
        JButton btnLogout = new JButton("Logout");

        p.add(btnUpload);
        p.add(btnView);
        p.add(btnLogout);

        btnUpload.addActionListener(e ->
            new SecureLockerUI().setVisible(true));

        btnView.addActionListener(e ->
            new SecureLockerDownloadUI().setVisible(true));

        btnLogout.addActionListener(e -> {
            loggedInUserId = -1;
            card.show(mainPanel, "LOGIN");
        });

        return p;
    }

    // ---------- LOGIN LOGIC ----------
    private void doLogin() {
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/AES_encryption?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",
                "root",
                "vishal08"
            );

            String sql = "SELECT user_id FROM users WHERE email=? AND password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, loginEmail.getText());
            ps.setString(2, new String(loginPass.getPassword()));

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                loggedInUserId = rs.getInt("user_id");
                JOptionPane.showMessageDialog(this, "Login Successful!");
                card.show(mainPanel, "DASHBOARD");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Credentials!");
            }

            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // ---------- REGISTER LOGIC ----------
    private void doRegister() {
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/AES_encryption?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",
                "root",
                "vishal08"
            );

            String sql = "INSERT INTO users(name, email, password) VALUES(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, regName.getText());
            ps.setString(2, regEmail.getText());
            ps.setString(3, new String(regPass.getPassword()));

            ps.executeUpdate();
            conn.close();

            JOptionPane.showMessageDialog(this, "Registration Successful!");
            card.show(mainPanel, "LOGIN");

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new AppMainUI().setVisible(true);
    }
}
