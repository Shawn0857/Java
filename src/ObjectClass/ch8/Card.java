package ObjectClass.ch8;

public class Card {
	final String face; //數字  final 第一次給定後，即無法再改變
	final String suit; //花色
	//建構子
	public Card(String _face, String _suit) {
		face = _face;
		suit = _suit;
	}
	public String getFace() {return face;}
	public String getSuit() {return suit;}
	public String toString() {return suit + face;}
	
}
