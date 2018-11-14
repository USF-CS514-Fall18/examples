package velocity;

import org.apache.velocity.app.VelocityEngine;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

/**
 A server that displays Hello followed by the  name passed as a parameter of the GET request,
 and shows a list of hotel names from the list.
 Demonstrates how to use Velocity template engine. This is a simple example, it is not meant
 demonstrate good design.
 To test in the browser, run and go to localhost:8080/hotels
 Need to add the following libraries to the buildpath:
 Velocity (you need to add velocity-1.7-dep.jar and velocity-1.7.jar), Jetty, Servlets, ApacheCommonsLang
 *
 */
public class HotelServer {

    public static final int PORT = 8080;

    public static void main(String[] args)  {
        // Create/Initialize velocity
        VelocityEngine velocity = new VelocityEngine();
        velocity.init();

        // Create the server
        Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler();
        context.addServlet(ShowHotelsServlet.class, "/hotels");
        context.setContextPath("/");

        context.setAttribute("templateEngine", velocity);

        server.setHandler(context);


        try {
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}