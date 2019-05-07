//accepts inputs, prints commands and responses
import java.util.*;

public class UserInterface {    
    private PhoneBook book;
    private Scanner reader;
    
    public UserInterface(){
        book = new PhoneBook();
        this.reader = new Scanner(System.in);
    }
    
    public void start(){
        System.out.println("phone search\n" +
                "available operations:\n" +
                " 1 add a number\n" +
                " 2 search for a number\n" +
                " 3 search for a person by phone number\n" +
                " 4 add an address\n" +
                " 5 search for personal information\n" +
                " 6 delete personal information\n" +
                " 7 filtered listing\n" +
                " x quit\n");        
        while(true){
            System.out.print("command: ");
            String command = this.reader();
            
            if(command.equals("x")){
                break;
            }
            if(command.equals("1")){
                this.addNumber();                
            }
            if(command.equals("2")){
                this.getNumber();
            }
            if(command.equals("3")){
                this.getNameByNumber();
            }
            if(command.equals("4")){
                this.addAddress();
            }
            if(command.equals("5")){                
                this.getAddressNNumber();
            }
            if(command.equals("6")){
                this.deletePerson();
            }
            if(command.equals("7")){
                this.getInfoByKeyword();
            }
            
        }
    }
    
    public String reader(){        
        return this.reader.nextLine();        
    }
    
    public void addNumber(){
        System.out.print("whose number: ");
        String name = this.reader();
        System.out.print("number: ");
        String number = this.reader();
        book.addNumber(name, number);
        System.out.println();
    }
    
    public void getNumber(){
        System.out.print("whose number: ");
        String name = this.reader();
        Set<String> numbers = book.getNumber(name);
        if (numbers == null){
            System.out.println("  not found");
        }
        if(numbers != null){
            for(String n : numbers){
                System.out.println(" " + n);
            }
        }
        System.out.println();
    }
    
    public void getNameByNumber(){
        System.out.print("number: ");
        String number = this.reader();
        System.out.println(" " + book.getNameByNumber(number));
        System.out.println();
    }
    
    public void addAddress(){
        System.out.print("whose address: ");
        String name = this.reader();
        System.out.print("street: ");
        String street = this.reader();
        System.out.print("city: ");
        String city = this.reader();
        book.addAddress(name, street, city);
        System.out.println();
    }
    
    public void getAddressNNumber(){
        System.out.print("whose information: ");
        String name = this.reader();
        this.printAddressNNumber(name);
    }
    
    public void printAddressNNumber(String name){
        if(book.getAddress(name)==null && book.getNumber(name) == null){
            System.out.println("  not found\n");
        }
        if(book.getAddress(name) == null && book.getNumber(name) != null){
            System.out.print("  address unknown");
        }
        else if(book.getAddress(name) != null){
            System.out.print("  address: " + book.getAddress(name));
        }
        if(book.getNumber(name) == null && book.getAddress(name) != null){
            System.out.println("\n  phone number not found\n");
        }
        else if (book.getNumber(name) != null){
            System.out.println("\n  phone numbers:");
            Set<String> numbers = book.getNumber(name);
            for(String n : numbers){
                System.out.println("   " + n);
            }
            System.out.println();
        }
    }
    
    public void deletePerson(){
        System.out.print("whose information: ");
        String name = this.reader();
        System.out.println();
        book.deletePerson(name);
    }
    
    public void getInfoByKeyword(){
        System.out.print("keyword (if empty, all listed): ");
        String keyword = this.reader();
        Set<String> hits = book.getInfoByKeyword(keyword);
        if(hits.isEmpty()){
            System.out.println(" keyword not found\n");
        }
        if(!hits.isEmpty()){
            System.out.println();
            for(String n : hits){
                System.out.println(" " + n);
                this.printAddressNNumber(n);
            }
        }
    }
}
