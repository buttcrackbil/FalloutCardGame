package com.ballu.falloutcardgame.card.enemy;

import java.awt.Component;
import java.awt.Rectangle;

import javax.swing.JLabel;

import com.ballu.falloutcardgame.card.Card;
import com.ballu.falloutcardgame.card.weapon.Weapon;

public class Enemy extends Card {
	
	private int					life;
	private int					damage;
	
	private String				currentHealth;
	private String				currentAttack;
	
	public static final Enemy	americanFlamer		= new Enemy(
															"American Flamer",
															"50% to set fire to enemy for two turns",
															5, 5);
	public static final Enemy	americanLauncher	= new Enemy(
															"American Launcher",
															"No special ability",
															5, 10);
	public static final Enemy	americanSniper		= new Enemy(
															"American Sniper",
															"Headshot: Instantly kills one enemy card",
															3, 8);
	public static final Enemy	americanSoldier		= new Enemy(
															"American Soldier",
															"No special abilities",
															5, 6);
	public static final Enemy	chineseFlamer		= new Enemy(
															"Chinese Flamer",
															"50% to set fire to enemy for two turns",
															5, 5);
	public static final Enemy	chineseLauncher		= new Enemy(
															"Chinese Launcher",
															"No special ability",
															5, 10);
	public static final Enemy	chineseSniper		= new Enemy(
															"Chinese Sniper",
															"Headshot: Instantly kills one enemy card",
															3, 8);
	public static final Enemy	chineseSoldier		= new Enemy(
															"Chinese Soldier",
															"No special abilities",
															5, 6);
	
	public Enemy(String name, String description, int health, int attack) {
		super(name, description);
		life = health;
		damage = attack;
		JLabel life = new JLabel(), damage = new JLabel();
		JLabel[] labels = { life, damage };
		Rectangle lifeRec = new Rectangle(0, getHeight() - 35, 100, 20);
		Rectangle attackRec = new Rectangle(0, getHeight() - 20, 100, 20);
		Rectangle[] bounds = { lifeRec, attackRec };
		String[] strings = { "Health: " + health, "Attack: " + attack };
		System.out.println("Creating Enemy");
		setEnemy(true);
		for (int i = 0; i < labels.length; i++) {
			labels[i].setText(strings[i]);
			labels[i].setBounds(bounds[i]);
			add(labels[i]);
		}
		currentHealth = strings[0];
		currentAttack = strings[1];
		System.out.println("Finished Enemy Creation");
	}
	
	// For get() method
	public Enemy() {
		super("<html>", "");
	}
	
	public void equipWeapon(Weapon weapon) {
		weapon.setLocation(getLocation().x, getLocation().y - 25);
		repaint();
	}
	
	public void updateHealth(int add) {
		Component[] components = getComponents();
		JLabel[] labels = new JLabel[components.length];
		for (int j = 0; j < components.length; j++) {
			labels[j] = (JLabel) components[j];
			System.out.println(labels[j].getText());
		}
		for (int i = 0; i < labels.length; i++) {
			System.out.println(labels[i].getText());
			if (labels[i].getText().equals(currentHealth)) {
				if (labels[i].getText().contains("+")) {
					labels[i].setText(labels[i].getText().substring(0, labels[i].getText().length() - 3) + " +" + add);
					currentHealth = labels[i].getText();
				}else{
					labels[i].setText(labels[i].getText() + " +" + add);
					currentHealth = labels[i].getText();
				}
			}
			repaint();
		}
	}
	
	public void updateAttack(int add) {
		Component[] components = getComponents();
		JLabel[] labels = new JLabel[components.length];
		for (int j = 0; j < components.length; j++) {
			labels[j] = (JLabel) components[j];
			System.out.println(labels[j].getText());
		}
		for (int i = 0; i < labels.length; i++) {
			System.out.println(labels[i].getText());
			if (labels[i].getText().equals(currentAttack)) {
				if (labels[i].getText().contains("+")) {
					labels[i].setText(labels[i].getText().substring(0, labels[i].getText().length() - 3) + " +" + add);
					currentAttack = labels[i].getText();
				}else{
					labels[i].setText(labels[i].getText() + " +" + add);
					currentAttack = labels[i].getText();
				}
			}
			repaint();
		}
	}
	
	public int getHealth() {
		return life;
	}
	
	public int getAttack() {
		return damage;
	}
	
	public static Enemy get(Enemy input) {
		Enemy output = new Enemy(input.getName(), input.getInfo(),
				input.getHealth(), input.getAttack());
		return output;
	}
}
