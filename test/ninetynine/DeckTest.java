/*
 * Copyright 2018 Roger Jaffe
 * All rights reserved
 */
package ninetynine;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Roger Jaffe
 */
public class DeckTest {
  
  public DeckTest() {
  }
  
  @BeforeClass
  public static void setUpClass() {
  }
  
  @AfterClass
  public static void tearDownClass() {
  }
  
  @Before
  public void setUp() {
  }
  
  @After
  public void tearDown() {
  }

  /**
   * Test of deal method, of class Deck.
   */
  @Test
  public void testDeal_0args() {
    Card card = new Card(Constants.TWO, Constants.HEARTS);
    Deck instance = new Deck();
    instance.add(card);
    Card expResult = card;
    Card result = instance.deal();
    assertEquals(expResult, result);
  }

  /**
   * Test of getCard method, of class Deck.
   */
  @Test
  public void testGetCard_int() {
    Card card1 = new Card(Constants.TWO, Constants.HEARTS);
    Card card2 = new Card(Constants.THREE, Constants.HEARTS);
    Deck instance = new Deck();
    instance.add(card1);
    instance.add(card2);
    Card expResult = card1;
    Card result = instance.getCard(0);
    assertEquals(expResult, result);
  }

  /**
   * Test of getCardCount method, of class Deck.
   */
  @Test
  public void testGetCardCount() {
    Card card1 = new Card(Constants.TWO, Constants.HEARTS);
    Card card2 = new Card(Constants.THREE, Constants.HEARTS);
    Deck instance = new Deck();
    instance.add(card1);
    instance.add(card2);
    int expResult = 2;
    int result = instance.getCardCount();
    assertEquals(expResult, result);
  }

  /**
   * Test of newDeck method, of class Deck.
   */
  @Test
  public void testNewDeck() {
    System.out.println("newDeck");
    Deck instance = new Deck();
    instance.newDeck();
    assertEquals(52, instance.getCardCount());
  }

  /**
   * Test of shuffle method, of class Deck.
   */
  @Test
  public void testShuffle() {
    Card card1 = new Card(Constants.TWO, Constants.HEARTS);
    Card card2 = new Card(Constants.THREE, Constants.HEARTS);
    Deck instance = new Deck();
    instance.add(card1);
    instance.add(card2);
    instance.shuffle();
    assertEquals(2, instance.getCardCount());
  }

  /**
   * Test of sort method, of class Deck.
   */
  @Test
  public void testSort() {
    Card card1 = new Card(Constants.TWO, Constants.HEARTS);
    Card card2 = new Card(Constants.THREE, Constants.HEARTS);
    Card card3 = new Card(Constants.SIX, Constants.HEARTS);
    Card card4 = new Card(Constants.JACK, Constants.HEARTS);
    Deck instance = new Deck();
    instance.add(card1);
    instance.add(card2);
    instance.add(card3);
    instance.add(card4);
    instance.sort();
    assertEquals(card1, instance.getCard(0));
    assertEquals(card2, instance.getCard(1));
    assertEquals(card3, instance.getCard(2));
    assertEquals(card4, instance.getCard(3));
  }

  /**
   * Test of findPairs method, of class Deck.
   */
  @Test
  public void testFindPairs() {
    Card card1 = new Card(Constants.FOUR, Constants.HEARTS);
    Card card2 = new Card(Constants.TWO, Constants.CLUBS);
    Card card3 = new Card(Constants.FOUR, Constants.CLUBS);
    Card card4 = new Card(Constants.JACK, Constants.HEARTS);
    Deck instance = new Deck();
    instance.add(card1);
    instance.add(card2);
    instance.add(card3);
    instance.add(card4);
    ArrayList<Deck> result = instance.findPairs();
    assertEquals(card1, result.get(0).getCard(0));
    assertEquals(card3, result.get(0).getCard(1));
  }

  /**
   * Test of findPairs method, of class Deck.
   */
  @Test
  public void testFindPairs2() {
    Card card1 = new Card(Constants.FOUR, Constants.HEARTS);
    Card card2 = new Card(Constants.TWO, Constants.CLUBS);
    Card card3 = new Card(Constants.FOUR, Constants.CLUBS);
    Card card4 = new Card(Constants.TWO, Constants.HEARTS);
    Deck instance = new Deck();
    instance.add(card1);
    instance.add(card2);
    instance.add(card3);
    instance.add(card4);
    ArrayList<Deck> result = instance.findPairs();
    assertEquals(card1, result.get(1).getCard(0));
    assertEquals(card3, result.get(1).getCard(1));
    assertEquals(card2, result.get(0).getCard(0));
    assertEquals(card4, result.get(0).getCard(1));
  }

  /**
   * Test of isEmptyDeck method, of class Deck.
   */
  @Test
  public void testIsEmptyDeck() {
    Deck instance = new Deck();
    assertEquals(true, instance.isEmptyDeck());
    Card card1 = new Card(Constants.FOUR, Constants.HEARTS);
    instance.add(card1);
    assertEquals(false, instance.isEmptyDeck());
  }

  /**
   * Test of getCards method, of class Deck.
   */
  @Test
  public void testGetCards() {
    Deck instance = new Deck();
    Card card1 = new Card(Constants.ACE, Constants.HEARTS);
    Card card2 = new Card(Constants.TWO, Constants.CLUBS);
    Card card3 = new Card(Constants.THREE, Constants.CLUBS);
    Card card4 = new Card(Constants.FOUR, Constants.HEARTS);
    instance.add(card1);
    instance.add(card2);
    instance.add(card3);
    instance.add(card4);
    Card[] expResult = {card1, card2, card3, card4};
    Card[] result = instance.getCards();
    assertArrayEquals(expResult, result);
  }

  /**
   * Test of getCards method, of class Deck.
   */
  @Test
  public void testGetCards2() {
    Deck instance = new Deck();
    Card[] expResult = null;
    Card[] result = instance.getCards();
    assertArrayEquals(expResult, result);
  }

  /**
   * Test of add method, of class Deck.
   */
  @Test
  public void testAdd_Card() {
    Card card = new Card(Constants.TWO, Constants.HEARTS);
    Deck instance = new Deck();
    instance.add(card);
    assertEquals(1, instance.getCardCount());
    assertEquals(card, instance.getCard());
  }

  /**
   * Test of add method, of class Deck.
   */
  @Test
  public void testAdd_Deck() {
    Card card1 = new Card(Constants.TWO, Constants.HEARTS);
    Card card2 = new Card(Constants.THREE, Constants.HEARTS);
    Deck deckToAdd = new Deck();
    deckToAdd.add(card1);
    deckToAdd.add(card2);
    Deck instance = new Deck();
    instance.add(deckToAdd);
    assertEquals(2, instance.getCardCount());
    assertEquals(card1, instance.getCard());
    assertEquals(card2, instance.getCard(1));
  }

  /**
   * Test of removeCard method, of class Deck.
   */
  @Test
  public void testRemoveCard_Card() {
    Card card1 = new Card(Constants.TWO, Constants.HEARTS);
    Card card2 = new Card(Constants.THREE, Constants.HEARTS);
    Deck deck = new Deck();
    deck.add(card1);
    deck.add(card2);
    deck.removeCard(card2);
    assertEquals(1, deck.getCardCount());
    assertEquals(card1, deck.getCard());
  }

  /**
   * Test of removeCard method, of class Deck.
   */
  @Test
  public void testRemoveCard_Deck() {
    Card card1 = new Card(Constants.TWO, Constants.HEARTS);
    Card card2 = new Card(Constants.THREE, Constants.HEARTS);
    Card card3 = new Card(Constants.KING, Constants.SPADES);
    Deck deck1 = new Deck();
    deck1.add(card1);
    deck1.add(card2);
    deck1.add(card3);
    Deck deck2 = new Deck();
    deck2.add(card1);
    deck2.add(card2);
    deck1.removeCard(deck2);
    assertEquals(1, deck1.getCardCount());
    assertEquals(card3, deck1.getCard());
  }

  /**
   * Test of deal method, of class Deck.
   */
  @Test
  public void testDeal() {
    Card card1 = new Card(Constants.TWO, Constants.HEARTS);
    Card card2 = new Card(Constants.THREE, Constants.HEARTS);
    Deck instance = new Deck();
    instance.add(card1);
    instance.add(card2);
    Card expResult = card1;
    Card result = instance.deal();
    assertEquals(expResult, result);
    assertEquals(1, instance.getCardCount());
  }

  /**
   * Test of getCard method, of class Deck.
   */
  @Test
  public void testGetCard_0args() {
    Card card1 = new Card(Constants.TWO, Constants.HEARTS);
    Card card2 = new Card(Constants.THREE, Constants.HEARTS);
    Deck instance = new Deck();
    instance.add(card1);
    instance.add(card2);
    Card expResult = card1;
    Card result = instance.getCard();
    assertEquals(expResult, result);
  }

}
