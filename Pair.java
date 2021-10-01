package chapter2_2;

import java.util.Iterator;

public class Pair implements Iterable<Card>{
	public static void main(String[] args) {
		Pair pair = new Pair(new Card(Rank.ACE, Suit.CLUBS),
				new Card(Rank.ACE, Suit.DIAMONDS));
		
		/*
		 * Use the enhanced for loop to iterator the cards in a pair.
		 * It is possible because pair has implemented iterable
		 */
		for (Card card : pair) {
			System.out.println(card);
		}
		
	}
	
	private Card aFirst;
	private Card aSecond;
	
	public Pair(Card pCard1, Card pCard2) {
		aFirst = pCard1;
		aSecond = pCard2;
	}


	@Override
	public Iterator<Card> iterator() {
		
		/**
		 * Here we use anonymous class
		 * 
		 */
		return new Iterator<Card>() {
			
			private int aSeen = 0;
			@Override
			public boolean hasNext() {
				return aSeen < 2;
			}

			@Override
			public Card next() {
				aSeen++;
				return aSeen == 1? aFirst : aSecond;
			}
			
		};
	}
	
	
	
	
}
