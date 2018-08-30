package Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import PokerHand.Card;
import PokerHand.Hands.Flush;
import PokerHand.Hands.FourOfAKind;
import PokerHand.Hands.FullHouse;
import PokerHand.Hands.HandType;
import PokerHand.Hands.HighCard;
import PokerHand.Hands.PairCard;
import PokerHand.Hands.Straight;
import PokerHand.Hands.StraightFlush;
import PokerHand.Hands.ThreeOfAKind;
import PokerHand.Hands.TwoPair;

public class TestHands {

	@Test
	public void highCard() {
		Card[] c = new Card[5];
		c[0] = new Card('H', '2');
		c[1] = new Card('D', '3');
		c[2] = new Card('S', '5');
		c[3] = new Card('C', '9');
		c[4] = new Card('D', 'K');

		HandType h = new HighCard(c);
		assertEquals(true, h.isValidHand());

		h = new PairCard(c);
		assertEquals(false, h.isValidHand());

		h = new TwoPair(c);
		assertEquals(false, h.isValidHand());

		h = new ThreeOfAKind(c);
		assertEquals(false, h.isValidHand());

		h = new Straight(c);
		assertEquals(false, h.isValidHand());

		h = new Flush(c);
		assertEquals(false, h.isValidHand());

		h = new FullHouse(c);
		assertEquals(false, h.isValidHand());

		h = new FourOfAKind(c);
		assertEquals(false, h.isValidHand());

		h = new StraightFlush(c);
		assertEquals(false, h.isValidHand());
	}

	@Test
	public void fullHouse() {

		Card[] c = new Card[5];
		c[0] = new Card('H', '2');
		c[1] = new Card('D', '2');
		c[2] = new Card('S', '2');
		c[3] = new Card('C', '3');
		c[4] = new Card('D', '3');

		HandType h = new HighCard(c);
		assertEquals(true, h.isValidHand());

		h = new PairCard(c);
		assertEquals(true, h.isValidHand());

		h = new TwoPair(c);
		assertEquals(true, h.isValidHand());

		h = new ThreeOfAKind(c);
		assertEquals(true, h.isValidHand());

		h = new Straight(c);
		assertEquals(false, h.isValidHand());

		h = new Flush(c);
		assertEquals(false, h.isValidHand());

		h = new FullHouse(c);
		assertEquals(true, h.isValidHand());

		h = new FourOfAKind(c);
		assertEquals(false, h.isValidHand());

		h = new StraightFlush(c);
		assertEquals(false, h.isValidHand());
	}

	@Test
	public void fourOfAKind() {
		Card[] c = new Card[5];
		c[0] = new Card('H', '2');
		c[1] = new Card('D', '2');
		c[2] = new Card('S', '2');
		c[3] = new Card('C', '2');
		c[4] = new Card('D', '3');

		HandType h = new HighCard(c);
		assertEquals(true, h.isValidHand());

		h = new PairCard(c);
		assertEquals(true, h.isValidHand());

		h = new TwoPair(c);
		assertEquals(true, h.isValidHand());

		h = new ThreeOfAKind(c);
		assertEquals(true, h.isValidHand());

		h = new Straight(c);
		assertEquals(false, h.isValidHand());

		h = new Flush(c);
		assertEquals(false, h.isValidHand());

		h = new FullHouse(c);
		assertEquals(false, h.isValidHand());

		h = new FourOfAKind(c);
		assertEquals(true, h.isValidHand());

		h = new StraightFlush(c);
		assertEquals(false, h.isValidHand());
	}

	@Test
	public void threeOfAKind() {
		Card[] c = new Card[5];
		c[0] = new Card('H', '2');
		c[1] = new Card('D', '2');
		c[2] = new Card('S', '2');
		c[3] = new Card('C', '4');
		c[4] = new Card('D', '3');

		HandType h = new HighCard(c);
		assertEquals(true, h.isValidHand());

		h = new PairCard(c);
		assertEquals(true, h.isValidHand());

		h = new TwoPair(c);
		assertEquals(false, h.isValidHand());

		h = new ThreeOfAKind(c);
		assertEquals(true, h.isValidHand());

		h = new Straight(c);
		assertEquals(false, h.isValidHand());

		h = new Flush(c);
		assertEquals(false, h.isValidHand());

		h = new FullHouse(c);
		assertEquals(false, h.isValidHand());

		h = new FourOfAKind(c);
		assertEquals(false, h.isValidHand());

		h = new StraightFlush(c);
		assertEquals(false, h.isValidHand());
	}

	@Test
	public void flush() {
		Card[] c = new Card[5];
		c[0] = new Card('H', '2');
		c[1] = new Card('H', '3');
		c[2] = new Card('H', '5');
		c[3] = new Card('H', '9');
		c[4] = new Card('H', 'K');

		HandType h = new HighCard(c);
		assertEquals(true, h.isValidHand());

		h = new PairCard(c);
		assertEquals(false, h.isValidHand());

		h = new TwoPair(c);
		assertEquals(false, h.isValidHand());

		h = new ThreeOfAKind(c);
		assertEquals(false, h.isValidHand());

		h = new Straight(c);
		assertEquals(false, h.isValidHand());

		h = new Flush(c);
		assertEquals(true, h.isValidHand());

		h = new FullHouse(c);
		assertEquals(false, h.isValidHand());

		h = new FourOfAKind(c);
		assertEquals(false, h.isValidHand());

		h = new StraightFlush(c);
		assertEquals(false, h.isValidHand());
	}

	@Test
	public void straight() {
		Card[] c = new Card[5];
		c[0] = new Card('H', '2');
		c[1] = new Card('D', '3');
		c[2] = new Card('S', '5');
		c[3] = new Card('C', '4');
		c[4] = new Card('D', '6');

		HandType h = new HighCard(c);
		assertEquals(true, h.isValidHand());

		h = new PairCard(c);
		assertEquals(false, h.isValidHand());

		h = new TwoPair(c);
		assertEquals(false, h.isValidHand());

		h = new ThreeOfAKind(c);
		assertEquals(false, h.isValidHand());

		h = new Straight(c);
		assertEquals(true, h.isValidHand());

		h = new Flush(c);
		assertEquals(false, h.isValidHand());

		h = new FullHouse(c);
		assertEquals(false, h.isValidHand());

		h = new FourOfAKind(c);
		assertEquals(false, h.isValidHand());

		h = new StraightFlush(c);
		assertEquals(false, h.isValidHand());
	}

	@Test
	public void straightFlush() {
		Card[] c = new Card[5];
		c[0] = new Card('D', '2');
		c[1] = new Card('D', '3');
		c[2] = new Card('D', '5');
		c[3] = new Card('D', '4');
		c[4] = new Card('D', '6');

		HandType h = new HighCard(c);
		assertEquals(true, h.isValidHand());

		h = new PairCard(c);
		assertEquals(false, h.isValidHand());

		h = new TwoPair(c);
		assertEquals(false, h.isValidHand());

		h = new ThreeOfAKind(c);
		assertEquals(false, h.isValidHand());

		h = new Straight(c);
		assertEquals(true, h.isValidHand());

		h = new Flush(c);
		assertEquals(true, h.isValidHand());

		h = new FullHouse(c);
		assertEquals(false, h.isValidHand());

		h = new FourOfAKind(c);
		assertEquals(false, h.isValidHand());

		h = new StraightFlush(c);
		assertEquals(true, h.isValidHand());
	}

	@Test
	public void pair() {
		Card[] c = new Card[5];
		c[0] = new Card('H', '2');
		c[1] = new Card('D', '2');
		c[2] = new Card('S', '5');
		c[3] = new Card('C', '9');
		c[4] = new Card('D', 'K');

		HandType h = new HighCard(c);
		assertEquals(true, h.isValidHand());

		h = new PairCard(c);
		assertEquals(true, h.isValidHand());

		h = new TwoPair(c);
		assertEquals(false, h.isValidHand());

		h = new ThreeOfAKind(c);
		assertEquals(false, h.isValidHand());

		h = new Straight(c);
		assertEquals(false, h.isValidHand());

		h = new Flush(c);
		assertEquals(false, h.isValidHand());

		h = new FullHouse(c);
		assertEquals(false, h.isValidHand());

		h = new FourOfAKind(c);
		assertEquals(false, h.isValidHand());

		h = new StraightFlush(c);
		assertEquals(false, h.isValidHand());
	}

	@Test
	public void twoPair() {
		Card[] c = new Card[5];
		c[0] = new Card('H', '2');
		c[1] = new Card('D', '2');
		c[2] = new Card('S', '9');
		c[3] = new Card('C', '9');
		c[4] = new Card('D', 'K');

		HandType h = new HighCard(c);
		assertEquals(true, h.isValidHand());

		h = new PairCard(c);
		assertEquals(true, h.isValidHand());

		h = new TwoPair(c);
		assertEquals(true, h.isValidHand());

		h = new ThreeOfAKind(c);
		assertEquals(false, h.isValidHand());

		h = new Straight(c);
		assertEquals(false, h.isValidHand());

		h = new Flush(c);
		assertEquals(false, h.isValidHand());

		h = new FullHouse(c);
		assertEquals(false, h.isValidHand());

		h = new FourOfAKind(c);
		assertEquals(false, h.isValidHand());

		h = new StraightFlush(c);
		assertEquals(false, h.isValidHand());
	}
}
