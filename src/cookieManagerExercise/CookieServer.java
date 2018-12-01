package cookieManagerExercise;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

/** Server for managing (adding, editing, deleting) cookies */
public class CookieServer {

    public static void main(String[] args)  {
            Server server = new Server(8080);
            ServletHandler handler = new ServletHandler();

            server.setHandler(handler);

            handler.addServletWithMapping(CookieManagerServlet.class, "/");

            try {
                server.start();
                server.join();
            }
            catch (InterruptedException e) {
                System.out.println("Thread got interrupted.");
            }
            catch (Exception e) {
                System.out.println(e);
            }

    }
}

