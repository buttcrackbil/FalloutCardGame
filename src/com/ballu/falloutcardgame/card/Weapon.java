package com.ballu.falloutcardgame.card;

public class Weapon extends Card {
	public Weapon(String title, int damaged, int maxDamage, int damage,
			String description) {
		super(title, damaged, maxDamage, damage, description);
		super.setWeapon(true);
	}
}
