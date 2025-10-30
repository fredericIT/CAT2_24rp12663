import java.awt.*;
import java.awt.event.*;

public class Project24RP12663 {
    private Frame mainFrame;
    private Panel cardPanel;
    private CardLayout cardLayout;
    private MenuBar menuBar;

    public Project24RP12663() {
        prepareGUI();
    }

    public static void main(String[] args) {
        Project24RP12663 awtProject = new Project24RP12663();
    }

    private void prepareGUI() {
        // Create main frame
        mainFrame = new Frame("AWAT MENU Practice - 24RP12663");
        mainFrame.setSize(600, 400);
        mainFrame.setLayout(new BorderLayout());

        // Create menu bar
        createMenuBar();

        // Create card layout for switching between pages
        cardLayout = new CardLayout();
        cardPanel = new Panel(cardLayout);

        // Create login page
        Panel loginPanel = createLoginPage();

        // Create student page
        Panel studentPanel = createStudentPage();

        // Add panels to card layout
        cardPanel.add(loginPanel, "Login");
        cardPanel.add(studentPanel, "Student");

        // Add components to main frame
        mainFrame.add(cardPanel, BorderLayout.CENTER);

        // Show login page by default
        cardLayout.show(cardPanel, "Login");

        // Add window listener to handle closing
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        // Make frame visible
        mainFrame.setVisible(true);
    }

    private void createMenuBar() {
        menuBar = new MenuBar();

        // Create Pages menu
        Menu pagesMenu = new Menu("Pages");

        // Create menu items
        MenuItem loginItem = new MenuItem("Login");
        MenuItem studentItem = new MenuItem("Student");

        // Add action listeners for menu items
        loginItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Login");
            }
        });

        studentItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Student");
            }
        });

        // Add items to Pages menu
        pagesMenu.add(loginItem);
        pagesMenu.add(studentItem);

        // Create other menus
        Menu editMenu = new Menu("Edit");
        Menu helpMenu = new Menu("Help");

        // Add menus to menu bar
        menuBar.add(pagesMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        // Set menu bar to frame
        mainFrame.setMenuBar(menuBar);
    }

    private Panel createLoginPage() {
        Panel loginPanel = new Panel();
        loginPanel.setLayout(new GridBagLayout());
        loginPanel.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title label
        Label titleLabel = new Label("SAMPLE JAVA AWT LAYOUT");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        loginPanel.add(titleLabel, gbc);

        // Empty space
        Label emptyLabel = new Label("");
        gbc.gridy = 1;
        loginPanel.add(emptyLabel, gbc);

        // Login page title
        Label loginTitle = new Label("LOGIN PAGE");
        loginTitle.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridy = 2;
        loginPanel.add(loginTitle, gbc);

        // Empty space
        gbc.gridy = 3;
        loginPanel.add(new Label(""), gbc);

        // Username label
        Label userLabel = new Label("Username");
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        loginPanel.add(userLabel, gbc);

        // Username text field
        TextField userText = new TextField(20);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        loginPanel.add(userText, gbc);

        // Password label
        Label passLabel = new Label("Password");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.EAST;
        loginPanel.add(passLabel, gbc);

        // Password text field
        TextField passText = new TextField(20);
        passText.setEchoChar('*');
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        loginPanel.add(passText, gbc);

        // Login button
        Button loginButton = new Button("LOGIN");
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        loginPanel.add(loginButton, gbc);

        return loginPanel;
    }

    private Panel createStudentPage() {
        Panel studentPanel = new Panel();
        studentPanel.setLayout(new BorderLayout());
        studentPanel.setBackground(Color.WHITE);

        // Create and format the student information
        String studentInfo = "Name: NTAWUKURIRYAYO Frederic\nRegistration Number: 24RP12663";
        Label studentLabel = new Label(studentInfo);
        studentLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        studentLabel.setAlignment(Label.CENTER);

        studentPanel.add(studentLabel, BorderLayout.CENTER);

        return studentPanel;
    }
}