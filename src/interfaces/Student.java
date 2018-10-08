package interfaces;

/** Class Student, implements Comparable interface */
public class Student implements   Comparable<Student> {
    public static final double EPS = 0.0001;
    private String name;
    private float gpa;

    /**
     * Constructor
     * @param name name
     * @param gpa gpa
     */
    public Student(String name, float gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    /**
     * Returns a string that contains name and gpa
     * @return string representation of the student
     */
    public String toString() {
        return name + ", " + gpa;
    }

    /**
     * Returns -1 if this student is less than other,
     * 1 if this student is greater than other,
     * 0 if they are requal
     * @param other
     * @return
     */
    public int compareTo(Student other) {
        // compare based on gpa
        // first, check if GPA of this student and other student are equal
        double dif = Math.abs(gpa - other.gpa);
        if (dif < EPS) // we consider them equal, since difference is very small
            return 0;
        if (gpa < other.gpa)
            return -1;
        else
            return 1;

        // If we wanted to compare based on names instead
        //return this.name.compareTo(other.name);
    }
}
