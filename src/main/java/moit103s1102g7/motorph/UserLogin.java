package moit103s1102g7.motorph;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserLogin extends JPanel {

	/**
	 * Create the panel.
	 */
	public UserLogin() {
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		add(btnNewButton_1);

	}

}
