/*  should print out the text wrapped in smileys
*   for example the test case below should print:
*   :):):):):):)
*   :) Method :)
*   :):):):):):)
*   :):):):):):):):)
*   :) Beerbottle :)
*   :):):):):):):):)
*   :):):):):):):):)
*   :) Interface  :)
*   :):):):):):):):)
*/

public class Smileys {    
    private static void printWithSmileys (String characterString) {
        int numberOfSmiles = 0;
        
        if(checkEven(characterString.length())){
            smile((characterString.length()/2)+3);
            System.out.println();
            smile(1);
            System.out.print(" " + characterString + " ");
            smile(1);
            System.out.println();
            smile((characterString.length()/2)+3);
            System.out.println();
        }
        
        if(!checkEven(characterString.length())){
            smile(((characterString.length()+1)/2)+3);
            System.out.println();
            smile(1);
            System.out.print(" " + characterString + "  ");
            smile(1);
            System.out.println();
            smile(((characterString.length()+1)/2)+3);
            System.out.println();
        }
    }
    
    private static void smile(int numberOfSmiles){
        while (numberOfSmiles > 0) {
            System.out.print(":)");
            numberOfSmiles--;
        }
    }
    
    private static boolean checkEven(int numToCheck){
        if (numToCheck%2 == 0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // Test your method at least with the following
        printWithSmileys("Method");
        printWithSmileys("Beerbottle");
        printWithSmileys("Interface");
    }
}
