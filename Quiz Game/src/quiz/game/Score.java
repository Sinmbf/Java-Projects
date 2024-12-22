package quiz.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener{
    
    // Global instance variables
    String username;
    int totalScore;
    JButton playAgainBtn;
    
    // Default Constructor
    Score(String username, int totalScore){
        
        this.username=username;
        this.totalScore=totalScore;
        
        // Set title of the frame
        setTitle("Score");
        
        // Set frame size and layout
        setBounds(300, 160, 800, 500); // By default called by JFrame
        getContentPane().setBackground(Color.WHITE);
        setLayout(null); // Custom layout

        // Create and add labels
        createAndAddLabels();
        
        // Create button
        createButton();
        
        // Make the frame visible
        setVisible(true);
    }
    
    // Method to create and add labels
    private void createAndAddLabels(){
        // Load image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
        
        /**
         * Swing components often render images with their original dimensions, 
         * which may not fit well in the GUI. 
         * Scaling ensures the image fits the desired size and layout of your application.
         */
        Image i2= i1.getImage().getScaledInstance(300, 250,Image.SCALE_DEFAULT );
        ImageIcon i3=new ImageIcon(i2);
        
        JLabel image = new JLabel(i3);
        image.setBounds(250, 90, 300, 250);  // Position the image
        add(image); // Add image to frame

        // Create heading label
        JLabel heading=new JLabel("Thank You " + username + " for playing Lost Quiz");
        heading.setBounds(120,30,600,45);
        
        // Decorate the heading (font family,style,size)
        heading.setFont(new Font("Futura",Font.BOLD,25)); 
        
        // Set font color for heading
        heading.setForeground(new Color(30,144,255));
        
        // Write heading on frame
        add(heading);
        
        // Create score label
        JLabel scoreLabel=new JLabel("Your score is " + totalScore);
        scoreLabel.setBounds(300,350,300,35);
        
        // Decorate the heading (font family,style,size)
        scoreLabel.setFont(new Font("Futura",Font.BOLD,25)); 
        
        // Set font color for heading
        scoreLabel.setForeground(Color.RED);
        
        // Write heading on frame
        add(scoreLabel);
    }
    
    // Method to create button
    private void createButton(){
        // Create submit button
        playAgainBtn=new JButton("Play Again");
        playAgainBtn.setBounds(295,400,230,50);
        playAgainBtn.setFont(new Font("Arial",Font.BOLD,24));
        playAgainBtn.setBackground(new Color(30,144,255)); //Blue
        playAgainBtn.setForeground(new Color(30,144,255)); // Button text color
        playAgainBtn.setContentAreaFilled(true); // Allow custom background to render
        playAgainBtn.setOpaque(true);
        
        // Change cursor to hand pointer on hover
        playAgainBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        // Add event to button
        playAgainBtn.addActionListener(this);
        add(playAgainBtn);
    }
    
    // Method to handle event
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==playAgainBtn){
            
            // Hide current(score) frame
            setVisible(false);
            
            // Show Login frame and reset the game
            new Login();
        }
    }
    
    public static void main(String[]args){
        new Score("User", 0);  // Anonymous object
    }
}

