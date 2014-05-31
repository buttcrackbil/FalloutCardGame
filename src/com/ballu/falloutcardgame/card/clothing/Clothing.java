package com.ballu.falloutcardgame.card.clothing;

import com.ballu.falloutcardgame.card.Card;
import com.ballu.falloutcardgame.card.enemy.Enemy;

public class Clothing extends Card {
	
	private int defense;
	
	private Enemy user;
	
	public Clothing(String title, String description, int armor) {
		super(title, description);
		defense = armor;
	}
	
	public int getArmor(){
		return defense;
	}

	@Override
	public Enemy getUser() {
		return user;
	}
	
}
