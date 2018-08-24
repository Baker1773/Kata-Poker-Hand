package PokerHand;

import java.util.Scanner;

import javafx.util.Pair;

public class Game {

	static Player one, two;

	public Game() {
	};

	public static void main(String args[]) {
		// opens input scanner
		Scanner in = new Scanner(System.in);

		// reads in text and sets up player
		String input = in.nextLine();
		SetUpPlayer(input);

		// closes input scanner
		in.close();

		// gets hand results
		String result = GetResults();

		// prints results
		System.out.println(result);
	}

	// reads in a String and sets up both players
	// based on the input text
	public static void SetUpPlayer(String input) {

		// getting name for player one
		int index = input.indexOf(':');
		String name = input.substring(0, index);

		Card[] hand = new Card[5];

		// getting cards for player one
		for (int i = 0; i < 5; i++) {
			index = input.indexOf(" ");
			input = input.substring(index + 1);

			char value = input.charAt(0);
			char suit = input.charAt(1);

			Card c = new Card(suit, value);
			hand[i] = c;
		}

		// removing extra white space
		index = input.indexOf(" ");
		input = input.substring(index + 1);

		// set player one
		one = new Player(name, hand);

		// if extra white space still exits remove it
		if (input.charAt(0) == ' ') {
			input = input.substring(1);
		}

		// getting name for player two
		index = input.indexOf(':');
		name = input.substring(0, index);

		// getting cards for player two
		hand = new Card[5];

		for (int i = 0; i < 5; i++) {
			index = input.indexOf(" ");
			input = input.substring(index + 1);

			char value = input.charAt(0);
			char suit = input.charAt(1);

			Card c = new Card(suit, value);
			hand[i] = c;
		}

		// set player two
		two = new Player(name, hand);
	}

	// returns the results of the two hands as a string.
	public static String GetResults() {
		String results = "";
		Pair<Player, String> handResults = HandComparator.CompareHand(one, two);
		if (handResults.getKey() != null) {
			results = handResults.getKey().GetName() + " wins. - with "
					+ handResults.getValue();
		} else
			results = "Tie.";
		return results;
	}
}
