package com.ballu.falloutcardgame.card.food;

import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JLabel;

import com.ballu.falloutcardgame.card.Card;
import com.ballu.falloutcardgame.card.enemy.Enemy;

public class Food extends Card {
	
	private Enemy					user;
	
	private JLabel					heal	= new JLabel();
	private Rectangle				healRec	= new Rectangle(0,
													getHeight() - 20, 100, 20);
	
	private int						healthBoost;
	private int						healthBoostTime;
	
	public static ArrayList<Food>	foods	= new ArrayList<Food>();
	
	public Food(String title, String description, int health, int turns) {
		super(title, description);
		foods.add(this);
		healthBoost = health;
		System.out.println("Beginning food creation");
		heal.setText("+" + health + " for " + turns + " turns");
		heal.setBounds(healRec);
		add(heal);
		setFood(true);
		System.out.println("Finished food creation");
	}
	
	public void setUser(Enemy input) {
		user = input;
	}
	
	@Override
	public Enemy getUser() {
		return user;
	}
	
	public int[] getHealthBoost() {
		int[] output = {healthBoost, healthBoostTime};
		return output;
	}
}
