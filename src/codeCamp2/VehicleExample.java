package codeCamp2;

/** Driver class for problem 3 of the code camp */
public class VehicleExample {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle(4, 4);
        Vehicle v2 = new Truck(2, 2, true);
        Truck tr = new Truck(2, 2, false);
        v1.print();
        System.out.println();
        v2.print();
        tr.print();
        System.out.println(v2.getClass().getSimpleName());
        System.out.println(v2 instanceof Truck);

        ((Truck)v2).setPickup(true); // change v2 to a pickup truck

    }
}
