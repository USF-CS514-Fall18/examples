package codeCamp2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Movie implements Comparable<Movie> {
    public final static double EPS = 0.001;
    private String title;
    private int year;
    private double rating;
    private List<String> actors;

    public Movie(String title, int year, double rating) {
        this.title = title;
        this.year = year;
        this.rating = rating;
        actors = new ArrayList();
    }

    public void addActor(String actor) {
        actors.add(actor);
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(title + " , " + year + " , " + rating);
        sb.append(System.lineSeparator());
        sb.append("Starring: ");
        for (int i = 0; i < actors.size(); i++) {
            sb.append(actors.get(i) + ", ");
        }
        String res = sb.toString();
        return res.substring(0, res.length() - 2);
    }

    public int getYear() {
        return year;
    }

	public Iterator<String> getActors() {
        return actors.iterator();
    }

    /**
     * Compares this movie to other movie based on the rating
     * @param other Another movie
     * @return 0 if equal (up to EPS),
     * -1 if this rating is less than other rating,
     * and 1 otherwise
     */
    public int compareTo(Movie other) {
        if (Math.abs(rating - other.rating) < EPS)
            return 0;
        else if (rating < other.rating)
            return -1;
        else
            return 1;
    }
}
