package com.ballu.falloutcardgame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main implements ActionListener {
	public static JFrame	frame	= new JFrame("Card Game");
	private static JButton	quit	= new JButton("Quit");
	public static JPanel	panel	= new JPanel();
	private static int		extendedWidth;
	private static int		extendedHeight;
	
	public static void main(String[] args) {
		frame.setLayout(null);
		frame.setDefaultCloseOperation(3);
		frame.setSize(500, 500);
		frame.setUndecorated(true);
		frame.setExtendedState(6);
		frame.setVisible(true);
		panel.setLayout(null);
		extendedWidth = frame.getWidth();
		extendedHeight = frame.getHeight();
		panel.setSize(extendedWidth, extendedHeight);
		panel.setLocation(0, 0);
		quit.addActionListener(new Main());
		quit.setBounds(10, extendedHeight - 50, 100, 20);
		frame.repaint();
		panel.add(quit);
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
}
