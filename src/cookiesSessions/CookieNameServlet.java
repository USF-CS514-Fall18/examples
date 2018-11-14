package cookiesSessions;

import org.apache.commons.text.StringEscapeUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/** The first time the user enters the website, asks the user for the name.
 * Stores the name in the cookie. Prints "Hello" and the name of the user.
 * Remembers the user's name when the user visits again.
 */
public class CookieNameServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        //System.out.println(request.getHeader("Cookie"));
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML>");
        out.println("<html><head>");
        out.println("<title> Simple Cookie Example </title>");
        out.println("<content=\"text/html\">");
        out.println("</head>");
        out.println("<body>");

        // Check if we entered a name before and it was saved in the cookie
        Cookie[] cookies = request.getCookies();
        boolean found  = false;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("name")) {
                    String userName = StringEscapeUtils.escapeHtml4(cookie.getValue());
                    out.println("<p>Hello, " + userName + "</p></body></html>");
                    found = true;
                    break;
                }
            }
        }

        if (!found) { // never entered the name before
            out.println("<form method=\"post\" action=\"" + request.getServletPath() + "\">");
            out.print("Please enter your name:<br><input type=\"text\" name=\"name\"><br>");
            out.println("<p><input type=\"submit\" value=\"Enter\"></p>");
            out.println("</form>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // will be called when the user submits the html form
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        String nameParam = request.getParameter("name"); // get it from the form
        if (nameParam == null)
            nameParam = "anonymous";
        nameParam = StringEscapeUtils.escapeHtml4(nameParam);
        Cookie cookie = new Cookie("name", nameParam);
        //cookie.setMaxAge(10); // will expire in 10 seconds
        response.addCookie(cookie);

        response.setStatus(HttpServletResponse.SC_OK);
        response.sendRedirect("/");

    }
}

