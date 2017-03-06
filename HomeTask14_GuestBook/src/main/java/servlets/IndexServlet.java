package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        StringBuilder out = new StringBuilder();
        out.append("<h1>hello</h1>");
        out.append("<form action=\"/comment\" method=\"GET\"");
        out.append("<p>Your name: <input type=\"text\"  name=\"userName\" /></p>");
        out.append("<p>rating: </p>");
        out.append("<input type=\"radio\" name=\"rating\" value=\"1\" /> 1 </br>");
        out.append("<input type=\"radio\" name=\"rating\" value=\"2\" /> 2 </br>");
        out.append("<input type=\"radio\" name=\"rating\" value=\"3\" /> 3 </br>");
        out.append("<input type=\"radio\" name=\"rating\" value=\"4\" /> 4 </br>");
        out.append("<p>review: </p>");
        out.append("<textarea name=\"comment\"></textarea>");
        out.append("</br>");
        out.append("<input type=\"submit\">");
        out.append("</form>");
        resp.getWriter().write(out.toString());
    }
}
