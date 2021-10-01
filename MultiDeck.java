package chapter2_2;

import java.util.ArrayList;
import java.util.List;

public class MultiDeck {

	private List<Deck> aDecks = new ArrayList<Deck>();
	
	public MultiDeck(MultiDeck pMultiDeck) {
		for (Deck aDeck : pMultiDeck.aDecks) {
			Deck newDeck = new Deck(aDeck);
			this.aDecks.add(newDeck);
		}
	}
	

}
