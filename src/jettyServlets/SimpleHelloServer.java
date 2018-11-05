package jettyServlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Locale;
import javax.servlet.*;
import org.eclipse.jetty.server.*;
import org.eclipse.jetty.servlet.*;

/**
 * A simple web server that sends the same response for each GET request (an
 * html page that says Hello, friends!)
 *
 */
public class SimpleHelloServer {

    public static final int PORT = 8080;

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        ServletHandler handler = new ServletHandler();

        // When the user goes to http://localhost:8080/hello, the get request is
        // going to go to a HelloServlet
        handler.addServletWithMapping(SimpleHelloServlet.class, "/hello");

        server.setHandler(handler);

        server.start();
        server.join();
    }
}