package polymorphismViaInheritance;

/**
 * StaffMember.java       Author: Lewis/Loftus
 * Represents a generic staff member.
 */
abstract public class StaffMember {
   private String name;
   private String address;
   private String phone;

   /** Constructor: Sets up this staff member using the specified information.
    *
    * @param eName name
    * @param eAddress address
    * @param ePhone phone
    */
   public StaffMember(String eName, String eAddress, String ePhone) {
      name = eName;
      address = eAddress;
      phone = ePhone;
   }

   /** Returns a string including the basic employee information.
    *
    * @return string that contains name, address and phone
    */
   public String toString()
   {
      String result = "Name: " + name + System.lineSeparator();

      result += "Address: " + address + System.lineSeparator();
      result += "Phone: " + phone;

      return result;
   }

   /** Derived classes must define the pay method for each type of employee.
    *
    * @return pay
    */
   public abstract double pay();
}
