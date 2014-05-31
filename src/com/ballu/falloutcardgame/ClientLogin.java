package com.ballu.falloutcardgame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FilenameFilter;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.ballu.falloutcardgame.card.Card;
import com.ballu.falloutcardgame.card.enemy.Enemy;
import com.ballu.falloutcardgame.card.weapon.Weapon;
import com.ballu.falloutcardgame.graphics.CardGraphics;
import com.ballu.falloutcardgame.listeners.ClientListener;

public class ClientLogin extends JFrame {
	
	public static JComboBox<String>	userSelect	= new JComboBox<String>();
	protected JPanel				panel		= new JPanel();
	protected static File			dir			= new File(
														System.getProperty("user.home")
																+ "/Documents/Ball U/FCG");
	
	public ClientLogin() {
		Thread cardGraphics = new Thread(new CardGraphics());
		cardGraphics.start();
		Enemy.setUp();
		Weapon.setUp();
		Card.registerCards();
		panel.setLayout(null);
		setUndecorated(true);
		JButton confirm = new JButton("Select");
		JButton newUser = new JButton("Create User");
		JLabel selectUser = new JLabel("Select User");
		JButton quit = new JButton("Quit");
		setTitle("Select User");
		setSize(200, 200);
		setLocationRelativeTo(null);
		selectUser.setBounds(0, 0, 200, 20);
		selectUser.setHorizontalAlignment(SwingConstants.CENTER);
		userSelect.setBounds(25, (getHeight() - 25) / 2, 150, 25);
		confirm.setBounds(100, getHeight() - 20, 100, 20);
		newUser.setBounds(25, getHeight() - 40, 150, 20);
		quit.setBounds(0, getHeight() - 20, 100, 20);
		confirm.addActionListener(new ClientListener());
		newUser.addActionListener(new ClientListener());
		quit.addActionListener(new ClientListener());
		add(selectUser);
		panel.add(userSelect);
		panel.add(confirm);
		panel.add(newUser);
		panel.add(quit);
		userSelect.removeAllItems();
		for (int i = 0; i < readUsers().length; i++) {
			userSelect.addItem(readUsers()[i]);
		}
		add(panel);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ClientLogin();
	}
	
	public String[] readUsers() {
		if (!dir.exists()) {
			dir.mkdirs();
		}
		String[] directories = dir.list(new FilenameFilter() {
			@Override
			public boolean accept(File current, String name) {
				return new File(current, name).isDirectory();
			}
		});
		return directories;
	}
	
	public void newUser() {
		panel.removeAll();
		final JButton create = new JButton("Create");
		JButton cancel = new JButton("Cancel");
		JTextField input = new JTextField();
		create.setBounds(0, getHeight() - 20, 100, 20);
		cancel.setBounds(100, getHeight() - 20, 100, 20);
		input.setBounds(50, (getHeight() - 21) / 2, 100, 21);
		input.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent arg0) {
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				JTextField input = (JTextField) arg0.getSource();
				
				create.setActionCommand(input.getText());
				
			}
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				
			}
		});
		cancel.addActionListener(new ClientListener());
		create.addActionListener(new ClientListener());
		panel.add(input);
		panel.add(create);
		panel.add(cancel);
		panel.repaint();
	}
	
	public void createUser(String input) {
		File make = new File(dir + "/" + input);
		if (!make.exists()) {
			make.mkdirs();
		}
		new ClientLogin();
		dispose();
	}
	
	public void cancel() {
		new ClientLogin();
		dispose();
	}
}
