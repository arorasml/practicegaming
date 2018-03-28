package com.game.battle.ship;

import java.util.ArrayList;
import java.util.List;

import com.game.battle.location.BattleShipCell;

public class BattleShip {

	private int width;
	private int height;
	private List<BattleShipCell> cellsOccupied = new ArrayList<BattleShipCell>();
	private boolean isSunk;

	public BattleShip() {
		this.isSunk = false;
		this.cellsOccupied = new ArrayList<BattleShipCell>();
	}

	public BattleShip(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}

	/* Method to check if battle ship is sunk */

	public boolean checkIfSunk() {
		// Iterate through segments, if any are intact ship has not sunk
		for (final BattleShipCell s : cellsOccupied) {
			if (!s.checKHit()) {
				return false;
			}
		}
		isSunk = true;
		return true;
	}

	public List<BattleShipCell> getCellsOccupied() {
		return cellsOccupied;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public boolean isSunk() {
		return isSunk;
	}

	public void setCellsOccupied(List<BattleShipCell> cellsOccupied) {
		this.cellsOccupied = cellsOccupied;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setSunk(boolean isSunk) {
		this.isSunk = isSunk;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public String toString() {
		return "BattleShip [cellsOccupied=" + cellsOccupied + "]";
	}

}
