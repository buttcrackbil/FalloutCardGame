package com.ballu.falloutcardgame.panels;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.ballu.falloutcardgame.Main;
import com.ballu.falloutcardgame.card.Weapon;
import com.ballu.falloutcardgame.listeners.InventoryListener;

public class Inventory extends JPanel {
	public JButton		select	= new JButton("Select Weapon");
	private Weapon[]	weapons;
	
	public Inventory() {
		setLayout(null);
		this.select.setSize(150, 21);
		setBackground(Color.BLUE);
		setSize(150, Main.getHeight() - 200);
		this.select.setLocation(getWidth() - 150, getHeight() - 20);
		this.select.addActionListener(new InventoryListener());
		this.select.setActionCommand("Select");
		add(this.select);
	}
	
	public void setUp() {
		BattlePanel parent = (BattlePanel) getParent();
		setLocation(parent.getWidth() + 4, 0);
		this.weapons = parent.user.getWeapons();
	}
	
	public void moveIn() {
		for (int j = 0; j < this.weapons.length; j++) {
			this.weapons[j].setLocation(20, j * 160 + 10);
			this.weapons[j].setSelectable(true);
			add(this.weapons[j]);
		}
		setLocation(getLocation().x - 170, 0);
	}
	
	public void moveOut() {
		setLocation(getLocation().x + 170, 0);
	}
}
