package video.domain;

public class Movie {

    private String title;
    PriceType priceType;


    public Movie(String title, PriceType priceType) {
        this.title = title;
        this.priceType = priceType;
    }

    public PriceType getPriceType() {
        return priceType;
    }

    public void setPriceType(PriceType priceType) {
        this.priceType = priceType;
    }

    public String getTitle() {
        return title;
    }

    public int amount(int daysRented) {
        return priceType.amount(daysRented);
    }

    public int frequentRenterPoints(int daysRented) {
        return priceType.frequentRenterPoints(daysRented);
    }
}