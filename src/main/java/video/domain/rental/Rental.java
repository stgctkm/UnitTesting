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
        switch (getMovie().getPriceType()) {
            case REGULAR:
                return regularPrice(daysRented);
            case NEW_RELEASE:
                return newReleasePrice(daysRented);
            case CHILDREN:
                return childrenPrice(daysRented);
            default:
                throw new RuntimeException("ビデオの区分が誤っています");
        }
    }

    private int regularPrice(int daysRented) {
        if (daysRented <= 2) return 200;
        return 200 + (daysRented - 2) * 150;
    }

    private int newReleasePrice(int daysRented) {
        return daysRented * 300;
    }

    private int childrenPrice(int daysRented) {
        if (daysRented <= 3) return 150;
        return 150 + (daysRented - 3) * 150;
    }

    public int frequentRenterPoints() {
        // 新作を二日以上借りた場合はボーナスポイント
        if ((getMovie().getPriceType() == PriceType.NEW_RELEASE) &&
            getDaysRented() > 1) return 2;
        return 1;
    }
}