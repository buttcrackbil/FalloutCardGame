package com.ballu.falloutcardgame.card.chem;

import com.ballu.falloutcardgame.card.Card;
import com.ballu.falloutcardgame.card.enemy.Enemy;

public class Chem extends Card {
	
	public Chem(String title, String description) {
		super(title, description);
	}

	@Override
	public Enemy getUser() {
		return null;
	}
	
}
