// File: MyShapes24RP12663.java
import java.awt.*;
import java.awt.event.*;

public class MyShapes24RP12663 extends Frame implements ActionListener, MouseListener, MouseMotionListener {

    private Button closeBtn;
    private Label titleLabel;
    private EmojiCanvas emojiCanvas;
    private int mouseX, mouseY;

    public MyShapes24RP12663() {
        // === Remove native title bar ===
        setUndecorated(true);
        setSize(850, 480);
        setLayout(null);
        setBackground(new Color(230, 230, 230));
        setResizable(false);

        // === Custom Title Bar ===
        Panel titleBar = new Panel(null);
        titleBar.setBackground(new Color(240, 240, 240));
        titleBar.setBounds(0, 0, 850, 50);
        add(titleBar);

        // Allow dragging the window
        titleBar.addMouseListener(this);
        titleBar.addMouseMotionListener(this);

        // Title text
        titleLabel = new Label("My shapes");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 15));
        titleLabel.setBounds(60, 15, 200, 25);
        titleBar.add(titleLabel);

        // Close button (black “X”)
        closeBtn = new Button("X");
        closeBtn.setFont(new Font("Arial", Font.BOLD, 16));
        closeBtn.setBackground(Color.BLACK);
        closeBtn.setForeground(Color.WHITE);
        closeBtn.setBounds(800, 10, 40, 30);
        closeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        closeBtn.addActionListener(this);
        titleBar.add(closeBtn);

        // Thin line under title bar (like your image)
        Panel separator = new Panel();
        separator.setBackground(Color.GRAY);
        separator.setBounds(0, 50, 850, 1);
        add(separator);

        // === Emoji Drawing Area ===
        emojiCanvas = new EmojiCanvas();
        emojiCanvas.setBounds(0, 51, 850, 429);
        add(emojiCanvas);

        // === Display window centered ===
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Close window
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == closeBtn) {
            dispose();
        }
    }

    // === Make title bar draggable ===
    @Override
    public void mousePressed(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Point p = getLocation();
        setLocation(p.x + e.getX() - mouseX, p.y + e.getY() - mouseY);
    }

    // Unused events
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseClicked(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
    @Override public void mouseMoved(MouseEvent e) {}

    // === Inner class to draw emoji ===
    class EmojiCanvas extends Canvas {
        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int centerX = getWidth() / 2;
            int centerY = getHeight() / 2;

            // Face
            g2.setColor(new Color(255, 200, 0));
            g2.fillOval(centerX - 50, centerY - 50, 100, 100);

            // Eyes
            g2.setColor(Color.WHITE);
            g2.fillOval(centerX - 25, centerY - 15, 20, 20);
            g2.fillOval(centerX + 5, centerY - 15, 20, 20);

            g2.setColor(Color.BLACK);
            g2.fillOval(centerX - 18, centerY - 8, 8, 8);
            g2.fillOval(centerX + 12, centerY - 8, 8, 8);

            // Smile
            g2.setColor(new Color(80, 40, 0));
            g2.setStroke(new BasicStroke(3));
            g2.drawArc(centerX - 25, centerY - 10, 50, 35, 190, 160);
        }
    }

    public static void main(String[] args) {
        new MyShapes24RP12663();
    }
}
