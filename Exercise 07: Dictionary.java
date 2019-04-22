//dictionary interface which allows you to manually populate a dictionary and then look up translations

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Dictionary dict = new Dictionary();

        TextUserInterface ui = new TextUserInterface(reader, dict);
        ui.start();
        }
}

import java.util.HashMap;
import java.util.ArrayList;
public class Dictionary {
    
    private HashMap<String, String> translations;
    public Dictionary(){
        this.translations = new HashMap<String, String>();
    }
    
    public void add(String word, String translation){
       this.translations.put(word, translation);
    }
    
    public String translate(String word){
        if(this.translations.containsKey(word)){
            return this.translations.get(word);
        }
        return null;
    }
    
    public int amountOfWords(){
        return this.translations.size();
    }
    
    public ArrayList<String> translationList(){        
        ArrayList<String> translationList = new ArrayList<String>();
        for(String key: this.translations.keySet()){
            translationList.add(key +" = " + this.translations.get(key));
        }
        return translationList;
    }
}

import java.util.Scanner;
public class TextUserInterface {    
    
    private Dictionary dictionary;
    private Scanner reader;
    
    public TextUserInterface(Scanner reader, Dictionary dictionary){
        this.dictionary = dictionary;
        this.reader = reader;
    }
    
    public void start(){
        System.out.println("Statement:\n  add - adds a word pair to the dictionary"
                + "\n  translate - asks a word and prints its translation"
                + "\n  quit - quit the text user interface");        
        while(true){
            System.out.print("Statement: ");
            String command = this.reader.nextLine();
            if (command.contains("quit")){
                System.out.println("Cheers!");
                break;
            }
            if (command.contains("add")){
                this.add();
            }
            if (command.contains("translate")){
                this.translate();
            }
            else{
            System.out.println("Unknown Statement");
            }
            
        }
                
    }
    
    public void add(){
        System.out.print("In Finnish: ");
        String finnish = this.reader.nextLine();
        System.out.print("Translation: ");
        String translation = this.reader.nextLine();
        this.dictionary.add(finnish, translation);
    }
    
    public void translate(){
            System.out.print("Give a word: ");
            String word = reader.nextLine();
            System.out.println("Translation: " + this.dictionary.translate(word));
            }    
}
