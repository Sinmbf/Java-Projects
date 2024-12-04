package quiz.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener{
    
    // Instance variable
    String name;
    JButton back,start;
    
    // Default Constructor
    Rules(String name){
        // Set title of the frame
        setTitle("Rules");
        
        this.name=name;
        // Launch a frame when the class runs at the beginning
            // getContentPane() => grab the whole frame
            // setBackground() => set backg        getContentPane().setBackground(Color.WHITE);round color for frame
        getContentPane().setBackground(Color.WHITE);
        
        // Set the layout for the frame
        setLayout(null); // Use our own layout by passing null
        
        // Write something on frame then use JLabel
        // For heading
        JLabel heading=new JLabel("Welcome " + name + " to Lost Quiz");
        heading.setBounds(110,40,600,45);
        
        // Decorate the heading (font family,style,size)
        heading.setFont(new Font("Futura",Font.BOLD,25)); 
        add(heading);
        
        // Set font color for heading
        heading.setForeground(Color.BLUE); 
        
        // For list of rules
        JLabel listOfRules=new JLabel();
        listOfRules.setBounds(20,80,600,500);
        
        // Decorate the list of rules (font family,style,size)
        listOfRules.setFont(new Font("Times New roman",Font.PLAIN,20)); 
        
        // Set texts dynamically
        listOfRules.setText(
            "<html>"+ 
                "1. You are trained to be a programmer and not a story teller, answer point to point" + "<br><br>" +
                "2. Do not unnecessarily smile at the person sitting next to you, they may also not know the answer" + "<br><br>" +
                "3. You may have lot of options in life but here all the questions are compulsory" + "<br><br>" +
                "4. Crying is allowed but please do so quietly." + "<br><br>" +
                "5. Only a fool asks and a wise answers (Be wise, not otherwise)" + "<br><br>" +
                "6. Do not get nervous if your friend is answering more questions, may be he/she is doing Jai Mata Di" + "<br><br>" +
                "7. Brace yourself, this paper is not for the faint hearted" + "<br><br>" +
                "8. May you know more than what John Snow knows, Good Luck" + "<br><br>" +
            "<html>"
);
        add(listOfRules);
        
        // Set font color for list of rules
        listOfRules.setForeground(Color.BLACK); 
        
        // Create back button
        back=new JButton("Back");
        back.setBounds(180,576,100,35);
        
        // Change button background and font color
        back.setBackground(new Color(138, 43, 226));
        back.setForeground(Color.BLACK);
        back.setContentAreaFilled(true); // Allow custom background to render
        back.setOpaque(true);
        
        // Add click event on button
        back.addActionListener(this);
        add(back);
        
        // Change cursor to hand pointer on hover
        back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        // Create Start button
        start=new JButton("Start");
        start.setBounds(350,576,100,35);
        
        // Change button background and font color
        start.setBackground(new Color(138, 43, 226));
        start.setForeground(Color.BLACK);
        start.setContentAreaFilled(true); // Allow custom background to render
        start.setOpaque(true);
        
        // Add click event on button
        start.addActionListener(this);
        add(start);
        
        // Change cursor to hand pointer on hover
        start.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        
        setSize(650,650); // Adjust size of frame(width, height)
        setLocation(300,80); // Adjust position of frame (left,right)
        setVisible(true); // By default, JFrame is invisible
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == start){
            
        }
        else{
            // Make current frame hidden
            setVisible(false);
            new Login();
        }
    }
    
    // Main method
    public static void main(String[]args){
        new Rules("User"); // Anonymous object
    }
}
