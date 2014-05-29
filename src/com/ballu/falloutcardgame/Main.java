package com.ballu.falloutcardgame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.ballu.falloutcardgame.card.enemy.Enemy;
import com.ballu.falloutcardgame.labels.PictureLabel;
import com.ballu.falloutcardgame.quest.Quest;

public class Main implements ActionListener, MouseListener {
	public static JFrame			frame	= new JFrame("Card Game");
	public static JPanel			panel	= new JPanel();
	private static int				extendedWidth;
	private static int				extendedHeight;
	private static PictureLabel		quest	= new PictureLabel("Quest");
	private static PictureLabel		multi	= new PictureLabel("MP [WIP]");
	private static PictureLabel		deck	= new PictureLabel("Edit Deck");
	private static PictureLabel		option	= new PictureLabel("Options");
	private static PictureLabel		quit	= new PictureLabel("Quit");
	public static String			user;
	
	private static PictureLabel[]	labels	= { quest, multi, deck, option };
	
	public static void start(String user) {
		Enemy weapon = new Enemy("", "", 5, 10, 5);
		weapon.setLocation(100, 100);
		frame.setLayout(null);
		Main.user = user;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setUndecorated(true);
		frame.setExtendedState(6);
		frame.setVisible(true);
		panel.setLayout(null);
		extendedWidth = frame.getWidth();
		extendedHeight = frame.getHeight();
		panel.setSize(extendedWidth, extendedHeight);
		panel.setLocation(0, 0);
		int parts = extendedHeight / 5;
		for (int i = 0; i < labels.length; i++) {
			labels[i].setLocation(extendedWidth - 100, parts * i);
			panel.add(labels[i]);
		}
		quit.setLocation(0, extendedHeight - 100);
		panel.add(quit);
		panel.add(weapon);
		frame.add(panel);
		panel.repaint();
	}
	
	public static int getWidth() {
		return extendedWidth;
	}
	
	public static int getHeight() {
		return extendedHeight;
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
					System.out.println("Starting quest");
					new Quest();
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
