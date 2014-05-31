package com.ballu.falloutcardgame.card.enemy;

import java.awt.Component;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JLabel;

import com.ballu.falloutcardgame.card.Card;
import com.ballu.falloutcardgame.card.food.Food;
import com.ballu.falloutcardgame.card.weapon.Weapon;

public class Enemy extends Card {
	
	private int						life, armor, pain, attack, health, healthBoost,
			healthBoostTime;
	
	public static Enemy				americanFlamer, americanLauncher,
			americanSniper, americanSoldier, chineseFlamer, chineseLauncher,
			chineseSniper, chineseSoldier;
	
	public static ArrayList<Enemy>	enemies	= new ArrayList<Enemy>();
	
	public Enemy(String name, String description, int health, int attack) {
		super(name, description);
		this.health = health;
		pain = attack;
		JLabel life = new JLabel(), damage = new JLabel();
		JLabel[] labels = { life, damage };
		String[] strings = {"Health: " + this.health, "Attack: " + attack};
		Rectangle lifeRec = new Rectangle(0, getHeight() - 35, 100, 20);
		Rectangle attackRec = new Rectangle(0, getHeight() - 20, 100, 20);
		Rectangle[] bounds = { lifeRec, attackRec };
		System.out.println("Creating Enemy");
		setEnemy(true);
		for (int i = 0; i < labels.length; i++) {
			labels[i].setText(strings[i]);
			labels[i].setBounds(bounds[i]);
			add(labels[i]);
		}
		System.out.println("Finished Enemy Creation");
	}
	
	public void equipWeapon(Weapon weapon) {
		weapon.setLocation(getLocation().x, getLocation().y - 25);
		weapon.setUser(this);
		attack = weapon.getDamage();
		repaint();
	}
	
	public void eatFood(Food food) {
		food.setUser(this);
		healthBoost = food.getHealthBoost()[0];
		healthBoostTime = food.getHealthBoost()[1];
	}
	
	public void updateHealth() {
		Component[] components = getComponents();
		JLabel[] labels = new JLabel[components.length];
		for (int j = 0; j < components.length; j++) {
			labels[j] = (JLabel) components[j];
		}
		for (int i = 0; i < labels.length; i++) {
			if (labels[i].getText().contains("Health: ")) {
				if (armor != 0) {
					labels[i].setText("Health: " + life + " +" + armor);
				}else{
					labels[i].setText("Health: " + life);
				}
			}
		}
	}
	
	public void updateAttack() {
		Component[] components = getComponents();
		JLabel[] labels = new JLabel[components.length];
		for (int i = 0; i < components.length; i++) {
			labels[i] = (JLabel) components[i];
		}
		for (int i = 0; i < labels.length; i++) {
			if (labels[i].getText().contains("Attack: ")) {
				if (attack != 0) {
					labels[i].setText("Attack: " + attack + " +" + attack);
				}else{
					labels[i].setText("Attack: " + attack);
				}
			}
		}
	}
	
	public void heal() {
		Component[] components = getComponents();
		JLabel[] labels = new JLabel[components.length];
		for (int i = 0; i < components.length; i++) {
			labels[i] = (JLabel) components[i];
		}
		for (int i = 0; i < labels.length; i++) {
			if (labels[i].getText().contains("Health: ")) {
				if (healthBoost != 0 && healthBoostTime != 0) {
					labels[i].setText("Health: " + life + " +" + armor + " +"
							+ healthBoost + "/" + "for " + healthBoostTime
							+ " turns");
				}
			}
		}
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getAttack() {
		return pain;
	}
	
	public static Enemy get(Enemy input) {
		Enemy output = new Enemy(input.getName(), input.getInfo(),
				input.getHealth(), input.getAttack());
		return output;
	}
	
	// Never called
	@Override
	public Enemy getUser() {
		return null;
	}
	
	public void displayRefresh() {
		updateHealth();
		updateAttack();
		heal();
	}
	
	public static void setUp() {
		americanFlamer = new Enemy("American Flamer",
				"50% to set fire to enemy for two turns", 5, 5);
		americanLauncher = new Enemy("American Launcher", "No special ability",
				5, 10);
		americanSniper = new Enemy("American Sniper",
				"Headshot: Instantly kills one enemy card", 3, 8);
		americanSoldier = new Enemy("American Soldier", "No special abilities",
				5, 6);
		chineseFlamer = new Enemy("Chinese Flamer",
				"50% to set fire to enemy for two turns", 5, 5);
		chineseLauncher = new Enemy("Chinese Launcher", "No special ability",
				5, 10);
		chineseSniper = new Enemy("Chinese Sniper",
				"Headshot: Instantly kills one enemy card", 3, 8);
		chineseSoldier = new Enemy("Chinese Soldier", "No special abilities",
				5, 6);
	}
}
