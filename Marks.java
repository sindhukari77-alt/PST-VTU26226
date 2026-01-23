import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    int marks;
    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class Marks {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();   // number of students
        List<Student> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String name = sc.next();
            int marks = sc.nextInt();
            list.add(new Student(name, marks));
        }

        int K = sc.nextInt();   // top K students

        list.stream()
            .sorted((s1, s2) -> {
                if (s1.marks != s2.marks)
                    return s2.marks - s1.marks;   // marks descending
                else
                    return s1.name.compareTo(s2.name); // name ascending
            })
            .limit(K)
            .map(s -> s.name)
            .forEach(name -> System.out.print(name + " "));
    }
}
