import java.awt.*;
import java.awt.event.*;

public class AWTMenuPractice_24RP12663 extends Frame implements ActionListener {

    MenuBar menuBar;
    Menu pagesMenu, editMenu, helpMenu;
    MenuItem loginItem, studentItem;
    Panel mainPanel, loginPanel, studentPanel;
    CardLayout cardLayout;

    public AWTMenuPractice_24RP12663() {
        // === Frame Setup ===
        setTitle("AWAT MENU Practice - 24RP12663");
        setSize(850, 500);
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        setResizable(false);

        // === Top Title Bar ===
        Panel topBar = new Panel(new BorderLayout());
        topBar.setBackground(Color.LIGHT_GRAY);
        topBar.setPreferredSize(new Dimension(850, 45));

        Label title = new Label("   AWAT MENU Practice");
        title.setFont(new Font("Arial", Font.BOLD, 15));
        topBar.add(title, BorderLayout.WEST);

        Button closeBtn = new Button("X");
        closeBtn.setBackground(Color.BLACK);
        closeBtn.setForeground(Color.WHITE);
        closeBtn.setFont(new Font("Arial", Font.BOLD, 14));
        closeBtn.addActionListener(e -> System.exit(0));
        topBar.add(closeBtn, BorderLayout.EAST);

        add(topBar, BorderLayout.NORTH);

        // === Menu Bar ===
        menuBar = new MenuBar();
        pagesMenu = new Menu("Pages");
        editMenu = new Menu("Edit");
        helpMenu = new Menu("Help");

        loginItem = new MenuItem("Login");
        studentItem = new MenuItem("Student");

        pagesMenu.add(loginItem);
        pagesMenu.add(studentItem);

        menuBar.add(pagesMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);
        setMenuBar(menuBar);

        loginItem.addActionListener(this);
        studentItem.addActionListener(this);

        // === Black Section Header ===
        Panel header = new Panel(new BorderLayout());
        header.setBackground(Color.BLACK);
        header.setPreferredSize(new Dimension(850, 40));

        Label headerText = new Label("SAMPLE JAVA AWT LAYOUT", Label.CENTER);
        headerText.setFont(new Font("Arial", Font.BOLD, 15));
        headerText.setForeground(Color.WHITE);
        header.add(headerText, BorderLayout.CENTER);

        add(header, BorderLayout.BEFORE_FIRST_LINE);

        // === Main Content with CardLayout ===
        cardLayout = new CardLayout();
        mainPanel = new Panel(cardLayout);
        mainPanel.setBackground(Color.WHITE);
        add(mainPanel, BorderLayout.CENTER);

        // === Login Page ===
        loginPanel = new Panel(new GridBagLayout());
        loginPanel.setBackground(Color.WHITE);
        loginPanel.setPreferredSize(new Dimension(600, 300));

        Panel loginBox = new Panel(new GridBagLayout());
        loginBox.setBackground(Color.WHITE);
        loginBox.setPreferredSize(new Dimension(350, 220));
        loginBox.setForeground(Color.BLACK);
        loginBox.setFont(new Font("Arial", Font.PLAIN, 14));
        loginBox.setForeground(Color.BLACK);
        loginBox.setLayout(new GridBagLayout());
        loginBox.setForeground(Color.BLACK);
        loginBox.setBackground(Color.WHITE);
        loginBox.setFont(new Font("Arial", Font.PLAIN, 13));
        loginBox.setForeground(Color.BLACK);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 5, 10, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;

        Label loginTitle = new Label("LOGIN PAGE", Label.CENTER);
        loginTitle.setFont(new Font("Arial", Font.BOLD, 16));
        loginBox.add(loginTitle, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 1; gbc.gridx = 0;
        Label userLbl = new Label("Username");
        userLbl.setFont(new Font("Arial", Font.BOLD, 13));
        loginBox.add(userLbl, gbc);

        gbc.gridx = 1;
        TextField userField = new TextField(15);
        loginBox.add(userField, gbc);

        gbc.gridy = 2; gbc.gridx = 0;
        Label passLbl = new Label("Password");
        passLbl.setFont(new Font("Arial", Font.BOLD, 13));
        loginBox.add(passLbl, gbc);

        gbc.gridx = 1;
        TextField passField = new TextField(15);
        passField.setEchoChar('*');
        loginBox.add(passField, gbc);

        gbc.gridy = 3; gbc.gridx = 0; gbc.gridwidth = 2;
        Button loginBtn = new Button("LOGIN");
        loginBtn.setBackground(Color.BLACK);
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setFont(new Font("Arial", Font.BOLD, 14));
        loginBox.add(loginBtn, gbc);

        loginPanel.add(loginBox);

        // === Student Page ===
        studentPanel = new Panel(new BorderLayout());
        studentPanel.setBackground(Color.WHITE);
        Label studentInfo = new Label("NTAWUKURIRYAYO Frederic - 24RP12663", Label.CENTER);
        studentInfo.setFont(new Font("Arial", Font.BOLD, 16));
        studentPanel.add(studentInfo, BorderLayout.CENTER);

        // === Add Cards ===
        mainPanel.add(loginPanel, "Login");
        mainPanel.add(studentPanel, "Student");

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginItem) {
            cardLayout.show(mainPanel, "Login");
        } else if (e.getSource() == studentItem) {
            cardLayout.show(mainPanel, "Student");
        }
    }

    public static void main(String[] args) {
        new AWTMenuPractice_24RP12663();
    }
}
