//exercise which creates card objects and allows them to be sorted in various ways

public class Main {

    public static void main(String[] args) {
        // write some test code here
        Hand hand = new Hand();

        hand.add( new Card(12, Card.HEARTS) );
        hand.add( new Card(4, Card.CLUBS) );
        hand.add( new Card(2, Card.DIAMONDS) );
        hand.add( new Card(14, Card.CLUBS) );
        hand.add( new Card(7, Card.HEARTS) );
        hand.add( new Card(2, Card.CLUBS) );

        hand.sortAgainstSuit();

        hand.print();
    }
}


public class Card implements Comparable<Card>{

    /*
     * These are static constant variables. These variables can be used inside and outside
     * of this class like, for example, Card.CLUBS
     */
    public static final int SPADES = 0;
    public static final int DIAMONDS = 1;
    public static final int HEARTS = 2;
    public static final int CLUBS = 3;
    /*
     * To make printing easier, Card-class also has string arrays for suits and values.
     * SUITS[suit] is a string representation of the suit (Clubs, Diamonds, Hearts, Spades)
     * VALUES[value] is an abbreviation of the card's value (A, J, Q, K, [2..10]).
     */
    public static final String[] SUITS = {"Spades", "Diamonds", "Hearts", "Clubs"};
    public static final String[] VALUES = {"-", "-", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private int value;
    private int suit;

    public Card(int value, int suit) {
        this.value = value;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return VALUES[value] + " of " + SUITS[suit];
    }

    public int getValue() {
        return value;
    }

    public int getSuit() {
        return suit;
    }
    
    //returns a card value which factors in the suit, but ensures that cards are primarily sorted in order of point value 
    public int totalCardValue(){
        int cardValue = this.getValue()*100;
        cardValue += this.getSuit();
        return cardValue;
    }
    
    @Override
    public int compareTo(Card card){
        return this.totalCardValue() - card.totalCardValue();
    }
}



import java.util.ArrayList;
import java.util.Collections;
public class Hand implements Comparable<Hand>{
    private ArrayList<Card> handOfCards;
    public Hand(){
        handOfCards = new ArrayList<Card>();
    }
    
    public void add(Card card){
        this.handOfCards.add(card);
    }
    
    public void print(){
        for(Card c : this.handOfCards){
            System.out.println(c.toString());
        }
    }
    
    public void sort(){
        Collections.sort(this.handOfCards);
    }
   
    //provides the sum of point values of all cards, ignoring suit
    public int handValueNoSuit(){
        int handValue = 0;
        for (Card c : this.handOfCards){
            handValue += c.getValue();
        }
        return handValue;
    }
    
    //sorts in order of Suit before sorting in order of Value (e.g. 5 of Hearts, 7 of Hearts, 2 of Clubs, 4 of Clubs)
    public void sortAgainstSuit(){
        SortAgainstSuitAndValue cardSort = new SortAgainstSuitAndValue();        
        Collections.sort(handOfCards, cardSort);
    }
    
    @Override
    public int compareTo(Hand hand){
        return this.handValueNoSuit() - hand.handValueNoSuit();
    }
}

import java.util.Comparator;
public class SortAgainstSuit implements Comparator<Card>{
    public int compare(Card card1, Card card2){
        return card1.getSuit() - card2.getSuit();
    } 
}

//allows user to sort by suit, and card value within each suit
import java.util.Comparator;
public class SortAgainstSuitAndValue implements Comparator<Card>{
    public int compare(Card card1, Card card2){
        int card1Value = card1.getValue() + (card1.getSuit()*100);
        int card2Value = card2.getValue() + (card2.getSuit()*100);
        return card1Value - card2Value;
    }
    
}
