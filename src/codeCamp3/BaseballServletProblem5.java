package codeCamp3;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/** Problem 5 of the code camp */
public class BaseballServletProblem5 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Here");
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        PrintWriter out = response.getWriter();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("player")) {
                    response.sendRedirect("/info");
                }
            }
        }
        out.println("<html>");
        out.println("<body>");
        out.println("<form action = \"player\" method = \"post\">");
        out.println("<input type = \"text\" name = \"name\">");
        out.println("<input type = \"submit\" name=\"Enter\">");
        out.println("</body>");
        out.println("</html>");
        out.flush();
        System.out.println("End of get");

        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("In Post!");
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        BaseballTeam team = (BaseballTeam) getServletContext().getAttribute("team");
        String name = request.getParameter("name");
        if (name == null)
            System.out.println("No such player");
        else {
            if (team.getPlayer(name) == null) {
                out.println("No such player");
            }
            else {
                Cookie cookie = new Cookie("player", name);
                response.addCookie(cookie);
                response.sendRedirect("/info");
            }
            //printHtml(out, team.getPlayer(name).toString());
        }

    }
}