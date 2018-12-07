package codeCamp3;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;


public class BaseballServerProblem5 {
    public static void main(String[] args)  {

        BaseballTeam team = new BaseballTeam();
        team.addPlayer(new BaseballTeam.Player("Jackson", 0.27));
        team.addPlayer(new BaseballTeam.Player("Lee", 0.26));
        team.addPlayer(new BaseballTeam.Player("Ackers", 0.25));

        Server server = new Server(8080);
        ServletContextHandler chandler = new ServletContextHandler();
        chandler.addServlet(BaseballServletProblem5.class, "/player");
        chandler.addServlet(InfoServletProblem5.class, "/info");

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