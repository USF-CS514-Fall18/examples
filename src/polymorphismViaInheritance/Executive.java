package polymorphismViaInheritance;
/** Executive.java       Author: Lewis/Loftus
 * Represents an executive staff member, who can earn a bonus.
 */
public class Executive extends Employee {
   private double bonus;

   /** Constructor: Sets up this executive with the specified information.
    *
    * @param eName name
    * @param eAddress address
    * @param ePhone phone
    * @param socSecNumber social security number
    * @param rate pay rate
    */
   public Executive(String eName, String eAddress, String ePhone,
                    String socSecNumber, double rate) {
      super(eName, eAddress, ePhone, socSecNumber, rate);

      bonus = 0;  // bonus has yet to be awarded
   }

   /** Awards the specified bonus to this executive.
    *
    * @param execBonus bonus amount
    */
   public void awardBonus(double execBonus)
   {
      bonus = execBonus;
   }

   /** Computes and returns the pay for an executive,
    * which is the regular employee payment plus a one-time bonus.
    *
    * @return pay
    */
   public double pay()
   {
      double payment = super.pay() + bonus;

      bonus = 0;

      return payment;
   }
}