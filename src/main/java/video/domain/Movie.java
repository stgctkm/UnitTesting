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

    public int movieAmount(int daysRented) {
        return priceType.amount(daysRented);
    }

}