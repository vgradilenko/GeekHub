package com.geekhub.hw8;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@WebServlet("/file/create")
public class CreateFileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Path path = Paths.get(req.getParameter("path"));
        String fileName = req.getParameter("fileName");
        String content = req.getParameter("content");

        File file = null;
        try {
            file = new File(createFile(path, fileName).toString());
            writeContent(file.getPath(), content);
        } catch (FileOperationException e) {
            resp.sendError(500, "file creation error");
        }

        resp.sendRedirect("/dir/view");
    }

    private Path createFile(Path path, String fileName) throws FileOperationException {
        String file = path.toString() + "/" + fileName;
        try {
            return Files.createFile(Paths.get(file));
        } catch (IOException e) {
            throw new FileOperationException(e);
        }
    }

    private void writeContent(String puth, String content) throws FileOperationException {
        File file = new File(puth);
        try (Writer writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(content);
        } catch (IOException e) {
            throw new FileOperationException(e);
        }
    }
}
