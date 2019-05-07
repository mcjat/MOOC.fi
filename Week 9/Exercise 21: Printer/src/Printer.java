import java.io.*;
import java.util.Scanner;

public class Printer {    
    private File f;    
    
    public Printer(String fileName) throws Exception{  
        //fileName = "src/" + fileName;
        f = new File(fileName); 
    }
    
    public void printLinesWhichContain(String word) throws Exception{
        Scanner reader = new Scanner(this.f, "UTF-8"); 
        while (reader.hasNextLine()){
            String line = reader.nextLine();
            if(line.contains(word)){                
                System.out.println(line);
            }
        }
        reader.close();
    }
}
