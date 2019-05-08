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
