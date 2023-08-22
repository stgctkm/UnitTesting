package video.domain.rental;

import video.domain.Movie;
import video.domain.PriceType;

public class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int amount() {
        // 金額を計算
        int daysRented = getDaysRented();
        return movie.amount(daysRented);
    }

    public int frequentRenterPoints() {
        // 新作を二日以上借りた場合はボーナスポイント
        if ((getMovie().getPriceType() == PriceType.NEW_RELEASE) &&
            getDaysRented() > 1) return 2;
        return 1;
    }
}