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
public class Player {

    private String name;
    private int money;
    protected Card[] hand = new Card[5];
    final String[] fullSuit = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    Player() {      // default constructor
        this("comp",100);
    }

    Player(String n) {    // construcor with fixed amount of money
        name = n;
        money = 100;
    }

    Player(String n, int m) {
        name = n;
        money = m;
    }

    public void setName(String n) {
        name = n;
    }

    public void setMoney(int m) {
        money = m;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    // assigns null values in the array hand (empty hand)
    public void clearHand() {
        for (int i = 0; i < 5; i++) {
            hand[i] = null;
        }
    }
    /* extract the amount of the bet from the total amount of money the player
     has and returns the value of the bet
     */
    public Card getCard(Player p, int pos){
     return hand[pos]; 
    } 
    
    
    
    public void showHand() {
        for (Card card : this.hand) {
            card.showCard();
        }
    }

    public Card[] sortHand(Card[] h) {
        Card[] sorted = new Card[h.length];
        int index = 0;

        for (String fullSuit1 : fullSuit) {
            for (Card h1 : h) {
                if (fullSuit1.equals(h1.getValue())) {
                    sorted[index++] = h1;
                }
            }
        }

        return this.hand = sorted;
    }

    public int bet(int b) {
        if (b <= money) {     // check if bet is not higher then amount of money player has
            setMoney(money - b);
            return b;
        } else {
            System.out.println("You don't have enough money!");
        }
        return 0;
    }

    // change one card
    public void changeCard(DeckofCards x, int a) {
        if (a > 5 || a < 1) {
            System.out.println("To change the card use its position between 1-5");
        } else {
            hand[a - 1] = x.get();
        }
    }

    // change two cards
    public void changeCard(DeckofCards x, int a, int b) {
        if (a > 5 || a < 1 || b > 5 || b < 1) {
            System.out.println("To change the card use its position between 1-5");
        } else {
            hand[a - 1] = x.get();
            hand[b - 1] = x.get();
        }
    }

    //change three cards
    public void changeCard(DeckofCards x, int a, int b, int c) {
        if (a > 5 || a < 1 || b > 5 || b < 1 || c > 5 || c < 1) {
            System.out.println("To change the card use its position between 1-5");
        } else {
            hand[a - 1] = x.get();
            hand[b - 1] = x.get();
            hand[c - 1] = x.get();
        }
    }

    //change four cards
    public void changeCard(DeckofCards x, int a, int b, int c, int d) {
        if (a > 5 || a < 1 || b > 5 || b < 1 || c > 5 || c < 1 || d > 5 || d < 1) {
            System.out.println("To change the card use its position between 1-5");
        } else {
            hand[a - 1] = x.get();
            hand[b - 1] = x.get();
            hand[c - 1] = x.get();
            hand[d - 1] = x.get();
        }
    }
}
