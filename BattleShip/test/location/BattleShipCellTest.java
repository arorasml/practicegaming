package location;

import org.junit.Assert;
import org.junit.Test;

import com.game.battle.location.BattleShipCell;

public class BattleShipCellTest {

	@Test
	public void checkHit() {
		final boolean isHit = true;
		final int shipStrength = 0;
		final BattleShipCell cell = new BattleShipCell(shipStrength, isHit);

		Assert.assertEquals(true, cell.checKHit());

	}

}
