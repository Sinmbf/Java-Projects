package quiz.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener {

    // Instance variable
    String username;
    JButton back, start;
    
    // Default Constructor
    Rules(){
        this("User");
    }

    // Parameterized Constructor
    Rules(String username) {
        // Set title of the frame
        setTitle("Rules");

        this.username = username;
        // Launch a frame when the class runs at the beginning
        // getContentPane() => grab the whole frame
        // setBackground() => set backg        getContentPane().setBackground(Color.WHITE);round color for frame
        getContentPane().setBackground(Color.WHITE);

        // Set the layout for the frame
        setLayout(null); // Use our own layout by passing null

        // Write something on frame then use JLabel
        // For heading
        JLabel heading = new JLabel("Welcome " + username + " to Lost Quiz");
        heading.setBounds(110, 40, 600, 45);

        // Decorate the heading (font family,style,size)
        heading.setFont(new Font("Futura", Font.BOLD, 25));
        add(heading);

        // Set font color for heading
        heading.setForeground(Color.BLUE);

        // For list of rules
        JLabel listOfRules = new JLabel();
        listOfRules.setBounds(20, 50, 600, 500);

        // Decorate the list of rules (font family,style,size)
        listOfRules.setFont(new Font("Times New roman", Font.PLAIN, 20));

        // Set texts dynamically
        listOfRules.setText(
                "<html>"
                + "1. There are 10 questions with four options each." + "<br><br>"
                + "2. You get 15 seconds to answer each question." + "<br><br>"
                + "3. If you fail to answer within 15 seconds, the question will be skipped." + "<br><br>"
                + "4. Score starts from 0. You get 10 score for every correct answer." + "<br><br>"
                + "5. 50-50 lifeline can be used for maximum 2 times." + "<br><br>"
                + "6. Click next button to view the next question." + "<br><br>"
                + "7. Click submit button after answering every question." + "<br><br>"
                + "8. After clicking submit, your total score will be displayed."
                + "<html>"
        );
        add(listOfRules);

        // Set font color for list of rules
        listOfRules.setForeground(Color.BLACK);

        // Create back button
        back = new JButton("Back");
        back.setBounds(180, 550, 112, 40);

        // Change button background and font color
        back.setBackground(new Color(138, 43, 226));
        back.setForeground(new Color(138, 43, 226));
        back.setContentAreaFilled(true); // Allow custom background to render
        back.setOpaque(true);
        back.setFont(new Font("Futura", Font.BOLD, 26));

        // Add click event on button
        back.addActionListener(this);
        add(back);

        // Change cursor to hand pointer on hover
        back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Create Start button
        start = new JButton("Start");
        start.setBounds(350, 550, 112, 40);

        // Change button background and font color
        start.setBackground(new Color(138, 43, 226));
        start.setForeground(new Color(138, 43, 226));
        start.setContentAreaFilled(true); // Allow custom background to render
        start.setOpaque(true);
        start.setFont(new Font("Futura", Font.BOLD, 26));

        // Add click event on button
        start.addActionListener(this);
        add(start);

        // Change cursor to hand pointer on hover
        start.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        setSize(650, 650); // Adjust size of frame(width, height)
        setLocation(300, 80); // Adjust position of frame (left,right)
        setVisible(true); // By default, JFrame is invisible

    }
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {

            // Hide current frame
            setVisible(false);

            // Show Quiz frame
            new Quiz(username);

        } else {
            // Make current frame hidden
            setVisible(false);
            new Login();
        }
    }

    // Main method
    public static void main(String[] args) {
        new Rules(); // Anonymous object
    }
}
