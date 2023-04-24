package moit103s1102g7.motorph;

public class MainMenu {
    	
	public void callMainMenu() {
		UserLogin userLogin = new UserLogin();
		userLogin.setVisible(true);
	}
    
    public void mainMenu() {
    	profilePanel.setVisible(false);
    	printNRead.printRead();   	
    	getContentPane().remove(profilePanel);
    	getContentPane().add(profilePanel);
    	setContentPane(mainPanel);
    	setVisible(true);
    	// Repaint the frame
        revalidate();
        repaint(); 
    }
    
    public void profileMenu() {
    	setVisible(true);
    	profilePanel.setVisible(true);
    	// Remove the main panel from the frame
        getContentPane().remove(mainPanel);

        // Add the profile panel to the frame
        getContentPane().add(profilePanel);
        setContentPane(profilePanel);
        // Repaint the frame
        revalidate();
        repaint();
   }
}
