package com.ballu.falloutcardgame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.ballu.falloutcardgame.labels.PictureLabel;
import com.ballu.falloutcardgame.user.Bar;
import com.ballu.falloutcardgame.user.User;

public class Main extends JFrame implements ActionListener, MouseListener {
	public static JPanel			panel		= new JPanel();
	private static int				extendedWidth;
	private static int				extendedHeight;
	private static PictureLabel		quest		= new PictureLabel("Quest");
	private static PictureLabel		multi		= new PictureLabel("MP [WIP]");
	private static PictureLabel		deck		= new PictureLabel("Edit Deck");
	private static PictureLabel		option		= new PictureLabel("Options");
	private static PictureLabel		switchUser	= new PictureLabel(
														"Switch User");
	
	private static JPanel			userStats	= new JPanel();
	
	private static PictureLabel		quit		= new PictureLabel("Quit");
	public static String			user;
	
	private static PictureLabel[]	labels		= { quest, multi, deck, option,
			switchUser							};
	
	//Keeps track of max stamina
	private static String			maxMana;
	
	//For concept
	private static Bar				bar			= new Bar(100, 0, Color.BLUE,
														120, 0);
	
	private static JLabel notice = new JLabel("Click Quest to see bar updating");
	
	// Required for PictureLabel
	public Main() {
		
	}
	
	public Main(String user) {
		maxMana = User.loadUser(user)[0];
		setTitle("Fallout Card Game");
		setLayout(null);
		Main.user = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setUndecorated(true);
		setExtendedState(6);
		setVisible(true);
		panel.setLayout(null);
		extendedWidth = getWidth();
		extendedHeight = getHeight();
		panel.setSize(extendedWidth, extendedHeight);
		panel.setLocation(0, 0);
		int parts = extendedHeight / 5;
		for (int i = 0; i < labels.length; i++) {
			labels[i].setLocation(extendedWidth - 100, parts * i);
			panel.add(labels[i]);
		}
		quit.setLocation(0, extendedHeight - 100);
		panel.add(quit);
		add(panel);
		panel.repaint();
		setupStats();
	}
	
	private void setupStats() {
		JLabel mana = new JLabel("Stamina: " + maxMana);
		userStats.setBackground(Color.green);
		mana.setBounds(120, 0, 100, 20);
		notice.setBounds((panel.getWidth() - 200) / 2, (getHeight() - 20) / 2, 200, 20);
		userStats.setLayout(null);
		userStats.setLocation(0, 0);
		userStats.setSize(getWidth() - 200, 100);
		userStats.add(bar);
		panel.add(userStats);
		panel.add(notice);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.exit(0);
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		PictureLabel label = (PictureLabel) arg0.getSource();
		
		if (SwingUtilities.isLeftMouseButton(arg0)) {
			switch (label.getText()) {
				case "Quest":
					bar.updateBar(20);
					System.out.println("Starting quest");
					break;
				case "MP [WIP]":
					System.out.println("Starting multiplayer");
					break;
				case "Edit Deck":
					System.out.println("Starting deck editing");
					break;
				case "Options":
					System.out.println("Starting options");
					break;
				case "Switch User":
					dispose();
					break;
				case "Quit":
					System.out.println("Quitting");
					System.exit(0);
					break;
				default:
					System.out.println(label.getText() + " not registered");
					break;
			}
		}
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
