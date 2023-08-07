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

    double charge() {
        return getMovie().getPriceType().charge(getDaysRented());
    }

    int frequentRenterPoints() {
        return getMovie().getPriceType().frequentRenterPoints(getDaysRented());
    }
}