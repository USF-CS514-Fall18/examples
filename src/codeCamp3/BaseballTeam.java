package codeCamp3;

import java.util.ArrayList;

public class BaseballTeam {
    private ArrayList<Player> players; // players in the team

    public BaseballTeam() {
        players = new ArrayList<Player>();
    }

    public void addPlayer(Player person) {
        players.add(person);
    }

    public Player getPlayer(String name) {
        for (Player p: players) {
            if (p.name.equals(name))
                return p;
        }
        return null;
    }

    /** Nested class Player */
    public static class Player {
        private String name; // name of the player
        private double battingAverage; // player's score

        public Player(String name, double bAverage) {
            this.name = name;
            this.battingAverage = bAverage;
        }

        public String getName() {
            return this.name;
        }

        public double getAverage() {
            return this.battingAverage;
        }

        public String toString() {
            return name + ", " + battingAverage;
        }
    } // close class Player
} // close class BaseballTeam
