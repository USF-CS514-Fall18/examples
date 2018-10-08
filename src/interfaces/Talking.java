package interfaces;

public class Talking {
    public static void main(String[] args) {
        GameCharacter c = new GameCharacter();
        c.say("Hello");
        c.shout();
    }
}
