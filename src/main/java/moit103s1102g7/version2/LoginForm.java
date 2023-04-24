package moit103s1102g7.version2;

import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class LoginForm extends JFrame implements ActionListener {
    
    private JLabel userLabel, passwordLabel;
    private JTextField userTextField;
    private JPasswordField passwordField;
    private JButton loginButton, clearButton;
    
    public LoginForm() {
        setTitle("Login Form");
        setSize(350, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        userLabel = new JLabel("Username");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);
        
        userTextField = new JTextField();
        userTextField.setBounds(100, 20, 165, 25);
        panel.add(userTextField);
        
        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(100, 50, 165, 25);
        panel.add(passwordField);
        
        loginButton = new JButton("Login");
        loginButton.setBounds(10, 90, 80, 25);
        loginButton.addActionListener(this);
        panel.add(loginButton);
        
        clearButton = new JButton("Clear");
        clearButton.setBounds(180, 90, 80, 25);
        clearButton.addActionListener(this);
        panel.add(clearButton);
        
        add(panel);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = userTextField.getText();
            String password = new String(passwordField.getPassword());
            boolean loggedIn = false;
            
            try {
                BufferedReader reader = new BufferedReader(new FileReader("users.csv"));
                String line;
                
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(",");
                    
                    if (data[0].equals(username) && data[1].equals(password)) {
                        JOptionPane.showMessageDialog(null, "Login successful!");
                        loggedIn = true;
                        MainWindow mainWindow = new MainWindow(); // Create the main window
                        mainWindow.setVisible(true); // Display the main window
                    }
                }
                
                reader.close();
                
                if (!loggedIn) {
                    JOptionPane.showMessageDialog(null, "Invalid username or password!");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == clearButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
    }
    
    public static void main(String[] args) {
        LoginForm form = new LoginForm();
        form.setVisible(true);
    }
}
