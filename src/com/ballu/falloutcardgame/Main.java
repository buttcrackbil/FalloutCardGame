package com.ballu.falloutcardgame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.ballu.falloutcardgame.card.enemy.Enemy;
import com.ballu.falloutcardgame.card.weapon.Weapon;
import com.ballu.falloutcardgame.labels.PictureLabel;
import com.ballu.falloutcardgame.listeners.ComponentMover;
import com.ballu.falloutcardgame.user.User;

public class Main extends JFrame implements ActionListener {
	public static JPanel			panel		= new JPanel();
	private static int				extendedWidth;
	private static int				extendedHeight;
	private static PictureLabel		quest		= new PictureLabel("Quest");
	private static PictureLabel		multi		= new PictureLabel("MP [WIP]");
	private static PictureLabel		deck		= new PictureLabel("Edit Deck");
	private static PictureLabel		option		= new PictureLabel("Options");
	private static PictureLabel		switchUser	= new PictureLabel(
														"Switch User");
	private static PictureLabel		quit		= new PictureLabel("Quit");
	
	public static String			user;
	
	private static PictureLabel[]	labels		= { quest, multi, deck, option,
			switchUser							};
	
	// Keeps track of max stamina
	private static String			maxMana;
	
	// Required for PictureLabel
	public Main() {
		
	}
	
	public Main(String user) {
		
		// Called to create cards (working on another way to call class)
		new Enemy();
		
		Enemy enemy1 = Enemy.get(Enemy.americanFlamer);
		Enemy enemy2 = Enemy.get(Enemy.americanLauncher);
		Weapon weapon1 = Weapon.get(Weapon.rifle1);
		Weapon weapon2 = Weapon.get(Weapon.rifle2);
		
		enemy1.setPlace(0, 50);
		enemy2.setPlace(150, 50).setSelectable(true);
		weapon1.setPlace(0, 300);
		weapon2.setPlace(150, 300).setSelectable(true);
		
		panel.add(enemy1);
		panel.add(enemy2);
		panel.add(weapon1);
		panel.add(weapon2);
		
		enemy1.equipWeapon(weapon1);
		
		maxMana = User.loadUser(user)[0];
		setTitle("Fallout Card Game");
		setLayout(null);
		Main.user = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setUndecorated(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
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
		ComponentMover cm = new ComponentMover();
		panel.add(quit);
		add(panel);
		panel.repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.exit(0);
	}
}
