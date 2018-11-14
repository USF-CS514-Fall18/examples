package cookiesSessions;


import org.apache.commons.text.StringEscapeUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/** Used in the GenreServer example. */
public class GenreServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        PrintWriter out = response.getWriter();
        out.println("<html><title>GenreServlet</title><body>");

        // Has this user visited before? Is their info in the cookies?
        Cookie[] cookies = request.getCookies();
        boolean foundName = false;
        boolean foundGenre = false;
        int i = 0;
        String username = "";
        String genre = "";
        while (cookies != null && i < cookies.length && (!foundName || !foundGenre)) {
            Cookie cookie = cookies[i];
            if (cookie.getName().equals("username")) {
                username = cookie.getValue();
                foundName = true;
            }
            if (cookie.getName().equals("genre")) {
                genre = cookie.getValue();
                foundGenre = true;
            }
            i++;
        }
        if (foundName && foundGenre) { // found both
            username = StringEscapeUtils.escapeHtml4(username);
            genre = StringEscapeUtils.escapeHtml4(genre);
            out.println("<p> Welcome,  " + username + "! </p>");
            out.println("<h3>Movie Recommendation: </h3>");
            String rec = "";
            if (genre.toLowerCase().equals("action"))
                rec = "Mission Impossible 6";
            else if (genre.toLowerCase().equals("comedy")) {
                rec = "Crazy Rich Asians";
            }
            else
                rec = "Indredibles 2";
            out.println("<p> " + rec + "</p>");
        }
        else {
            out.println("<form action=\"" + request.getServletPath() + "\" method=\"post\">");

            out.println("Username: <br/>");
            out.println("<input type=\"text\" name=\"username\"><br/>");
            out.println("Favorite Movie Genre: <br/>");
            out.println("<input type=\"text\" name=\"genre\"><br/>");
            // button
            out.println("<input type=\"submit\" value=\"Enter\"></form>");

            out.println("</body></html>");
        }
    }

    /** The method that will process the form once it's submitted */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        PrintWriter out = response.getWriter();

        String username= request.getParameter("username");
        username = StringEscapeUtils.escapeHtml4(username);
        String genre = request.getParameter("genre");
        genre = StringEscapeUtils.escapeHtml4(genre);
        response.addCookie(new Cookie("username", username));
        response.addCookie(new Cookie("genre", genre));
        response.sendRedirect("/genre"); // send a get request
    }

}