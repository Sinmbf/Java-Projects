package quiz.game;

import javax.swing.*; // For JFrame and images
import java.awt.*; // For color and graphics
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {

    // Instance variables
    // Globally declare variables
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupOptions;
    JButton nextBtn, lifelineBtn, submitBtn;
    String username;

    // Static timer field
    // For tracking timer
    public int timer = 16;

    // For tracking question count
    public int count = 0;

    // For tracking count of lifeline used
    public int lifelineCount = 0;

    // For tracking total score of user
    public int totalScore = 0;

    // For questions => 10 questions(10 rows), each question 4 options(4+1 columns)
    public String questions[][] = new String[40][5]; // 10 questions

    // For correct answers => 10 questions(10 rows), each question 1 correct answer(1 column)
    String correctAns[][] = new String[40][1];

    // For answers given by the user
    String userAns[][] = new String[10][1];

    QuestionsAndAnswers qa = new QuestionsAndAnswers();

    // Parameterized Constructor
    Quiz(String username) {

        this.username = username;

        // Set title of the frame
        setTitle("Quiz");

        // Set frame size and layout
        setBounds(45, 0, 1200, 850); // By default called by JFrame
        getContentPane().setBackground(Color.WHITE);
        setLayout(null); // Custom layout

        // Load image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1200, 330);  // Position the image
        add(image); // Add image to frame

        // Create question number label
        qno = new JLabel();
        qno.setBounds(100, 365, 55, 30);
        qno.setFont(new Font("Futura", Font.BOLD, 20));
        add(qno);

        // Create question label
        question = new JLabel();
        question.setBounds(140, 365, 1100, 30);
        question.setFont(new Font("Futura", Font.BOLD, 20));
        add(question);

        // Fill questions and answers
        qa.fillQuestionsAndAnswers(questions, correctAns);

        // Create radio buttons for options
        createRadioButtons();

        // Create buttons
        createButtons();

        // Start quiz by displaying the first question
        startQuiz(count);

        // Create a custom panel for the timer
        TimerPanel timerPanel = new TimerPanel();
        timerPanel.setBounds(800, 420, 500, 40);  // Set bounds for the timer display
        timerPanel.setBackground(Color.WHITE);
        add(timerPanel);  // Add the timer panel to the frame

        // Timer to decrease the timer and update every second
        Timer countdownTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timer > 0) {
                    timer--;  // Decrement the timer every second
                    timerPanel.repaint(); // Repaint only the timer panel
                }
            }
        });
        countdownTimer.start();  // Start the countdown timer

        // Set frame visibility
        setVisible(true);
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

    // Method to create buttons (Lifeline, Next, Submit)
    private void createButtons() {
        // Create lifeline button
        lifelineBtn = new JButton("50-50 LIFELINE");
        lifelineBtn.setBounds(135, 600, 230, 50);
        lifelineBtn.setFont(new Font("Arial", Font.BOLD, 24));
        lifelineBtn.setBackground(Color.GREEN);
        lifelineBtn.setForeground(Color.GREEN); // Button text color
        lifelineBtn.setContentAreaFilled(true); // Allow custom background to render
        lifelineBtn.setOpaque(true);

        // Change cursor to hand pointer on hover
        lifelineBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Add event to button
        lifelineBtn.addActionListener(this);
        add(lifelineBtn);

        // Create next button
        nextBtn = new JButton("NEXT");
        nextBtn.setBounds(455, 600, 230, 50);
        nextBtn.setFont(new Font("Arial", Font.BOLD, 24));
        nextBtn.setBackground(new Color(30, 144, 255));
        nextBtn.setForeground(new Color(30, 144, 255)); // Button text color
        nextBtn.setContentAreaFilled(true); // Allow custom background to render
        nextBtn.setOpaque(true);

        // Change cursor to hand pointer on hover
        nextBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Add event to button
        nextBtn.addActionListener(this);
        add(nextBtn);

        // Create submit button
        submitBtn = new JButton("Submit");
        submitBtn.setBounds(775, 600, 230, 50);
        submitBtn.setFont(new Font("Arial", Font.BOLD, 24));
        submitBtn.setBackground(new Color(30, 144, 255));
        submitBtn.setForeground(new Color(30, 144, 255)); // Button text color
        submitBtn.setContentAreaFilled(true); // Allow custom background to render
        submitBtn.setOpaque(true);

        // Disable submit button initially
        submitBtn.setEnabled(false);

        // Change cursor to hand pointer on hover
        submitBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Add event to button
        submitBtn.addActionListener(this);
        add(submitBtn);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == nextBtn) {
            timer = 16;
            repaint();

            // Only enable lifeline button if used less than 2 times
            if (lifelineCount < 2) {
                lifelineBtn.setEnabled(true);
            }

            // Enable option button if in case disabled
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            // Change color back to normal
            opt1.setOpaque(false);
            opt2.setOpaque(false);
            opt3.setOpaque(false);
            opt4.setOpaque(false);

            // Set Answer given
            if (groupOptions.getSelection() == null) {
                userAns[count][0] = "";
            } else {
                // Get the answer given by user and insert in array
                userAns[count][0] = groupOptions.getSelection().getActionCommand();
            }

            // Show next question
            count++;
            startQuiz(count);

            // Disable next button after final question
            if (count == 9) {
                nextBtn.setEnabled(false);
                submitBtn.setEnabled(true);
            }
        } 
        else if (ae.getSource() == lifelineBtn) {
            lifelineCount++;
            
            // Check the position of the correct answer
            for (int i = 1; i < questions[count].length; i++) {
                if (questions[count][i].equals(correctAns[count][0])) {
                    if (i == 2 || i == 3) {
                        opt1.setEnabled(false);
                        opt4.setEnabled(false);
                        opt1.setBackground(Color.RED);
                        opt4.setBackground(Color.RED);
                        opt1.setOpaque(true);
                        opt4.setOpaque(true);
                    } else {
                        opt2.setEnabled(false);
                        opt3.setEnabled(false);
                        opt2.setBackground(Color.RED);
                        opt3.setBackground(Color.RED);
                        opt2.setOpaque(true);
                        opt3.setOpaque(true);
                    }
                }
            }

            // Disable lifeline button
            lifelineBtn.setEnabled(false);

        } 
        else {

            // Check if answer is given
            if (groupOptions.getSelection() == null) {  // No answer selected
                userAns[count][0] = "";
            } else {
                // Get the answer given by user and insert in array
                userAns[count][0] = groupOptions.getSelection().getActionCommand();
            }

            // Check the answers given by user and assign total score
            for (int i = 0; i < userAns.length; i++) {
                if (userAns[i][0].equals(correctAns[i][0])) {
                    totalScore += 10;
                }
            }

            // Hide current frame
            setVisible(false);

            // Show score frame
            new Score(username, totalScore);
        }
    }

    // Custom JPanel to display the timer
    class TimerPanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);  // Call superclass's paintComponent to handle background
            g.setColor(Color.RED);
            g.setFont(new Font("Futura", Font.BOLD, 30));

            // Display the timer value
            String time = "Time Left: " + timer + " seconds";
            if (timer > 0) {
                g.drawString(time, 11, 30);  // Draw timer text
            } else {
                g.drawString("Time is Up!!", 10, 30);
                handleTimeUp();
            }

        }
    }

    // Method to start the quiz and display questions and answers
    public void startQuiz(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);

        opt1.setText(" " + questions[count][1]);
        // Set action for option so that it can be retrieved by getActionCommand()
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(" " + questions[count][2]);
        // Set action for option so that it can be retrieved by getActionCommand()
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(" " + questions[count][3]);
        // Set action for option so that it can be retrieved by getActionCommand()
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(" " + questions[count][4]);
        // Set action for option so that it can be retrieved by getActionCommand()
        opt4.setActionCommand(questions[count][4]);

        // Reset the selection
        groupOptions.clearSelection();
    }

    // Method to Handle what happens when time runs out
    private void handleTimeUp() {
        if (timer == 0) {
            timer = 16; // Reset timer for next round

            // Only enable lifeline button if used less than 2 times
            if (lifelineCount < 2) {
                lifelineBtn.setEnabled(true);
            }

            // Enable option button if in case disabled
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            // Change color back to normal
            opt1.setOpaque(false);
            opt2.setOpaque(false);
            opt3.setOpaque(false);
            opt4.setOpaque(false);

            // Enable the next button and handle user input if not already answered
            if (count < 9) {

                // Check if answer is given
                if (groupOptions.getSelection() == null) {  // No answer selected
                    userAns[count][0] = "";
                } else {
                    // Get the answer given by user and insert in array
                    userAns[count][0] = groupOptions.getSelection().getActionCommand();
                }

                // Show next question
                count++;
                startQuiz(count);
            } else {
                // Submit the quiz if it's the last question
                nextBtn.setEnabled(false);
                submitBtn.setEnabled(true);

                // Check if answer is given
                if (groupOptions.getSelection() == null) {  // No answer selected
                    userAns[count][0] = "";
                } else {
                    // Get the answer given by user and insert in array
                    userAns[count][0] = groupOptions.getSelection().getActionCommand();
                }

                // Check the answers given by user and assign total score
                for (int i = 0; i < userAns.length; i++) {
                    if (userAns[i][0].equals(correctAns[i][0])) {
                        totalScore += 10;
                    }
                }

                // Hide current frame
                Quiz.this.setVisible(false);

                // Show score frame
                new Score(username, totalScore);
            }
        }
    }

    public static void main(String[] args) {
        new Quiz("User"); // Create and display the quiz
    }
}
