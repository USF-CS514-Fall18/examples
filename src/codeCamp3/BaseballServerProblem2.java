package codeCamp3;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

/** A simple web server that serves information about baseball players.
 *  If the client sends request to /player, the form would show up
 *  where the user can type the name of the player and press the submit button
 *  to return this player's info (name and batting average).
 *  For instance, typing /player in the browser, will take me to the webpage where I enter
 *  Ackers in the textfield. Then the server should display "Ackers, 0.25". */
public class BaseballServerProblem2 {
    public static void main(String[] args)  {

        BaseballTeam team = new BaseballTeam();
        team.addPlayer(new BaseballTeam.Player("Jackson", 0.27));
        team.addPlayer(new BaseballTeam.Player("Lee", 0.26));
        team.addPlayer(new BaseballTeam.Player("Ackers", 0.25));

        Server server = new Server(8080);
        ServletContextHandler chandler = new ServletContextHandler();
        chandler.addServlet(BaseballServletProblem2.class, "/player");
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