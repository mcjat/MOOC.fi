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
    
    public int handValueNoSuit(){
        int handValue = 0;
        for (Card c : this.handOfCards){
            handValue += c.getValue();
        }
        return handValue;
    }
    
    public void sortAgainstSuit(){
        SortAgainstSuitAndValue cardSort = new SortAgainstSuitAndValue();        
        Collections.sort(handOfCards, cardSort);
    }
    
    @Override
    public int compareTo(Hand hand){
        return this.handValueNoSuit() - hand.handValueNoSuit();
    }
}
