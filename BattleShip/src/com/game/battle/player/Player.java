package com.game.battle.player;

import java.util.List;
import java.util.logging.Logger;

import javax.naming.SizeLimitExceededException;

import com.game.battle.location.BattleArea;
import com.game.battle.location.BattleShipCell;
import com.game.battle.location.Coordinate;
import com.game.battle.ship.BattleShip;
import com.game.battle.ship.BattleShipType;

public class Player {

	private static final Logger logger = Logger.getLogger(Player.class.getName());
	private int counter = 0;
	private BattleArea battleArea;
	private String playerName;

	/*
	 * Setting Up Battle area
	 */

	public void setUpBattleArea(int width, char height) throws SizeLimitExceededException {
		battleArea = new BattleArea(width, height);
		counter = 0;

	}

	/*
	 * Find next target on opponent's battle area
	 */

	public BattleShipCell getNextTarget(String attackInstructions) {

		final String attackInstructionsArray[] = attackInstructions.split(" ");
		String getNextTargetStr = null;
		if (counter < attackInstructionsArray.length) {

			getNextTargetStr = attackInstructionsArray[counter];
			char yCoord = getNextTargetStr.charAt(0);
			int xCoord = Integer.valueOf(getNextTargetStr.substring(1, 2));
			BattleShipCell getNextTargetCell = new BattleShipCell(new Coordinate(xCoord, yCoord));
			counter++;
			return getNextTargetCell;
		}

		return null;
	}

	/*
	 * Creating and placing up ships on player's battle area
	 */

	public boolean setUpShip(int noOfShips, List<String> locationSets) throws SizeLimitExceededException {

		boolean setUpSuccessFully = false;
		if (noOfShips > battleArea.getWidth() * (battleArea.getHeight() - 'A' + 1)) {
			throw new SizeLimitExceededException("Number of ships can not exceed width * height of battle area");

		}

		logger.info("No of Ships per player : " + noOfShips);

		// Get each ship coordinates from input location sets

		int i = 0;
		while (i < noOfShips) {
			String result = locationSets.get(i);
			String shipType = result.substring(0, 1);
			int width = Integer.valueOf(result.substring(2, 3));
			int height = Integer.valueOf(result.substring(4, 5));
			String startingCell = null;

		

				BattleShip ship = new BattleShip(width, height);
				startingCell = result.substring(6, 8);
				logger.info("Player Name :" + this.getPlayerName() + " " + "ship type : " + shipType);
				logger.info("width of ship: " + width + " " + "height : " + height + " " + "starting Cell: "
						+ startingCell);

				setUpSuccessFully = battleArea.addShipsToBattleArea(ship, startingCell, BattleShipType.valueOf(shipType).getVal());
			
//
//			else if (BattleShipConstants.PType.equals(shipType)) {
//
//				BattleShip pShip = new PTypeBattleShip(width, height);
//				startingCell = result.substring(6, 8);
//				logger.info("Player Name :" + this.getPlayerName() + " " + "ship type : " + shipType);
//				logger.info("width of ship: " + width + " " + "height : " + height + " " + "starting Cell: "
//						+ startingCell);
//
//				setUpSuccessFully = battleArea.addShipsToBattleArea(pShip, startingCell, BattleShipConstants.pStrength);
//			}

//			else {
//				System.out.println("Ships can be either Q-Type or P-Type");
//			}

			i++;
		}

		if (!setUpSuccessFully) {
			return false;
		}

		return setUpSuccessFully;

	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public BattleArea getBattleArea() {
		return battleArea;
	}

}
