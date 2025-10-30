import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleJavaAWTLayout_24RP12663 extends Frame implements ActionListener {

    Label titleLabel, headerLabel, userLabel, passLabel, loginLabel;
    TextField userField, passField;
    Button loginButton, closeButton;
    Panel topPanel, centerPanel, bottomPanel;

    // Hardcoded credentials
    String correctUsername = "admin";
    String correctPassword = "12345";

    public SimpleJavaAWTLayout_24RP12663() {
        setTitle("SIMPLE JAVA AWT LAYOUT - 24RP12663");
        setSize(700, 450);
        setLayout(new BorderLayout());
        setBackground(Color.white);
        setResizable(false);

        // ===== Top Panel (Title bar + Close button) =====
        topPanel = new Panel(new BorderLayout());
        topPanel.setBackground(Color.LIGHT_GRAY);

        titleLabel = new Label("AWAT MENU Practice", Label.LEFT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        titleLabel.setForeground(Color.black);
        titleLabel.setBackground(Color.LIGHT_GRAY);
        titleLabel.setPreferredSize(new Dimension(200, 40));
        topPanel.add(titleLabel, BorderLayout.CENTER);

        closeButton = new Button("X");
        closeButton.setBackground(Color.black);
        closeButton.setForeground(Color.white);
        closeButton.setFont(new Font("Arial", Font.BOLD, 14));
        closeButton.setPreferredSize(new Dimension(50, 40));
        closeButton.addActionListener(this);
        topPanel.add(closeButton, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);

        // ===== Header (Black bar with title) =====
        headerLabel = new Label("SIMPLE JAVA AWT LAYOUT", Label.CENTER);
        headerLabel.setBackground(Color.black);
        headerLabel.setForeground(Color.white);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(headerLabel, BorderLayout.BEFORE_FIRST_LINE);

        // ===== Center Panel (Login Form) =====
        centerPanel = new Panel();
        centerPanel.setLayout(null);
        centerPanel.setBackground(Color.white);

        loginLabel = new Label("LOGIN PAGE", Label.CENTER);
        loginLabel.setFont(new Font("Arial", Font.BOLD, 14));
        loginLabel.setBounds(280, 50, 150, 30);
        centerPanel.add(loginLabel);

        userLabel = new Label("Username:");
        userLabel.setFont(new Font("Arial", Font.BOLD, 12));
        userLabel.setBounds(200, 110, 100, 25);
        centerPanel.add(userLabel);

        userField = new TextField();
        userField.setBounds(300, 110, 180, 25);
        centerPanel.add(userField);

        passLabel = new Label("Password:");
        passLabel.setFont(new Font("Arial", Font.BOLD, 12));
        passLabel.setBounds(200, 150, 100, 25);
        centerPanel.add(passLabel);

        passField = new TextField();
        passField.setEchoChar('*');
        passField.setBounds(300, 150, 180, 25);
        centerPanel.add(passField);

        loginButton = new Button("LOGIN");
        loginButton.setBackground(Color.black);
        loginButton.setForeground(Color.white);
        loginButton.setFont(new Font("Arial", Font.BOLD, 12));
        loginButton.setBounds(300, 200, 100, 30);
        loginButton.addActionListener(this);
        centerPanel.add(loginButton);

        add(centerPanel, BorderLayout.CENTER);

        // ===== Bottom Panel (Dark footer) =====
        bottomPanel = new Panel();
        bottomPanel.setBackground(new Color(45, 57, 75)); // dark gray-blue tone
        bottomPanel.setPreferredSize(new Dimension(100, 40));
        add(bottomPanel, BorderLayout.SOUTH);

        // ===== Window Close Event =====
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String enteredUser = userField.getText();
            String enteredPass = passField.getText();

            if (enteredUser.equals(correctUsername) && enteredPass.equals(correctPassword)) {
                JOptionPane.showMessageDialog(this,
                        "Welcome " + enteredUser + "! (Project: SIMPLE JAVA AWT LAYOUT - 24RP12663)",
                        "Login Successful", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Incorrect Username or Password! Please try again.",
                        "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == closeButton) {
            dispose();
        }
    }

    public static void main(String[] args) {
        new SimpleJavaAWTLayout_24RP12663();
    }
}
