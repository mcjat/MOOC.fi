//exercise to show how Strings may be sorted using compareTo()


public class Main {


    public static void main(String[] args){
        Student first = new Student("jamo");
        Student second = new Student("jamo1");
        System.out.println(first.compareTo(second));
    }
}


public class Student implements Comparable<Student>{

    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
    
    @Override
    public int compareTo(Student stud){
        return this.name.compareToIgnoreCase(stud.getName());
    }

}
