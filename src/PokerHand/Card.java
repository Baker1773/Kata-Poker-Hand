package PokerHand;

public class Card {
	char suit;
	char value;

	// Card constructor
	// Expects a char suit and char value
	public Card(char suit, char value) {
		this.suit = suit;
		this.value = value;
	}

	// returns the suit of the card
	public char GetSuit() {
		return suit;
	}

	// returns an integer value for the card
	// this allows the card to be compared to each other
	public int GetIntegerValue() {
		int val = 0;

		switch (value) {
		case '2':
			val = 2;
			break;
		case '3':
			val = 3;
			break;
		case '4':
			val = 4;
			break;
		case '5':
			val = 5;
			break;
		case '6':
			val = 6;
			break;
		case '7':
			val = 7;
			break;
		case '8':
			val = 8;
			break;
		case '9':
			val = 9;
			break;
		case 'T':
			val = 10;
			break;
		case 'J':
			val = 11;
			break;
		case 'Q':
			val = 12;
			break;
		case 'K':
			val = 13;
			break;
		case 'A':
			val = 14;
			break;

		default:
			break;
		}
		return val;
	}

	// Returns a String value of the cards value
	public String GetValue() {
		String val = "";

		switch (value) {
		case '2':
			val = "2";
			break;
		case '3':
			val = "3";
			break;
		case '4':
			val = "4";
			break;
		case '5':
			val = "5";
			break;
		case '6':
			val = "6";
			break;
		case '7':
			val = "7";
			break;
		case '8':
			val = "8";
			break;
		case '9':
			val = "9";
			break;
		case 'T':
			val = "Ten";
			break;
		case 'J':
			val = "Jack";
			break;
		case 'Q':
			val = "Queen";
			break;
		case 'K':
			val = "King";
			break;
		case 'A':
			val = "Ace";
			break;

		default:
			break;
		}
		return val;
	}

	// Changed toString for easier debugging
	@Override
	public String toString() {
		return value + "" + suit;
	}
}
