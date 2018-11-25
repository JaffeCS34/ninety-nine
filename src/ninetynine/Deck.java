package ninetynine;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Write a description of class Deck here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Deck
{
  private ArrayList<Card> cards;

  /**
   * Constructor for objects of class Deck
   */
  public Deck()
  {
    this.cards = new ArrayList<>();
  }
  
  /**
   * Copies a deck from an existing deck
   * @param deck 
   */
  public Deck(Deck deck) {
    this.cards = deck.getCards();
  }
  
  /**
   * Gets the deck of cards
   * @return ArrayList Deck of cards
   */
  public ArrayList<Card> getCards() {
    return this.cards;
  }
  
  /**
   * Gets the number of cards in this deck
   * @return card count
   */
  public int getCardCount() {
    return this.cards.size();
  }

  /**
   * Are the first two cards the same rank?
   * @return True if cards 0 and 1 are the same rank
   */
  public boolean isPair() {
    return this.cards.get(0).getRank().equals(this.cards.get(1).getRank());
  }
  
  /** 
   * Creates a new deck of cards in order
   */
  public void newDeck() {
    for (String suit : Constants.suits) {
      for (String rank : Constants.ranks) {
        Card card = new Card(rank, suit);
        cards.add(card);
      }
    }
    this.shuffle();
  }
  
  /**
   * Sorts the cards in the deck
   */
  public void sort() {
    Collections.sort(cards, new SortByCard());
  }
  
  /**
   * Gets all the card pairs by rank only
   * @return ArrayList of Decks with the cards that form each pair
   */
  public ArrayList<Deck> getPairs() {
    ArrayList<Deck> pairs = new ArrayList<>();
    for (int i = 0; i < cards.size()-1; i++) {
      for (int j = i+1; j < cards.size(); j++) {
        if (cards.get(i).getRank().equals(cards.get(j).getRank())) {
          Deck d = new Deck();
          d.draw(cards.get(i));
          d.draw(cards.get(j));
          pairs.add(d);
        }
      }
    }
    return pairs;
  }
  
  /**
   * Shuffles the cards in the deck
   */
  public void shuffle() {
    ArrayList<Card> newCards = new ArrayList<>();
    while (this.cards.size() > 0) {
      int pos = (int)(Math.random() * this.cards.size());
      newCards.add(this.cards.get(pos));
      this.cards.remove(pos);
    }
    this.cards = newCards;
  }
  
  /**
   * Receive a drawn card and add to this deck
   * @param card Card to add to the deck
   */
  public void draw(Card card) {
    if (card != null) 
      this.cards.add(card);
    this.shuffle();
  }

  /**
   * Draw a card from the deck and add it to this deck
   * @param deck Deck from which the card should be drawn
   */
  public void draw(Deck deck) {
    this.draw(deck.deal());
    this.sort();
  }
  
  /**
   * Get the top card from this deck and return it
   * @return Dealt card (null if deck is empty)
   */
  public Card deal() {
    if (this.isEmptyDeck()) {
      return null;
    } else {
      return this.cards.remove(0);
    }
  }
  
  /**
   * Remove the specified card by removing it
   * @param card 
   */
  public void remove(Card card) {
    this.cards.remove(card);
  }
  
  /**
   * Check if deck is empty
   * @return 
   */
  public boolean isEmptyDeck() {
    return this.cards.isEmpty();
  }
  
}
