package com.ballu.falloutcardgame.listeners;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.SwingUtilities;

import com.ballu.falloutcardgame.card.Card;
import com.ballu.falloutcardgame.card.enemy.Enemy;
import com.ballu.falloutcardgame.card.weapon.Weapon;

public class SelectionListener implements MouseListener {
	
	private static Weapon	selectedWeapon;
	private static Enemy	selectedEnemy;
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		Card card = (Card) arg0.getSource();
		
		if (SwingUtilities.isLeftMouseButton(arg0)) {
			if (card.isWeapon()) {
				System.out.println("Card is weapon");
				if (card.isSelectable()) {
					System.out.println("Card is selectable");
					if (card.isSelected()) {
						System.out.println("Card is selected");
						card.setBorder(null);
						card.setSelected(false);
						card.repaint();
					} else if (!card.isSelected()) {
						System.out.println("Card is not selected");
						if (selectedWeapon == null) {
							System.out.println("No card in memory");
							selectedWeapon = (Weapon) card;
							card.setSelected(true);
							card.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
						} else if (selectedWeapon != null) {
							System.out.println("Card already in memory. Erasing.");
							// Undoes selection to original selected car
							selectedWeapon.setBorder(null);
							selectedWeapon.setSelected(false);
							selectedWeapon.repaint();
							
							// Changes selected card
							selectedWeapon = (Weapon) card;
							card.setSelected(true);
							card.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
						}
					}
				}
			} else if (card.isEnemy()) {
				if (card.isSelectable()) {
					if (card.isSelected()) {
						card.setBorder(null);
						card.setSelected(false);
						card.repaint();
					} else if (!card.isSelected()) {
						if (selectedEnemy == null) {
							selectedEnemy = (Enemy) card;
							card.setSelected(true);
							card.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
						} else if (selectedEnemy != null) {
							// Undoes selection to original selected car
							selectedEnemy.setBorder(null);
							selectedEnemy.setSelected(false);
							selectedEnemy.repaint();
							
							// Changes selected card
							selectedEnemy = (Enemy) card;
							card.setSelected(true);
							card.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
						}
					}
				}
			}
		}
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}
	
	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}
	
	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}
	
	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}
	
}
