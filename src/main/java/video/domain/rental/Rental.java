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
        switch (getMovie().getPriceType()) {
            case REGULAR:
                if (getDaysRented() <= 2) return 200;
                return 200 + (getDaysRented() - 2) * 150;
            case NEW_RELEASE:
                return getDaysRented() * 300;
            case CHILDREN:
                if (getDaysRented() <= 3) return 150;
                return 150 + (getDaysRented() - 3) * 150;
            default:
                throw new RuntimeException("ビデオの区分が誤っています");
        }
    }

    public int frequentRenterPoints() {
        // 新作を二日以上借りた場合はボーナスポイント
        if ((getMovie().getPriceType() == PriceType.NEW_RELEASE) &&
            getDaysRented() > 1) return 2;
        return 1;
    }
}