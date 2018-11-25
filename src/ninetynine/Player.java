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
  private Deck deck;
  private boolean dead;
  
  /**
   * Player constructor
   */
  public Player() {
    this.deck = new Deck();
    dead = false;
  }
  
  /**
   * Getter for dead
   * @return dead
   */
  public boolean isDead() {
    return dead;
  }
  
  /**
   * Getter for "not dead yet"
   * @return not dead
   */
  public boolean isNotDead() {
    return !dead;
  }
  
  /**
   * Setter for dead
   */
  public void setDead() {
    dead = true;
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
  
  /**
   * Draw a card from deck
   * @param deck Deck to draw from
   */
  public void draw(Deck deck) {
    this.deck.draw(deck);
  }
  
  public void remove(Deck deck) {
    deck.getCards().forEach((card) -> {
      this.deck.remove(card);
    });
  }

  /** 
   * Deal a card from this player's deck
   * @return Card dealt
   */
  public Card deal() {
    return deck.deal();
  }
  
  /**
   * Display the player's hand
   * @param player 
   */
  public void displayHand() {
    System.out.println("\n******* PLAYER "+this.getName()+" *******");
    for (Card card : this.deck.getCards()) {
      System.out.println(card.getRank()+' '+card.getSuit());
    }
  }
  
  public void cardsPlayed(Deck deck) {
    
  }
  
  /**
   * Gets the player name
   * @return        Player name
   */
  public String getName() {
    return this.getClass().getSimpleName();
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

}
