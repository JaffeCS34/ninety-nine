/*
 * Copyright 2018 Roger Jaffe
 * All rights reserved
 */
package ninetynine;

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
public class UtilitiesTest {
  
  public UtilitiesTest() {
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
   * Test of getNewTotal method, of class Utilities.
   */
  @Test
  public void testGetNewTotal1() {
    Deck deck = new Deck();
    Card card = new Card(Constants.FOUR, Constants.HEARTS);
    deck.add(card);
    int total = 10;
    int expResult = 14;
    int result = Utilities.getNewTotal(deck, total);
    assertEquals(expResult, result);
  }

  /**
   * Test of getNewTotal method, of class Utilities.
   */
  @Test
  public void testGetNewTotal2() {
    Deck deck = new Deck();
    Card card = new Card(Constants.QUEEN, Constants.HEARTS);
    deck.add(card);
    int total = 15;
    int expResult = 5;
    int result = Utilities.getNewTotal(deck, total);
    assertEquals(expResult, result);
  }

  /**
   * Test of getNewTotal method, of class Utilities.
   */
  @Test
  public void testGetNewTotal3() {
    Deck deck = new Deck();
    Card card = new Card(Constants.KING, Constants.HEARTS);
    deck.add(card);
    int total = 0;
    int expResult = 99;
    int result = Utilities.getNewTotal(deck, total);
    assertEquals(expResult, result);
  }

  /**
   * Test of isLegalMove method, of class Utilities.
   */
  @Test
  public void testIsLegalMove1() {
    Deck deck = new Deck();
    Card card1 = new Card(Constants.FIVE, Constants.HEARTS);
    Card card2 = new Card(Constants.SIX, Constants.HEARTS);
    deck.add(card1);
    deck.add(card2);
    int total = 10;
    assertFalse(Utilities.isLegalMove(deck, total));
  }
  
  /**
   * Test of isLegalMove method, of class Utilities.
   */
  @Test
  public void testIsLegalMove2() {
    Deck deck = new Deck();
    Card card1 = new Card(Constants.FIVE, Constants.HEARTS);
    Card card2 = new Card(Constants.FIVE, Constants.HEARTS);
    deck.add(card1);
    deck.add(card2);
    int total = 10;
    assertTrue(Utilities.isLegalMove(deck, total));
  }
  
  /**
   * Test of isLegalMove method, of class Utilities.
   */
  @Test
  public void testIsLegalMove3() {
    Deck deck = new Deck();
    Card card = new Card(Constants.SIX, Constants.HEARTS);
    deck.add(card);
    int total = 10;
    assertTrue(Utilities.isLegalMove(deck, total));
  }
  
  /**
   * Test of isLegalMove method, of class Utilities.
   */
  @Test
  public void testIsLegalMove4() {
    Deck deck = new Deck();
    Card card = new Card(Constants.SIX, Constants.HEARTS);
    deck.add(card);
    int total = 95;
    assertFalse(Utilities.isLegalMove(deck, total));
  }
  
  /**
   * Test of isLegalMove method, of class Utilities.
   */
  @Test
  public void testIsLegalMove5() {
    Deck deck = new Deck();
    Card card = new Card(Constants.JACK, Constants.HEARTS);
    deck.add(card);
    int total = 95;
    assertTrue(Utilities.isLegalMove(deck, total));
  }
  
  /**
   * Test of isLegalMove method, of class Utilities.
   */
  @Test
  public void testIsLegalMove6() {
    Deck deck = new Deck();
    Card card = new Card(Constants.QUEEN, Constants.HEARTS);
    deck.add(card);
    int total = 95;
    assertTrue(Utilities.isLegalMove(deck, total));
  }
  
  /**
   * Test of isLegalMove method, of class Utilities.
   */
  @Test
  public void testIsLegalMove7() {
    Deck deck = new Deck();
    Card card = new Card(Constants.KING, Constants.HEARTS);
    deck.add(card);
    int total = 95;
    assertTrue(Utilities.isLegalMove(deck, total));
  }
  
}
