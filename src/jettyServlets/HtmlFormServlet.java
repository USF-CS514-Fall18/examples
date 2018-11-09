package jettyServlets;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.apache.commons.text.StringEscapeUtils;

/** An example that demonstrates how to process HTML forms with servlets.*/
@SuppressWarnings("serial")
public class HtmlFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println();
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>" + "Form" + "</title></head>");
        out.println("<body>");
        // display HTML Form
        printForm(request, response);

        out.println("</body>");
        out.println("</html>");

        response.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // will be called when the user submits the html form
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        String nameParam = request.getParameter("name");
        if (nameParam == null)
            nameParam = "anonymous";
        nameParam = StringEscapeUtils.escapeHtml4(nameParam);
        //System.out.println(nameParam);

        response.setStatus(HttpServletResponse.SC_OK);
        // Redirect to another url, send name in the get request
        // Going to this url will invoke a welcome servlet
        response.sendRedirect("/welcome?name=" + nameParam);

    }

    private static void printForm(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter out = response.getWriter();

        out.println("<form method=\"post\" action=\"" + request.getServletPath() + "\">");
        out.print("Enter name:<br><input type=\"text\" name=\"name\"><br>");
        out.println("<p><input type=\"submit\" value=\"Enter\"></p>");
        out.println("</form>");
    }

}