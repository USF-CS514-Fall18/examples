package cookiesSessions;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

/** This example demonstrates how to store the user's name in a cookie */
public class SimpleCookieServer {
    public final static int PORT = 8090;
    public static void main(String[] args) throws Exception {
        Server server = new Server(PORT);

        ServletHandler handler = new ServletHandler();
        handler.addServletWithMapping(CookieNameServlet.class, "/");


        server.setHandler(handler);
        server.start();
        server.join();
    }
}
