package quiz.game;
// Javax - extended package for java
import javax.swing.*;
// For Color class
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{
    // Globally declare JButtons
    JButton rules,back;
    
    // Default Constructor
    Login(){
        // Launch a frame when the class runs at the beginning
            // getContentPane() => grab the whole frame
            // setBackground() => set background color for frame
        getContentPane().setBackground(Color.WHITE); 
        
        // Set the layout for the frame
        setLayout(null); // Use our own layout by passing null
        
        // Get the login icon from system directory
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));
        
        // Place the image on the frame using add()
        JLabel image=new JLabel(i1); // can't pass object to add directly so use JLabel class
        
        // Create our own layout
        image.setBounds(0,0,600,500);  // (left,top,width,height)
        add(image); // Add image on frame
        
        // Write something on frame then use JLabel
        // For heading
        JLabel heading=new JLabel("Lost Quiz");
        heading.setBounds(750,60,300,45);
        
        // Decorate the heading (font family,style,size)
        heading.setFont(new Font("Futura",Font.BOLD,40)); 
        add(heading);
        
        // Set font color for heading
        heading.setForeground(new Color(138, 43, 226)); // Light Purple
        
        // For Name
        JLabel name=new JLabel("Enter your name");
        name.setBounds(775,145,300,45);
        
        // Decorate the name (font family,style,size)
        name.setFont(new Font("Arial",Font.PLAIN,20));
        add(name);
        
        // Set font color for name
        name.setForeground(Color.BLUE); // Light blue
        
        // Insert a input text field
        JTextField tfName=new JTextField();
        tfName.setBounds(695,200,320,50);
        
        // Decorate the text inside textfield (font family,style,size)
        tfName.setFont(new Font("Times New Roman",Font.PLAIN,25));
        add(tfName);
        
        // Create Rules button
        rules=new JButton("Rules");
        rules.setBounds(698,265,100,35);
        
        // Change button background and font color
        rules.setBackground(new Color(138, 43, 226));
        rules.setForeground(Color.BLACK);
        rules.setContentAreaFilled(true); // Allow custom background to render
        rules.setOpaque(true);
        // Add click event on button
        rules.addActionListener(this);
        add(rules);
        
        // Change cursor to hand pointer on hover
        rules.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        // Create Back button
        back=new JButton("Back");
        back.setBounds(913,265,100,35);
        
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
        
        // Manage the frame
        setSize(1100,500); // Adjust size of frame(width, height)
        setLocation(100,100); // Adjust position of frame (left,right)
        setVisible(true); // By default, JFrame is invisible
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == rules){
            System.out.println("Rules 2");
        }
        else if(ae.getSource() == back){
            System.out.println("Back");
            setVisible(false);
        }
    }
    
    // Main method
    public static void main(String[]args){
        new Login(); // Anonymous object (calls default constructor)
    }
}