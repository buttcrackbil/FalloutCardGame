package com.ballu.falloutcardgame.graphics;

import com.ballu.falloutcardgame.card.Card;
import com.ballu.falloutcardgame.card.enemy.Enemy;

public class CardGraphics implements Runnable {
	
	public double	delta;
	
	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000D / 60D;
		
		long lastTimer = System.currentTimeMillis();
		delta = 0D;
		
		while (true) {
			long now = System.nanoTime();
			delta += (now - lastTime) / nsPerTick;
			lastTime = now;
			
			while (delta >= 1) {
				for (int i = 0; i < Card.cardList.length; i++) {
					if (Card.cardList[i] != null) {
						if (Card.cardList[i].isEnemy()) {
							((Enemy) Card.cardList[i]).displayRefresh();
							Card.cardList[i].repaint();
							delta -= 1;
						}
					}
				}
			}
		}
	}
	
}
