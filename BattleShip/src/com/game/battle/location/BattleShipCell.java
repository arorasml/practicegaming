package com.game.battle.location;

public class BattleShipCell {

	private Coordinate cell;

	/*
	 * For Q Type Ship : Strength = 2 ie will take 2 hits to get collapsed For P
	 * Type Ship : Strength = 1 ie will take 1 hit to get collapsed
	 */

	int shipStrength;
	boolean isHit;

	public BattleShipCell() {

	}

	public BattleShipCell(Coordinate cell) {
		super();
		this.cell = cell;
	}

	public BattleShipCell(Coordinate cell, int shipStrength) {
		super();
		this.cell = cell;
		this.shipStrength = shipStrength;
	}

	public BattleShipCell(int shipStrength, boolean isHit) {
		super();
		this.shipStrength = shipStrength;
		this.isHit = isHit;
	}

	/*
	 * Check whether battleship's cell gets hit
	 */
	public boolean checKHit() {
		if (shipStrength == 0 && isHit) {
			return isHit;
		} else {
			isHit = false;
		}

		return isHit;

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final BattleShipCell other = (BattleShipCell) obj;
		if (cell == null) {
			if (other.cell != null) {
				return false;
			}
		} else if (!cell.equals(other.cell)) {
			return false;
		}
		return true;
	}

	public Coordinate getCell() {
		return cell;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cell == null) ? 0 : cell.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "BattleShipCell [cell=" + cell.getyCoordinate() + cell.getxCoordinate() + "]";
	}

}
