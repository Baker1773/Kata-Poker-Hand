package Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import PokerHand.Game;

public class TestCompareHands {

	@Test
	public void aceWhite() {
		String input = "Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C AH";

		Game g = new Game();
		g.setUpPlayer(input);
		String result = g.getResults();

		assertEquals("White wins. - with high card: Ace", result);
	}

	@Test
	public void fullHouseBlack() {
		String input = "Black: 2H 4S 4C 2D 4H  White: 2S 8S AS QS 3S";

		Game g = new Game();
		g.setUpPlayer(input);
		String result = g.getResults();

		// The expected form the kata page was wrong
		// as a full house beats a flush
		assertEquals("Black wins. - with full house", result);
	}

	@Test
	public void highCard9Black() {
		String input = "Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C KH";

		Game g = new Game();
		g.setUpPlayer(input);
		String result = g.getResults();

		assertEquals("Black wins. - with high card: 9", result);
	}

	@Test
	public void tie() {
		String input = "Black: 2H 3D 5S 9C KD  White: 2D 3H 5C 9S KH";

		Game g = new Game();
		g.setUpPlayer(input);
		String result = g.getResults();

		assertEquals("Tie.", result);
	}

	@Test
	public void fourOfAKindBlack() {
		String input = "Black: 5H 5D 5S 5C KD  White: 2C 3H 4S 8C KH";

		Game g = new Game();
		g.setUpPlayer(input);
		String result = g.getResults();

		assertEquals("Black wins. - with four of a kind", result);
	}

	@Test
	public void threeOfAKindBlack() {
		String input = "Black: 5H 5D 5S AC KD  White: 2C 3H 4S 8C KH";

		Game g = new Game();
		g.setUpPlayer(input);
		String result = g.getResults();

		assertEquals("Black wins. - with three of a kind", result);
	}

	@Test
	public void flushBlack() {
		String input = "Black: 4H 5H 7H 8H 9H  White: 2C 3H 4S 8C KH";

		Game g = new Game();
		g.setUpPlayer(input);
		String result = g.getResults();

		assertEquals("Black wins. - with flush", result);
	}

	@Test
	public void straightBlack() {
		String input = "Black: 4H 5H 6H 7H 8D  White: 2C 3H 4S 8C KH";

		Game g = new Game();
		g.setUpPlayer(input);
		String result = g.getResults();

		assertEquals("Black wins. - with straight", result);
	}

	@Test
	public void straightFlushBlack() {
		String input = "Black: 4H 5H 6H 7H 8H  White: 2C 3H 4S 8C KH";

		Game g = new Game();
		g.setUpPlayer(input);
		String result = g.getResults();

		assertEquals("Black wins. - with straight flush", result);
	}

	@Test
	public void pairBlack() {
		String input = "Black: 2H 5D 5S 9C KD  White: 2D 3H 5C 9S KH";

		Game g = new Game();
		g.setUpPlayer(input);
		String result = g.getResults();

		assertEquals("Black wins. - with pair", result);
	}

	@Test
	public void twoPairBlack() {
		String input = "Black: 9H 5D 5S 9C KD  White: 2D 3H 5C 9S KH";

		Game g = new Game();
		g.setUpPlayer(input);
		String result = g.getResults();

		assertEquals("Black wins. - with two pairs", result);
	}
}
