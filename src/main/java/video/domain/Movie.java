package video.domain;

import video.domain.price.ChildrenPrice;
import video.domain.price.NewReleasePrice;
import video.domain.price.RegularPrice;

public class Movie {

    private String title;
    PriceType priceType;

    private final RegularPrice regularPrice = new RegularPrice();
    private final NewReleasePrice newReleasePrice = new NewReleasePrice();
    private final ChildrenPrice childrenPrice = new ChildrenPrice();

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
        switch (priceType) {
            case REGULAR:
                return regularPrice.amount(daysRented);
            case NEW_RELEASE:
                return newReleasePrice.amount(daysRented);
            case CHILDREN:
                return childrenPrice.amount(daysRented);
            default:
                throw new RuntimeException("ビデオの区分が誤っています");
        }
    }
}