package video.domain.movie;

public class Movie {

    private String title;
    MovieType movieType;


    public Movie(String title, MovieType movieType) {
        this.title = title;
        this.movieType = movieType;
    }

    public MovieType getPriceType() {
        return movieType;
    }

    public void setPriceType(MovieType movieType) {
        this.movieType = movieType;
    }

    public String getTitle() {
        return title;
    }

    public int amount(int daysRented) {
        return movieType.amount(daysRented);
    }

    public int frequentRenterPoints(int daysRented) {
        return movieType.frequentRenterPoints(daysRented);
    }
}