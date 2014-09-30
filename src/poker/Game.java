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
public class Game {

    final static String[] fullSuit = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    final static String[] value = new String[]{"high card", "pair", "Two Pairs", "Three of a Kind", "Straight", "Flush", "Full House",
        "Four of a Kind", "Straight Flush", "Royal Flush"};

    // this method will catch pair, 2 pairs, 3ofakind and 4ofakind
    public static void analize(Player p) {
        int[] check = checkedHand(p);
        int high = highestCard(check);
        for (int a : check) {
            System.out.print(a + " ");
        }

        if (hasPair(check) && !hasThree(check)) {
            System.out.println(p.getName() + " has a pair!");
        }

        if (has2Pairs(check)) {
            System.out.println(p.getName() + " has two pairs!");
        }
        for (int i = 0; i < check.length - 4; i++) {
            if (check[i] == 2) {
                System.out.println(fullSuit[i] + "'s ");
            }
        }
        if (hasThree(check) && !hasPair(check)) {
            System.out.println(p.getName() + " has three of a kind!");
        }
        if (hasFullHouse(check)) {
            System.out.println(p.getName() + " has a full house!");
        }
        if (hasFour(check)) {
            System.out.println(p.getName() + " has a four of a kind!");
        }
        if (hasFlush(check)) {
            if (highestCard(check)==12) {
                System.out.println("You have a Royal Flush!!!");
            } else {
                System.out.println(p.getName() + " has a flush!");
            }
        }
        if (hasStraight(check)) {
            System.out.println(p.getName() + " has straight!");
        }
        if (!hasPair(check) && !has2Pairs(check) && !hasThree(check)
                && !hasFullHouse(check) && !hasFour(check) && !hasFlush(check)
                && !hasStraight(check)) {
            System.out.print("Your highest card " + fullSuit[high]);
            
        }

    }
    /*
     public static void analize(Player p1, Player p2) {

     analize(p1);
     analize(p2);

     int[] p1hand = checkedHand(p1);
     int[] p2hand = checkedHand(p2);
     for (int i = 0; i < checkedHand(p1).length; i++) {
            
     }
     }
     */

    private static int[] checkedHand(Player p) {

        int[] counts = new int[17]; // array to store info about the hand
        // checking for figures
        for (Card card : p.hand) {
            switch (card.getValue()) {
                case "2":
                    counts[0]++;
                    break;
                case "3":
                    counts[1]++;
                    break;
                case "4":
                    counts[2]++;
                    break;
                case "5":
                    counts[3]++;
                    break;
                case "6":
                    counts[4]++;
                    break;
                case "7":
                    counts[5]++;
                    break;
                case "8":
                    counts[6]++;
                    break;
                case "9":
                    counts[7]++;
                    break;
                case "10":
                    counts[8]++;
                    break;
                case "J":
                    counts[9]++;
                    break;
                case "Q":
                    counts[10]++;
                    break;
                case "K":
                    counts[11]++;
                    break;
                case "A":
                    counts[12]++;

            }
        }
        //checking for colours 
        for (Card card : p.hand) {
            switch (card.getColour()) {
                case "heart":
                    counts[13]++;
                    break;
                case "diamond":
                    counts[14]++;
                    break;
                case "spade":
                    counts[15]++;
                    break;
                case "club":
                    counts[16]++;
            }
        }

        return counts;

    }

    // the sum equals 2 if there is only one pair in the player's hand
    public static boolean hasPair(int[] h) {
        for (int i = 0; i < 13; i++) {
            if (h[i] == 2 && !has2Pairs(h)) {
                return true;
            }
        }
        return false;
    }

    // count will increase by one each time there is a pair
    public static boolean has2Pairs(int[] h) {
        int count = 0;
        for (int i = 0; i < 13; i++) {
            if (h[i] == 2) {
                count++;
            }
        }
        return (count == 2);
    }

    public static boolean hasThree(int[] h) {
        for (int i = 0; i < 13; i++) {
            if (h[i] == 3) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasFullHouse(int[] h) {
        boolean threeOfaKind = false;
        boolean twoOfaKind = false;
        for (int i = 0; i < 13; i++) {
            if (h[i] == 2) {
                twoOfaKind = true;
            }
            if (h[i] == 3) {
                threeOfaKind = true;
            }
        }
        return (twoOfaKind && threeOfaKind);
    }

    public static boolean hasFour(int[] h) {
        for (int i = 0; i < 13; i++) {
            if (h[i] == 4) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasFlush(int[] h) {
        for (int i = 13; i < 17; i++) {
            if (h[i] == 5) {
                return true;
            }
        }
        return false;
    }

    // the hand has to be sorted prior to running this method
    public static boolean hasStraight(int[] h) {
        int index = -1;
        for (int i = 0; i < h.length; i++) {
            if (h[i] == 1) {
                index = i;
                break;
            }
        }
        if (index < 8 && index > 0) {
            return (h[index] == h[index + 1] && h[index] == h[index + 2] && h[index]
                    == h[index + 3] && h[index] == h[index + 4]);

        } else if (index == 0) {

            return (h[index] == h[index + 1] && h[index] == h[index + 2] && h[index]
                    == h[index + 3] && (h[index] == h[index + 4] || h[index] == h[index + 12]));
        } else {
            return false;
        }
    }

    // will compare hand to the fullSuit and return highest index
    public static int highestCard(int[] check) {

        int max = 0;
        for (int i = 12; i >= 0; i--) {
            if (check[i] == 1) {
                max = i;
                break;
            }

        }
        return max;

    }

}
