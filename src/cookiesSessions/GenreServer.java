package cookiesSessions;


import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

/**
 * When the user visits the webpage for the first time,
 * the webserver displays the HTML form that allows a user to enter
 * the name and their favorite movie genre. When the form is submitted,
 * the webserver returns an html page that welcomes the user
 * with the given name gives a movie recommendation:
 * -if "genre" is "animation", it will recommend "Incredibles 2",
 * -if "genre"  is "comedy", it will recommend "Crazy Rich Asians",
 * -if genre is "action", it will recommend "Mission Impossible 6".
 * When the user visits the webpage again, he/she is displayed the same
 * recommendation without the need to fill out the html form again.
 *
 */
public class GenreServer {

    public static final int PORT = 8080;

    public static void main(String[] args) throws Exception {
        Server server = new Server(PORT);

        ServletHandler handler = new ServletHandler();
        handler.addServletWithMapping(GenreServlet.class, "/genre");

        server.setHandler(handler);

        server.start();
        server.join();
    }
}
