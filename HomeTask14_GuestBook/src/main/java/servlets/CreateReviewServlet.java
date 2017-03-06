package servlets;

import objects.UserReview;
import storage.DatabaseStorage;
import storage.StorageException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/comment")
public class CreateReviewServlet extends HttpServlet {
    private DatabaseStorage storage;

    @Override
    public void init(ServletConfig config) throws ServletException {
        storage = (DatabaseStorage) config.getServletContext().getAttribute("db");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserReview userReview = new UserReview();

        userReview.setName(req.getParameter("userName"));
        userReview.setRating(Integer.parseInt(req.getParameter("rating")));
        userReview.setReview(req.getParameter("comment"));

        try {
            storage.save(userReview);
            resp.sendRedirect("/reviews");
        } catch (StorageException e) {
            resp.sendRedirect("/error");
        }
    }
}
