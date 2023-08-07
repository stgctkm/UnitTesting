package video.domain;

import video.domain.movie.Movie;
import video.domain.movie.MovieType;

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

    double charge() {
        return getMovie().getPriceType().charge(getDaysRented());
    }

    int frequentRenterPoints() {
        // レンタルポイントを加算
        // 新作を二日以上借りた場合はボーナスポイント
        if ((getMovie().getPriceType() == MovieType.NEW_RELEASE) &&
            getDaysRented() > 1) return 2;
        return 1;
    }
}