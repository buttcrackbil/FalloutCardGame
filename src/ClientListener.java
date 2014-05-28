import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.ballu.falloutcardgame.Main;

public class ClientListener implements ActionListener {
	
	// Just to fire all buttons correctly
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton button = (JButton) e.getSource(); //Gets source button
		ClientLogin frame = (ClientLogin) button.getParent().getParent()
				.getParent().getParent().getParent(); //Gets the frame the button is on (not a static frame)
		
		switch (button.getText()) {
			case "Quit":
				System.exit(0);
				break;
			case "Select":
				String user = (String) ClientLogin.userSelect.getSelectedItem();
				
				// Makes certain that a user is chosen
				if (user != null) {
					Main.start(user);
				}
				break;
			case "Create User":
				frame.newUser();
				break;
			case "Cancel":
				frame.cancel();
				break;
			case "Create":
				frame.createUser(button.getActionCommand());
				break;
		}
	}
	
}
