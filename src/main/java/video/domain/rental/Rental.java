package video.domain.rental;

import video.domain.Movie;
import video.domain.PriceType;

public class Rental {
    private final RegularPrice regularPrice = new RegularPrice();
    private final NewReleasePrice newReleasePrice = new NewReleasePrice();
    private final ChildrenPrice childrenPrice = new ChildrenPrice();
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
                return regularPrice.price(daysRented);
            case NEW_RELEASE:
                return newReleasePrice.price(daysRented);
            case CHILDREN:
                return childrenPrice.price(daysRented);
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