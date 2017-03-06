package objects;
import java.time.LocalDate;

public class UserReview extends Entity {
    private String name;
    private String review;
    private int rating;
    private String date;

    public UserReview() {
        this.date = LocalDate.now().toString() ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public LocalDate getDate() {
        return LocalDate.parse(date);
    }
}
