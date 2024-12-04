package quiz.game;

import javax.swing.*; // For JFrame and images
import java.awt.*; // For color and graphics
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener{
    // Instance variables
    
    // Globally declare variables
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupOptions;
    JButton nextBtn,lifelineBtn,submitBtn;
    
    // Static timer field
    // For tracking timer
    public static int timer = 16;
    
    // For tracking answer given or not
    public static boolean isAnsGiven=false;
    
    // For tracking question count
    public static int count=0;
    
    // For tracking count of lifeline used
    public static int lifelineCount=0;
    
    // For tracking total score of user
    public static int totalScore=0;
    
    // For questions => 10 questions(10 rows), each question 4 answers(4+1 columns)
    String questions[][] = new String[10][5]; // 10 questions
    
    // For correct answers => 10 questions(10 rows), each question 1 correct answer(1 column)
    String correctAns[][] = new String[10][1];
    
    // For answers given by the user
    String userAns[][]=new String[10][1];
    
    // Default Constructor
    Quiz() {
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
        question.setBounds(140, 365, 1000, 30);
        question.setFont(new Font("Futura", Font.BOLD, 20));
        add(question);

        // Fill questions and answers
        fillQuestionsAndAnswers();

        // Create radio buttons for options
        createRadioButtons();

        // Create buttons
        createButtons();

        // Start quiz by displaying the first question
        startQuiz(count);
        
        // Create a custom panel for the timer
        TimerPanel timerPanel = new TimerPanel();
        timerPanel.setBounds(800, 420, 500, 40);  // Set bounds for the timer display
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

    // Method to fill questions and answers
    private void fillQuestionsAndAnswers() {
        questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";
        
        // Fill answers array
        correctAns[0][0] = "JDB";
        correctAns[1][0] = "int";
        correctAns[2][0] = "java.util package";
        correctAns[3][0] = "Marker Interface";
        correctAns[4][0] = "Heap memory";
        correctAns[5][0] = "Remote interface";
        correctAns[6][0] = "import";
        correctAns[7][0] = "Java Archive";
        correctAns[8][0] = "java.lang.StringBuilder";
        correctAns[9][0] = "Bytecode is executed by JVM";
    }
    
    // Method to create radio buttons for options
    private void createRadioButtons() {
         // Insert a radio button to choose among multiple options
        // Option 1
        opt1=new JRadioButton();
        opt1.setBounds(135,420,500,30);
        opt1.setBackground(Color.DARK_GRAY);
        opt1.setOpaque(true);
        opt1.setFont(new Font("Dialog",Font.PLAIN,18));
        
        // Change cursor to hand pointer on hover
        opt1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(opt1);
        
        // Option 2
        opt2=new JRadioButton();
        opt2.setBounds(135,460,500,30);
        opt2.setBackground(Color.DARK_GRAY);
        opt2.setOpaque(true);
        opt2.setFont(new Font("Dialog",Font.PLAIN,18));
        
        // Change cursor to hand pointer on hover
        opt2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(opt2);
        
        // Option 3
        opt3=new JRadioButton();
        opt3.setBounds(135,500,500,30);
        opt3.setBackground(Color.DARK_GRAY);
        opt3.setOpaque(true);
        opt3.setFont(new Font("Dialog",Font.PLAIN,18));
        
        // Change cursor to hand pointer on hover
        opt3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(opt3);
        
        // Option 4
        opt4=new JRadioButton();
        opt4.setBounds(135,540,500,30);
        opt4.setBackground(Color.DARK_GRAY);
        opt4.setOpaque(true);
        opt4.setFont(new Font("Dialog",Font.PLAIN,18));
        
        // Change cursor to hand pointer on hover
        opt4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(opt4);
        
        // When buttons are grouped, only one button can be selected at a time
        groupOptions=new ButtonGroup();
        groupOptions.add(opt1);
        groupOptions.add(opt2);
        groupOptions.add(opt3);
        groupOptions.add(opt4);
    }

    // Method to create buttons (Lifeline, Next, Submit)
    private void createButtons() {
         // Create lifeline button
        lifelineBtn=new JButton("50-50 LIFELINE");
        lifelineBtn.setBounds(135,600,230,50);
        lifelineBtn.setFont(new Font("Arial",Font.BOLD,24));
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
        nextBtn=new JButton("NEXT");
        nextBtn.setBounds(455,600,230,50);
        nextBtn.setFont(new Font("Arial",Font.BOLD,24));
        nextBtn.setBackground(new Color(30,144,255));
        nextBtn.setForeground(new Color(30,144,255)); // Button text color
        nextBtn.setContentAreaFilled(true); // Allow custom background to render
        nextBtn.setOpaque(true);
        
        // Change cursor to hand pointer on hover
        nextBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        // Add event to button
        nextBtn.addActionListener(this);
        add(nextBtn);
        
        // Create submit button
        submitBtn=new JButton("Submit");
        submitBtn.setBounds(775,600,230,50);
        submitBtn.setFont(new Font("Arial",Font.BOLD,24));
        submitBtn.setBackground(new Color(30,144,255));
        submitBtn.setForeground(new Color(30,144,255)); // Button text color
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
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==nextBtn){
            repaint();
            
            // Only enable lifeline button if used less than 2 times
            if(lifelineCount<2){
                lifelineBtn.setEnabled(true);
            }
            
            // Enable option button if in case disabled
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            // Set Answer given
            isAnsGiven=true;
            if(groupOptions.getSelection()==null){
                userAns[count][0]="";
            }
            else{
                // Get the answer given by user and insert in array
                userAns[count][0]=groupOptions.getSelection().getActionCommand();
            }
            
            // Show next question
            count++;
            startQuiz(count);
            
            // Disable next button after final question
            if(count==9){
                nextBtn.setEnabled(false);
                submitBtn.setEnabled(true);
            }
        }
        else if(ae.getSource()==lifelineBtn){
            lifelineCount++;
            // 1, 3, 5, 7, 8
            if(count==0 || count==2 || count==4 || count==6 || count==7){
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            // 2, 4, 6, 9, 10
            else{
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            }
            
            // Disable lifeline button
            lifelineBtn.setEnabled(false);
            
        }
        else{
            System.out.println("Submit");
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
            if(timer>0){
                g.drawString(time, 11, 30);  // Draw timer text
            }
            else{
                g.drawString("Time is Up!!",10,30);
            }
            
            // Check if answer is given by the user in time or not
            if(isAnsGiven){
                isAnsGiven=false;
                timer=16;
            }
            else if(timer==0){
                timer=16;
                
                // Only enable lifeline button if used less than 2 times
                if(lifelineCount<2){
                    lifelineBtn.setEnabled(true);
                }
            
                // Enable option button if in case disabled
                opt1.setEnabled(true);
                opt2.setEnabled(true);
                opt3.setEnabled(true);
                opt4.setEnabled(true);
                
                // Enable option button if in case disabled
                opt1.setEnabled(true);
                opt2.setEnabled(true);
                opt3.setEnabled(true);
                opt4.setEnabled(true);
                
                // If last question, but not selected ans then disable next btn
                if(count==9){
                    nextBtn.setEnabled(false);
                    submitBtn.setEnabled(true);
                }
                
                // If time over for last question but still not clicked submit
                if(count==9){
                    // Check if answer is given
                    if(groupOptions.getSelection()==null){  // No answer selected
                        userAns[count][0]="";
                    }
                    else{
                        // Get the answer given by user and insert in array
                        userAns[count][0]=groupOptions.getSelection().getActionCommand();
                    }
                    
                    // Check the answers given by user and assign total score
                    for(int i=0;i<userAns.length;i++){
                        if(userAns[i][0].equals(correctAns[i][0])){
                            totalScore+=10;
                        }
                    }
                    
                    // Hide current frame and show score frame
                    setVisible(false);
                    
                    // Score frame
                    System.out.println(totalScore);
                }
                
                // If next btn is not clicked after given time
                else{
                    // Check if answer is given
                    if(groupOptions.getSelection()==null){  // No answer selected
                        userAns[count][0]="";
                    }
                    else{
                        // Get the answer given by user and insert in array
                        userAns[count][0]=groupOptions.getSelection().getActionCommand();
                        System.out.println(userAns[count][0]);
                    }
                    // Show next question
                    count++;
                    startQuiz(count);
                }
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

    public static void main(String[] args) {
        new Quiz(); // Create and display the quiz
    }
}
