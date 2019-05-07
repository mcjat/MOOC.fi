package file;
import java.io.*;
import java.util.Scanner;

public class Analysis {    
    private File file;
    public Analysis(File file){
        this.file = file;
    }
    
    public int lines() throws Exception{
        int lines = 0;
        Scanner reader = new Scanner(this.file);
        while(reader.hasNextLine()){
            reader.nextLine();
            lines++;
        }
        reader.close();
        return lines;
    }
    
    public int characters() throws Exception{
        int characters = 0;
        Scanner reader = new Scanner(this.file);
        while(reader.hasNextLine()){
            String line = reader.nextLine();
            characters += (line.length()+1);
        }
        reader.close();
        return characters;       
    }
}
