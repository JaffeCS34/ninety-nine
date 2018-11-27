package ninetynine;

import java.util.Collections;

/**
 * Player object. Students will extend this class
 * and override the getNextMove method
 * 
 * @author Mr. Jaffe
 * @version 1.0
 */
public class Player
{
  protected Deck deck;
  private String teamName;
  
  /**
   * Player constructor
   */
  public Player() {
    this.deck = new Deck();
  }
  
  /**
   * Player constructor with teamName added as instance variable
   * If teamName is not set, then the class name is used when printed
   * during game play
   */
  public Player(String teamName) {
    this();
    this.teamName = teamName;
  }
  
  /**
   * Gets the player's deck
   * @return Deck of cards
   */
  public Deck getDeck() {
    return this.deck;
  }

  /**
   * Sets the deck with the parameter
   * @param deck Deck to set this player with
   */
  public void setDeck(Deck deck) {
    this.deck = deck;
  }
  
  public void draw(Card card) {
    this.deck.add(card);
  }
  
  public void removeCards(Deck cards) {
    for (Card card : cards.getCards()) {
      this.deck.removeCard(card);
    }
  }
  
  public int getCardCount() {
    return this.deck.getCardCount();
  }
  
  /**
   * Display the player's hand
   * @param player 
   */
  public void displayHand() {
    System.out.println("\n******* "+this.getName()+" *******");
    Card[] cards = this.deck.getCards();
    for (int i=0; i<cards.length; i++) {
      System.out.println(cards[i].getRank()+' '+cards[i].getSuit());
    }
  }
  
  /**
   * Gets the player name
   * @return        Player name
   */
  public String getName() {
    return (this.teamName.equals("")) ? this.getClass().getSimpleName() : this.teamName;
  }
  
  /**
   * The player must override getNextMove
   * @param board Game board
   * @return A position coordinate pair of his/her next move. Returns null
   *          if no move is available
   */
  Deck getNextMove(int total) {
    return null;
  };
  
  public void cardsPlayed(Deck deck) {
    
  }  

}
