package objectOrientedDesign;

/** Represents an address in the US */
public class Address {
    private String state;
    private String city;
    private String streetAddress;
    private long zipcode;

    /**
     * Constructor for class Address
     * @param state state
     * @param city city
     * @param streetAddress house number and street name
     * @param zipcode 5 digit zipcode
     */
    public Address(String state, String city, String streetAddress, long zipcode) {
        this.state = state;
        this.city = city;
        this.streetAddress = streetAddress;
        this.zipcode = zipcode;
    }

    /**
     * Returns city
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * Returns the state
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * Returns street address
     * @return house number and street
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * Returns zipcode
     * @return zipcode
     */
    public long getZipcode() {
        return zipcode;
    }

    /**
     * Returns the string representation of this address:
     * street address on one line, then city comma state comma zipcode on another line
     * @return string representatin of the address
     */
    public String toString() {
        String res = streetAddress + System.lineSeparator() +
        city + ", " + state + ", " + zipcode;
        return res;
    }
}
