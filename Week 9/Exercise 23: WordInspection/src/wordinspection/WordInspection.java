package wordinspection;
import java.io.*;
import java.util.*;

public class WordInspection {    
    private List<String> fileList;    
    public WordInspection(File file) throws Exception{
        this.fileList = this.reader(file);        
    }
    
    public int wordCount(){ 
        return this.fileList.size();
    }
    
    public List<String> wordsContainingZ(){
        ArrayList<String> wordZ = new ArrayList<String>();
        for(String s: this.fileList){
            if(s.contains("z")){
                wordZ.add(s);
            }
        }
        return wordZ;
    }
    
    public final List<String> reader(File file) throws Exception{
        ArrayList<String> readLines = new ArrayList<String>();
        Scanner reader = new Scanner(file, "UTF-8");
        while(reader.hasNextLine()){
            String line = reader.nextLine();
            readLines.add(line);
        }
        return readLines;
    }
    
    public List<String> wordsEndingInL(){
        ArrayList<String> wordL = new ArrayList<String>();
        for (String s: this.fileList){
            int size = s.length();            
            if(s.charAt(size-1) == 'l'){
                wordL.add(s);
            }
        }       
        return wordL;
    }
    
    public List<String> palindromes(){
        ArrayList<String> wordPalin = new ArrayList<String>();
        for(String s: this.fileList){
            int wordLength = s.length()-1;
            String reversed = "";
            while(wordLength>=0){
                reversed = reversed+ s.charAt(wordLength);
                wordLength--;
            }
            if (s.equals(reversed)){
                wordPalin.add(s);
            }
        }
        return wordPalin;
    }
    
    public List<String> wordsWhichContainAllVowels(){
        char[] finVowels = new char[]{'a','e','i','o','u','y','ä','ö'};
        ArrayList<String> wordVow = new ArrayList<String>();
        for (String s: this.fileList){
            int test = 1;
            for(Character c : finVowels){
                String vowel = Character.toString(c);
                if(!s.contains(vowel)){
                    test = 0;
                }
            }
            if(test ==1){
                wordVow.add(s);
            }
        }
        return wordVow;
    }
    
}
