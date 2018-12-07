package codeCamp3;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/** When receives a get request about the player with the certain name,
 *  returns the player's info: name and batting average.
 */
public class BaseballServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        BaseballTeam team  = (BaseballTeam)getServletContext().getAttribute("team");

        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        if (name == null)
            System.out.println("No such player");
        else {
            if (team.getPlayer(name) == null) {
               out.println("No such player") ;
            }
            else
                printHtml(out, team.getPlayer(name).toString());
        }

    }

    public void printHtml(PrintWriter out, String s) {
        out.println("<html>");
        out.println("<body>");
        out.println("<p> " + s + " </p>");
        out.println("</body>");
        out.println("</html>");

    }
}