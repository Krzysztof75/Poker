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

public final class Card {
 private String value;
 private String colour;
 
 Card(){
     this(null,null);
 }
 
 Card(String val, String col){
     value = val;
     colour = col;
 }
 
 Card(int ind){
     switch(ind){
         case 1: value = "2";
                 colour = "heart";
             break;
         case 2: value = "3";
                colour = "heart";
             break;
         case 3: value = "4";
                 colour = "heart";
             break;
         case 4: value = "5";
                colour = "heart";
             break;
         case 5: value = "6";
                colour = "heart";
             break;
         case 6: value = "7";
                colour = "heart";
             break;
         case 7: value = "8";
                 colour = "heart";
             break;
         case 8: value = "9";
                colour = "heart";
             break;
         case 9: value = "10";
                 colour = "heart";
             break;
         case 10: value = "J";
                colour = "heart";
             break;
         case 11: value = "Q";
                 colour = "heart";
             break;
         case 12: value = "K";
                colour = "heart";
             break;   
         case 13: value = "A";
                colour = "heart";
             break;
         case 14: value = "2";
                 colour = "diamond";
             break;
         case 15: value = "3";
                colour = "diamond";
             break;
         case 16: value = "4";
                 colour = "diamond";
             break;
         case 17: value = "5";
                colour = "diamond";
             break;
         case 18: value = "6";
                colour = "diamond";
             break;
         case 19: value = "7";
                colour = "diamond";
             break;
         case 20: value = "8";
                 colour = "diamond";
             break;
         case 21: value = "9";
                colour = "diamond";
             break;
         case 22: value = "10";
                 colour = "diamond";
             break;
         case 23: value = "J";
                colour = "diamond";
             break;
         case 24: value = "Q";
                 colour = "diamond";
             break;
         case 25: value = "K";
                colour = "diamond";
             break;   
         case 26: value = "A";
                colour = "diamond";
             break;
         case 27: value = "2";
                 colour = "club";
             break;
         case 28: value = "3";
                colour = "club";
             break;
         case 29: value = "4";
                 colour = "club";
             break;
         case 30: value = "5";
                colour = "club";
             break;
         case 31: value = "6";
                colour = "club";
             break;
         case 32: value = "7";
                colour = "club";
             break;
         case 33: value = "8";
                 colour = "club";
             break;
         case 34: value = "9";
                colour = "club";
             break;
         case 35: value = "10";
                 colour = "club";
             break;
         case 36: value = "J";
                colour = "club";
             break;
         case 37: value = "Q";
                 colour = "club";
             break;
         case 38: value = "K";
                colour = "club";
             break;   
         case 39: value = "A";
                colour = "club";
             break;
         case 40: value = "2";
                 colour = "spade";
             break;
         case 41: value = "3";
                colour = "spade";
             break;
         case 42: value = "4";
                 colour = "spade";
             break;
         case 43: value = "5";
                colour = "spade";
             break;
         case 44: value = "6";
                colour = "spade";
             break;
         case 45: value = "7";
                colour = "spade";
             break;
         case 46: value = "8";
                 colour = "spade";
             break;
         case 47: value = "9";
                colour = "spade";
             break;
         case 48: value = "10";
                 colour = "spade";
             break;
         case 49: value = "J";
                colour = "spade";
             break;
         case 50: value = "Q";
                 colour = "spade";
             break;
         case 51: value = "K";
                colour = "spade";
             break;   
         case 52: value = "A";
                colour = "spade";       
             break;    
         default: value = null;
                  colour = null;
 }
 }
  public void showCard(){
      System.out.println("value: " + value + " colour: " + colour);
  }
  public String getValue(){
      return value;
  }
  public String getColour(){
      return colour;
  }
}
