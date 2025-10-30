import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AWTMultiplicationTable_24RP12663 extends Frame implements ActionListener {

    Label titleLabel;
    TextField numberField;
    TextArea resultArea;
    Button displayButton, closeButton;
    Panel topPanel, centerPanel, bottomPanel;

    public AWTMultiplicationTable_24RP12663() {
        // Frame setup
        setTitle("AWT Practice - 24RP12663");
        setSize(600, 400);
        setLayout(new BorderLayout());
        setBackground(Color.white);
        setResizable(false);

        // ===== Top Panel (Header bar + Close Button) =====
        topPanel = new Panel(new BorderLayout());
        topPanel.setBackground(Color.LIGHT_GRAY);

        titleLabel = new Label("AWT Practice", Label.LEFT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        titleLabel.setBackground(Color.LIGHT_GRAY);
        titleLabel.setForeground(Color.black);
        topPanel.add(titleLabel, BorderLayout.CENTER);

        closeButton = new Button("X");
        closeButton.setFont(new Font("Arial", Font.BOLD, 14));
        closeButton.setBackground(Color.black);
        closeButton.setForeground(Color.white);
        closeButton.addActionListener(this);
        topPanel.add(closeButton, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);

        // ===== Center Panel (Main Content) =====
        centerPanel = new Panel();
        centerPanel.setLayout(null);
        centerPanel.setBackground(Color.white);

        // Input Field
        numberField = new TextField();
        numberField.setFont(new Font("Arial", Font.BOLD, 14));
        numberField.setBackground(new Color(45, 57, 75)); // dark gray-blue tone
        numberField.setForeground(Color.white);
        numberField.setBounds(80, 60, 250, 35);
        centerPanel.add(numberField);

        // Display Button
        displayButton = new Button("DISPLAY");
        displayButton.setFont(new Font("Arial", Font.BOLD, 12));
        displayButton.setBackground(Color.black);
        displayButton.setForeground(Color.white);
        displayButton.setBounds(80, 110, 100, 35);
        displayButton.addActionListener(this);
        centerPanel.add(displayButton);

        // Result Area
        resultArea = new TextArea();
        resultArea.setFont(new Font("Consolas", Font.PLAIN, 14));
        resultArea.setEditable(false);
        resultArea.setBackground(new Color(45, 57, 75));
        resultArea.setForeground(Color.white);
        resultArea.setBounds(350, 40, 200, 220);
        centerPanel.add(resultArea);

        add(centerPanel, BorderLayout.CENTER);

        // ===== Bottom Panel (Footer) =====
        bottomPanel = new Panel();
        bottomPanel.setBackground(new Color(45, 57, 75));
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

    // ===== Button Actions =====
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == displayButton) {
            try {
                int number = Integer.parseInt(numberField.getText().trim());
                StringBuilder table = new StringBuilder();
                for (int i = 1; i <= 10; i++) {
                    table.append(number + " * " + i + " = " + (number * i) + "\n");
                }
                resultArea.setText(table.toString());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Please enter a valid number.",
                        "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == closeButton) {
            dispose();
        }
    }

    public static void main(String[] args) {
        new AWTMultiplicationTable_24RP12663();
    }
}
