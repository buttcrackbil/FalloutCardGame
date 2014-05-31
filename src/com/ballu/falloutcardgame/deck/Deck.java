package com.ballu.falloutcardgame.deck;

import java.util.ArrayList;
import java.util.Random;

import com.ballu.falloutcardgame.card.Card;
import com.ballu.falloutcardgame.card.enemy.Enemy;
import com.ballu.falloutcardgame.card.weapon.Weapon;

public class Deck {
	
	ArrayList<Card>				deck		= new ArrayList<Card>();
	
	public static final Deck starterDeck1 = new Deck();
	
	public Deck(Card... cards) {
		for (Card card : cards) {
			deck.add(card);
			System.out.println(card.getName());
		}
	}
	
	public void addCards(Card... cards){
		for (Card card : cards) {
			deck.add(card);
		}
	}
	
	public Card[] getCards() {
		Card[] cards = new Card[deck.size()];
		deck.toArray(cards);
		return cards;
	}
	
	public static Deck get(Deck deck){
		Deck output = new Deck();
		if(deck == starterDeck1){
			output.addCards(getRandomEnemy(), getRandomEnemy(), getRandomWeapon());
		}
		return output;
	}
	
	public int getSize(){
		return deck.size();
	}
	
	private static Enemy getRandomEnemy(){
		Random r = new Random();
		int i = r.nextInt(Enemy.enemies.size());
		return Enemy.get(Enemy.enemies.get(i));
	}
	
	private static Weapon getRandomWeapon(){
		Random r = new Random();
		int i = r.nextInt(Weapon.weapons.size());
		return Weapon.get(Weapon.weapons.get(i));
	}
}
