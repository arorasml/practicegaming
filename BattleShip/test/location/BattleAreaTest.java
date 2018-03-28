package location;

import javax.naming.SizeLimitExceededException;

import org.junit.Assert;
import org.junit.Test;

import com.game.battle.location.BattleArea;
import com.game.battle.ship.BattleShip;

public class BattleAreaTest {

	@Test
	public void addShipsToBattleAreaFail() throws SizeLimitExceededException {
		final BattleArea testArea = new BattleArea(5, 'E');

		final BattleShip testShip = new BattleShip(1, 4);

		final String testCell = "C2";

		final int shipStrength = 2;

		Assert.assertEquals(false, testArea.addShipsToBattleArea(testShip, testCell, shipStrength));

	}

	@Test
	public void addShipsToBattleAreaSuccess() throws SizeLimitExceededException {
		final BattleArea testArea = new BattleArea(5, 'E');

		final BattleShip testShip = new BattleShip(1, 3);

		final String testCell = "C2";

		final int shipStrength = 2;

		Assert.assertEquals(true, testArea.addShipsToBattleArea(testShip, testCell, shipStrength));

	}

	@Test
	public void checkIfCoordinateNotWithInRange() throws SizeLimitExceededException {
		final BattleArea testArea = new BattleArea(5, 'E');

		final int width = 4;
		final char height = 'F';

		Assert.assertNotEquals(true, testArea.checkIfCoordinateWithInRange(width, height));
	}

	@Test
	public void checkIfCoordinateWithInRange() throws SizeLimitExceededException {
		final BattleArea testArea = new BattleArea(5, 'E');

		final int width = 4;
		final char height = 'D';

		Assert.assertEquals(true, testArea.checkIfCoordinateWithInRange(width, height));
	}

}
