package logic;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CardUtil {

	public static boolean isExistsInList(UnitCard card, ArrayList<UnitCard> list) {

		// TODO: Fill Code
		return list.contains(card);

	}

	public static boolean isExistsInList(UnitDeck deck, ArrayList<UnitDeck> list) {

		// TODO: Fill Code
		return list.contains(deck);

	}

	public static boolean cardExistsInDeckList(ArrayList<UnitDeck> deckList, UnitCard cardToTest) {

		// TODO: Fill Code
		for (UnitDeck deck : deckList) {
			if (deck.existsInDeck(cardToTest)) {
				return true;
			}
		}
		return false;
	}

	public static ArrayList<UnitCard> getCardsFromFile(String filename) {

		Scanner sc = null;

		try {

			File fileToRead = new File(filename);
			ArrayList<UnitCard> cardsFromFile = new ArrayList<UnitCard>();

			// TODO: Fill Code

			sc = new Scanner(fileToRead);

			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] parts = line.split(",");
				if (parts.length != 5) {
					sc.close();
					throw new NumberFormatException();
				}
				String name = parts[0];
				int bloodCost = Integer.parseInt(parts[1]);
				int power = Integer.parseInt(parts[2]);
				int health = Integer.parseInt(parts[3]);
				String flavorText = parts[4];
				UnitCard card = new UnitCard(name, bloodCost, power, health, flavorText);
				cardsFromFile.add(card);
			}

			sc.close();

			return cardsFromFile;

		} catch (FileNotFoundException e) {
			System.out.println("Cannot Find File!");
			System.out.println("File error! No new card added.");
		} catch (NumberFormatException e) {
			System.out.println("File contains string with incorrect format!");
		}

		sc.close();

		return null;
	}

	public static void printCardList(ArrayList<UnitCard> cardList, boolean verbose) {

		for (int i = 0; i < cardList.size(); i++) {
			System.out.println(i + ") " + cardList.get(i));
			if (verbose) {
				System.out.println("Blood Cost: " + cardList.get(i).getBloodCost());
				System.out.println(cardList.get(i).getFlavorText());
				if (i < cardList.size() - 1)
					System.out.println("-----");
			}
		}
	}

	public static void printDeck(UnitDeck ud) {

		if (ud.getCardsInDeck().size() == 0) {
			System.out.println("EMPTY DECK");
		} else {
			for (CardCounter cc : ud.getCardsInDeck()) {
				System.out.println(cc);
			}
		}

		System.out.println("Total Cards: " + ud.cardCount());
	}

	public static void printDeckList(ArrayList<UnitDeck> deckList) {

		for (int i = 0; i < deckList.size(); i++) {
			System.out.println(i + ") " + deckList.get(i).getDeckName());
			printDeck(deckList.get(i));
			if (i < deckList.size() - 1)
				System.out.println("-----");
		}
	}
}
