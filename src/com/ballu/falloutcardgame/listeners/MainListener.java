package com.ballu.falloutcardgame.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.ballu.falloutcardgame.labels.PictureLabel;

public class MainListener implements MouseListener{
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		PictureLabel label = (PictureLabel) arg0.getSource();
		
		if (SwingUtilities.isLeftMouseButton(arg0)) {
			switch (label.getText()) {
				case "Quest":
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
					JFrame frame = (JFrame)label.getParent().getParent()
							.getParent().getParent().getParent();
					frame.dispose();
					System.out.println("Starting switch user");
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
