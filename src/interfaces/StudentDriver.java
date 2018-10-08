package interfaces;

import java.util.ArrayList;
import java.util.Collections;

public class StudentDriver {
    public static void main(String[] args) {
        Student s1 = new Student("Jones", 3.5f);
        Student s2 = new Student("Ackton", 3.7f);
        Student s3 = new Student("Bailey", 4.0f);
        System.out.println(s1.compareTo(s2));

        ArrayList<Student> students = new ArrayList();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        Collections.sort(students); // uses compareTo defined in class Student
        System.out.println(students);

    }
}
