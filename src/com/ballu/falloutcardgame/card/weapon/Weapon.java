package com.ballu.falloutcardgame.card.weapon;

import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JLabel;

import com.ballu.falloutcardgame.card.Card;
import com.ballu.falloutcardgame.card.enemy.Enemy;

public class Weapon extends Card {
	
	private Enemy					user;
	
	private JLabel					attack;
	private Rectangle				attackRec	= new Rectangle(0,
														getHeight() - 20, 100,
														20);
	
	public static ArrayList<Weapon>	weapons		= new ArrayList<Weapon>();
	
	public static Weapon gaussRifle;
	public static Weapon trenchKnife;
	
	public Weapon(String title, String description, int damage) {
		super(title, description);
		weapons.add(this);
		System.out.println("Beginning Weapon Creation");
		attack = new JLabel("+" + damage);
		attack.setBounds(attackRec);
		add(attack);
		setWeapon(true);
		System.out.println("Finished weapon creation");
	}
	
	public int getDamage() {
		return Integer.parseInt(attack.getText().substring(1));
	}
	
	public static Weapon get(Weapon input) {
		Weapon output = new Weapon(input.getName(), input.getInfo(),
				input.getDamage());
		return output;
	}
	
	public void setUser(Enemy input) {
		user = input;
	}
	
	@Override
	public Enemy getUser() {
		return user;
	}
	
	public static void setUp() {
		gaussRifle = new Weapon("Gauss Rifle", "A very accurate rifle", 5);
		trenchKnife = new Weapon("Trench Knife", "A large knife", 2);
	}
}
