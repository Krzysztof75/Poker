/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import java.util.*;

/**
 *
 * @author Kris
 */
public class PokerRunTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner console = new Scanner(System.in);
        int pl = 0;
        Player[] players = new Player[4];
        String cleanline;
        boolean letsplay = true; // to continue the game?

        while (letsplay) {

            do {

                System.out.println("How many players? (max 4 players)");

                pl = console.nextInt();
                if (pl <= 0 || pl > 4) {
                    System.out.println("The number of players must be between 1 and 4");

                }

            } while (pl <= 0 || pl > 4);

            System.out.println("Enter the name of first player:");
            players[0] = new Player(console.next());

            for (int i = 1; i < pl; i++) {
                System.out.println("Name of the next player?:");
                players[i] = new Player(console.next());
            }
            DeckofCards deck = new DeckofCards();

            // deal cards to all players
            for (int i = 0; i < pl; i++) {
                deck.deal(deck, players[i]);
                System.out.println();
                System.out.println(players[i].getName());
                players[i].showHand();
            }

            //change cards
            int n = 0;
            int cardschanged;
            int pos1 = 0, pos2 = 0, pos3 = 0, pos4 = 0;  // variables to store positions of cards to exchange
            while (n < pl) {
                do {
                    System.out.println(players[n].getName() + " How many cards would you like to exchange? (max 4) ");
                    cardschanged = console.nextInt();
                    if (cardschanged >= 0 && cardschanged < 5) {
                        do {
                            if (cardschanged != 0) {
                                System.out.println("enter their location followed by enter ");
                            }

                            switch (cardschanged) {
                                case 1:
                                    players[n].changeCard(deck, pos1 = console.nextInt());
                                    break;
                                case 2:
                                    players[n].changeCard(deck, pos1 = console.nextInt(), pos2 = console.nextInt());
                                    break;
                                case 3:
                                    players[n].changeCard(deck, pos1 = console.nextInt(), pos2 = console.nextInt(), pos3 = console.nextInt());
                                    break;
                                case 4:
                                    players[n].changeCard(deck, pos1 = console.nextInt(), pos2 = console.nextInt(),
                                            pos3 = console.nextInt(), pos4 = console.nextInt());
                            }
                        } while (pos1 < 0 || pos1 > 5 || pos2 < 0 || pos2 > 5 || pos3 < 0 || pos3 > 5 || pos4 < 0 || pos4 > 5);
                    }

                } while (cardschanged < 0 || cardschanged > 4);
                n++;
            }
            for (int i = 0; i < pl; i++) {
                System.out.println("\n" + players[i].getName());
                players[i].showHand();
                players[i].sortHand(players[i].hand);
                Game.analize(players[i]);

            }
            String answer;
            boolean ok;
            do {
                System.out.println("\nWould you like to play again? (yes/no)");
                answer = console.next();

                if (answer.equalsIgnoreCase("no")) {
                    letsplay = false;
                    ok = true;
                } else if (answer.equalsIgnoreCase("yes")) {
                    ok = true;
                } else {
                    ok = false;
                }

            } while (!ok);

        }
    }
}
/*
 DeckofCards deck = new DeckofCards();
 Player player1 = new Player();
 Player player2 = new Player("Kris");
 Player player3 = new Player("Johanna", 200);
 Player player4 = new Player();
        
 System.out.println("Display random deck of cards: ");
 deck.showDeck();
 System.out.println();
        
 System.out.println("Player 1 name: //default constructor: player name:" + player1.getName() + " player's money: " + player1.getMoney());
 System.out.println("Player 2 name: //second constructor: player name:  " + player2.getName() + " player's money: " + player2.getMoney());
 System.out.println("Player 3 name: //third constructor: player name:   " + player3.getName() + " player's money: " + player3.getMoney());
 System.out.println();
        
 int betMoney = player1.bet(10);
 System.out.println("The amount of bet: " + betMoney);
 System.out.println("The amount of money left for player 1 after the bet: " + player1.getMoney());
 System.out.println();
        
 System.out.println("Player2 bets 110 (more than he/she has) ");
 player2.bet(110);
 System.out.println();
 /* 
 for(int i = 1; i <= 53; i++){
 System.out.print("Card " + i + " ");  deck.get().show();
 }
               
 System.out.println();
    
 System.out.println("Dealing cards to player3");
 deck.deal(deck, player3);
 System.out.println("Display Player3 hand:");
 for(Card card : player3.hand)
 card.showCard();
 System.out.println();
    
 System.out.println("Player3 changes card 3");
 player3.changeCard(deck, 3);
 System.out.println("Display Player3 hand:");
 for(Card card : player3.hand)
 card.showCard();
 System.out.println();
    
    
 System.out.println("Dealing cards to player1 and player2");
 deck.deal(deck, player1, player2);
   
 System.out.println("Display hands of player 1:");
 for(Card card : player1.hand)
 card.showCard();
    
 System.out.println();
 System.out.println("Player 1 changes 4 cards");
 player1.changeCard(deck, 2, 3, 4, 5);
 System.out.println("Player1 display his/her hand:");
 player1.showHand();
 System.out.println();
            
 System.out.println("Display hands of player 2:");
 for(Card card : player2.hand)
 card.showCard();
 System.out.println();
    
 System.out.println("Clear all hands");
 player1.clearHand();
 player2.clearHand();
 player3.clearHand();
    
 System.out.println();
    
 System.out.println("Dealing 3 players and displaying their cards");
 deck.deal(deck, player1, player2, player3);
    
 System.out.println("Display hands of player 1:");
 for(Card card : player1.hand)
 card.showCard();
            
 System.out.println("Display hands of player 2:");
 for(Card card : player2.hand)
 card.showCard();
    
 System.out.println("Display hands of player 3:");
 for(Card card : player3.hand)
 card.showCard();
    
 System.out.println("Clear all hands ");
 player1.clearHand();
 player2.clearHand();
 player3.clearHand();
    
 DeckofCards deck1 = new DeckofCards();
    
 System.out.println("Dealing 4 players and displaying their cards");
 deck1.deal(deck1, player1, player2, player3, player4);
    
 System.out.println("Display hands of player 1:");
 for(Card card : player1.hand)
 card.showCard();
            
 System.out.println("Display hands of player 2:");
 for(Card card : player2.hand)
 card.showCard();
    
 System.out.println("Display hands of player 3:");
 for(Card card : player3.hand)
 card.showCard();
    
 System.out.println("Display hands of player 4:");
 for(Card card : player4.hand)
 card.showCard();
    
 System.out.println("Running out of cards");
 deck.deal(deck, player4, player3, player2, player1);
 System.out.println();
 System.out.println("New deck. Deal p1 & p2, show p1.hand");
 DeckofCards deck2 = new DeckofCards();
    
 deck2.deal(deck2, player1, player2);
    
 player1.showHand();
 System.out.println("Sorting p1 hand and displaying sorted");
 player1.sortHand(player1.hand);
 player1.showHand();
 System.out.println();
    
 player2.showHand();
 player2.sortHand(player2.hand);
 Game.analize(player2);
 System.out.println();
 System.out.println("The highest card of player2: " + Game.highestCard(player2));
 System.out.println();
    
 player1.hand = new Card[]{new Card("4", "hearts"), new Card("3", "club"), new Card("2", "diamond"),
 new Card("5", "spade"), new Card("A", "heart")};
    
 player1.sortHand(player1.hand);
 player1.showHand();
 Game.analize(player1);
                  
 player2.hand = new Card[]{new Card("A", "heart"), new Card("A", "club"),
 new Card("A", "diamond"), new Card("2", "club"), new Card("2", "heart")};
 player2.showHand();
 Game.analize(player2);
    
 player3.hand = new Card[]{new Card("7", "heart"), new Card("3", "heart"), new Card("4", "heart"),
 new Card("5", "heart"), new Card("6", "heart")};
 player3.sortHand(player3.hand);
 player3.showHand();
 Game.analize(player3);
    
 player4.hand = new Card[]{new Card("2", "hearts"), new Card("2", "club"), new Card("4", "diamond"),
 new Card("4", "spade"), new Card("6", "heart")};
 player4.showHand();
 Game.analize(player4);
 }
    
 }
 */
