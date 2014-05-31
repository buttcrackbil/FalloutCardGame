package com.ballu.falloutcardgame.card.book;

import com.ballu.falloutcardgame.card.Card;
import com.ballu.falloutcardgame.card.enemy.Enemy;

public class Book extends Card {
	
	private Enemy user;
	
	public Book(String title, String description) {
		super(title, description);
	}

	@Override
	public Enemy getUser() {
		return user;
	}
	
}
