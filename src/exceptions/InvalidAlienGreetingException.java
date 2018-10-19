package exceptions;

public class InvalidAlienGreetingException extends Exception {
    public InvalidAlienGreetingException() {
        System.out.println("Exception: Invalid Alien Greeting");
    }

    @Override
    public String getMessage() {
        return "Alien's greeting can not be all in uppercase. This is considered rude.";
    }

}
