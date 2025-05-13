package advancequizgame;

import advancequizgame.Utilities.AddHoverEffect;
import advancequizgame.Utilities.QuestionsAndAnswers;
import java.awt.*;
import javax.swing.*;

public class Admin {

    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupOptions;

    // For questions => 10 questions(10 rows), each question 4 options(4+1 columns)
    public String questionsAndOptions[][] = new String[40][5]; // 10 questions

    // For correct answers => 10 questions(10 rows), each question 1 correct answer(1 column)
    String correctAns[][] = new String[40][1];

    // For answers given by the user
    String userAns[][] = new String[10][1];

    // Create an instance for hover effect class
    AddHoverEffect hoverEffect = new AddHoverEffect();

    // Create an instance for hover effect class
    QuestionsAndAnswers qa = new QuestionsAndAnswers();

    // Constructor
    public Admin() {
        this("Admin");
    }

    public Admin(String username) {
        System.out.println("Admin page");

        // Create a frame
        JFrame frame = new JFrame("Admin");

        // Launch a frame when the class runs at the beginning
        // getContentPane() => grab the whole frame
        // setBackground() => set background color for frame
        frame.getContentPane().setBackground(Color.WHITE);

        // Set size of the frame
        frame.setSize(900, 500);

        // Center the frame relative to screen
        frame.setLocationRelativeTo(null);

        // Set the position layout of frame
        frame.setLayout(null);

        // Create a panel for admin image and username
        JPanel adminPanel = new JPanel();
        adminPanel.setLayout(null);
        adminPanel.setBounds(0, 0, 150, 50);
        adminPanel.setBackground(Color.WHITE);

        // Scale the image
        ImageIcon originalImage = new ImageIcon(getClass().getResource("/resources/icons/admin.jpg"));
        Image scaledImage = originalImage.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon resizedImage = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(resizedImage);
        imageLabel.setBounds(0, 0, 50, 50);

        // Add the image in the panel
        adminPanel.add(imageLabel);

        // Create a label for admin username
        JLabel adminUsernameLabel = new JLabel(username);
        adminUsernameLabel.setFont(new Font("Arial", Font.BOLD, 15));
        adminUsernameLabel.setBounds(55, 0, 300, 50);
//
        // Add the username label in the panel
        adminPanel.add(adminUsernameLabel);

        // Create a panel for admin actions
        JPanel adminActionPanel = new JPanel();
        adminActionPanel.setLayout(null);
        adminActionPanel.setBounds(0, 60, 156, 450);
        adminActionPanel.setBackground(Color.WHITE);
        adminActionPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        // Create a button for change credentials
        JButton changeCredentialsBtn = new JButton("Change Credentials");
        changeCredentialsBtn.setFont(new Font("Arial", Font.PLAIN, 13));
        changeCredentialsBtn.setBackground(new Color(138, 43, 226));
        changeCredentialsBtn.setForeground(Color.WHITE);
        hoverEffect.addHoverEffect(changeCredentialsBtn, new Color(75, 0, 130), Color.WHITE, new Color(138, 43, 226), Color.WHITE);

        // Disable the default look of button
        changeCredentialsBtn.setBorder(BorderFactory.createEmptyBorder());
        changeCredentialsBtn.setOpaque(true);

        changeCredentialsBtn.setBounds(3, 50, 150, 40);
        changeCredentialsBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        adminActionPanel.add(changeCredentialsBtn);

        // Create a button for managing Questions
        JButton manageQuestionsBtn = new JButton("Questions");
        manageQuestionsBtn.setFont(new Font("Arial", Font.PLAIN, 13));
        manageQuestionsBtn.setBackground(new Color(138, 43, 226));
        manageQuestionsBtn.setForeground(Color.WHITE);
        hoverEffect.addHoverEffect(manageQuestionsBtn, new Color(75, 0, 130), Color.WHITE, new Color(138, 43, 226), Color.WHITE);

        // Disable the default look of button
        manageQuestionsBtn.setBorder(BorderFactory.createEmptyBorder());
        manageQuestionsBtn.setOpaque(true);

        manageQuestionsBtn.setBounds(3, 5, 150, 40);
        manageQuestionsBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Add the button in the panel
        adminActionPanel.add(manageQuestionsBtn);

        // Create questions label
        JLabel questions = new JLabel("Questions");
        questions.setFont(new Font("Arial", Font.BOLD, 17));
        questions.setBounds(23, 0, 300, 50);
        questions.setBackground(Color.RED);

        // Create credentials label
        JLabel credentials = new JLabel("Current Credentials");
        credentials.setFont(new Font("Arial", Font.BOLD, 17));
        credentials.setBounds(23, 0, 300, 50);

        // Create a panel to be scrolled
        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(null); // The panel itself can also use null layout
        actionPanel.setPreferredSize(new Dimension(500, 2000)); // Set the preferred size

        // Wrap the panel in a JScrollPane
        JScrollPane scrollPane = new JScrollPane(actionPanel);
        scrollPane.setBounds(165, 60, 700, 400); // Manually set the bounds of the scroll pane
        frame.add(scrollPane);

        // Fill questions and answers
        qa.fillQuestionsAndAnswers(questionsAndOptions, correctAns);

        // Add event for questions button click
        manageQuestionsBtn.addActionListener(e -> {
            int count = 0;
            int num = 20;
            if (count < 1) {
                actionPanel.removeAll();
                actionPanel.add(questions);
                for (int i = 0; i < 40; i++) {

                    num += 20;
                    JLabel qno=new JLabel("" + (i+1)+ ". ");
                    qno.setBounds(10, num + 20, 50, 25);
                    JLabel question=new JLabel(questionsAndOptions[i][0]);
                    question.setBounds(60, num + 20, 500, 25);
                    actionPanel.add(qno);
                    actionPanel.add(question);
//                    JLabel questionLabel = new JLabel("Question " + (i + 1));
//                    questionLabel.setBounds(10, num + 20, num, 25);
//                    actionPanel.add(questionLabel);
                }
                frame.repaint();
                frame.revalidate();
            }
            count++;
        });

        // Add event for change credentials button click
        changeCredentialsBtn.addActionListener(e -> {
            System.out.println("credentials");
            actionPanel.removeAll();
            actionPanel.add(credentials);

            frame.repaint();
            frame.revalidate();

        });

        // Add the admin panel in the frame
        frame.add(adminPanel);
        frame.add(adminActionPanel);

        // Define what happens after closing the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make the frame visible
        frame.setVisible(true);
    }
    
    // Method to create radio buttons for options
    private void createRadioButtons() {
        // Insert a radio button to choose among multiple options
        // Option 1
        opt1 = new JRadioButton();
        opt1.setBounds(135, 420, 550, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setOpaque(true);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 18));

        // Change cursor to hand pointer on hover
        opt1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(opt1);

        // Option 2
        opt2 = new JRadioButton();
        opt2.setBounds(135, 460, 550, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setOpaque(true);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 18));

        // Change cursor to hand pointer on hover
        opt2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(opt2);

        // Option 3
        opt3 = new JRadioButton();
        opt3.setBounds(135, 500, 550, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setOpaque(true);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 18));

        // Change cursor to hand pointer on hover
        opt3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(opt3);

        // Option 4
        opt4 = new JRadioButton();
        opt4.setBounds(135, 540, 550, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setOpaque(true);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 18));

        // Change cursor to hand pointer on hover
        opt4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(opt4);

        // When buttons are grouped, only one button can be selected at a time
        groupOptions = new ButtonGroup();
        groupOptions.add(opt1);
        groupOptions.add(opt2);
        groupOptions.add(opt3);
        groupOptions.add(opt4);
    }

    // Main method
    public static void main(String[] args) {
        new Admin();
    }
}
