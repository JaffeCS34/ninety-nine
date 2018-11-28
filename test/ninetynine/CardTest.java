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
public class CardTest {
  
  public CardTest() {
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
   * Test of getRank method, of class Card.
   */
  @Test
  public void testGetRank() {
    Card instance = new Card(Constants.TEN, Constants.HEARTS);
    String expResult = Constants.TEN;
    String result = instance.getRank();
    assertEquals(expResult, result);
  }

  /**
   * Test of getRankInt method, of class Card.
   */
  @Test
  public void testGetRankInt() {
    Card instance = new Card(Constants.TEN, Constants.HEARTS);
    int expResult = 10;
    int result = instance.getRankInt();
    assertEquals(expResult, result);
    instance = new Card(Constants.QUEEN, Constants.HEARTS);
    expResult = 12;
    result = instance.getRankInt();
    assertEquals(expResult, result);
  }

  /**
   * Test of getSuit method, of class Card.
   */
  @Test
  public void testGetSuit() {
    Card instance = new Card(Constants.TEN, Constants.SPADES);
    String expResult = Constants.SPADES;
    String result = instance.getSuit();
    assertEquals(expResult, result);
  }

  /**
   * Test of getPointValue method, of class Card.
   */
  @Test
  public void testGetPointValue() {
    Card instance = new Card(Constants.EIGHT, Constants.SPADES);
    int expResult = 8;
    int result = instance.getPointValue();
    assertEquals(expResult, result);
  }
  
  /**
   * Test of getPointValue method, of class Card.
   */
  @Test
  public void testGetPointValue2() {
    Card instance = new Card(Constants.QUEEN, Constants.SPADES);
    int expResult = -10;
    int result = instance.getPointValue();
    assertEquals(expResult, result);
  }
  
  /**
   * Test of getPointValue method, of class Card.
   */
  @Test
  public void testGetPointValue3() {
    Card instance = new Card(Constants.JACK, Constants.SPADES);
    int expResult = 0;
    int result = instance.getPointValue();
    assertEquals(expResult, result);
  }
  
  /**
   * Test of getPointValue method, of class Card.
   */
  @Test
  public void testGetPointValue4() {
    Card instance = new Card(Constants.KING, Constants.SPADES);
    int expResult = 99;
    int result = instance.getPointValue();
    assertEquals(expResult, result);
  }

  /**
   * Test of toString method, of class Card.
   */
  @Test
  public void testToString() {
    System.out.println("toString");
    Card instance = new Card(Constants.THREE, Constants.DIAMONDS);
    String expResult = "3 of DIAMONDS";
    String result = instance.toString();
    assertEquals(expResult, result);
  }
  
}
