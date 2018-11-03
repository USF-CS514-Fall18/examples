package codeCamp2;

/** Problem 3 of the code camp. Child class Truck */
public class Truck extends Vehicle {
    private boolean isPickup;

    public Truck(int doors, int seats, boolean isPickup) {
        super(doors, seats);
        this.isPickup = isPickup;
    }


    public void setPickup(boolean pickup) {
        this.isPickup = pickup;
    }

    // FILL IN CODE: override the print method to print the number of doors,
    // the number of seats and whether it's a pickup truck or not.
    @Override
    public void print() {
        super.print(); // parent's method would print doors and seats
        System.out.println(" It is " + (isPickup?"":"not ") + "a truck");
    }









}