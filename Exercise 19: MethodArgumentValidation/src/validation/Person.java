package validation;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        if(name == null){
            throw new IllegalArgumentException("You must enter a name");
        }
        if(name.length() ==0 || name.length() >40){
            throw new IllegalArgumentException("Name must be between 1 and 40 characters");
        }
        if(age <0 || age >120){
            throw new IllegalArgumentException("Age must be between 0 and 120");
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
