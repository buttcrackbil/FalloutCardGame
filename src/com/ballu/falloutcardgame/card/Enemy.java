package com.ballu.falloutcardgame.card;

import java.util.ArrayList;

public class Enemy extends Card {
	private ArrayList<Weapon>		weaponList	= new ArrayList<Weapon>();
	private static ArrayList<Enemy>	enemies		= new ArrayList<Enemy>();
	
	public Enemy(String string, String description, int life, int damage,
			int level) {
		super(string, description, damage, life, level);
		System.out.println("Beginning Enemy Creation");
		super.setEnemy(true);
		enemies.add(this);
		System.out.println("Finished Enemy Creation");
	}
	
	public void addWeapon(Weapon weapon) {
		this.weaponList.add(weapon);
	}
	
	public Weapon[] getWeapons() {
		Weapon[] weapons = new Weapon[this.weaponList.size()];
		for (int i = 0; i < this.weaponList.size(); i++) {
			weapons[i] = ((Weapon) this.weaponList.get(i));
		}
		return weapons;
	}
	
	public static Enemy[] getEnemies() {
		Enemy[] all = new Enemy[enemies.size()];
		for (int i = 0; i < enemies.size(); i++) {
			all[i] = ((Enemy) enemies.get(i));
		}
		return all;
	}
}
