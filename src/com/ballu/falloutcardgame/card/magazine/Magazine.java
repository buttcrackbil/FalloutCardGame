package com.ballu.falloutcardgame.card.magazine;

import com.ballu.falloutcardgame.card.Card;
import com.ballu.falloutcardgame.card.enemy.Enemy;

public class Magazine extends Card {
	
	private Enemy user;
	
	public Magazine(String title, String description) {
		super(title, description);
	}

	@Override
	public Enemy getUser() {
		return user;
	}
	
}
