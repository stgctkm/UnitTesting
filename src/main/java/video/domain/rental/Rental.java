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
        int thisAmount = 0;
        // 金額を計算
        switch (getMovie().getPriceType()) {
            case REGULAR:
                thisAmount += 200;
                if (getDaysRented() > 2)
                    thisAmount += (getDaysRented() - 2) * 150;
                break;
            case NEW_RELEASE:
                thisAmount += getDaysRented() * 300;
                break;
            case CHILDREN:
                thisAmount += 150;
                if (getDaysRented() > 3)
                    thisAmount += (getDaysRented() - 3) * 150;
                break;
        }
        return thisAmount;
    }

    public int frequentRenterPoints() {
        // 新作を二日以上借りた場合はボーナスポイント
        if ((getMovie().getPriceType() == PriceType.NEW_RELEASE) &&
            getDaysRented() > 1) return 2;
        return 1;
    }
}