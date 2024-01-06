package ObjectClass.ch8;

import java.security.SecureRandom;

public class DeckOfCards {
	
	private Card[] cards = new Card[52];
	
	public DeckOfCards() {
		String[] faces = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		String[] suits = {"♠","♥","♣","♦"};
		for(int i = 0; i < cards.length; i++) {
			cards[i] = new Card(faces[i%13], suits[i/13]);
		}
	}
	public Card getCard(int i) {return cards[i];}
	public void shuffle() {
		SecureRandom ranNumbers = new SecureRandom();
		for(int i = 0; i< cards.length; i++) {
			int j = ranNumbers.nextInt(cards.length);
			swapcards(cards[i], cards[j]);
			
		}
	}
	void swapcards(Card a, Card b) {
		Card c = a;
		a = b;
		b = c;
	}
	void swapcards(int i, int j) {
		Card c = cards[i];
		cards[i] = cards[j];
		cards[j] = c;
	}
	
	
}
