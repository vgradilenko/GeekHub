package servlets;

import objects.UserReview;
import pagination.Page;
import pagination.PageRequest;
import pagination.PaginationUtils;
import storage.DatabaseStorage;
import storage.StorageException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@WebServlet("/reviews")
public class CustomerReviewsServlet extends HttpServlet {
    private final static int USERS_PER_PAGE = 5;
    private DatabaseStorage storage;

    @Override
    public void init(ServletConfig config) throws ServletException {
        storage = (DatabaseStorage) config.getServletContext().getAttribute("db");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<UserReview> reviews = getSortedCommentsByDate();
            PageRequest pageRequest = extractPageRequest(req);
            Page<UserReview> page = PaginationUtils.getPage(reviews, pageRequest);
            req.setAttribute("page", page);
            req.getRequestDispatcher("/WEB-INF/list.jsp").forward(req, resp);
        } catch (StorageException | IOException e) {
            resp.sendRedirect("/error");
        }
    }

    private List<UserReview> getSortedCommentsByDate() throws StorageException {
        List<UserReview> reviews = storage.list(UserReview.class);

        Comparator<UserReview> comparator = Comparator.comparing(UserReview::getDate).reversed()
                .thenComparing(UserReview::getName)
                .thenComparing(UserReview::getRating);

        reviews.sort(comparator);
        return reviews;
    }

    private PageRequest extractPageRequest(HttpServletRequest request) {
        String page = request.getParameter("page");
        if (page != null) {
            return new PageRequest(Integer.parseInt(page), USERS_PER_PAGE);
        } else {
            return new PageRequest(1, USERS_PER_PAGE);
        }
    }

}

