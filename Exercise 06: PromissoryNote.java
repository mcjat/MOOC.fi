//exercise has us creating a small simple database for storing loan information

public class Main {
    public static void main(String[] args) {
        // Test your program here
        
    PromissoryNote mattisNote = new PromissoryNote();
    mattisNote.setLoan("Arto", 51.5);
    mattisNote.setLoan("Mikael", 30);

    System.out.println(mattisNote.howMuchIsTheDebt("Arto"));
    System.out.println(mattisNote.howMuchIsTheDebt("Joel"));
    }
}

//below is the loan structure

import java.util.HashMap;        
public class PromissoryNote {
    
    private HashMap<String, Double> loans;
    
    public PromissoryNote(){
      this.loans = new HashMap<String, Double>();  
    }
    
    public void setLoan(String toWhom, double value){        
        this.loans.put(toWhom, value);

    }
    
    public double howMuchIsTheDebt(String whose){
        if(this.loans.containsKey(whose)){
            return this.loans.get(whose);
        }
        return 0;        
    }
    
    
}
