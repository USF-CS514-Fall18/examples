package cookieManagerExercise;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/** Servlet for the CookieServer example. Allows the user to add, edit and delete cookies */
public class CookieManagerServlet extends BaseServlet {
            // FILL IN CODE


        public void doPost(HttpServletRequest request, HttpServletResponse response)
                throws IOException {
            PrintWriter writer = response.getWriter();
            // FILL IN CODE



            writer.close();
        }

        public void doGet(HttpServletRequest request, HttpServletResponse response)
                throws IOException {
            PrintWriter writer = response.getWriter();

           // FILL IN CODE

            writer.flush();
            writer.close();
        }
    }
