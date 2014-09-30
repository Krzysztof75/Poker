/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package poker;

/**
 *
 * @author Kris
 */
import java.util.Random;


public class DeckofCards {

    Card[] cards;               //array to store references to objects Cards
    final int SIZE = 52;      
    private int[] check;        //array to store the index numbers (avoids forming unnecessary objects/ prevents possible memory leaks 
    private int index;          // random integer number used in the card constructor
    private int count;          // counts the remaining cards in the deck
    /* Pleacing cards randomly in the deck. 
     int[]check stores the index numbers used in the Card constructor to form particular card
     new randomly-formed index numbers are checked inside IsDouble() method against the values
     stored in the array check to reject doubles
     */

    DeckofCards() {

        Random rand = new Random();
        cards = new Card[SIZE];
        check = new int[SIZE];
        /* variable count will show the number of the cards remaining in the deck
           and it will be used in the method deal() as an index to the ramaining cards
        */ 
        count = SIZE;             

        for (int i = 0; i < SIZE; i++) {
            do {
                index = rand.nextInt(SIZE) + 1;

            } while (isDouble(check));
            check[i] = index;
            cards[i] = new Card(index);

        }
       
    }

    private boolean isDouble(int[] ch) {
        for (int i = 0; i < ch.length; i++) {
            if (check[i] == index) {

                return true;
            }
        }

        return false;
    }
    
    public Card get(){
        if(count == 0){
            System.out.println("There is not enough cards to deal in the deck");
            return new Card();   // calling default constructor (value = null, color = null)
        } else {
            count--;
            return cards[count];
        }
    }
    // deal one player 
    public void deal(DeckofCards d,Player p){
    if(count < p.hand.length){
        System.out.println("There is not enough cards in this deck to deal");
    } else {
        for(int i = 0; i < p.hand.length; i++){
          p.hand[i] = d.get();
        }
    }   
    }
    // deal two players
    public void deal(DeckofCards d,Player p1, Player p2){
        if(count < 10){
           System.out.println("There is not enough cards in this deck to deal"); 
    } else {
          for(int i = 0; i < p1.hand.length; i++){   
                  p1.hand[i] = d.get();
                  p2.hand[i] = d.get();
              }
          }
}
    public void deal(DeckofCards d,Player p1, Player p2, Player p3){
            if(count < 15){
           System.out.println("There is not enough cards in this deck to deal"); 
    } else {
          for(int i = 0; i < p1.hand.length; i++){   
                  p1.hand[i] = d.get();
                  p2.hand[i] = d.get();
                  p3.hand[i] = d.get();
              }
          }
    }
    
    public void deal(DeckofCards d,Player p1, Player p2, Player p3, Player p4){
            if(count < 20){
           System.out.println("There is not enough cards in this deck to deal"); 
    } else {
          for(int i = 0; i < p1.hand.length; i++){   
                  p1.hand[i] = d.get();
                  p2.hand[i] = d.get();
                  p3.hand[i] = d.get();
                  p4.hand[i] = d.get();
              }
          }
    }
            
            
    public void showDeck() {
        for (Card card : cards) {
            card.showCard();
        }
    }
   
}

