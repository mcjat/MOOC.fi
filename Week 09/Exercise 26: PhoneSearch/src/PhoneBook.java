//maintains all necessary user information
import java.util.*;

public class PhoneBook {    
    private Map<String, Set<String>> namesNPhoneNumbers;
    private Map<String, String> namesNAddresses;
    
    public PhoneBook(){
        this.namesNAddresses = new HashMap<String, String>();
        this.namesNPhoneNumbers = new HashMap<String, Set<String>>();
    }
    
    public void addNumber(String name, String number){
        if(!this.namesNPhoneNumbers.containsKey(name)){
            this.namesNPhoneNumbers.put(name, new HashSet<String>());
        }
        Set<String> numbers = this.namesNPhoneNumbers.get(name);
        numbers.add(number);
    }
    
    public Set<String> getNumber(String name){
        if(!this.namesNPhoneNumbers.containsKey(name)){
            return null;
        }
        return this.namesNPhoneNumbers.get(name);
    }
    
    public String getNameByNumber(String number){
        String name = " not found";
        for(String n : this.namesNPhoneNumbers.keySet()){            
            for(String s : this.getNumber(n)){
                if(s.contains(number)){
                    name = n;
                }
            }
        }
        return name;
    }
    
    public void addAddress(String name, String street, String city){
        String address = street + " " + city;
        if(!this.namesNAddresses.containsKey(name)){
            this.namesNAddresses.put(name, address);
        }
       
    }
    
    public String getAddress(String name){
        if(!this.namesNAddresses.containsKey(name)){
            return null;
        }
        return this.namesNAddresses.get(name);
    }
    
    public void deletePerson(String name){
        this.namesNAddresses.remove(name);
        this.namesNPhoneNumbers.remove(name);
    }
    
    public Set<String> getInfoByKeyword(String keyword){
        Set<String> hits = new TreeSet<String>();

        for(String n : this.namesNAddresses.keySet()){
            if(n.contains(keyword) || this.namesNAddresses.get(n).contains(keyword)){
                hits.add(n);
            }
        }
        for(String n : this.namesNPhoneNumbers.keySet()){
            if(n.contains(keyword)){
                hits.add(n);
            }
        }
        return hits;
    }
}
