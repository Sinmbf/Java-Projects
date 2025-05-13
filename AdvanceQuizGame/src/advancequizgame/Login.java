package advancequizgame;

import advancequizgame.Utilities.AddHoverEffect;
import advancequizgame.Utilities.AdminCredentials;
import javax.swing.*;
import java.awt.*;

public class Login {

    // Globally Declared variables (so that they can be accessed from
    // other class)
    JPasswordField passwordField;
    char[] password={};
    String username,role;
    String credentials[]={};
    // Constructor
    Login() {

        // Create an instance for hover effect class
        AddHoverEffect hoverEffect = new AddHoverEffect();
        
        // Create an instance for admin credentials class
        AdminCredentials adminCredentials=new AdminCredentials();
        
        // Create a frame
        JFrame frame = new JFrame("Login");

        // Set size of the frame
        frame.setSize(900, 500);

        // Center the frame relative to screen
        frame.setLocationRelativeTo(null);

        // Set the position layout of frame
        frame.setLayout(null);

        // Scale the image
        ImageIcon originalImage = new ImageIcon(getClass().getResource("/resources/icons/login.jpeg"));
        Image scaledImage = originalImage.getImage().getScaledInstance(530, 550, Image.SCALE_SMOOTH);
        ImageIcon resizedImage = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(resizedImage);
        imageLabel.setBounds(0, 0, 530, 550);

        // Add image in the frame
        frame.add(imageLabel);

        // Add text in the frame
        JLabel textLabel = new JLabel("Enter your details");
        textLabel.setFont(new Font("Arial", Font.BOLD, 26));
        textLabel.setForeground(new Color(138, 43, 226)); // Purple color
        textLabel.setBounds(600, 30, 400, 50);
        frame.add(textLabel);

        // Create panel for input fields
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(null);
        inputPanel.setBounds(530, 60, 400, 500);

        // Add name label in the panel
        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 17));
        nameLabel.setBounds(23, 50, 300, 50);
        inputPanel.add(nameLabel);

        // Add name field in the panel
        JTextField nameField = new JTextField(35);
        nameField.setBounds(20, 95, 280, 35);
        nameField.setFont(new Font("Arial", Font.PLAIN, 16));
        inputPanel.add(nameField);

        // Add role label in the panel
        JLabel roleLabel = new JLabel("Role: ");
        roleLabel.setFont(new Font("Arial", Font.BOLD, 17));
        roleLabel.setBounds(23, 125, 300, 50);
        inputPanel.add(roleLabel);

        // Add role field in the panel
        JRadioButton roleOption1 = new JRadioButton("Admin");
        JRadioButton roleOption2 = new JRadioButton("Player");
        ButtonGroup roleButtonGroup = new ButtonGroup();
        roleButtonGroup.add(roleOption1);
        roleButtonGroup.add(roleOption2);
        roleOption1.setBounds(23, 160, 100, 50);
        roleOption1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        roleOption2.setBounds(110, 160, 100, 50);
        roleOption2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        inputPanel.add(roleOption1);
        inputPanel.add(roleOption2);

        // Add submit button in the panel
        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.PLAIN, 17));
        submitButton.setBackground(new Color(138, 43, 226));
        submitButton.setForeground(Color.WHITE);
        hoverEffect.addHoverEffect(submitButton, new Color(75, 0, 130), Color.WHITE, new Color(138, 43, 226), Color.WHITE);

        // Disable the default look of button
        submitButton.setBorder(BorderFactory.createEmptyBorder());
        submitButton.setOpaque(true);

        submitButton.setBounds(23, 210, 280, 40);
        submitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        inputPanel.add(submitButton);

        // Add event for submit button click
        submitButton.addActionListener(e -> {
            username = nameField.getText();
            role = roleOption1.isSelected() ? roleOption1.getText()
                    : roleOption2.isSelected() ? roleOption2.getText() : "";
            if (username.isEmpty() || role.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (username.length() < 6) {
                JOptionPane.showMessageDialog(frame, "Minimum length of name must be 6", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (role.equals("Admin")) {
                passwordField=new JPasswordField();
                int option = JOptionPane.showConfirmDialog(
                        frame,
                        passwordField,
                        "Enter your password",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE
                );
                if(option==JOptionPane.OK_OPTION){
                    password=passwordField.getPassword();
                    credentials=adminCredentials.readAdminCredentials();
                    String adminUsername=credentials[0];
                    String adminPassword=credentials[1];
                    if(username.equals(adminUsername) && new String(password).equals(adminPassword)){
                        new Admin(username);
                    }
                    else{
                       JOptionPane.showMessageDialog(frame, "Wrong username or password", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    
                    
                }
//                new Admin();
            } else {
                new Player();
            }

        });

        // Add input panel in the frame
        frame.add(inputPanel);

        // Define what happens after closing the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make the frame visible
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new Login();
    }
}
