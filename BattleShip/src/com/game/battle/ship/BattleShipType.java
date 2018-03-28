package com.game.battle.ship;

public enum BattleShipType {
	
	
	Q(2),
	P(1);
	
	int val;
	
	private BattleShipType(int val) {
		this.val = val;
	}
	public int getVal() {
		return val;
	}
  
	
}
