//exercise which creates card objects and allows them to be sorted in various ways

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
