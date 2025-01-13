package logic;

import java.util.ArrayList;
import java.util.Objects;

public class UnitDeck {
	private ArrayList<CardCounter> cardsInDeck;
	private String deckName;

	public UnitDeck(String deckName) {
		setCardsInDeck(new ArrayList<CardCounter>());
		setDeckName(deckName);
	}

	public void addCard(UnitCard newCard, int count) {
		if (count > 0) {
			boolean cardHasBeenAdded = false;
			for (CardCounter cardCT : cardsInDeck) {
				if (cardCT.getCard().equals(newCard)) {
					cardCT.setCount(cardCT.getCount() + count);
					cardHasBeenAdded = true;
					break;
				}
			}
			if (!cardHasBeenAdded) {
				CardCounter NewCT = new CardCounter(newCard, count);
				cardsInDeck.add(NewCT);
			}
		}
	}

	public void removeCard(UnitCard toRemove, int count) {
		if (count > 0) {
			for (CardCounter cardCT : cardsInDeck) {
				if (cardCT.getCard().equals(toRemove)) {
					if (cardCT.getCount() - count > 0) {
						cardCT.setCount(cardCT.getCount() - count);
					} else {
						cardsInDeck.remove(cardCT);
					}
					break;
				}

			}
		}
	}

	public int cardCount() {
		int numberOfCards = 0;
		for (CardCounter cardCT : cardsInDeck) {
			numberOfCards += cardCT.getCount();
		}
		return numberOfCards;
	}

	public boolean existsInDeck(UnitCard Card) {
		for (CardCounter cardCT : cardsInDeck) {
			if (cardCT.getCard().equals(Card)) {
				return true;
			}
		}
		return false;
	}

	// getter , setter

	public ArrayList<CardCounter> getCardsInDeck() {
		return cardsInDeck;
	}

	public void setCardsInDeck(ArrayList<CardCounter> cardsInDeck) {
		this.cardsInDeck = cardsInDeck;
	}

	public String getDeckName() {
		return deckName;
	}

	public void setDeckName(String deckName) {
		this.deckName = (deckName.isBlank() ? "Untitled Deck" : deckName);

	}

	// Equals

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnitDeck other = (UnitDeck) obj;
		return Objects.equals(cardsInDeck, other.cardsInDeck) && Objects.equals(deckName, other.deckName);
	}

}
