package com.game.battle.location;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.naming.SizeLimitExceededException;

import com.game.battle.ship.BattleShip;

public class BattleArea {

	private static final Logger logger = Logger.getLogger(BattleArea.class.getName());

	private int width;
	private char height;
	private Coordinate downRightMostCell = new Coordinate(0, '0');

	private List<BattleShip> battleships = new ArrayList<BattleShip>();

	private final List<BattleShipCell> cellsHit = new ArrayList<BattleShipCell>();

	boolean addedSuccessfully;

	/*
	 * Constructor to create object with width and height validation at the time
	 * of creation
	 */

	public BattleArea(int downRightMostXCoordinate, char downRightMostYCoordinate) throws SizeLimitExceededException {
		super();
		if (downRightMostXCoordinate <= 9) {
			this.width = downRightMostXCoordinate;
		} else {
			throw new SizeLimitExceededException("The width of battle area can not be greater than 9");
		}

		if (downRightMostYCoordinate <= 'Z') {
			this.height = downRightMostYCoordinate;
		} else {
			throw new SizeLimitExceededException("The height of battle area can not be greater than Z");
		}

		this.downRightMostCell = downRightMostCell.findCellLocation(downRightMostXCoordinate, downRightMostYCoordinate);

	}

	/* Adding ships to players battle area */

	public boolean addShipsToBattleArea(BattleShip ship, String startingCell, int shipStrength) {

		char startingCellYCoordinate = startingCell.charAt(0);
		int startingCellXCoordinate = Integer.valueOf(startingCell.substring(1));

		addedSuccessfully = checkIfCoordinateWithInRange(startingCellXCoordinate, startingCellYCoordinate);

		int shipWidth = ship.getWidth();
		int shipHeight = ship.getHeight();

		// assign battleship cells in battle area
		if (shipWidth > this.width - (startingCellXCoordinate - 1)
				|| shipHeight > ((this.height - startingCellYCoordinate) + 1)) {
			System.out.println("Ship must be with in the battle area");
			return false;
		}

		else {
			BattleShipCell cell = new BattleShipCell(new Coordinate(startingCellXCoordinate, startingCellYCoordinate),
					shipStrength);
			ship.getCellsOccupied().add(cell);
			for (int i = 1; i < shipWidth; i++) {
				ship.getCellsOccupied().add(new BattleShipCell(
						new Coordinate(startingCellXCoordinate + i, startingCellYCoordinate), shipStrength));
			}

			for (int k = 1; k < shipHeight; k++) {
				int startingCellYCoordinateInt = (startingCellYCoordinate - 'A' + k);

				ship.getCellsOccupied().add(new BattleShipCell(
						new Coordinate(startingCellXCoordinate, Character.toChars(startingCellYCoordinateInt + 65)[0]),
						shipStrength));
			}
		}

		// check whether ships are already placed at battleshipscell

		for (BattleShip battleship : battleships) {
			for (BattleShipCell cell : ship.getCellsOccupied()) {
				if (battleship.getCellsOccupied().contains(cell)) {
					System.out.println("Ship is already placed at given cell locations");
					return false;
				}
			}
		}

		logger.info("Cells occupied: " + ship.toString());
		this.battleships.add(ship);

		return addedSuccessfully;

	}

	/* check whether ships coordinate are with in battle area range */

	public boolean checkIfCoordinateWithInRange(int width, char height) {
		if (width <= this.width && height <= this.height) {
			return true;
		} else {
			System.out.println("Ship's coordinate should be with in battle area range");
			return false;
		}
	}

	/* Check whether all ships are sunk */
	public boolean isAllSunk() {
		// Iterate through all battleships checking if sunk
		for (BattleShip b : this.battleships) {
			if (!b.isSunk()) {
				return false;
			}
		}
		return true;
	}

	/*
	 * Method for trying hitting the opponents cell locations scanned from input
	 * file
	 */
	public int tryHit(BattleShipCell c) {
		// Ensure coordinates are within grid
		if (c.getCell().getxCoordinate() < 0 || c.getCell().getyCoordinate() < 'A'
				|| c.getCell().getxCoordinate() > this.width || c.getCell().getyCoordinate() > this.height) {
			return -1; // Invalid coordinates
		}

		for (BattleShip b : battleships) {
			for (BattleShipCell s : b.getCellsOccupied()) {
				if (s.equals(c)) {
					// If hit, change status of grid, segment, and check if
					// battleship is sunk
					s.shipStrength--;
					if (s.shipStrength == 0) {
						b.getCellsOccupied().remove(s);
						cellsHit.add(s);
					}
					s.isHit = true;
					System.out.println("target " + c.toString() + "got hit");
					if (b.checkIfSunk()) {
						battleships.remove(b);
					}
					return 1; // Successful hit & ship sunk
				}
			}
		}
		if (cellsHit.contains(c)) {
			System.out.println("Cell is invalid or already hit");
			return -1;
		}
		System.out.println("target " + c.toString() + "got miss");
		return 0; // Unsuccessful hit

	}

	public void setBattleships(List<BattleShip> battleships) {
		this.battleships = battleships;
	}

	public void setDownRightMostCell(Coordinate downRightMostCell) {
		this.downRightMostCell = downRightMostCell;
	}

	public void setHeight(char height) {
		this.height = height;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public List<BattleShip> getBattleships() {
		return battleships;
	}

	public Coordinate getDownRightMostCell() {
		return downRightMostCell;
	}

	public char getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

}
