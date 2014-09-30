/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker.test;
 
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import poker.Game;
import poker.Player;

/**
 *
 * @author Kris
 */
        
       
        
public class pokerJunitTest {
    
    
    public pokerJunitTest() {
  
    }

    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
          int [] score = new int []{1,0,0,1,1,1,1,0,2,1,0,0,0,0,0,0,0,0,0,};
       
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testhasPair(){
        int [] score = new int [] {1,1,0,0,0,2,1,1,1,1,1,1,1,1,1,1,1};
            boolean result = Game.hasPair(score);
            assertTrue("There should be a pair!", result);
    }
    @Test
    public void testhas2Pairs(){
        int [] score = new int [] {0,0,2,1,2,0,0,0,0,0,0,0,1,1,1,1,1};
        boolean result = Game.has2Pairs(score);
        assertTrue("There should 2 pairs!", result);
    }
    @Test
    public void testhasThree(){
        int [] score = new int [] {0,1,1,0,3,0,0,0,0,0,0,2,0,1,0,2};
        boolean result = Game.hasThree(score);
        assertTrue("There should be 3 of a kind",result);
    }
    @Test
    public void testHasFullHouse(){
        int [] score = new int [] {3,0,0,0,0,2,0,0,0,0,0,0,2,1,1,1};
        boolean result = Game.hasFullHouse(score);
        assertTrue("There should be a full house", result);
       
    }
    @Test
    public void testHasFour(){
        int [] score = new int [] {0,0,0,0,0,1,0,0,0,4,0,1,1,1,1,1};
        boolean result = Game.hasFour(score);
        assertTrue("There should be four of a kind", result);
    }
    @Test
    public void testHasFlush(){
        int [] score = new int [] {0,0,1,0,1,1,1,0,0,1,0,0,0,5,0,0,0};
        boolean result = Game.hasFlush(score);
        assertTrue("There should be a flush!", result);
    }
    /*
    @Test
    public void testHighestCard(){
        Player player = new Player("test");
        int [] score = new int [] {0,1,0,1,0,1,1,0,0,0,0,1,0,1,2,1,1};
        int result = Game.highestCard();
        assertEquals()
    }
    */
}
