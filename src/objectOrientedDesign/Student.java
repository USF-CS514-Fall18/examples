package objectOrientedDesign;

public class Student {
    private String name;
    private int studentId;
    private Address address;
    // other variables as needed

    public Student(String name, int studentId, Address address) {
        this.name = name;
        this.studentId = studentId;

        // do not want to copy the reference, otherwise we will be referencing
        // the address that is passed as a parameter
        // Instead, create a new Address
        this.address = new Address(address.getState(), address.getCity(), address.getStreetAddress(), address.getZipcode());

    }

    /**
     * Returns the name of student
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns student id
     * @return student id
     */
    public int getStudentId() {
        return studentId;
    }

    /**
     * Returns the address as a string
     * @return student address as a string
     */
    public String getAddress() {
        return address.toString();
    }
    // other methods as needed..

}
