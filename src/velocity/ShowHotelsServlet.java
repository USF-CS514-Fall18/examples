package velocity;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.text.StringEscapeUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

@SuppressWarnings("serial")
public class ShowHotelsServlet extends HttpServlet {

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);
		PrintWriter out = response.getWriter();

		// Get the "name" parameter from the GET request
		// The request may look like this: /hotels?name=Ali
		String name = request.getParameter("name");
		if (name == null || name.isEmpty())
			name = "anonymous";
		name = StringEscapeUtils.escapeHtml4(name);

		VelocityEngine ve = (VelocityEngine) request.getServletContext().getAttribute("templateEngine");
		VelocityContext context = new VelocityContext();
		Template template = ve.getTemplate("templates/hotelInfo.html");
		context.put("name", name);

		// usually the data would come from some kind of database. Using a
		// simple ArrayList here instead:
		List<String> hotels = new ArrayList<>();
		hotels.add("Hilton");
		hotels.add("Holiday Inn");
		hotels.add("Hampton Inn");

		context.put("hotels", hotels);

		
		StringWriter writer = new StringWriter();
		template.merge(context, writer);

		out.println(writer.toString());

	}
}