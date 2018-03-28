package player;

import java.util.ArrayList;
import java.util.List;

import javax.naming.SizeLimitExceededException;

import org.junit.Assert;
import org.junit.Test;

import com.game.battle.location.BattleShipCell;
import com.game.battle.location.Coordinate;
import com.game.battle.player.Player;

public class PlayerTest {

	@Test
	public void getNextTarget() {

		final Player p = new Player();
		final String attackInstructions = "A1";
		final BattleShipCell test = new BattleShipCell(new Coordinate(1, 'A'));
		Assert.assertEquals(test, p.getNextTarget(attackInstructions));
	}

	@Test
	public void setUpShip() throws SizeLimitExceededException {

		final Player p = new Player();
		p.setPlayerName("Fighter 1");
		p.setUpBattleArea(5, 'E');
		final int noOfShips = 1;

		final String testLocation = "Q 1 1 A1 B2";

		final List<String> testLocations = new ArrayList<String>();
		testLocations.add(testLocation);

		Assert.assertEquals(true, p.setUpShip(noOfShips, testLocations));
	}

}
