package com.ballu.falloutcardgame.panels;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.ballu.falloutcardgame.Main;
import com.ballu.falloutcardgame.card.Card;
import com.ballu.falloutcardgame.card.Enemy;
import com.ballu.falloutcardgame.listeners.InventoryListener;

public class BattlePanel extends JPanel {
	public final JButton	inventory	= new JButton("Inventory");
	public Enemy			user;
	public Inventory		userInventory;
	
	public BattlePanel(Card enemy, Card user) {
		setLayout(null);
		this.user = ((Enemy) user);
		setBackground(Color.BLACK);
		setLocation(0, 0);
		setSize(Main.getWidth(), Main.getHeight());
		enemy.setLocation(5, 5);
		user.setLocation(getWidth() - 120, getHeight() - 190);
		this.inventory.setBounds(10, 200, 200, 20);
		this.inventory.addActionListener(new InventoryListener());
		this.inventory.setActionCommand("Open Inventory");
		this.inventory.setToolTipText("Opens your inventory");
		add(this.inventory);
		add(enemy);
		add(user);
		setUpInventory();
	}
	
	private void setUpInventory() {
		this.userInventory = new Inventory();
		add(this.userInventory);
		this.userInventory.setUp();
	}
}
