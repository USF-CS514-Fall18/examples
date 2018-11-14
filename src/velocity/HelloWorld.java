package velocity;

import java.io.StringWriter;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;

public class HelloWorld {
	public static void main(String[] args) throws Exception {
		/* first, get and initialize an engine */
		VelocityEngine ve = new VelocityEngine();
		ve.init();

		Template template = ve.getTemplate("templates/hello.html");

		VelocityContext context = new VelocityContext();
		context.put("name", "Olga");
		context.put("vel", "Template engine");
		
		/* now render the template into a StringWriter */
		StringWriter writer = new StringWriter();
		template.merge(context, writer);

		/* show the result */
		System.out.println(writer.toString());
	}
}
