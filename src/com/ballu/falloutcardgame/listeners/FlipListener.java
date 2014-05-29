package com.ballu.falloutcardgame.listeners;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.SwingUtilities;

import com.ballu.falloutcardgame.card.Card;

public class FlipListener implements MouseListener {
	private static Card	selectedCard;
	
	public void mouseClicked(MouseEvent arg0) {
		Card card = (Card) arg0.getSource();
		if (SwingUtilities.isRightMouseButton(arg0)) {
			if (!card.isFlipped()) {
				card.flip();
				card.setFlipped(true);
				System.out.println("Fired");
			} else if (card.isFlipped()) {
				card.flip();
				card.setFlipped(false);
				System.out.println("Flipped back");
			}
		} else if ((SwingUtilities.isLeftMouseButton(arg0))
				&& (card.isSelectable())) {
			if (!card.isSelected()) {
				System.out.println("Selecting " + card.getName());
				if (selectedCard != null) {
					selectedCard.setBorder(null);
					selectedCard.setSelected(false);
				}
				selectedCard = card;
				card.setSelected(true);
				card.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
			} else if (card.isSelected()) {
				System.out.println("Deselecting " + card.getName());
				card.setSelected(false);
				selectedCard = null;
				card.setBorder(null);
				card.repaint();
			}
		}
	}
	
	public void mouseEntered(MouseEvent arg0) {
	}
	
	public void mouseExited(MouseEvent arg0) {
	}
	
	public void mousePressed(MouseEvent arg0) {
	}
	
	public void mouseReleased(MouseEvent arg0) {
	}
	
	public static Card getSelectedCard() {
		return selectedCard;
	}
	
	public static void clear() {
		if (selectedCard != null) {
			selectedCard.setSelected(false);
			selectedCard.setBorder(null);
			selectedCard = null;
		}
	}
}
