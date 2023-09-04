package video.domain.rental;

import video.domain.movie.Movie;

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
        return movie.frequentRenterPoints(daysRented);
    }
}