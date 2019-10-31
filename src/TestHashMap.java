import java.util.HashMap;
import java.util.Map;

class Student {
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

public class TestHashMap {
    public static void main(String[] args) {
        Student s1 = new Student(1, "Venkat");
        Student s2 = new Student(2, "Ramana");
        Student s3 = new Student(3,"Jayakanthan");
        Student s4 = new Student(4,"Bhavithra");
        Student s5 = new Student(5, "Siva");

        System.out.println(s1.hashCode() + " "+s2.hashCode() +" " +s3.hashCode()+" " +s4.hashCode() + " "+s5.hashCode());

        System.out.println(s1.hashCode() ^ (1>>>16));

        Map<Student, Student> studentMap = new HashMap<>();
        studentMap.put(s1, s1);
        studentMap.put(s2, s2);
        studentMap.put(s3, s3);
        studentMap.put(s4, s4);
        studentMap.put(s5, s5);

        System.out.println(studentMap.get(s2));

    }

}
