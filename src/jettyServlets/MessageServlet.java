package jettyServlets;

import java.io.*;
import java.text.*;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.apache.commons.text.StringEscapeUtils;


/**
 * An example demonstrating how to create a simple message board using
 * jetty/servlets.
 */
@SuppressWarnings("serial")
public class MessageServlet extends HttpServlet {
    private static final String TITLE = "Messages";

    private ConcurrentLinkedQueue<String> messages; // thread-safe, from the
    // concurrent package

    public MessageServlet() {
        super();
        messages = new ConcurrentLinkedQueue<>();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        //response.setStatus(HttpServletResponse.SC_OK);

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>" + TITLE + "</title></head>");
        out.println("<body>");

        out.println("<h1>Message Board</h1>");

        // Keep in mind: multiple threads may access messages at once.
        // We do not provide synchronization here because we used a thread-safe
        // queue to store messages
        for (String message : messages) {
            out.println("<p>" + message + "</p>");
        }

        printForm(request, response);

        out.println("<p>This request was handled by thread " + Thread.currentThread().getName() + ".</p>");

        out.println("</body>");
        out.println("</html>");

        response.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        //response.setStatus(HttpServletResponse.SC_OK);

        String username = request.getParameter("username");
        String message = request.getParameter("message");

        username = username == null ? "anonymous" : username;
        message = message == null ? "" : message;

        // Avoid XSS attacks using Apache Commons StringUtils
        // Comment out if you don't have this library installed
        username = StringEscapeUtils.escapeHtml4(username);
        message = StringEscapeUtils.escapeHtml4(message);

        String formatted = String.format("%s<br><font size=\"-2\">[ posted by %s at %s ]</font>", message, username,
                getDate());

        // Keep in mind multiple threads may access at once
        messages.add(formatted);

        // Only keep the latest 5 messages
        if (messages.size() > 5) {
            String first = messages.poll();
        }

        response.setStatus(HttpServletResponse.SC_OK);
        response.sendRedirect(request.getServletPath());
    }

    private static void printForm(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter out = response.getWriter();

        out.println("<form action=\"" + request.getServletPath() + "\" method = \"post\">");
        out.println("Name: <br>");
        out.println("<input type=\"text\" name=\"username\"><br>");

        out.println("Message: <br>");
        out.println("<input type=\"text\" name=\"message\">");
        out.println("<br><br>");
        out.println("<input type=\"submit\">");
        out.println("</form>");
    }

    private static String getDate() {
        String format = "hh:mm a 'on' EEEE, MMMM dd yyyy";
        DateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(new Date());
    }
}
