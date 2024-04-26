import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class QuizApplication extends JFrame {

    private String[] topics = {"History", "Science", "Geography", "Music", "Art"};
    private JComboBox<String> topicComboBox;
    private JButton startButton;

    public QuizApplication() {
        setTitle("Quiz Application");
        setSize(700,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Set custom background image
        setContentPane(new JLabel(new ImageIcon("finalbg.jpg")));
        setLayout(null); // Set layout to null for absolute positioning

        JPanel panel = new JPanel();
        panel.setOpaque(false); // Make panel transparent
        panel.setLayout(new GridLayout(4, 1));

        JLabel titleLabel = new JLabel("Welcome to the Quiz Application");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(titleLabel);

        JLabel topicLabel = new JLabel("Select a topic:");
        topicLabel.setForeground(Color.WHITE);
        topicLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(topicLabel);

        topicComboBox = new JComboBox<>(topics);
        panel.add(topicComboBox);

        startButton = new JButton("Start Quiz");
        startButton.setFont(new Font("Arial", Font.BOLD, 20));
        startButton.setBackground(Color.BLACK);
        startButton.setForeground(Color.WHITE);
        panel.add(startButton);

        // Set position of panel within the JFrame
        panel.setBounds(50, 200, 550, 150); // x, y, width, height

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedTopic = (String) topicComboBox.getSelectedItem();
                openQuizPage(selectedTopic);
            }
        });

        add(panel);
        setVisible(true);
    }

    private void openQuizPage(String topic) {
        // URL for the quiz page based on the selected topic
        String url = ""; // Add appropriate URL for each topic
        switch (topic) {
            case "History":
                url = "file:///C:/Users/aasth/Desktop/jmp/History.html";
                break;
            case "Science":
                url = "file:///C:/Users/aasth/Desktop/jmp/Science.html";
                break;
            case "Geography":
                url = "file:///C:/Users/aasth/Desktop/jmp/geography.html";
                break;
            case "Music":
                url = "file:///C:/Users/aasth/Desktop/jmp/Music.html";
                break;
            case "Art":
                url = "file:///C:/Users/aasth/Desktop/jmp/art.html";
                break;
        }

        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error opening quiz page for " + topic);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new QuizApplication();
            }
        });
    }
}
