import java.util.Comparator;

public class SortAgainstSuitAndValue implements Comparator<Card>{
    public int compare(Card card1, Card card2){
        int card1Value = card1.getValue() + (card1.getSuit()*100);
        int card2Value = card2.getValue() + (card2.getSuit()*100);
        return card1Value - card2Value;
    }
}
