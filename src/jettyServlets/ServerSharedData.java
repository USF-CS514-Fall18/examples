package jettyServlets;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

import codeCamp2.Movie;

/** The example demonstrates how to use the attribute of the ServletContextHandler
 *  to pass the resource from server to servlets */

public class ServerSharedData {
    public static final int PORT = 8080;

    public static void main(String[] args) {
        Movie movie = new Movie("Home Alone", 1990, 5.0); // some resource, like Movie
        movie.addActor("Macaulay Culkin");

        Server server = new Server(PORT);

        ServletContextHandler chandler = new ServletContextHandler();
        chandler.setAttribute("movie", movie);
        chandler.addServlet(ServletUsingSharedData.class, "/*");
        server.setHandler(chandler);

        try {
            server.start();
            server.join();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
