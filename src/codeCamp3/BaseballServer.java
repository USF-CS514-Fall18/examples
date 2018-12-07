package codeCamp3;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

/** A simple web server that serves information about baseball players.
 *  If the client sends request to /player and provides the name of the player,
 *  the server will return this player's info (name and batting average).
 *  For instance, typing /player?name=Ackers in the browser, will result in
 *  the server displaying "Ackers, 0.25". */
public class BaseballServer {
    public static void main(String[] args)  {

        BaseballTeam team = new BaseballTeam();
        team.addPlayer(new BaseballTeam.Player("Jackson", 0.27));
        team.addPlayer(new BaseballTeam.Player("Lee", 0.26));
        team.addPlayer(new BaseballTeam.Player("Ackers", 0.25));

        Server server = new Server(8080);
        ServletContextHandler chandler = new ServletContextHandler();
        chandler.addServlet(BaseballServlet.class, "/player");
        chandler.setAttribute("team", team);
        server.setHandler(chandler);

        try {
            server.start();
            server.join();
        }
        catch (Exception e) {
            System.out.println("Server could not start: " + e);
        }
    }
}