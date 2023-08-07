package video.domain;

import video.domain.price.PriceType;

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
        double thisAmount = 0;
        // 一行ごとに金額を計算
        switch (getMovie().getPriceType()) {
            case REGULAR:
                thisAmount += getMovie().getPriceType().charge(getDaysRented());
                break;
            case NEW_RELEASE:
                thisAmount += getMovie().getPriceType().charge(getDaysRented());
                break;
            case CHILDREN:
                thisAmount += getMovie().getPriceType().charge(getDaysRented());
                break;
        }
        return thisAmount;
    }

    int frequentRenterPoints() {
        // レンタルポイントを加算
        // 新作を二日以上借りた場合はボーナスポイント
        if ((getMovie().getPriceType() == PriceType.NEW_RELEASE) &&
            getDaysRented() > 1) return 2;
        return 1;
    }
}