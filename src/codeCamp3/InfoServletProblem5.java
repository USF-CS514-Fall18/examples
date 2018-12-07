package codeCamp3;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/** Problem 5 */
public class InfoServletProblem5 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        BaseballTeam team  = (BaseballTeam)getServletContext().getAttribute("team");

        PrintWriter out = response.getWriter();
        Cookie[] cookies = request.getCookies();
        String player = "";
        for (Cookie c: cookies) {
            if (c.getName().equals("player")) {
                player = c.getValue();
                break;
            }
        }
        if (!player.isEmpty()) {
            if (team.getPlayer(player) == null)
                System.out.println("No such player");
            else {
                printHtml(out, team.getPlayer(player).toString());
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        Cookie[] cookies = request.getCookies();
        for (Cookie c: cookies) {
            if (c.getName().equals("player")) {
                c.setValue(null);
                c.setMaxAge(0);
                response.addCookie(c);
            }
        }
        response.sendRedirect("/player");
    }

    public void printHtml(PrintWriter out, String s) {
        out.println("<html>");
        out.println("<body>");
        out.println("<p> " + s + " </p>");
        out.println("<form action = \"info\" method = \"post\">");
        out.println("<input type = \"submit\" value =\"Clear player\">");
        out.println("</body>");
        out.println("</html>");

    }
}