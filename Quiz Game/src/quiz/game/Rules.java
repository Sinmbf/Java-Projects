package quiz.game;

import javax.swing.*;
import java.awt.*;

public class Rules extends JFrame{
    
    // Default Constructor
    Rules(){
        
        // Launch a frame when the class runs at the beginning
            // getContentPane() => grab the whole frame
            // setBackground() => set background color for frame
        getContentPane().setBackground(Color.WHITE);
        
        // Set the layout for the frame
        setLayout(null); // Use our own layout by passing null
        
        // Write something on frame then use JLabel
        // For heading
        JLabel heading=new JLabel("Lost Quiz");
        heading.setBounds(250,60,300,45);
        
        // Decorate the heading (font family,style,size)
        heading.setFont(new Font("Futura",Font.BOLD,40)); 
        add(heading);
        
        // Set font color for heading
        heading.setForeground(new Color(138, 43, 226)); // Light Purple
        
        setSize(1100,600); // Adjust size of frame(width, height)
        setLocation(100,100); // Adjust position of frame (left,right)
        setVisible(true); // By default, JFrame is invisible
        
    }
    
    // Main method
    public static void main(String[]args){
        new Rules(); // Anonymous object
    }
}
