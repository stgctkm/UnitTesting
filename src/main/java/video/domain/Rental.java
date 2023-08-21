package video.domain;

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

    int amount() {
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
}