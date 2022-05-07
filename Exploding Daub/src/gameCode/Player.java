package gameCode;

import serverCode.*;
import java.util.ArrayList;

public class Player{

  private ArrayList<Card> hand;
  private String name;
  private ClientHandler handler;
  
  public Player(String n, ClientHandler c){
    name = n;
    handler = c;
  }


  public String getName(){
    return name;
  }

  public void addCard(Card c){
    //Method gives the player a card
    if (c != null){
      hand.add(c);  
    }
  }

  public void removeCard(Card c){
    try{
      hand.remove(hand.indexOf(c));
    }catch (ArrayIndexOutOfBoundsException e){
      System.out.println("Player does not have the card");
    }
  }
}