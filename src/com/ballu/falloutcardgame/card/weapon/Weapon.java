package com.ballu.falloutcardgame.card.weapon;

import java.awt.Rectangle;

import javax.swing.JLabel;

import com.ballu.falloutcardgame.card.Card;
import com.ballu.falloutcardgame.card.enemy.Enemy;

public class Weapon extends Card {
	
	private Enemy user;
	
	private JLabel				attack;
	private Rectangle			attackRec	= new Rectangle(0, getHeight() - 20, 100, 20);
	
	public static final Weapon	rifle1		= new Weapon("American Rifle",
													"No special abilities", 5);
	public static final Weapon	rifle2		= new Weapon("Chinese Rifle",
													"No special abilities", 5);
	
	public Weapon(String title, String description, int damage) {
		super(title, description);
		System.out.println("Beggining Weapon Creation");
		attack = new JLabel("+" + damage);
		attack.setBounds(attackRec);
		add(attack);
		setWeapon(true);
		repaint();
	}
	
	public void addTo(Enemy enemy) {
		enemy.equipWeapon(this);
	}
	
	public int getDamage() {
		return Integer.parseInt(attack.getText().substring(1));
	}
	
	public static Weapon get(Weapon input){
		Weapon output = new Weapon(input.getName(), input.getInfo(),
				input.getDamage());
		return output;
	}
	
	public void setUser(Enemy input){
		user = input;
	}
	
	@Override
	public Enemy getUser(){
		return user;
	}
}
