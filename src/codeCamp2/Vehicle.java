package codeCamp2;

/** Problem 3 of the code camp, parent class Vehicle */
public class Vehicle 		{
    private int doors;
    private int seats;

    public Vehicle(int doors, int seats) {
        this.doors = doors;
        this.seats = seats;
    }

    public void print() {
        System.out.print(doors + " " + seats);
    }

}


