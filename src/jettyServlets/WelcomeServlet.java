package jettyServlets;


import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.commons.text.StringEscapeUtils;

/** An example that demonstrates how to process HTML forms with servlets.
 *  Part of the example that also includes HtmlFormServer and HtmlFormServlet.
 */

@SuppressWarnings("serial")
public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println();
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>" + "Form" + "</title></head>");
        String name = request.getParameter("name");
        name = StringEscapeUtils.escapeHtml4(name);
        out.println("<body>");

        // Displays Hello and the name of the person
        out.println("<h1>Hello, " + name + "!</h1>");

        out.println("</body>");
        out.println("</html>");

        response.setStatus(HttpServletResponse.SC_OK);
    }


}
