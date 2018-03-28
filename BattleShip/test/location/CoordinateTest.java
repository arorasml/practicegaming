package location;

import org.junit.Assert;
import org.junit.Test;

import com.game.battle.location.Coordinate;

public class CoordinateTest {

	@Test
	public void findCell() {
		final int width = 5;
		final char height = 'E';

		final Coordinate test = new Coordinate();

		Assert.assertEquals(new Coordinate(5, 5), test.findCellLocation(width, height));

	}

}
