package com.game.battle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import javax.naming.SizeLimitExceededException;

import com.game.battle.common.BattleShipConstants;
import com.game.battle.location.BattleShipCell;
import com.game.battle.player.Player;

public class PlayGame {

	private static final Logger logger = Logger.getLogger(PlayGame.class.getName());

	public static void main(String args[]) throws FileNotFoundException, SizeLimitExceededException {

		boolean gameContinue = false;

		Player p1 = new Player();
		p1.setPlayerName(BattleShipConstants.Player1);
		logger.info("First Player Name: " + p1.getPlayerName());

		Player p2 = new Player();
		p2.setPlayerName(BattleShipConstants.Player2);
		logger.info("Second Player Name: " + p2.getPlayerName());

		/*
		 * Declare scanner to read input file line by line
		 */

		Scanner scanner = new Scanner(new File("input.txt"));

		/*
		 * First input line : setting up battle area for p1 and p2
		 */

		String result1 = scanner.nextLine();
		logger.info("First Input Line : " + result1);

		int battleAreaWidth = Integer.valueOf(result1.substring(0, 1));
		char battleAreaHeight = result1.charAt(2);

		p1.setUpBattleArea(battleAreaWidth, battleAreaHeight);
		p2.setUpBattleArea(battleAreaWidth, battleAreaHeight);

		/*
		 */

		String result2 = scanner.nextLine();
		logger.info("Second Input Line : " + result2);
		int noOfShips = Integer.valueOf(result2.substring(0, 1));

		/*
		 * Third & Fourth Line : Placing ships at given location for Player p1
		 * and Player p2
		 */

		List<String> p1Locations = new ArrayList<String>();
		List<String> p2Locations = new ArrayList<String>();

		int i = 0;

		while (i < noOfShips) {
			String result3 = scanner.nextLine();

			/*
			 * location sets for Player p1 and p2 from input file that holds
			 * Player 1 and Player 2 location set in the same line eg. if input
			 * is (Q 1 1 A1 B2) then input for player p1 is (Q 1 1 A1) and input
			 * for player p2 is (Q 1 1 B2)
			 */

			String p1Result = result3.substring(0, 8);
			p1Locations.add(p1Result);
			logger.info("ShipType, Dimensions and Locations for ships: " + p1Result);

			String p2Result = result3.substring(0, 5) + " " + result3.substring(9, 11);
			p2Locations.add(result3);
			logger.info("ShipType, Dimensions and Locations for ships: " + p2Result);

			i++;
		}

		gameContinue = p1.setUpShip(noOfShips, p1Locations);
		gameContinue = p2.setUpShip(noOfShips, p2Locations);

		/*
		 * game begins after ships get placed on respective battle area
		 */

		if (gameContinue) {

			/*
			 * Fifth and Sixth Command Line
			 */

			String playerOneAttackMoves = scanner.nextLine();
			String playerTwoAttackMoves = scanner.nextLine();
			System.out.println("Continue Playing:  Battle ships ready and placed on their battle area");

			while (gameContinue) {

				/*
				 * player 1 turns
				 */

				int hitTarget = 1;
				BattleShipCell opponentP2Cell = null;
				while (hitTarget == 1) {
					opponentP2Cell = p1.getNextTarget(playerOneAttackMoves);

					if (opponentP2Cell != null) {
						System.out.println("Player-1 fires a missile");
						hitTarget = p2.getBattleArea().tryHit(opponentP2Cell);
					} else {
						// invalid cell or no cell
						hitTarget = -1;
					}
				}

				/*
				 * Check if all of the player 1 ships are sunk
				 */

				if (p2.getBattleArea().isAllSunk()) {
					// If so, announce winner and exit
					System.out.println(" P1 sunk all ships of P2 and won the game");
					System.exit(0);
				}

				/*
				 * player 2 turns
				 */

				hitTarget = 1;
				BattleShipCell opponentP1Cell = null;
				while (hitTarget == 1) {
					opponentP1Cell = p2.getNextTarget(playerTwoAttackMoves);

					if (opponentP1Cell != null) {
						System.out.println("Player-2 fires a missile");
						hitTarget = p1.getBattleArea().tryHit(opponentP1Cell);
					}

					else {
						// invalid cell or no cell
						hitTarget = -1;
					}
				}

				/*
				 * Check if all of the player 2 ships are sunk
				 */

				if (p1.getBattleArea().isAllSunk()) {
					// If so, announce winner and exit
					System.out.println(" P2 sunk all ships of P1 and won the game");
					System.exit(0);
				}

				/*
				 * if attacks from both the ships are over and there is no win
				 */

				if (opponentP1Cell == null && opponentP2Cell == null) {
					System.out.println("No win or lost : There is peace ");
					System.exit(0);

				}

			}
		}

	}

}
