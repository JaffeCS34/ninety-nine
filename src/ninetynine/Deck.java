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
   * Add a card to this deck
   * @param card Card to add
   */
  public void add(Card card) {
    this.cards.add(card);
    this.sort();
  }
  
  /**
   * Get the top card from this deck and return it
   * @return Dealt card
   */
  public Card deal() {
    return this.deal(0);
  }

  /**
   * Deal the card at index idx and remove from this deck
   * @param idx Index of card to remove
   * @return Dealt card
   */
  public Card deal(int idx) {
    if (0 <= idx && idx < this.cards.size())
      return this.cards.remove(idx);
    else
      return null;
  }
  
  public void removeCard(Card card) {
    this.cards.remove(card);
  }
  
  /**
   * Get an individual card from the deck but DO NOT remove it!
   * @param idx
   * @return 
   */
  public Card getCard(int idx) {
    if (0 <= idx && idx < this.cards.size()) 
      return this.cards.get(idx);
    else
      return null;
  }
  
  /**
   * Gets the number of cards in this deck
   * @return card count
   */
  public int getCardCount() {
    return this.cards.size();
  }
  
  public Card[] getCards() {
    if (this.getCardCount() == 0) return null;    
    Card[] cards = new Card[this.getCardCount()];
    for (int i=0; i<this.getCardCount(); i++) {
      cards[i] = this.getCard(i);
    }
    return cards;
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
   * Sorts the cards in the deck
   */
  public void sort() {
    Collections.sort(cards, new SortByCard());
  }
  
  /**
   * Gets all the card pairs by rank only
   * @return ArrayList of Decks with the cards that form each pair
   */
  public ArrayList<Deck> findPairs() {
    ArrayList<Deck> pairs = new ArrayList<>();
    for (int i = 0; i < cards.size()-1; i++) {
      for (int j = i+1; j < cards.size(); j++) {
        if (cards.get(i).getRank().equals(cards.get(j).getRank())) {
          Deck d = new Deck();
          d.add(this.getCard(i));
          d.add(this.getCard(j));
          pairs.add(d);
        }
      }
    }
    return pairs;
  }
  
  /**
   * Check if deck is empty
   * @return 
   */
  public boolean isEmptyDeck() {
    return this.cards.isEmpty();
  }
  
}
