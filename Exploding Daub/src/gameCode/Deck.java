package gameCode;
import java.util.*;

public class Deck{
  private ArrayList<Card> deck;
  private int numBombs;
  private String[] cards = {"Exploding Kittens", "Attack", "See the Future",
		  					"Shuffle", "Nope", "Bearded Cat", "Rainbow Cat"};
  
  public Deck(int i){
	  numBombs = i;
  }
  
  public void populate() {
	  for (int j =0; j < this.numBombs; j++) {
		  deck.add(new Card(cards[1]));
	  }
	  for (int i = 1; i < cards.length; i++) {
		  for (int j = 0; j < 4; i++) {
			  deck.add(new Card(cards[i]));
		  }
	  }
  }
  
  public Card draw(){
    return deck.remove(deck.size()-1);
  }

  public Card getTopInt(int i){
    return deck.get(deck.size() - i);
  }
  public void addCard(Card c){
    deck.add(c);
  }
  
  public void shuffle(){
    Collections.shuffle(deck);
  }

  
}