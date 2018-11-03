package codeCamp2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class MovieTest {
    public static void main(String[] args) {
        // Problem 2:
        Movie movie1 = new Movie("A", 2018, 4.5);
        movie1.addActor("Actor A1");
        movie1.addActor("Actor A2");

        Movie movie2 = new Movie("B", 2016, 5.0);
        movie2.addActor("Actor B1");
        movie2.addActor("Actor B2");
        int res = movie1.compareTo(movie2);
        Iterator<String> it = null;
        if (res < 0) {
            System.out.println("movie1 is worse than movie2");
            it = movie2.getActors();
        }
        else {
            it = movie1.getActors();
            if (res > 0)
                System.out.println("movie1 is better than movie2");
            else
                System.out.println("The movies are equal.");

        }

        // Print actors of the better movie:
        System.out.print("Actors: ");
        while (it.hasNext()) {
            System.out.print(it.next() + "; ");
        }
        System.out.println();

        // Add movies to the ArrayList, and sort,
        // passing the Comparator object that compares movies based on the year.
        // You are required to use an anonymous class for the Comparator.
        List<Movie> movies = new ArrayList();
        movies.add(movie1);
        movies.add(movie2);
        // more movies can be added ...
        movies.sort(new Comparator<Movie>() {
            @Override
            public int compare(Movie m1, Movie m2) {
                if (m1.getYear() < m2.getYear())
                    return -1;
                else if (m1.getYear() > m2.getYear())
                    return 1;
                else return 0;
            }
        });
        System.out.println("After sorting by year: ");
        for (Movie m: movies) {
            System.out.println(m);
        }

    }
}
