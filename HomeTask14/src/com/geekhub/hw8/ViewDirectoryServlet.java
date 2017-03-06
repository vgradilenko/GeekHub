package com.geekhub.hw8;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/dir/view", initParams = {
        @WebInitParam(name = "root", value = "/home/grava/java/tmp")
})
public class ViewDirectoryServlet extends HttpServlet {

    private static Path ROOT_PATH;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ROOT_PATH = Paths.get(config.getInitParameter("root"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        StringBuilder sb = new StringBuilder();

        Path path;
        String pathParam = req.getParameter("path");
        if (pathParam == null) {
            path = ROOT_PATH;
        } else {
            path = Paths.get(pathParam);
        }

        sb.append("<html>");
        sb.append("<h2>Web Commander</h2>");

        for (Path current : files(path)) {
            appendLink(sb, current.getFileName().toString(), current);
        }

        createFileButton(sb, path);

        sb.append("</html>");
        resp.getWriter().write(sb.toString());
    }

    private void appendLink(StringBuilder sb, String text, Path path) {
        sb.append("<ul>");
        sb.append("<li>");
        if (Files.isDirectory(path)) {
            sb.append("<a href=\"" + "/dir/view" + "?path=")
                    .append(path.toString())
                    .append("\">")
                    .append("<h3>")
                    .append(text)
                    .append("</h3>")
                    .append("</a>");
        } else {
            sb.append("<a href=\"" + "/file/view" + "?path=")
                    .append(path.toString())
                    .append("\">")
                    .append("<h3>")
                    .append(text)
                    .append("</h3>")
                    .append("</a>");
        }
        sb.append("</li>")
                .append("<a href=\"/file/remove?path=")
                .append(path.toString())
                .append("\"")
                .append(">kill me</a>");
        sb.append("</ul>");
    }

    private void createFileButton(StringBuilder sb, Path path) {
        sb.append("<form action=\"/file/create\" method=\"GET\"");
        sb.append("<p><input type=\"text\" name=\"fileName\" size=\"20px\"></p></br>");
        sb.append("<p><textarea rows=\"10\" cols=\"45\" name=\"context\"></textarea></p></br>");
        sb.append("<p><input type=\"submit\" value=\"submit\"></p></br>");
        sb.append("<input type=\"hidden\" name=\"path\" value=\"").append(path).append("\"></br>");
        sb.append("</form>");
    }

    private List<Path> files(Path directory) throws IOException {
        List<Path> fileNames = new ArrayList<>();
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directory)) {
            for (Path path : directoryStream) {
                fileNames.add(path);
            }
        }
        return fileNames;
    }
}
