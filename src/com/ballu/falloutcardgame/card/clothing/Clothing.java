package com.ballu.falloutcardgame.card.clothing;

import com.ballu.falloutcardgame.card.Card;

public class Clothing extends Card {
	
	private int defense;
	
	public Clothing(String title, String description, int armor) {
		super(title, description);
		defense = armor;
	}
	
	public int getArmor(){
		return defense;
	}
	
}
