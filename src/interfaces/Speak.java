package interfaces;

/** Speak: interface with a default method */
interface Speak {

    public void say(String greeting);

    default public void shout() { // default implementation
        System.out.println("I am so angry, I want to shout!");
    }

}
