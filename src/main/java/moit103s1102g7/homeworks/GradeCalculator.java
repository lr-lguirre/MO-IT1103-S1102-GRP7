package moit103s1102g7.homeworks;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GradeCalculator extends JFrame {
    private JLabel label1, label2, label3, resultLabel;
    private JTextField field1, field2, field3, resultField;
    private JButton button;

    public GradeCalculator() {
        super("Grade Calculator");
        setLayout(new GridLayout(5, 2, 10, 10));

        label1 = new JLabel("Milestone 1 (25%): ");
        field1 = new JTextField(10);

        label2 = new JLabel("Milestone 2 (40%): ");
        field2 = new JTextField(10);

        label3 = new JLabel("Terminal Assessment (35%): ");
        field3 = new JTextField(10);

        resultLabel = new JLabel("Your grade: ");
        resultField = new JTextField(10);
        resultField.setEditable(false);

        button = new JButton("Calculate");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double milestone1 = 0, milestone2 = 0, terminalAssessment = 0;

                try {
                    milestone1 = Double.parseDouble(field1.getText());
                    milestone2 = Double.parseDouble(field2.getText());
                    terminalAssessment = Double.parseDouble(field3.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numerical values for all fields.");
                    return;
                }

                double grade = (milestone1 * 0.25) + (milestone2 * 0.4) + (terminalAssessment * 0.35);

                resultField.setText(String.format("%.2f", grade));
            }
        });

        add(label1);
        add(field1);
        add(label2);
        add(field2);
        add(label3);
        add(field3);
        add(resultLabel);
        add(resultField);
        add(new JLabel(""));
        add(button);

        setSize(300, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new GradeCalculator();
    }
}
