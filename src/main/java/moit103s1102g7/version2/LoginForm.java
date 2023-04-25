package moit103s1102g7.version2;

import java.awt.HeadlessException;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

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
        
        passwordField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LoginForm.this.actionPerformed(e);
            }
        });
        
        add(panel);
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        String username = userTextField.getText();
        String password = new String(passwordField.getPassword());
    
        try {
            FileReader fileReader = new FileReader("users.csv");
            CSVParser parser = new CSVParserBuilder().withQuoteChar('"').build();
            CSVReader reader = new CSVReaderBuilder(fileReader).withCSVParser(parser).build();
            String[] nextLine;
            boolean userFound = false;
    
            while ((nextLine = reader.readNext()) != null) {
                if (username.equals(nextLine[0]) && password.equals(nextLine[1])) {
                    userFound = true;
                    String accessType = nextLine[2];
                    JOptionPane.showMessageDialog(this, "Login successful! Welcome, " + username + "!");
                    dispose();
                    MainWindow mainWindow = new MainWindow(accessType);
                    mainWindow.setVisible(true);
                    break;
                }
            }
    
            if (!userFound) {
                JOptionPane.showMessageDialog(this, "Invalid username or password");
            }
    
            reader.close();
        } catch (IOException | CsvValidationException | HeadlessException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        LoginForm form = new LoginForm();
        form.setVisible(true);
    }
}
