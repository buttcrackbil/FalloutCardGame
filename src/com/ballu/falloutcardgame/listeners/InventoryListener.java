package com.ballu.falloutcardgame.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.ballu.falloutcardgame.Main;
import com.ballu.falloutcardgame.card.Card;
import com.ballu.falloutcardgame.panels.BattlePanel;

public class InventoryListener implements ActionListener {
	private boolean	out	= false;
	
	public void actionPerformed(ActionEvent arg0) {
		JButton input = (JButton) arg0.getSource();
		if (input.getActionCommand() == "Open Inventory") {
			BattlePanel bp = (BattlePanel) input.getParent();
			if (input == bp.inventory) {
				if (!this.out) {
					this.out = true;
					bp.userInventory.moveIn();
				} else if (this.out) {
					this.out = false;
					FlipListener.clear();
					bp.userInventory.moveOut();
				}
			}
		} else if (input.getActionCommand() == "Select") {
			BattlePanel bp = (BattlePanel) input.getParent().getParent();
			if (input == bp.userInventory.select) {
				Card card = FlipListener.getSelectedCard();
				if (card != null) {
					System.out.println(card.getName());
					card.setLocation(Main.getWidth() - 230,
							Main.getHeight() - 190);
					card.setSelected(false);
					card.setSelectable(false);
					FlipListener.clear();
					bp.add(card);
				} else {
					System.out.println("No card Selected");
				}
			}
		}
	}
}
